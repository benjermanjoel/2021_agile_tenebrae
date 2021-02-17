/*
* The WorkbookUtility java class is used for parsing an included .xlsx spreadsheet of default campaign
* data. This data is then used to populate the database with default values for weapons, items, spells,
* playable character data, and non-playable character data.
* */

package utility;

import model.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WorkbookUtility {
    public final static String WEAPONS_FILE_DATA = "assets/workbook/weapons.xlsx";
    public final static String ITEMS_FILE_DATA = "assets/workbook/items.xlsx";
    public final static String SPELLS_FILE_DATA = "assets/workbook/spells.xlsx";
    public final static String PCS_FILE_DATA = "assets/workbook/PCs.xlsx";
    public final static String NPCS_FILE_DATA = "assets/workbook/NPCs.xlsx";

    public static List<Weapon> retrieveWeapons( File inputFile) throws IOException, InvalidFormatException {
         List<Weapon> weapons = new ArrayList<>();
         XSSFWorkbook workbook = new XSSFWorkbook(OPCPackage.open(inputFile));
         Sheet sheet = workbook.getSheetAt(0);


        for ( Row row : sheet){
             Cell nameCell = row.getCell(0);
             Cell typeCell = row.getCell(1);
             Cell costCell = row.getCell(2);
             Cell damageCell = row.getCell(3);
             Cell weightCell = row.getCell(4);
             Cell propertiesCell = row.getCell(5);

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
        XSSFWorkbook workbook = new XSSFWorkbook(OPCPackage.open(inputFile));
        Sheet sheet = workbook.getSheetAt(0);

        for ( Row row : sheet) {
             Cell itemCell = row.getCell(0);
             Cell typeCell = row.getCell(1);
             Cell costCell = row.getCell(2);
             Cell weightCell = row.getCell(3);

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
        XSSFWorkbook workbook = new XSSFWorkbook(OPCPackage.open(inputFile));
         Sheet sheet = workbook.getSheetAt(0);

        for ( Row row : sheet) {
             Cell nameCell = row.getCell(0);
             Cell levelCell = row.getCell(1);
             Cell schoolCell = row.getCell(2);
             Cell castingCell = row.getCell(3);
             Cell ritualCell = row.getCell(4);
             Cell concentrationCell = row.getCell(5);
             Cell classesCell = row.getCell(6);

             Spell spell = new Spell(nameCell.getStringCellValue().trim(),
                     String.valueOf((int)levelCell.getNumericCellValue()),
                    schoolCell.getStringCellValue().trim(),
                    castingCell.getStringCellValue().trim(),
                     String.valueOf((int)ritualCell.getNumericCellValue()),
                     String.valueOf((int)concentrationCell.getNumericCellValue()),
                    classesCell.getStringCellValue());
            spells.add(spell);
        }

        return spells;
    }

    public static List<PC> retrievePCs( File inputFile) throws IOException, InvalidFormatException {
         List<PC> PCs = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(OPCPackage.open(inputFile));
         Sheet sheet = workbook.getSheetAt(0);

        for ( Row row : sheet) {
             Cell nameCell = row.getCell(0);
             Cell classCell = row.getCell(1);
             Cell levelCell = row.getCell(2);
             Cell raceCell = row.getCell(3);
             Cell hitptsCell = row.getCell(4);
             Cell armorCell = row.getCell(5);
             Cell proficiencyCell = row.getCell(6);
             Cell initiativeCell = row.getCell(7);
             Cell speedCell = row.getCell(8);
             Cell strengthCell = row.getCell(9);
             Cell dexterityCell = row.getCell(10);
             Cell constitutionCell = row.getCell(11);
             Cell intelligenceCell = row.getCell(12);
             Cell wisdomCell = row.getCell(13);
             Cell charismaCell = row.getCell(14);
             Cell backgroundCell = row.getCell(15);

             PC pc = new PC(nameCell.getStringCellValue().trim(),
                    classCell.getStringCellValue().trim(),
                     String.valueOf((int)levelCell.getNumericCellValue()),
                    raceCell.getStringCellValue().trim(),
                     String.valueOf((int)hitptsCell.getNumericCellValue()),
                     String.valueOf((int)armorCell.getNumericCellValue()),
                     String.valueOf((int)proficiencyCell.getNumericCellValue()),
                     String.valueOf((int)initiativeCell.getNumericCellValue()),
                     String.valueOf((int)speedCell.getNumericCellValue()),
                     String.valueOf((int)strengthCell.getNumericCellValue()),
                     String.valueOf((int)dexterityCell.getNumericCellValue()),
                     String.valueOf((int)constitutionCell.getNumericCellValue()),
                     String.valueOf((int)intelligenceCell.getNumericCellValue()),
                     String.valueOf((int)wisdomCell.getNumericCellValue()),
                     String.valueOf((int)charismaCell.getNumericCellValue()),
                    backgroundCell.getStringCellValue().trim());
            PCs.add(pc);
        }

        return PCs;
    }
    public static List<NPC> retrieveNPCs( File inputFile) throws IOException, InvalidFormatException {
         List<NPC> NPCs = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(OPCPackage.open(inputFile));
         Sheet sheet = workbook.getSheetAt(0);

        for ( Row row : sheet) {
             Cell nameCell = row.getCell(0);
             Cell typeCell = row.getCell(1);
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
             Cell locationCell = row.getCell(16);
             Cell traitsCell = row.getCell(17);
             Cell backgroundCell = row.getCell(18);

             NPC npc = new NPC(nameCell.getStringCellValue().trim(),
                     typeCell.getStringCellValue().trim(),
                     classCell.getStringCellValue().trim(),
                     String.valueOf((int)levelCell.getNumericCellValue()),
                    raceCell.getStringCellValue().trim(),
                     String.valueOf((int)hitptsCell.getNumericCellValue()),
                     String.valueOf((int)armorCell.getNumericCellValue()),
                     String.valueOf((int)proficiencyCell.getNumericCellValue()),
                     String.valueOf((int)initiativeCell.getNumericCellValue()),
                     String.valueOf((int)speedCell.getNumericCellValue()),
                     String.valueOf((int)strengthCell.getNumericCellValue()),
                     String.valueOf((int)dexterityCell.getNumericCellValue()),
                     String.valueOf((int)constitutionCell.getNumericCellValue()),
                     String.valueOf((int)intelligenceCell.getNumericCellValue()),
                     String.valueOf((int)wisdomCell.getNumericCellValue()),
                     String.valueOf((int)charismaCell.getNumericCellValue()),
                    locationCell.getStringCellValue().trim(),
                    traitsCell.getStringCellValue().trim(),
                    backgroundCell.getStringCellValue().trim());
            NPCs.add(npc);
        }

        return NPCs;
    }
}