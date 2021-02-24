/*
 * The DBUtility java class is used to register a JDBC driver with sqlite in order to create
 * a lightweight database.
 * */

package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtility {
    public static final int TIMEOUT = 30;
    private static final String CONNECTION = "jdbc:postgresql://ec2-3-87-180-131.compute-1.amazonaws.com:5432/d7iin3c0jveuc0";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String DB_USER = "xmmswjwvrjiqum";
    private static final String DB_PASSWORD = "ff9117bc32289988222af83be7cfce55d5b6068e2df694fba3b6ca159a934193";

    public static Connection createConnection() throws SQLException, ClassNotFoundException {
        //register
        Class.forName(DRIVER);
        //create database connection, this also creates the database
        Properties props = new Properties();
        props.setProperty("user", DB_USER);
        props.setProperty("password", DB_PASSWORD);

        return DriverManager.getConnection(CONNECTION, props);
    }

    public static void closeConnection(final Connection connection, final Statement statement) throws SQLException {

        if(connection != null) connection.close();
        if (statement != null) statement.close();

    }
}