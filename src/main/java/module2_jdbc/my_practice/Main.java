package module2_jdbc.my_practice;

import module2_jdbc.my_practice.jdbc.JdbcProjectDAO;
import module2_jdbc.my_practice.model.ProjectDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args)throws Exception {
        ProjectDAO jdbcProjectDAO = new JdbcProjectDAO();

        System.out.println("All projects");
        jdbcProjectDAO.getAll().forEach(System.out::println);

        System.out.println("Project with id 3");
        System.out.println(jdbcProjectDAO.load(3));


    }

}

