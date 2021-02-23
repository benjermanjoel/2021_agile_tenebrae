package dao;
import model.User;

import java.sql.*;
import java.util.Properties;

public class UserDAO {

    public User checkLogin(String email, String password) throws SQLException, ClassNotFoundException{
        String jdbcURL = "jdbc:postgresql://ec2-3-87-180-131.compute-1.amazonaws.com:5432/d7iin3c0jveuc0";
        String dbUser = "xmmswjwvrjiqum";
        String dbPassword = "ff9117bc32289988222af83be7cfce55d5b6068e2df694fba3b6ca159a934193";

        // Insert Database Creds and create a new connection
        Class.forName("org.postgresql.Driver");
        Properties props = new Properties();
        props.setProperty("user", dbUser);
        props.setProperty("password", dbPassword);
        props.setProperty("ssl", "true");
        Connection conn = DriverManager.getConnection(jdbcURL, props);

        String sql = "select * from users where email = ? and password = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);

        ResultSet result = statement.executeQuery();

        User user = null;

        if(result.next()){
            user = new User();
            user.setFirstName(result.getString("firstname"));
            user.setLastName(result.getString("lastname"));
            user.setEmail(email);
        }

        conn.close();

        return user;
    }
}
