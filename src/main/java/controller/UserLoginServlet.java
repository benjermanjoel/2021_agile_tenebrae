package controller;

import dao.UserDAO;
import model.User;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "UserLoginServlet", value="/login")
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserLoginServlet(){
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO userDao = new UserDAO();

        try{
            User user = userDao.checkLogin(email, password);
            String destPage = "index.jsp";

            if(user != null){
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                session.setAttribute("user_id", user.getId());
                destPage = "main.jsp";
            } else {
                String message = "Invalid email/password";
                request.setAttribute("message", message);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException ex){
            throw new ServletException(ex);
        }
    }
}
