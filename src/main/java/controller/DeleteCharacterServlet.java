package controller;

import dao.CampaignDAO;
import dao.CampaignDAOException;
import dao.CampaignDAOImpl;
import utility.DBUtility;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "DeleteCharacterServlet", value = "/DeleteCharacter")
public class DeleteCharacterServlet extends HttpServlet {
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
            int char_id = rs.getInt(1);

            if (isnpc == true) try {
                    campaignDAO.deleteNPC(name,char_id);
                    request.setAttribute("message", "Non-playable character deleted successfully.");
                } catch (CampaignDAOException exception) {
                    exception.printStackTrace();
                    request.setAttribute("message", exception.getMessage());
                }
                else {
                    try {
                        campaignDAO.deletePC(name);
                        request.setAttribute("message", "Playable character deleted successfully.");
                    } catch (CampaignDAOException exception) {
                        exception.printStackTrace();
                        request.setAttribute("message", exception.getMessage());
                    }
                }
            connection.close();
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/deleteCharacter.jsp").forward(request, response);
    }

}
