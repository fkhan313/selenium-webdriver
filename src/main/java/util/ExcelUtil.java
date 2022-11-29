package util;

import base.TestBase;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtil extends TestBase {
    public static Workbook book;
    public static Sheet sheet;

    //public static String TEST_DATA_SHEET_PATH = System.getProperty("user.dir")+"\\src\\main\\java\\testdata\\TestData.xlsx";
    public static String TEST_DATA_SHEET_PATH = System.getProperty("user.dir")+ prop.getProperty("testDataFilePath") ;

    public static Object[][] getTestData(String sheetName) {

        FileInputStream file = null;

        try {
            file = new FileInputStream(TEST_DATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sheet = book.getSheet(sheetName);

        Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
            }
        }

        return data;

    }
}
