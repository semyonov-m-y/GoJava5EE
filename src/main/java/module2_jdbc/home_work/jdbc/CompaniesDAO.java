package module2_jdbc.home_work.jdbc;

import module2_jdbc.home_work.entry.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GetFire on 20.02.2017.
 */
public class CompaniesDAO {

    public CompaniesDAO() {
        loadDriver();
    }

    private String url = "jdbc:mysql://localhost:3306/home_work1?autoReconnect=true&useSSL=false";
    private String user = "root";
    private String pass = "admin";

    public void addCompany(Company company){
        String name = company.getName();
        try (Connection connection = DriverManager.getConnection(url,user,pass);
        PreparedStatement statement = connection.prepareStatement("INSERT INTO companies(comp_name) VALUES (?);")){
            statement.setString(1,name);
            statement.executeUpdate();
            System.out.println(name + ", successfully added to DB");
        }catch (SQLException e){
            throw new RuntimeException("Cannot connect to DB", e);
        }

    }

    public List<Company> getAllCompanies() {
        List<Company> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM companies;";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Company company = createCompany(resultSet);
                result.add(company);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        }

        return result;
    }

    public Company getByName(String name) {
        Company result;
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM companies WHERE companies.comp_name LIKE ?;")) {
            name = "%" + name + "%";
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = createCompany(resultSet);
            } else {
                result = new Company("Default");
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to DB", e);
        }
    }

    public void deleteByName(String name) {
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM companies WHERE comp_name LIKE ?;")) {
            String name1 = "%" + name + "%";
            statement.setString(1,name1);
            statement.executeUpdate();
            System.out.println(name + ", Successfully deleted");
        }catch (SQLException e){
            throw  new RuntimeException("Cannot connect to DB", e);
        }
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
