package controller;

import dao.CampaignDAO;
import dao.CampaignDAOException;
import dao.CampaignDAOImpl;
import model.NPC;
import model.PC;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoadDMServlet", value = "/LoadDMServlet")
public class LoadDMServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* Set variables */
        final CampaignDAO campaignDAO = new CampaignDAOImpl();

        //Tell servlet which file to route to
        String target = "screenDM.jsp";

        try {

            /* Retrieve list of PC information from DAO and store in variable pcList */
            List<PC> pcList = campaignDAO.retrievePCs();

            /* Retrieve list of NPC information from DAO and store in variable npcList */
            List<NPC> npcList = campaignDAO.retrieveNPCs();

            //Attach our lists of people to the request object
            request.setAttribute("pcList", pcList);
            request.setAttribute("npcList", npcList);

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
