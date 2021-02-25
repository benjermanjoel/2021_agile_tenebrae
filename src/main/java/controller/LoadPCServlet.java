package controller;

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

@WebServlet(name = "LoadPCServlet", value = "/LoadPCServlet")
public class LoadPCServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* Set variables */
        final CampaignDAO campaignDAO = new CampaignDAOImpl();

        //Tell servlet which file to route to
        String target = "screenPC.jsp";

        try {

            /* Retrieve list of PC information from DAO and store in variable pcList */
            List<PC> pcList = campaignDAO.retrievePCs();

            //Attach our list of people to the request object
            request.setAttribute("pcList", pcList);

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
