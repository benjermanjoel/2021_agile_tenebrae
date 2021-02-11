package dao;

import model.Campaign;
import java.util.List;

public interface CampaignDAO {
    void populateDB(String filepath) throws CampaignDAOException;
    List<Campaign> retrieveData() throws CampaignDAOException;
    //TODO determine if we need more exceptions here.
}
