package controller;

import com.google.gson.Gson;
import dao.CampaignDAO;
import dao.CampaignDAOException;
import dao.CampaignDAOImpl;
import dao.TestDAO;
import model.NPC;
import model.PC;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewPCServlet", value = "/ViewPCServlet")
public class ViewPCServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* Set variables */
        final CampaignDAO campaignDAO = new CampaignDAOImpl();
        String requestType = request.getParameter("type");
        String name = request.getParameter("name");


        if (requestType.equals("PC")) {

            /* Set empty variable to hold found Player Character information */
            PC foundPC = null;
            try {
                /* Retrieve list of PC information from DAO and store in variable pcList */
                List<PC> pcList = campaignDAO.retrievePCs();

                /* Cycle through list of PC's to find matching name */
                /* For each PC(model) pc in pcList... */
                for (PC pc : pcList) {
                    /* ...if the name matches... */
                    if (name.equals(pc.getName())) {
                        /* ...store in empty variable foundPC */
                        foundPC = pc;
                        break;
                    }
                }

                if (foundPC == null) {
                    return;
                }

                /* Create new gson variable to hold json */
                Gson gson = new Gson();

                /* Populate json with Player Character found and convert to JSON */
                String json = gson.toJson(foundPC);

                /* Display information  */
                response.getWriter().println(json);


            } catch (CampaignDAOException e) {
                e.printStackTrace();
            }

        } else if (requestType.equals("NPC")){

            /* Set empty variable to hold found Non Player Character information */
            NPC foundNPC = null;
            try {
                /* Retrieve list of NPC information from DAO and store in variable npcList */
                List<NPC> npcList = campaignDAO.retrieveNPCs();

                /* Cycle through list of NPC's to find matching name */
                /* For each NPC(model) npc in npcList... */
                for (NPC npc : npcList) {
                    /* ...if the name matches... */
                    if (name.equals(npc.getName())) {
                        /* ...store in empty variable foundNPC */
                        foundNPC = npc;
                        break;
                    }
                }

                if (foundNPC == null) {
                    return;
                }

                /* Create new gson variable to hold json */
                Gson gson = new Gson();

                /* Populate json with Player Character found and convert to JSON */
                String json = gson.toJson(foundNPC);

                /* Display information  */
                response.getWriter().println(json);
            } catch (CampaignDAOException e) {
                e.printStackTrace();
            }
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
