/*
* The CampaignDAO class is an interface that defines methods that must be implemented by other
*  java classes and is used here as a best practice.
* */

package dao;

import model.*;
import java.util.List;

public interface CampaignDAO {
    void populateDB(String weaponsPath,String itemsPath,String spellsPath,String pcsPath,String npcsPath) throws CampaignDAOException;
    List<Weapon> retrieveWeapons() throws CampaignDAOException;
    List<Item> retrieveItems() throws CampaignDAOException;
    List<Spell> retrieveSpells() throws CampaignDAOException;
    List<PC> retrievePCs() throws CampaignDAOException;
    List<NPC> retrieveNPCs() throws CampaignDAOException;
    void addPC(PC pc) throws CampaignDAOException;
    void addNPC(NPC npc) throws CampaignDAOException;
    void deletePC(String name) throws CampaignDAOException;
    void deleteNPC(String name,Integer char_id) throws CampaignDAOException;
    //TODO determine if we need more stuff here.
}
