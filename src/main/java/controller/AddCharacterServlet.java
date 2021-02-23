package controller;

import com.google.common.base.Strings;
import dao.CampaignDAO;
import dao.CampaignDAOException;
import dao.CampaignDAOImpl;
import model.PC;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddCharacterServlet", value = "/addCharacter")
public class AddCharacterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String name = request.getParameter("name");
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
        final String background = request.getParameter("background");



//        if (Strings.isNullOrEmpty(title)
//                || Strings.isNullOrEmpty(director)
//                || Strings.isNullOrEmpty(runtimeString)){
//            // one of the above was null or empty
//            request.setAttribute("message", "Please complete all required fields");
//        }
//        else {
//            // all required fields entered

            final CampaignDAO campaignDAO = new CampaignDAOImpl();
            final PC pc = new PC(name,char_class,level,race,hitPts,armorClass,proficiency,initiative,speed,strength,
                    dexterity,constitution,intelligence,wisdom,charisma,background);

            try {
                campaignDAO.addPC(pc);
                request.setAttribute("message", "A new playable character has been added successfully!");

            } catch (CampaignDAOException exception) {
                exception.printStackTrace();
                request.setAttribute("message", exception.getMessage());
            }
            getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
