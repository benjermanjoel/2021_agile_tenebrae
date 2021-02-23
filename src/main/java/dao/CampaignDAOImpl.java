/*
* The CampaignDAOImpl class implements the CampaignDAO interface and its methods. It is used for
* creating and populating the web application's database.
* */

package dao;

import model.*;
import model.Item;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import utility.DBUtility;
import utility.WorkbookUtility;

import java.io.File;
import java.io.IOException;
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
    final static String CREATE_TABLE_WEAPONS = "create table weapons(id integer primary key autoincrement, name text, " +
            "type text, cost text, damage text, weight text, properties text);";
    final static String SELECT_ALL_WEAPONS = "select * from weapons;";
    // CREATE and SELECT queries for items
    final static String CREATE_TABLE_ITEMs = "create table items(id integer primary key autoincrement, name text, " +
            "type text, cost text, weight text);";
    final static String SELECT_ALL_ITEMS = "select * from items;";
    // CREATE and SELECT queries for spells
    final static String CREATE_TABLE_SPELLS = "create table spells(id integer primary key autoincrement, name text, " +
            "level text, school text, casting text, ritual text, concentration text, classes text);";
    final static String SELECT_ALL_SPELLS = "select * from spells;";
    // CREATE and SELECT queries for pcs
    final static String CREATE_TABLE_PCS = "create table pcs(id integer primary key autoincrement, name text, " +
            "char_class text,level text,race text,hitpts text,armor text,proficiency text, " +
            "initiative text,speed text,strength text,dexterity text,constitution text, "+
            "intelligence text,wisdom text,charisma text,background text);";
    final static String SELECT_ALL_PCS = "select * from pcs;";
    // CREATE and SELECT queries for npcs
    final static String CREATE_TABLE_NPCS = "create table npcs(id integer primary key autoincrement, name text, " +
            "type text,char_class text,level text,race text,hitpts text,armor text,proficiency text, " +
            "initiative text,speed text,strength text,dexterity text,constitution text, "+
            "intelligence text,wisdom text,charisma text,location text,traits text,background text);";
    final static String SELECT_ALL_NPCS = "select * from npcs;";

    @Override
    /*
    * The following method, populateDB, takes as an argument a filepath. It then uses the JDBC to create a new
    * database connect which creates the database. The first SQL statement we run is to drop all tables.
    * Then using our CREATE and SELECT queries above, this method begins creating and populating our database tables.
    *
    * */
    public void populateDB(String weaponsPath,String itemsPath,String spellsPath,String pcsPath,String npcsPath) throws CampaignDAOException {
        Connection connection;
        Statement statement;

        try {
            // Create the database and tables
            connection = DBUtility.createConnection();
            statement = connection.createStatement();
            statement.setQueryTimeout(DBUtility.TIMEOUT);
            statement.executeUpdate(DROP_WEAPONS_TABLE);
            statement.executeUpdate(DROP_ITEMS_TABLE);
            statement.executeUpdate(DROP_SPELLS_TABLE);
            statement.executeUpdate(DROP_PCS_TABLE);
            statement.executeUpdate(DROP_NPCS_TABLE);
            statement.executeUpdate(CREATE_TABLE_WEAPONS);
            statement.executeUpdate(CREATE_TABLE_ITEMs);
            statement.executeUpdate(CREATE_TABLE_SPELLS);
            statement.executeUpdate(CREATE_TABLE_PCS);
            statement.executeUpdate(CREATE_TABLE_NPCS);

            // Populate the campaign tables with data
            final File weaponsFile = new File(weaponsPath);
            final File itemsFile = new File(itemsPath);
            final File spellsFile = new File(spellsPath);
            final File pcsFile = new File(pcsPath);
            final File npcsFile = new File(npcsPath);
            final List<Weapon> weapons = WorkbookUtility.retrieveWeapons(weaponsFile);
            final List<Item> items = WorkbookUtility.retrieveItems(itemsFile);
            final List<Spell> spells = WorkbookUtility.retrieveSpells(spellsFile);
            final List<PC> pcs = WorkbookUtility.retrievePCs(pcsFile);
            final List<NPC> npcs = WorkbookUtility.retrieveNPCs(npcsFile);

            for (final Weapon weapon : weapons) {
                final String insertWeapons = "insert into weapons (name,type,cost,damage,weight,properties) values" +
                        "('" + weapon.getName() + "','"
                        + weapon.getType() + "','"
                        + weapon.getCost() + "','"
                        + weapon.getDamage() + "','"
                        + weapon.getWeight() + "','"
                        + weapon.getProperties() + "')";
                //Debugging
                System.out.println(insertWeapons);
                // Insert the data
                statement.executeUpdate(insertWeapons);
            }
            for (final Item item : items) {
                final String insertItems = "insert into items (name,type,cost,weight) values" +
                        "('" + item.getName() + "','"
                        + item.getType() + "','"
                        + item.getCost() + "','"
                        + item.getWeight() + "')";
                //Debugging
                System.out.println(insertItems);
                // Insert the data
                statement.executeUpdate(insertItems);

            }
            for (final Spell spell : spells) {
                final String insertSpells = "insert into spells (name,level,school,casting,ritual,concentration,classes) values" +
                        "('" + spell.getName() + "','"
                        + spell.getLevel() + "','"
                        + spell.getSchool() + "','"
                        + spell.getCasting() + "','"
                        + spell.getRitual() + "','"
                        + spell.getConcentration() + "','"
                        + spell.getClasses() + "')";
                //Debugging
                System.out.println(insertSpells);
                // Insert the data
                statement.executeUpdate(insertSpells);
            }
            for (final PC pc : pcs) {
                final String insertPCS = "insert into pcs (name,char_class,level,race,hitpts,armor,proficiency," +
                        "initiative,speed,strength,dexterity,constitution,intelligence,wisdom,charisma,background) values" +
                        "('" + pc.getName() + "','"
                        + pc.getChar_class() + "','"
                        + pc.getLevel() + "','"
                        + pc.getRace() + "','"
                        + pc.getHitpts() + "','"
                        + pc.getArmor() + "','"
                        + pc.getProficiency() + "','"
                        + pc.getInitiative() + "','"
                        + pc.getSpeed() + "','"
                        + pc.getStrength() + "','"
                        + pc.getDexterity() + "','"
                        + pc.getConstitution() + "','"
                        + pc.getIntelligence() + "','"
                        + pc.getWisdom() + "','"
                        + pc.getCharisma() + "','"
                        + pc.getBackground() + "')";
                //Debugging
                System.out.println(insertPCS);
                // Insert the data
                statement.executeUpdate(insertPCS);
            }
            for (final NPC npc : npcs) {
                final String insertNPCS = "insert into npcs (name,type,char_class,level,race,hitpts,armor,proficiency," +
                        "initiative,speed,strength,dexterity,constitution,intelligence,wisdom,charisma,location,traits,background) values" +
                        "('" + npc.getName() + "','"
                        + npc.getType() + "','"
                        + npc.getChar_class() + "','"
                        + npc.getLevel() + "','"
                        + npc.getRace() + "','"
                        + npc.getHitpts() + "','"
                        + npc.getArmor() + "','"
                        + npc.getProficiency() + "','"
                        + npc.getInitiative() + "','"
                        + npc.getSpeed() + "','"
                        + npc.getStrength() + "','"
                        + npc.getDexterity() + "','"
                        + npc.getConstitution() + "','"
                        + npc.getIntelligence() + "','"
                        + npc.getWisdom() + "','"
                        + npc.getCharisma() + "','"
                        + npc.getLocation() + "','"
                        + npc.getTraits() + "','"
                        + npc.getBackground() + "')";
                //Debugging
                System.out.println(insertNPCS);
                // Insert the data
                statement.executeUpdate(insertNPCS);
            }
        } catch (SQLException | ClassNotFoundException | InvalidFormatException | IOException exception ) {
            exception.printStackTrace();
            throw new CampaignDAOException("Error: Unable to populate the campaign database with data from spreadsheet.");
        }
    }

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

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
            throw new CampaignDAOException("Error: unable to retrieve spell records from the spells table.");
        }
        return spells;
    }

    @Override
    /*
     * The following method leverages the SELECT_ALL_PCS query to retrieve PC data from the pcs table
     *
     * */
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
                 String name = results.getString("name");
                 String char_class = results.getString("char_class");
                 String level = results.getString("level");
                 String race = results.getString("race");
                 String hitpts = results.getString("hitpts");
                 String armor = results.getString("armor");
                 String proficiency = results.getString("proficiency");
                 String initiative = results.getString("initiative");
                 String speed = results.getString("speed");
                 String strength = results.getString("strength");
                 String dexterity = results.getString("dexterity");
                 String constitution = results.getString("constitution");
                 String intelligence = results.getString("intelligence");
                 String wisdom = results.getString("wisdom");
                 String charisma = results.getString("charisma");
                 String background = results.getString("background");

                pcs.add(new PC(name,char_class,level,race,hitpts,armor,proficiency,initiative,speed,
                        strength,dexterity,constitution,intelligence,wisdom,charisma,background));
            }

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
            throw new CampaignDAOException("Error: unable to retrieve pc records from the pcs table.");
        }
        return pcs;
    }

    @Override
    /*
     * The following method leverages the SELECT_ALL_NPCS query to retrieve NPC data from the npcs table
     *
     * */
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
                 String name = results.getString("name");
                 String type = results.getString("type");
                 String char_class = results.getString("char_class");
                 String level = results.getString("level");
                 String race = results.getString("race");
                 String hitpts = results.getString("hitpts");
                 String armor = results.getString("armor");
                 String proficiency = results.getString("proficiency");
                 String initiative = results.getString("initiative");
                 String speed = results.getString("speed");
                 String strength = results.getString("strength");
                 String dexterity = results.getString("dexterity");
                 String constitution = results.getString("constitution");
                 String intelligence = results.getString("intelligence");
                 String wisdom = results.getString("wisdom");
                 String charisma = results.getString("charisma");
                 String location = results.getString("location");
                 String traits = results.getString("traits");
                 String background = results.getString("background");

                npcs.add(new NPC(name,type,char_class,level,race,hitpts,armor,proficiency,initiative,speed,
                        strength,dexterity,constitution,intelligence,wisdom,charisma,location,traits,background));
            }

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
            final String addPCSQL = "insert into pcs (name,char_class,level,race,hitpts,armor,proficiency," +
                    "initiative,speed,strength,dexterity,constitution,intelligence,wisdom,charisma,background) values" +
                    "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            // Insert a new record into pcs table using our prepared statement
            insertStatement = connection.prepareStatement(addPCSQL);
            insertStatement.setString(1, pc.getName());
            insertStatement.setString(2, pc.getChar_class());
            insertStatement.setString(3, pc.getLevel());
            insertStatement.setString(4, pc.getRace());
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


            insertStatement.setQueryTimeout(DBUtility.TIMEOUT);
            insertStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
            throw new CampaignDAOException("Error: unable to add playable character record to the PCs table.");
        }

    }

    @Override
    public void addNPC(NPC npc) throws CampaignDAOException {
        Connection connection;
        PreparedStatement insertStatement;

        try {
            connection = DBUtility.createConnection();
            final String addNPCSQL = "insert into npcs (name,type,char_class,level,race,hitpts,armor,proficiency," +
                    "initiative,speed,strength,dexterity,constitution,intelligence,wisdom,charisma,location,traits,background) values" +
                    "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            // Insert a new record into npcs table using our prepared statement
            insertStatement = connection.prepareStatement(addNPCSQL);
            insertStatement.setString(1, npc.getName());
            insertStatement.setString(2, npc.getType());
            insertStatement.setString(3, npc.getChar_class());
            insertStatement.setString(4, npc.getLevel());
            insertStatement.setString(5, npc.getRace());
            insertStatement.setString(6, npc.getHitpts());
            insertStatement.setString(7, npc.getArmor());
            insertStatement.setString(8, npc.getProficiency());
            insertStatement.setString(9, npc.getInitiative());
            insertStatement.setString(10, npc.getSpeed());
            insertStatement.setString(11, npc.getStrength());
            insertStatement.setString(12, npc.getDexterity());
            insertStatement.setString(13, npc.getConstitution());
            insertStatement.setString(14, npc.getIntelligence());
            insertStatement.setString(15, npc.getWisdom());
            insertStatement.setString(16, npc.getCharisma());
            insertStatement.setString(17, npc.getLocation());
            insertStatement.setString(18, npc.getTraits());

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
            throw new CampaignDAOException("Error: unable to add non-playable character record to the NPCs table.");
        }

    }
}
