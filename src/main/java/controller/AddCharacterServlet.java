package controller;

import com.google.common.base.Strings;
import dao.CampaignDAO;
import dao.CampaignDAOException;
import dao.CampaignDAOImpl;
import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddCharacterServlet", urlPatterns = "/addCharacter")
public class AddCharacterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String name = request.getParameter("name");
        final String type = request.getParameter("type");
        final String char_class = request.getParameter("class");
        final String level = request.getParameter("level");
        final String race = request.getParameter("race");
        final String hitPts = request.getParameter("hitPts");
        final String armorClass = request.getParameter("armorClass");
        final String proficiency = request.getParameter("proficiency");
        final String initiative = request.getParameter("initiative");
        final String speed = request.getParameter("speed");
        final String strength = request.getParameter("strength");
        final String dexterity = request.getParameter("dexterity");
        final String constitution = request.getParameter("constitution");
        final String intelligence = request.getParameter("intelligence");
        final String wisdom = request.getParameter("wisdom");
        final String charisma = request.getParameter("charisma");
        final String location = request.getParameter("location");
        final String traits = request.getParameter("traits");
        final String background = request.getParameter("background");

        /* ------------------------------ Validation for name  ------------------------------*/
        /* Check to see if entry is empty or less than 20 characters */
        if (Strings.isNullOrEmpty(name) || name.length() >= 20) {
            request.setAttribute("message", "Please enter a valid Name less than 20 characters.");
            getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
            return;
        }

        /* ------------------------------ Validation for level  ------------------------------*/
        /* Check to see if entry is empty or left on "Choose..." option */
        if (Strings.isNullOrEmpty(level) || level.equals("Choose...")) {
            request.setAttribute("message", "Please select the Level of your character.");
            getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
            return;
        }
        /* Check to see if level is a number, then check to see if it is a number 1-20 */
        try {
            int enteredLevel = Integer.parseInt(level);

            /* Check if entered level is within the range */
            if (enteredLevel < 1 || enteredLevel > 20) {
                request.setAttribute("message", "Please select the Level of your character.");
                getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
                return;
            }
        } catch (NumberFormatException nfe) {
            request.setAttribute("message", "Please select the Level of your character.");
            getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
            return;
        }

        /* ------------------------------ Validation for class ------------------------------*/
        /* Check to see if entry is empty or left on "Choose..." option */
        if (Strings.isNullOrEmpty(char_class) || char_class.equals("Choose...")) {
            request.setAttribute("message", "Please select a Class for your character.");
            getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
            return;
        }
        /* Validate class selection by checking if the class chosen does not match each given class with the preset values */
        if (!(char_class.equals("Barbarian")
                || char_class.equals("Bard")
                || char_class.equals("Cleric")
                || char_class.equals("Druid")
                || char_class.equals("Fighter")
                || char_class.equals("Monk")
                || char_class.equals("Paladin")
                || char_class.equals("Ranger")
                || char_class.equals("Rogue")
                || char_class.equals("Sorcerer")
                || char_class.equals("Warlock")
                || char_class.equals("Wizard"))) {
                request.setAttribute("message", "Please select a Class for your character.");
            getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
            return;
        }

        /* ------------------------------ Validation for race ------------------------------*/
        /* Check to see if entry is empty or left on "Choose..." option */
        if (Strings.isNullOrEmpty(race) || race.equals("Choose...")) {
            request.setAttribute("message", "Please select a Race for your character.");
            getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
            return;
        }
        /* Validate race selection by checking if the race chosen does not match each given race with the preset values */
        if (!(race.equals("Dragonborn")
                || race.equals("Dwarf")
                || race.equals("Drow")
                || race.equals("Elf")
                || race.equals("Gnome")
                || race.equals("Half-Elf")
                || race.equals("Halfling")
                || race.equals("Half-Orc")
                || race.equals("Human")
                || race.equals("Tiefling"))) {
            request.setAttribute("message", "Please select a Race for your character.");
            getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
            return;
        }

        /* ------------------------------ Validation for hit points  ------------------------------*/
        /* TODO: Check length of varchar for hitPts (in database?) to match */
        /* Check to see if entry is empty or greater than 5 digits */
        if (Strings.isNullOrEmpty(hitPts) || hitPts.length() > 5) {
            request.setAttribute("message", "Please enter a valid Hit Point total number, no greater than 5 digits.");
            getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
            return;
        }
        /* Check to see if Hit Points is a number */
        try {
            int enteredHP = Integer.parseInt(hitPts);

            /* Check if entered hit points is within the range */
            if (enteredHP < 1 || enteredHP > 99999) {
                request.setAttribute("message", "Please enter a valid number for Hit Points, no greater than 5 digits.");
                getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
                return;
            }
        } catch (NumberFormatException nfe) {
            request.setAttribute("message", "Please enter a valid number for Hit Points, no greater than 5 digits.");
            getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
            return;
        }

        /* ------------------------------ Validation for armor class  ------------------------------*/
        if (Strings.isNullOrEmpty(armorClass) || armorClass.length() > 2) {
            request.setAttribute("message", "Please enter a valid Armor Class, between 1 and 99.");
            getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
            return;
        }
        /* Check to see if AC is a number */
        try {
            int enteredAC = Integer.parseInt(armorClass);

            /* Check if entered armor class is within the range */
            if (enteredAC < 1 || enteredAC > 99) {
                request.setAttribute("message", "Please enter a valid number for Armor Class, between 1 and 99.");
                getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
                return;
            }
        } catch (NumberFormatException nfe) {
            request.setAttribute("message", "Please enter a valid number for Armor Class, between 1 and 99.");
            getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
            return;
        }

        /* ------------------------------ Validation for proficiency  ------------------------------*/
        /* Check to see if entry is empty or left on "Choose..." option */
        if (Strings.isNullOrEmpty(proficiency) || proficiency.equals("Choose...")) {
            request.setAttribute("message", "Please select the Proficiency of your character.");
            getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
            return;
        }
        /* Check to see if proficiency is a number, then check to see if it is a number 2-6 */
        try {
            int enteredProficiency = Integer.parseInt(proficiency);

            /* Check if entered proficiency is within the range */
            if (enteredProficiency < 2 || enteredProficiency > 6) {
                request.setAttribute("message", "Please select the Proficiency of your character.");
                getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
                return;
            }
        } catch (NumberFormatException nfe) {
            request.setAttribute("message", "Please select the Proficiency of your character.");
            getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
            return;
        }

        /* ------------------------------ Validation for initiative  ------------------------------*/
        /* TODO: Confirm changes made to initiative */
        /* Check to see if entry is empty or left on "Choose..." option */
        if (Strings.isNullOrEmpty(initiative) || initiative.equals("Choose...")) {
            request.setAttribute("message", "Please enter a valid Initiative, between 1 and 99.");
            getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
            return;
        }
        /* Check to see if initiative is a number, then check to see if it is a number 1-99 */
        try {
            int enteredInitiative = Integer.parseInt(initiative);

            /* Check if entered initiative is within the range */
            if (enteredInitiative < 1 || enteredInitiative > 99) {
                request.setAttribute("message", "Please enter a valid number for Initiative, between 1 and 99.");
                getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
                return;
            }
        } catch (NumberFormatException nfe) {
            request.setAttribute("message", "Please enter a valid number for Initiative, between 1 and 99.");
            getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
            return;
        }


        /* ------------------------------ Validation for speed  ------------------------------*/
        /* TODO: Confirm changes made to speed */
        /* Check to see if entry is empty or left on "Choose..." option */
        if (Strings.isNullOrEmpty(speed) || speed.equals("Choose...")) {
            request.setAttribute("message", "Please enter a valid Speed, between 5 and 5000 and a multiple of 5.");
            getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
            return;
        }
        /* Check to see if initiative is a number, then check to see if it is a number 5-5000 */
        try {
            int enteredSpeed = Integer.parseInt(speed);

            /* Check if entered speed is within the range */
            if (enteredSpeed < 5 || enteredSpeed > 5000) {
                request.setAttribute("message", "Please enter a valid number for Speed, between 5 and 5000 and a multiple of 5.");
                getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
                return;
            }
            /* Check if entered speed is divisible by 5 (speed is always a multiple of 5 in D&D) */
            if (enteredSpeed % 5 != 0) {
                request.setAttribute("message", "Please enter a valid number for Speed, between 5 and 5000 and a multiple of 5.");
                getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
                return;
            }
        } catch (NumberFormatException nfe) {
            request.setAttribute("message", "Please enter a valid number for Speed, between 5 and 5000 and a multiple of 5.");
            getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
            return;
        }

        /* ------------------------------ Validation for strength  ------------------------------*/
        /* TODO: Validation for strength */

        /* ------------------------------ Validation for dexterity  ------------------------------*/
        /* TODO: Validation for dexterity */

        /* ------------------------------ Validation for constitution  ------------------------------*/
        /* TODO: Validation for constitution */

        /* ------------------------------ Validation for intelligence  ------------------------------*/
        /* TODO: Validation for intelligence */

        /* ------------------------------ Validation for wisdom  ------------------------------*/
        /* TODO: Validation for wisdom */

        /* ------------------------------ Validation for charisma  ------------------------------*/
        /* TODO: Validation for charisma */

        /* ------------------------------ Validation for background  ------------------------------*/
        /* TODO: Validation for background */


        if (Strings.isNullOrEmpty(type)
                && Strings.isNullOrEmpty(traits)
                && Strings.isNullOrEmpty(location)) {

                final CampaignDAO campaignDAO = new CampaignDAOImpl();
                final PC pc = new PC(name, char_class, level, race, hitPts, armorClass, proficiency, initiative, speed, strength,
                        dexterity, constitution, intelligence, wisdom, charisma, background);

                try {
                    campaignDAO.addPC(pc);
                    request.setAttribute("message", "A new playable character has been added successfully!");


                } catch (CampaignDAOException exception) {
                    exception.printStackTrace();
                    request.setAttribute("message", exception.getMessage());
                }
                getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
            }
            else {
                final CampaignDAO campaignDAO = new CampaignDAOImpl();
                final NPC npc = new NPC(name, type,char_class, level, race, hitPts, armorClass, proficiency, initiative, speed, strength,
                        dexterity, constitution, intelligence, wisdom, charisma, location, traits, background);

                try {
                    campaignDAO.addNPC(npc);
                    request.setAttribute("message", "A new non-playable character has been added successfully!");

                } catch (CampaignDAOException exception) {
                    exception.printStackTrace();
                    request.setAttribute("message", exception.getMessage());
                }
                getServletContext().getRequestDispatcher("/addCharacter.jsp").forward(request, response);
            }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
