package controller;

import dao.CampaignDAO;
import dao.CampaignDAOException;
import dao.CampaignDAOImpl;
import utility.WorkbookUtility;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateCampaignServlet", value = "/createCampaign")
public class CreateCampaignServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String weaponsPath = getServletContext().getRealPath(WorkbookUtility.WEAPONS_FILE_DATA);
        final String itemsPath = getServletContext().getRealPath(WorkbookUtility.ITEMS_FILE_DATA);
        final String spellsPath = getServletContext().getRealPath(WorkbookUtility.SPELLS_FILE_DATA);
        final String pcsPath = getServletContext().getRealPath(WorkbookUtility.PCS_FILE_DATA);
        final String npcsPath = getServletContext().getRealPath(WorkbookUtility.NPCS_FILE_DATA);
        final CampaignDAO campaignDAO = new CampaignDAOImpl();
        String message;

        try {
            campaignDAO.populateDB(weaponsPath,itemsPath,spellsPath,pcsPath,npcsPath);
            message = "Database successfully populated!";
        } catch (CampaignDAOException e) {
            e.printStackTrace();
            message = "There was an error creating the database. The database has not been populated.";
        }
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/createCampaign.jsp").forward(request,response);
    }
}
