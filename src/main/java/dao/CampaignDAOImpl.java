/*
* The CampaignDAOImpl class implements the CampaignDAO interface and its methods. It is used for
* creating and populating the web application's database.
* */

package dao;

import model.*;
import model.Item;
import utility.DBUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CampaignDAOImpl implements CampaignDAO{

/*
     Database creation actions. The following code block instantiates final strings of SQL queries that are used for
     dropping all tables, creating each individual table, and for selecting all table information.
     These final's are later used in the implemented interface methods below.
*/
    // With each new campaign creation, all tables are dropped!
    final static String DROP_WEAPONS_TABLE = "drop table if exists weapons;";
    final static String DROP_ITEMS_TABLE = "drop table if exists items;";
    final static String DROP_SPELLS_TABLE = "drop table if exists spells;";
    final static String DROP_PCS_TABLE = "drop table if exists pcs;";
    final static String DROP_NPCS_TABLE = "drop table if exists npcs;";
    // CREATE and SELECT queries for weapons
    final static String CREATE_TABLE_WEAPONS = "create table weapons(id serial primary key, name text, " +
            "type text, cost text, damage text, weight text, properties text);";
    final static String SELECT_ALL_WEAPONS = "select * from weapons;";
    // CREATE and SELECT queries for items
    final static String CREATE_TABLE_ITEMs = "create table items(id serial primary key, name text, " +
            "type text, cost text, weight text);";
    final static String SELECT_ALL_ITEMS = "select * from items;";
    // CREATE and SELECT queries for spells
    final static String CREATE_TABLE_SPELLS = "create table spells(id serial primary key, name text, " +
            "level text, school text, casting text, ritual text, concentration text, classes text);";
    final static String SELECT_ALL_SPELLS = "select * from spells;";
    // CREATE and SELECT queries for pcs
    final static String CREATE_TABLE_PCS = "create table pcs(id serial primary key, name text, " +
            "char_class text,level text,race text,hitpts text,armor text,proficiency text, " +
            "initiative text,speed text,strength text,dexterity text,constitution text, "+
            "intelligence text,wisdom text,charisma text,background text);";
    final static String SELECT_ALL_PCS = "select * from characters where isnpc=false;";
    // CREATE and SELECT queries for npcs
    final static String CREATE_TABLE_NPCS = "create table npcs(id serial primary key, name text, " +
            "type text,char_class text,level text,race text,hitpts text,armor text,proficiency text, " +
            "initiative text,speed text,strength text,dexterity text,constitution text, "+
            "intelligence text,wisdom text,charisma text,location text,traits text,background text);";
    final static String SELECT_ALL_NPCS = "select * from characters join npcs n on characters.char_id = n.char_id";

    @Override
    /*
    * The following method leverages the SELECT_ALL_WEAPONS query to retrieve weapons data from the weapons table
    *
    * */
    public List<Weapon> retrieveWeapons() throws CampaignDAOException {
        final List<Weapon> weapons = new ArrayList<Weapon>();
        Connection connection;
        Statement statement;

        try {
            connection = DBUtility.createConnection();
            statement = connection.createStatement();
            statement.setQueryTimeout(DBUtility.TIMEOUT);

            // select all data from weapons table
            final ResultSet results = statement.executeQuery(SELECT_ALL_WEAPONS);
            // loop
            while (results.next()){
                final String name = results.getString("name");
                final String type = results.getString("type");
                final String cost = results.getString("cost");
                final String damage = results.getString("damage");
                final String weight = results.getString("weight");
                final String properties = results.getString("properties");

                weapons.add(new Weapon(name,type,cost,damage,weight,properties));
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
            throw new CampaignDAOException("Error: unable to retrieve weapons records from the weapons table.");
        }
        return weapons;
    }

    @Override
    /*
     * The following method leverages the SELECT_ALL_ITEMS query to retrieve item data from the items table
     *
     * */
    public List<Item> retrieveItems() throws CampaignDAOException {
        final List<Item> items = new ArrayList<Item>();
        Connection connection;
        Statement statement;

        try {
            connection = DBUtility.createConnection();
            statement = connection.createStatement();
            statement.setQueryTimeout(DBUtility.TIMEOUT);

            // select all data from items table
            final ResultSet results = statement.executeQuery(SELECT_ALL_ITEMS);
            // loop
            while (results.next()){
                final String name = results.getString("name");
                final String type = results.getString("type");
                final String cost = results.getString("cost");
                final String weight = results.getString("weight");

                items.add(new Item(name,type,cost,weight));
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
            throw new CampaignDAOException("Error: unable to retrieve item records from the items table.");
        }
        return items;
    }

    @Override
    /*
     * The following method leverages the SELECT_ALL_SPELLS query to retrieve spell data from the spells table
     *
     * */
    public List<Spell> retrieveSpells() throws CampaignDAOException {
        final List<Spell> spells = new ArrayList<Spell>();
        Connection connection;
        Statement statement;

        try {
            connection = DBUtility.createConnection();
            statement = connection.createStatement();
            statement.setQueryTimeout(DBUtility.TIMEOUT);

            // select all data from spells table
            final ResultSet results = statement.executeQuery(SELECT_ALL_SPELLS);
            // loop
            while (results.next()){
                final String name = results.getString("name");
                final String level = results.getString("level");
                final String school = results.getString("school");
                final String casting = results.getString("casting");
                final String ritual = results.getString("ritual");
                final String concentration = results.getString("concentration");
                final String classes = results.getString("classes");

                spells.add(new Spell(name,level,school,casting,ritual,concentration,classes));
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
            throw new CampaignDAOException("Error: unable to retrieve spell records from the spells table.");
        }
        return spells;
    }

    @Override
    //The following method leverages the SELECT_ALL_PCS query to retrieve PC data from the pcs table

    //TODO de-duplicate code.
    public List<PC> retrievePCs() throws CampaignDAOException {
        final List<PC> pcs = new ArrayList<PC>();
        Connection connection;
        Statement statement;

        try {
            connection = DBUtility.createConnection();
            statement = connection.createStatement();
            statement.setQueryTimeout(DBUtility.TIMEOUT);

            // select all data from pcs table
            final ResultSet results = statement.executeQuery(SELECT_ALL_PCS);
            // loop
            while (results.next()){
                 int user_id = results.getInt("user_id");
                 String name = results.getString("name");
                 String char_class = results.getString("class");
                 String level = results.getString("level");
                 String race = results.getString("race");
                 String hitpts = results.getString("hp");
                 String armor = results.getString("ac");
                 String proficiency = results.getString("proficiency");
                 String initiative = results.getString("initiative");
                 String speed = results.getString("speed");
                 String strength = results.getString("str");
                 String dexterity = results.getString("dex");
                 String constitution = results.getString("con");
                 String intelligence = results.getString("intel");
                 String wisdom = results.getString("wis");
                 String charisma = results.getString("cha");
                 String background = results.getString("background");

                pcs.add(new PC(user_id,name,char_class,level,race,hitpts,armor,proficiency,initiative,speed,
                        strength,dexterity,constitution,intelligence,wisdom,charisma,background));
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
            throw new CampaignDAOException("Error: unable to retrieve pc records from the characters table.");
        }
        return pcs;
    }

    @Override
    //The following method leverages the SELECT_ALL_NPCS query to retrieve NPC data from the npcs table

    //TODO de-duplicate code
    public List<NPC> retrieveNPCs() throws CampaignDAOException {
        final List<NPC> npcs = new ArrayList<NPC>();
        Connection connection;
        Statement statement;

        try {
            connection = DBUtility.createConnection();
            statement = connection.createStatement();
            statement.setQueryTimeout(DBUtility.TIMEOUT);

            // select all data from npcs table
            final ResultSet results = statement.executeQuery(SELECT_ALL_NPCS);
            // loop
            while (results.next()){
                 int user_id = results.getInt("user_id");
                 String name = results.getString("name");
                 String char_class = results.getString("class");
                 String level = results.getString("level");
                 String race = results.getString("race");
                 String hitpts = results.getString("hp");
                 String armor = results.getString("ac");
                 String proficiency = results.getString("proficiency");
                 String initiative = results.getString("initiative");
                 String speed = results.getString("speed");
                 String strength = results.getString("str");
                 String dexterity = results.getString("dex");
                 String constitution = results.getString("con");
                 String intelligence = results.getString("intel");
                 String wisdom = results.getString("wis");
                 String charisma = results.getString("cha");
                 String background = results.getString("background");

                 String type = results.getString("type");
                 String location = results.getString("loc");
                 String traits = results.getString("traits");

                npcs.add(new NPC(user_id,name,type,char_class,level,race,hitpts,armor,proficiency,initiative,speed,
                        strength,dexterity,constitution,intelligence,wisdom,charisma,location,traits,background));
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
            throw new CampaignDAOException("Error: unable to retrieve npc records from the npcs table.");
        }
        return npcs;
    }

    @Override
    public void addPC(PC pc) throws CampaignDAOException {
        Connection connection;
        PreparedStatement insertStatement;

        try {
            connection = DBUtility.createConnection();
            final String addPCSQL = "insert into characters (name, level, race, class, hp, ac,proficiency," +
                    "initiative,speed,str,dex,con,intel,wis,cha,background,isnpc, user_id) values" +
                    "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            // Insert a new record into pcs table using our prepared statement
            insertStatement = connection.prepareStatement(addPCSQL);
            insertStatement.setString(1, pc.getName());
            insertStatement.setString(2, pc.getLevel());
            insertStatement.setString(3, pc.getRace());
            insertStatement.setString(4, pc.getChar_class());
            insertStatement.setString(5, pc.getHitpts());
            insertStatement.setString(6, pc.getArmor());
            insertStatement.setString(7, pc.getProficiency());
            insertStatement.setString(8, pc.getInitiative());
            insertStatement.setString(9, pc.getSpeed());
            insertStatement.setString(10, pc.getStrength());
            insertStatement.setString(11, pc.getDexterity());
            insertStatement.setString(12, pc.getConstitution());
            insertStatement.setString(13, pc.getIntelligence());
            insertStatement.setString(14, pc.getWisdom());
            insertStatement.setString(15, pc.getCharisma());
            insertStatement.setString(16, pc.getBackground());
            insertStatement.setBoolean(17, false);
            insertStatement.setInt(18, pc.getUser_id());


            insertStatement.setQueryTimeout(DBUtility.TIMEOUT);
            insertStatement.executeUpdate();
            connection.close();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
            throw new CampaignDAOException("Error: unable to add playable character record to the PCs table.");
        }

    }

    @Override
    public void addNPC(NPC npc) throws CampaignDAOException {
        Connection connection;
        PreparedStatement insertStatement;
        PreparedStatement insertNPCStatement;

        try {
            connection = DBUtility.createConnection();
            final String ADD_NPC_CHAR_SQL = "insert into characters (name,class,level,race,hp,ac,proficiency," +
                    "initiative,speed,str,dex,con,intel,wis,cha,background,isnpc,user_id) values" +
                    "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            final String ADD_NPC_SQL = "insert into npcs (type,loc,traits,char_id) values" +
                    "(?,?,?,?);";

            // Insert a new record into characters table using our prepared statement
            insertStatement = connection.prepareStatement(ADD_NPC_CHAR_SQL, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, npc.getName());
            insertStatement.setString(2, npc.getChar_class());
            insertStatement.setString(3, npc.getLevel());
            insertStatement.setString(4, npc.getRace());
            insertStatement.setString(5, npc.getHitpts());
            insertStatement.setString(6, npc.getArmor());
            insertStatement.setString(7, npc.getProficiency());
            insertStatement.setString(8, npc.getInitiative());
            insertStatement.setString(9, npc.getSpeed());
            insertStatement.setString(10, npc.getStrength());
            insertStatement.setString(11, npc.getDexterity());
            insertStatement.setString(12, npc.getConstitution());
            insertStatement.setString(13, npc.getIntelligence());
            insertStatement.setString(14, npc.getWisdom());
            insertStatement.setString(15, npc.getCharisma());
            insertStatement.setString(16, npc.getBackground());
            insertStatement.setBoolean(17, true);
            insertStatement.setInt(18, npc.getUser_id());

            insertStatement.setQueryTimeout(DBUtility.TIMEOUT);
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            rs.next();
            int charID = rs.getInt(1);

            insertNPCStatement = connection.prepareStatement(ADD_NPC_SQL);
            insertNPCStatement.setString(1, npc.getType());
            insertNPCStatement.setString(2, npc.getLocation());
            insertNPCStatement.setString(3, npc.getTraits());
            insertNPCStatement.setInt(4, charID);

            insertNPCStatement.setQueryTimeout(DBUtility.TIMEOUT);
            insertNPCStatement.executeUpdate();
            connection.close();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
            throw new CampaignDAOException("Error: unable to add non-playable character record to the NPCs table.");
        }

    }

    @Override
    public void deletePC(String name) throws CampaignDAOException {
        Connection connection;
        PreparedStatement deleteStatement;

        try {
            connection = DBUtility.createConnection();
            final String deletePCSQL = "delete from characters where name = ?";

            deleteStatement = connection.prepareStatement(deletePCSQL);
            deleteStatement.setString(1, name);

            deleteStatement.setQueryTimeout(DBUtility.TIMEOUT);
            deleteStatement.executeUpdate();
            connection.close();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
            throw new CampaignDAOException("Error: unable to delete playable character record from the characters table.");
        }

    }

    @Override
    public void deleteNPC(String name) throws CampaignDAOException {
        Connection connection;
        PreparedStatement deleteStatement;

        try {
            connection = DBUtility.createConnection();
            final String deleteNPC_SQL_1 = "delete from characters where name = ?";

            deleteStatement = connection.prepareStatement(deleteNPC_SQL_1);
            deleteStatement.setString(1, name);
            deleteStatement.setQueryTimeout(DBUtility.TIMEOUT);
            deleteStatement.executeUpdate();

            connection.close();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
            throw new CampaignDAOException("Error: unable to add non-playable character record from the characters table.");
        }

    }


}
