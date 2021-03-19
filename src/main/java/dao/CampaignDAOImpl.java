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

/*
     The CampaignDAOImpl class is the main Java class used to interact with the database backend. This class implements
      all the methods defined in the CampaignDAO interface.
*/
public class CampaignDAOImpl implements CampaignDAO{

    // Final static strings for the main SELECT SQL queries used in the below methods
    final static String SELECT_ALL_WEAPONS = "select * from weapons;";
    final static String SELECT_ALL_ITEMS = "select * from items;";
    final static String SELECT_ALL_SPELLS = "select * from spells;";


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

    public List<PC> retrievePCs(Integer user_id) throws CampaignDAOException {
        final List<PC> pcs = new ArrayList<PC>();
        final String SELECT_ALL_PCS = "select * from characters where isnpc=false and user_id = ?;";
        Connection connection;
        PreparedStatement statement;

        try {
            connection = DBUtility.createConnection();
            statement = connection.prepareStatement(SELECT_ALL_PCS);
            statement.setInt(1,user_id);
            statement.setQueryTimeout(DBUtility.TIMEOUT);

            // select all data from pcs table
            final ResultSet results = statement.executeQuery();
            // loop
            while (results.next()){
                 int id = results.getInt("user_id");
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

                pcs.add(new PC(id,name,char_class,level,race,hitpts,armor,proficiency,initiative,speed,
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

    public List<NPC> retrieveNPCs(Integer user_id) throws CampaignDAOException {
        final List<NPC> npcs = new ArrayList<NPC>();
        final String SELECT_ALL_NPCS = "select * from characters c join npcs n on c.char_id = n.char_id where c.user_id=?;";
        Connection connection;
        PreparedStatement statement;

        try {
            connection = DBUtility.createConnection();
            statement = connection.prepareStatement(SELECT_ALL_NPCS);
            statement.setInt(1,user_id);
            statement.setQueryTimeout(DBUtility.TIMEOUT);

            // select all data from pcs table
            final ResultSet results = statement.executeQuery();
            // loop
            while (results.next()){
                 int id = results.getInt("user_id");
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
    public void modifyPC(PC pc, Integer char_id) throws CampaignDAOException {
        Connection connection;
        PreparedStatement updateStatement;

        try {
            connection = DBUtility.createConnection();
            final String modifyPCSQL = "update characters set name=?, level=?, race=?, class=?, hp=?, ac=?,proficiency=?," +
                    "initiative=?,speed=?,str=?,dex=?,con=?,intel=?,wis=?,cha=?,background=? where char_id = ?;";

            // Insert a new record into pcs table using our prepared statement
            updateStatement = connection.prepareStatement(modifyPCSQL);
            updateStatement.setString(1, pc.getName());
            updateStatement.setString(2, pc.getLevel());
            updateStatement.setString(3, pc.getRace());
            updateStatement.setString(4, pc.getChar_class());
            updateStatement.setString(5, pc.getHitpts());
            updateStatement.setString(6, pc.getArmor());
            updateStatement.setString(7, pc.getProficiency());
            updateStatement.setString(8, pc.getInitiative());
            updateStatement.setString(9, pc.getSpeed());
            updateStatement.setString(10, pc.getStrength());
            updateStatement.setString(11, pc.getDexterity());
            updateStatement.setString(12, pc.getConstitution());
            updateStatement.setString(13, pc.getIntelligence());
            updateStatement.setString(14, pc.getWisdom());
            updateStatement.setString(15, pc.getCharisma());
            updateStatement.setString(16, pc.getBackground());
            updateStatement.setInt(17, char_id);

            updateStatement.setQueryTimeout(DBUtility.TIMEOUT);
            updateStatement.executeUpdate();
            connection.close();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
            throw new CampaignDAOException("Error: unable to modify playable character record.");
        }
    }

    @Override
    public void modifyNPC(NPC npc, Integer char_id) throws CampaignDAOException {
        Connection connection;
        PreparedStatement updateCHARStatement;
        PreparedStatement updateNPCStatement;

        try {
            connection = DBUtility.createConnection();
            final String ADD_NPC_CHAR_SQL = "UPDATE characters SET name=?,class=?,level=?,race=?,hp=?,ac=?,proficiency=?," +
                    "initiative=?,speed=?,str=?,dex=?,con=?,intel=?,wis=?,cha=?,background=? where char_id=?;";
            final String ADD_NPC_SQL = "UPDATE npcs SET type=?,loc=?,traits=? where char_id=?;";

            // Insert a new record into characters table using our prepared statement
            updateCHARStatement = connection.prepareStatement(ADD_NPC_CHAR_SQL);
            updateCHARStatement.setString(1, npc.getName());
            updateCHARStatement.setString(2, npc.getChar_class());
            updateCHARStatement.setString(3, npc.getLevel());
            updateCHARStatement.setString(4, npc.getRace());
            updateCHARStatement.setString(5, npc.getHitpts());
            updateCHARStatement.setString(6, npc.getArmor());
            updateCHARStatement.setString(7, npc.getProficiency());
            updateCHARStatement.setString(8, npc.getInitiative());
            updateCHARStatement.setString(9, npc.getSpeed());
            updateCHARStatement.setString(10, npc.getStrength());
            updateCHARStatement.setString(11, npc.getDexterity());
            updateCHARStatement.setString(12, npc.getConstitution());
            updateCHARStatement.setString(13, npc.getIntelligence());
            updateCHARStatement.setString(14, npc.getWisdom());
            updateCHARStatement.setString(15, npc.getCharisma());
            updateCHARStatement.setString(16, npc.getBackground());
            updateCHARStatement.setInt(17, char_id);

            updateCHARStatement.setQueryTimeout(DBUtility.TIMEOUT);
            updateCHARStatement.executeUpdate();

            updateNPCStatement = connection.prepareStatement(ADD_NPC_SQL);
            updateNPCStatement.setString(1, npc.getType());
            updateNPCStatement.setString(2, npc.getLocation());
            updateNPCStatement.setString(3, npc.getTraits());
            updateNPCStatement.setInt(4, char_id);

            updateNPCStatement.setQueryTimeout(DBUtility.TIMEOUT);
            updateNPCStatement.executeUpdate();
            connection.close();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
            throw new CampaignDAOException("Error: unable to modify non-playable character.");
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

    @Override
    public void addNote(Integer user_id, String contents) throws CampaignDAOException {
        Connection connection;
        PreparedStatement insertStatement;

        try {
            connection = DBUtility.createConnection();
            final String addNoteSQL = "insert into journal (user_id,contents) values" +
                    "(?,?);";

            // Insert a new record into pcs table using our prepared statement
            insertStatement = connection.prepareStatement(addNoteSQL);
            insertStatement.setInt(1, user_id);
            insertStatement.setString(2, contents);


            insertStatement.setQueryTimeout(DBUtility.TIMEOUT);
            insertStatement.executeUpdate();
            connection.close();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
            throw new CampaignDAOException("Error: unable to add note to journal.");
        }
    }

    @Override
    public List retrieveNotes(Integer user_id) throws CampaignDAOException {
        final List notes = new ArrayList();
        Connection connection;
        PreparedStatement selectStatement;

        try {
            connection = DBUtility.createConnection();
            final String retrieveNotesSQL = "SELECT contents from journal where user_id = ?;";

            // Insert a new record into pcs table using our prepared statement
            selectStatement = connection.prepareStatement(retrieveNotesSQL);
            selectStatement.setInt(1, user_id);


            selectStatement.setQueryTimeout(DBUtility.TIMEOUT);
            final ResultSet results = selectStatement.executeQuery();
            while (results.next()){
                String contents = results.getString("contents");
                notes.add(contents);
            }
            connection.close();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
            throw new CampaignDAOException("Error: unable to retrieve notes from journal.");
        }
        return notes;
    }


}
