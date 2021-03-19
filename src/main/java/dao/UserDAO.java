package dao;
import model.User;
import utility.DBUtility;

import java.sql.*;
import java.util.Properties;

public class UserDAO {

    public User checkLogin(String email, String password) throws SQLException, ClassNotFoundException{

        Connection conn = DBUtility.createConnection();
        String sql = "select * from users where email = ? and password = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setQueryTimeout(DBUtility.TIMEOUT);

        statement.setString(1, email);
        statement.setString(2, password);

        ResultSet result = statement.executeQuery();

        User user = null;

        if(result.next()){
            user = new User();
            user.setId(result.getInt("user_id"));
            user.setFirstName(result.getString("firstname"));
            user.setLastName(result.getString("lastname"));
            user.setEmail(email);
        }

        conn.close();

        return user;
    }


}
