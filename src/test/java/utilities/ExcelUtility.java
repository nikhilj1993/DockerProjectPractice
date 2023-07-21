package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFAnchor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtility {

    FileInputStream fis;
    XSSFWorkbook wb;
    public ExcelUtility(String path) throws IOException {
        fis = new FileInputStream(path);
        wb=new XSSFWorkbook(fis);
    }

    public int getNumberOfRows(String sheetName){
        XSSFSheet sheet = wb.getSheet(sheetName);
        return sheet.getPhysicalNumberOfRows();
    }

    public int getNumberOfColumns(String sheetName){
        XSSFSheet sheet = wb.getSheet(sheetName);
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }

    public String getValueInCell(String sheetName,int columnNumber,int rowNumber){
        XSSFSheet sheet = wb.getSheet(sheetName);
        Cell cell = sheet.getRow(rowNumber-1).getCell(columnNumber-1);
        DataFormatter df = new DataFormatter();
        return df.formatCellValue(cell);
    }
}
