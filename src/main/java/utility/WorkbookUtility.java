/*
* The WorkbookUtility java class is used for parsing an included .xlsx spreadsheet of default campaign
* data. This data is then used to populate the database with default values for weapons, items, spells,
* playable character data, and non-playable character data.
* */

package utility;

import model.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WorkbookUtility {
    public final static String INPUT_FILE_DATA = "web/assets/workbook/data.xlsx";

    public static List<Weapon> retrieveWeapons( File inputFile) throws IOException, InvalidFormatException {
         List<Weapon> weapons = new ArrayList<>();
         Workbook workbook = WorkbookFactory.create(inputFile);
         Sheet sheet = workbook.getSheetAt(0);

        for ( Row row : sheet){
             Cell nameCell = row.getCell(1);
             Cell typeCell = row.getCell(2);
             Cell costCell = row.getCell(3);
             Cell damageCell = row.getCell(4);
             Cell weightCell = row.getCell(5);
             Cell propertiesCell = row.getCell(6);

             Weapon weapon = new Weapon(nameCell.getStringCellValue().trim(),
                    typeCell.getStringCellValue().trim(),
                    costCell.getStringCellValue().trim(),
                    damageCell.getStringCellValue().trim(),
                    weightCell.getStringCellValue().trim(),
                    propertiesCell.getStringCellValue().trim());
            weapons.add(weapon);
        }

        return weapons;
    }
    public static List<Item> retrieveItems( File inputFile) throws IOException, InvalidFormatException {
         List<Item> items = new ArrayList<>();
         Workbook workbook = WorkbookFactory.create(inputFile);
         Sheet sheet = workbook.getSheetAt(1);

        for ( Row row : sheet) {
             Cell itemCell = row.getCell(1);
             Cell typeCell = row.getCell(2);
             Cell costCell = row.getCell(3);
             Cell weightCell = row.getCell(4);

             Item item = new Item(itemCell.getStringCellValue().trim(),
                    typeCell.getStringCellValue().trim(),
                    costCell.getStringCellValue().trim(),
                    weightCell.getStringCellValue().trim());
            items.add(item);
        }

        return items;
    }
    public static List<Spell> retrieveSpells( File inputFile) throws IOException, InvalidFormatException {
         List<Spell> spells = new ArrayList<>();
         Workbook workbook = WorkbookFactory.create(inputFile);
         Sheet sheet = workbook.getSheetAt(2);

        for ( Row row : sheet) {
             Cell nameCell = row.getCell(1);
             Cell levelCell = row.getCell(2);
             Cell schoolCell = row.getCell(3);
             Cell castingCell = row.getCell(4);
             Cell ritualCell = row.getCell(5);
             Cell concentrationCell = row.getCell(6);
             Cell classesCell = row.getCell(7);

             Spell spell = new Spell(nameCell.getStringCellValue().trim(),
                    levelCell.getStringCellValue().trim(),
                    schoolCell.getStringCellValue().trim(),
                    castingCell.getStringCellValue().trim(),
                    ritualCell.getStringCellValue().trim(),
                    concentrationCell.getStringCellValue(),
                    classesCell.getStringCellValue());
            spells.add(spell);
        }

        return spells;
    }

    public static List<PC> retrievePCs( File inputFile) throws IOException, InvalidFormatException {
         List<PC> PCs = new ArrayList<>();
         Workbook workbook = WorkbookFactory.create(inputFile);
         Sheet sheet = workbook.getSheetAt(3);

        for ( Row row : sheet) {
             Cell nameCell = row.getCell(1);
             Cell classCell = row.getCell(2);
             Cell levelCell = row.getCell(3);
             Cell raceCell = row.getCell(4);
             Cell hitptsCell = row.getCell(5);
             Cell armorCell = row.getCell(6);
             Cell proficiencyCell = row.getCell(7);
             Cell initiativeCell = row.getCell(8);
             Cell speedCell = row.getCell(9);
             Cell strengthCell = row.getCell(10);
             Cell dexterityCell = row.getCell(11);
             Cell constitutionCell = row.getCell(12);
             Cell intelligenceCell = row.getCell(13);
             Cell wisdomCell = row.getCell(14);
             Cell charismaCell = row.getCell(15);
             Cell backgroundCell = row.getCell(16);

             PC pc = new PC(nameCell.getStringCellValue().trim(),
                    classCell.getStringCellValue().trim(),
                    levelCell.getNumericCellValue(),
                    raceCell.getStringCellValue().trim(),
                    hitptsCell.getNumericCellValue(),
                    armorCell.getNumericCellValue(),
                    proficiencyCell.getNumericCellValue(),
                    initiativeCell.getNumericCellValue(),
                    speedCell.getNumericCellValue(),
                    strengthCell.getNumericCellValue(),
                    dexterityCell.getNumericCellValue(),
                    constitutionCell.getNumericCellValue(),
                    intelligenceCell.getNumericCellValue(),
                    wisdomCell.getNumericCellValue(),
                    charismaCell.getNumericCellValue(),
                    backgroundCell.getStringCellValue().trim());
            PCs.add(pc);
        }

        return PCs;
    }
    public static List<NPC> retrieveNPCs( File inputFile) throws IOException, InvalidFormatException {
         List<NPC> NPCs = new ArrayList<>();
         Workbook workbook = WorkbookFactory.create(inputFile);
         Sheet sheet = workbook.getSheetAt(4);

        for ( Row row : sheet) {
             Cell nameCell = row.getCell(1);
             Cell typeCell = row.getCell(2);
             Cell classCell = row.getCell(3);
             Cell levelCell = row.getCell(4);
             Cell raceCell = row.getCell(5);
             Cell hitptsCell = row.getCell(6);
             Cell armorCell = row.getCell(7);
             Cell proficiencyCell = row.getCell(8);
             Cell initiativeCell = row.getCell(9);
             Cell speedCell = row.getCell(10);
             Cell strengthCell = row.getCell(11);
             Cell dexterityCell = row.getCell(12);
             Cell constitutionCell = row.getCell(13);
             Cell intelligenceCell = row.getCell(14);
             Cell wisdomCell = row.getCell(15);
             Cell charismaCell = row.getCell(16);
             Cell locationCell = row.getCell(17);
             Cell traitsCell = row.getCell(18);
             Cell backgroundCell = row.getCell(19);

             NPC npc = new NPC(nameCell.getStringCellValue().trim(),
                    classCell.getStringCellValue().trim(),
                    typeCell.getStringCellValue().trim(),
                    levelCell.getNumericCellValue(),
                    raceCell.getStringCellValue().trim(),
                    hitptsCell.getNumericCellValue(),
                    armorCell.getNumericCellValue(),
                    proficiencyCell.getNumericCellValue(),
                    initiativeCell.getNumericCellValue(),
                    speedCell.getNumericCellValue(),
                    strengthCell.getNumericCellValue(),
                    dexterityCell.getNumericCellValue(),
                    constitutionCell.getNumericCellValue(),
                    intelligenceCell.getNumericCellValue(),
                    wisdomCell.getNumericCellValue(),
                    charismaCell.getNumericCellValue(),
                    locationCell.getStringCellValue().trim(),
                    traitsCell.getStringCellValue().trim(),
                    backgroundCell.getStringCellValue().trim());
            NPCs.add(npc);
        }

        return NPCs;
    }
}