package module2_jdbc.my_practice.jdbc;

import module2_jdbc.my_practice.model.Project;
import module2_jdbc.my_practice.model.ProjectDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcProjectDAO implements ProjectDAO {
    public JdbcProjectDAO() {
        loadDriver();
    }

    private String url = "jdbc:mysql://localhost:3306/home_work1?autoReconnect=true&useSSL=false";
    private String user = "root";
    private String pass = "admin";


    @Override
    public List<Project> getAll() {
        List<Project> projectsList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT project_name, project_cost, comp_name FROM projectcompany");
            while (rs.next()) {
                Project pr = new Project(rs.getString("comp_name"),
                        rs.getString("project_name"),
                        rs.getInt("project_cost"));
                projectsList.add(pr);
            }


        } catch (SQLException e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
        return projectsList;
    }

    @Override
    public Project load(int id) {
        Project result;
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM projectcompany WHERE project_id=?")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                result = createProject(rs);
            } else {
                throw new RuntimeException("Cannot find Project with id: " + id);
            }

            rs.close();

        } catch (SQLException e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
        return result;
    }

    private Project createProject(ResultSet resultSet) throws SQLException {
        return new Project(resultSet.getString("comp_name"),
                resultSet.getString("project_name"),
                resultSet.getInt("project_cost"));
    }

    public void loadDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Cannot find driver: com.mysql.jdbc.Driver");
            throw new RuntimeException(e);
        }
    }

}
