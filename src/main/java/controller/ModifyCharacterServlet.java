package controller;

import com.google.common.base.Strings;
import dao.CampaignDAO;
import dao.CampaignDAOException;
import dao.CampaignDAOImpl;
import model.NPC;
import model.PC;
import utility.DBUtility;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "ModifyCharacterServlet", value = "/modifyCharacter")
public class ModifyCharacterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String name = request.getParameter("name");
        final String type = request.getParameter("type");
        final String char_class = request.getParameter("class");
        final String level = request.getParameter("level");
        final String race = request.getParameter("race");
        final String hitPts = request.getParameter("hitPts");
        final String armorClass = request.getParameter("armorClass");
        final String proficiency = request.getParameter("proficiency");
        final String initiative = request.getParameter("initiative");
        final String speed = request.getParameter("speed");
        final String strength = request.getParameter("strength");
        final String dexterity = request.getParameter("dexterity");
        final String constitution = request.getParameter("constitution");
        final String intelligence = request.getParameter("intelligence");
        final String wisdom = request.getParameter("wisdom");
        final String charisma = request.getParameter("charisma");
        final String location = request.getParameter("location");
        final String traits = request.getParameter("traits");
        final String background = request.getParameter("background");

        if (Strings.isNullOrEmpty(type)
                && Strings.isNullOrEmpty(traits)
                && Strings.isNullOrEmpty(location)) {

            final CampaignDAO campaignDAO = new CampaignDAOImpl();
            final PC pc = new PC(name, char_class, level, race, hitPts, armorClass, proficiency, initiative, speed, strength,
                    dexterity, constitution, intelligence, wisdom, charisma, background);

            try {
                Connection connection;
                PreparedStatement statement;
                connection = DBUtility.createConnection();
                statement = connection.prepareStatement("select char_id from characters where name = ?;");
                statement.setString(1, name);
                statement.setQueryTimeout(DBUtility.TIMEOUT);

                ResultSet rs = statement.executeQuery();
                rs.next();
                int char_id = rs.getInt(1);

                campaignDAO.modifyPC(pc, char_id);
                request.setAttribute("message", "Playable character modified successfully!");

            } catch (CampaignDAOException | SQLException | ClassNotFoundException exception) {
                exception.printStackTrace();
                request.setAttribute("message", exception.getMessage());
            }
            getServletContext().getRequestDispatcher("/modifyCharacter.jsp").forward(request, response);
        } else {
            final CampaignDAO campaignDAO = new CampaignDAOImpl();
            final NPC npc = new NPC(name, type, char_class, level, race, hitPts, armorClass, proficiency, initiative, speed, strength,
                    dexterity, constitution, intelligence, wisdom, charisma, location, traits, background);

            try {
                Connection connection;
                PreparedStatement statement;
                connection = DBUtility.createConnection();
                statement = connection.prepareStatement("select char_id from characters where name = ?;");
                statement.setString(1, name);
                statement.setQueryTimeout(DBUtility.TIMEOUT);

                ResultSet rs = statement.executeQuery();
                rs.next();
                int char_id = rs.getInt(1);

                campaignDAO.modifyNPC(npc,char_id);
                request.setAttribute("message", "Non-playable character modified successfully!");

            } catch (CampaignDAOException | SQLException | ClassNotFoundException exception) {
                exception.printStackTrace();
                request.setAttribute("message", exception.getMessage());
            }
            getServletContext().getRequestDispatcher("/modifyCharacter.jsp").forward(request, response);
        }
    }
}