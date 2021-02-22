package controller;

import dao.CampaignDAO;
import dao.CampaignDAOException;
import dao.CampaignDAOImpl;
import model.PC;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "viewPC", value = "/viewPC")
public class viewPC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final CampaignDAO campaignDAO = new CampaignDAOImpl();

        try {
            List<PC> pcList = campaignDAO.retrievePCs();
        } catch (CampaignDAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
