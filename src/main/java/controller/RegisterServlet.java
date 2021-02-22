package controller;

import utility.DBUtility;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        try {

            /* sqlite
            Connection con = DBUtility.createConnection();
            PreparedStatement ps = con.prepareStatement("insert into users values (?, ?)");
            */

            // loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            // creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:mysql:/ /localhost:3306/tenebrae", "root", "mysql");
            PreparedStatement ps = con.prepareStatement("insert into users values (?, ?)");

            ps.setString(1, email);
            ps.setString(2, pass);
            int i = ps.executeUpdate();

            if(i > 0){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('You are succesfully registered!');");
                out.println("</script>");
            }
        } catch (Exception se) {
            se.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
