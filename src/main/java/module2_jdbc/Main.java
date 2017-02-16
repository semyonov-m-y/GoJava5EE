package module2_jdbc;

import module2_jdbc.jdbc.JdbcProjectDAO;
import module2_jdbc.model.ProjectDAO;

public class Main {

    public static void main(String[] args) {
        ProjectDAO jdbcProjectDAO = new JdbcProjectDAO();

        System.out.println("All projects");
        jdbcProjectDAO.getAll().forEach(System.out::println);

        System.out.println("Project with id 3");
        System.out.println(jdbcProjectDAO.load(3));
        System.out.println("Project with id 1");
        System.out.println(jdbcProjectDAO.load(1));

    }

}

