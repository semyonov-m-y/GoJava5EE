package module2_jdbc.my_practice.jdbc.exception;

/**
 * Created by GetFire on 17.02.2017.
 */
public class JdbcProjectDaoException extends RuntimeException {
    public JdbcProjectDaoException() {
        super();
    }

    public JdbcProjectDaoException(String message) {
        super(message);
    }

    public JdbcProjectDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public JdbcProjectDaoException(Throwable cause) {
        super(cause);
    }
}
