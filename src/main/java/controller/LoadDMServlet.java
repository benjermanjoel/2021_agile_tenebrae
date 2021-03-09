package controller;

import dao.CampaignDAO;
import dao.CampaignDAOException;
import dao.CampaignDAOImpl;
import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
/* The LoadDMServlet is used to retrieve playable and non-playable characters, items, weapons and spells for display to
DM's on the DM dashboard page.
* */
@WebServlet(name = "LoadDMServlet", value = "/LoadDMServlet")
public class LoadDMServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* Set variables */
        final CampaignDAO campaignDAO = new CampaignDAOImpl();
        HttpSession session = request.getSession();
        final int user_id = ((int)session.getAttribute("user_id"));

        //Tell servlet which file to route to
        String target = "screenDM.jsp";

        try {
            /* ------------------------Retrieve Players--------------------------- */

            /* Retrieve list of PC information from DAO and store in variable pcList */
            List<PC> pcList = campaignDAO.retrievePCs(user_id);

            /* Retrieve list of NPC information from DAO and store in variable npcList */
            List<NPC> npcList = campaignDAO.retrieveNPCs(user_id);

            //Attach our lists of people to the request object
            request.setAttribute("pcList", pcList);
            request.setAttribute("npcList", npcList);

            /* ------------------------Retrieve Items--------------------------- */

            /* Retrieve list of item information from DAO and store in variable itemList */
            List<Item> itemList = campaignDAO.retrieveItems();

            //Attach our lists of items to the request object
            request.setAttribute("itemList", itemList);

            /* ------------------------Retrieve Spells--------------------------- */

            /* Retrieve list of spell information from DAO and store in variable spellList */
            List<Spell> spellList = campaignDAO.retrieveSpells();

            //Attach our lists of items to the request object
            request.setAttribute("spellList", spellList);

            /* ------------------------Retrieve Weapons--------------------------- */

            /* Retrieve list of weapon information from DAO and store in variable weaponList */
            List<Weapon> weaponList = campaignDAO.retrieveWeapons();

            //Attach our lists of items to the request object
            request.setAttribute("weaponList", weaponList);

        } catch (CampaignDAOException e) {
            e.printStackTrace();
        }

        //Forward the request object to the correct .jsp
        request.getRequestDispatcher(target).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
