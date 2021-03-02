package dao;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class TestDAO implements CampaignDAO {
    @Override
    public void populateDB(String weaponsPath, String itemsPath, String spellsPath, String pcsPath, String npcsPath) throws CampaignDAOException {

    }

    @Override
    public List<Weapon> retrieveWeapons() throws CampaignDAOException {
        return null;
    }

    @Override
    public List<Item> retrieveItems() throws CampaignDAOException {
        return null;
    }

    @Override
    public List<Spell> retrieveSpells() throws CampaignDAOException {
        return null;
    }

    @Override
    public List<PC> retrievePCs() throws CampaignDAOException {
        PC pc = new PC("Toddddd", "Bard", "7", "Human", "40", "20", "2", "1", "30", "15", "12", "10", "18", "14", "14", "He has history.");

        List<PC> list = new ArrayList<PC>() {{
           add(pc);
        }};
        return list;
    }

    @Override
    public List<NPC> retrieveNPCs() throws CampaignDAOException {
        NPC npc = new NPC("Jarnthoor", "Combat", "Barbarian", "12", "Half-Orc", "55", "14", "1", "2","30", "17", "15", "17", "18", "15", "14", "Pumperduke", "Very angry", "Crazy man kills things.");


        List<NPC> list = new ArrayList<NPC>() {{
            add(npc);
        }};
        return list;

    }

    @Override
    public void addPC(PC pc) throws CampaignDAOException {

    }

    @Override
    public void addNPC(NPC npc) throws CampaignDAOException {

    }

    @Override
    public void modifyPC(String name) throws CampaignDAOException {

    }

    @Override
    public void modifyNPC(String name) throws CampaignDAOException {

    }

    @Override
    public void deletePC(String name) throws CampaignDAOException {

    }

    @Override
    public void deleteNPC(String name) throws CampaignDAOException {

    }
}
