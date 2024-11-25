package DataBase.Connection;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class DataBaseConnection {
    public static final String JDBC_URL = "jdbc:mysql://18.209.45.69:3306/1152370?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String DB_USER = "test";
    public static final String DB_CLAVE = "test1_*";

    public static DataSource getDataSource() {

        BasicDataSource bs = new BasicDataSource();
        bs.setUrl(JDBC_URL);
        bs.setUsername(DB_USER);
        bs.setPassword(DB_CLAVE);
        bs.setInitialSize(5);
        return bs;

    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return getDataSource().getConnection();

    }
}
