package dao;

import model.Campaign;

import java.util.List;
import java.util.function.ToDoubleBiFunction;

public class CampaignDAOImpl implements CampaignDAO{

    // Database actions
    final static String DROP_DATABASE = "drop database if exists new_campaign";
    final static String CREATE_TABLE_CHAR = "create table char(id integer primary key autoincrement, name text, " +
            "race text, char_class text);";
    final static String SELECT_ALL_CHAR = "select * from char;";
    //TODO Add table creations for all database tables

    @Override
    public void populateDB(String filepath) throws CampaignDAOException {

    }

    @Override
    public List<Campaign> retrieveData() throws CampaignDAOException {
        return null;
    }



}
