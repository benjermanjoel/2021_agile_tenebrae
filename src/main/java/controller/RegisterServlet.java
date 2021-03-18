package controller;

import dao.UserDAO;
import model.User;
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

        String fName = request.getParameter("firstName");
        String lName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");


        try {
            String destPage = "register.jsp";

            Connection con = DBUtility.createConnection();
            PreparedStatement ps = con.prepareStatement("insert into users(firstname, lastname, password, email) values (?, ?, ?, ?)");

            ps.setString(1, fName);
            ps.setString(2, lName);
            ps.setString(3, pass);
            ps.setString(4, email);
            int i = ps.executeUpdate();

            if(i > 0){
                String message = "You are successfully registered";
                request.setAttribute("message", message);
                destPage = "index.jsp";
            }

            con.close();


            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
        } catch (Exception se) {
            se.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
