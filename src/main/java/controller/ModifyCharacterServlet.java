package controller;

import dao.CampaignDAO;
import dao.CampaignDAOException;
import dao.CampaignDAOImpl;
import utility.DBUtility;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "ModifyCharacterServlet", value = "/ModifyCharacterServlet")
public class ModifyCharacterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection;
        PreparedStatement statement;
        final CampaignDAO campaignDAO = new CampaignDAOImpl();
        final String name = request.getParameter("name");
        final String SELECT_ALL_CHARS = "select * from characters where name = ?;";

        try {
            connection = DBUtility.createConnection();
            statement = connection.prepareStatement(SELECT_ALL_CHARS);
            statement.setString(1, name);
            statement.setQueryTimeout(DBUtility.TIMEOUT);

            ResultSet rs = statement.executeQuery();
            rs.next();
            boolean isnpc = rs.getBoolean("isnpc");

            if (isnpc == true) try {
                campaignDAO.modifyNPC(name);
                request.setAttribute("message", "Non-playable character modified successfully.");
            } catch (CampaignDAOException exception) {
                exception.printStackTrace();
                request.setAttribute("message", exception.getMessage());
            }
            else {
                try {
                    campaignDAO.modifyPC(name);
                    request.setAttribute("message", "Playable character modified successfully.");
                } catch (CampaignDAOException exception) {
                    exception.printStackTrace();
                    request.setAttribute("message", exception.getMessage());
                }
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/modifyCharacter.jsp").forward(request, response);
    }
}
