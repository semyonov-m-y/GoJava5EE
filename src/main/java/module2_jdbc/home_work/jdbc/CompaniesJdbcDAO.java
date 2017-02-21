package module2_jdbc.home_work.jdbc;

import module2_jdbc.home_work.entry.Company;
import module2_jdbc.home_work.entry.Developer;
import module2_jdbc.home_work.entry.Project;
import module2_jdbc.home_work.model.CompaniesDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GetFire on 20.02.2017.
 */
public class CompaniesJdbcDAO implements CompaniesDAO {

    public CompaniesJdbcDAO() {
        loadDriver();
    }

    private String url = "jdbc:mysql://localhost:3306/home_work1?autoReconnect=true&useSSL=false";
    private String user = "root";
    private String pass = "admin";

    @Override
    public void addCompany(Company company) {
        String name = company.getName();
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO companies(comp_name) VALUES (?);")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            connection.setAutoCommit(false);
            statement.setString(1, name);
            statement.executeUpdate();
            System.out.println(name + ", successfully added to DB");
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        }

    }

    @Override
    public List<Company> getAllCompanies() {
        List<Company> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement statement = connection.createStatement()) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            String sql = "SELECT * FROM companies;";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Company company = createCompany(resultSet);
                result.add(company);
            }
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        }

        return result;
    }

    @Override
    public Company getByName(String name) {
        Company result;
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM companies WHERE companies.comp_name LIKE ?;")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            name = "%" + name + "%";
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = createCompany(resultSet);
                connection.commit();
            } else {
                result = new Company("Default");
                connection.rollback();
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        }
    }

    @Override
    public void updateByID(int id, Company company) {
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement statement = connection.prepareStatement("UPDATE companies SET comp_name = ? WHERE comp_id =?;")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            String name = company.getName();
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
            connection.commit();
            System.out.println("Successfully updated");
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        }
    }

    @Override
    public Company getByID(int id) {
        Company company = null;
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM companies WHERE comp_id=?;")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                company = createCompany(rs);
                connection.commit();
            } else {
                System.out.println("Cannot find any company with id: "+id);
                company = new Company("Default");
                connection.rollback();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        }
        return company;

    }

    @Override
    public List<Project> getCompaniesProjects(Company company) {
        List<Project> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement statement = connection.prepareStatement("SELECT project_name, project_cost FROM projects JOIN companies USING (comp_id) WHERE comp_name LIKE ?;")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            String name = "%" + company.getName() + "%";
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String aName = resultSet.getString("project_name");
                int cost = resultSet.getInt("project_cost");
                result.add(new Project(aName, cost));
            }
            connection.commit();

        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        }
        return result;
    }

    @Override
    public int deleteByName(String name) {
        int res;
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM companies WHERE comp_name LIKE ?;")) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            String name1 = "%" + name + "%";
            statement.setString(1, name1);
            statement.executeUpdate();
            connection.commit();
            System.out.println(name + ", Successfully deleted");
            res = 1;

        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        }
        return res;
    }

    @Override
    public List<Developer> getAllDevelopers(String companyName) {
        companyName = "%"+companyName+"%";
        List<Developer> developers= new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url,user,pass);
        PreparedStatement statement = connection.prepareStatement("SELECT dev_name FROM developers INNER JOIN projects USING (project_id) INNER JOIN companies USING (comp_id) WHERE comp_name LIKE ?;")){
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            statement.setString(1,companyName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                developers.add(new Developer(resultSet.getString("dev_name")));
            }
            connection.commit();
        }catch (SQLException e){
            throw new RuntimeException("Cannot connect to DB", e);
        }
        return developers;
    }

    private void loadDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot load drive from companiesDAO", e);
        }
    }

    private Company createCompany(ResultSet resultSet) throws SQLException {
        return new Company(resultSet.getString("comp_name"),
                resultSet.getInt("comp_id"));

    }
}
