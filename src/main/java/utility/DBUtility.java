/*
* The DBUtility java class is used to register a JDBC driver with sqlite in order to create
* a lightweight database.
* */

package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtility {
    public static final int TIMEOUT = 30;
    private static final String CONNECTION = "jdbc:postgresql://ec2-3-87-180-131.compute-1.amazonaws.com:5432/d7iin3c0jveuc0";

    public static Connection createConnection() throws SQLException, ClassNotFoundException {
        //create database connection, this also creates the database
        return DriverManager.getConnection(CONNECTION);
    }

    public static void closeConnection(final Connection connection, final Statement statement) throws SQLException {

        if(connection != null) connection.close();
        if (statement != null) statement.close();

    }
}