package controller;

import com.google.common.base.Strings;
import dao.CampaignDAO;
import dao.CampaignDAOException;
import dao.CampaignDAOImpl;
import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddCharacterServlet", urlPatterns = "/addCharacter")
public class AddCharacterServlet extends HttpServlet {
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

        if (Strings.isNullOrEmpty(name)
                || Strings.isNullOrEmpty(char_class)
                || Strings.isNullOrEmpty(race)
                || Strings.isNullOrEmpty(level)) {
            // one of the above was null or empty
            request.setAttribute("message", "Please complete all required fields");
        }
        else {
            // all required fields entered
            if (Strings.isNullOrEmpty(type)
                    || Strings.isNullOrEmpty(traits)
                    || Strings.isNullOrEmpty(location)){
                final CampaignDAO campaignDAO = new CampaignDAOImpl();
                final PC pc = new PC(name, char_class, level, race, hitPts, armorClass, proficiency, initiative, speed, strength,
                        dexterity, constitution, intelligence, wisdom, charisma, background);

                try {
                    campaignDAO.addPC(pc);
                    request.setAttribute("message", "A new playable character has been added successfully!");

                } catch (CampaignDAOException exception) {
                    exception.printStackTrace();
                    request.setAttribute("message", exception.getMessage());
                }
                getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
            }
            else {
                final CampaignDAO campaignDAO = new CampaignDAOImpl();
                final NPC npc = new NPC(name, type,char_class, level, race, hitPts, armorClass, proficiency, initiative, speed, strength,
                        dexterity, constitution, intelligence, wisdom, charisma, location, traits, background);

                try {
                    campaignDAO.addNPC(npc);
                    request.setAttribute("message", "A new non-playable character has been added successfully!");

                } catch (CampaignDAOException exception) {
                    exception.printStackTrace();
                    request.setAttribute("message", exception.getMessage());
                }
                getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
