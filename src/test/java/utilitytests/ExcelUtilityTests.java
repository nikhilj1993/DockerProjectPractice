package utilitytests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ExcelUtility;

import java.io.IOException;

public class ExcelUtilityTests {

    @Test
    public void testGetNumberOfRows() throws IOException {
        ExcelUtility excelObj = new ExcelUtility(System.getProperty("user.dir")+"\\src\\test\\resources\\utility test data\\UtilityTest.xlsx");
        Assert.assertEquals(excelObj.getNumberOfRows("Sheet1"),4);
    }

    @Test
    public void testGetNumberOfColumns() throws IOException {
        ExcelUtility excelObj = new ExcelUtility(System.getProperty("user.dir")+"\\src\\test\\resources\\utility test data\\UtilityTest.xlsx");
        Assert.assertEquals(excelObj.getNumberOfColumns("Sheet1"),4);
    }

    @Test
    public void getValueInCell() throws IOException {
        ExcelUtility excelObj = new ExcelUtility(System.getProperty("user.dir")+"\\src\\test\\resources\\utility test data\\UtilityTest.xlsx");
        Assert.assertEquals(excelObj.getValueInCell("Sheet1",3,1),"heading 3");
        Assert.assertEquals(excelObj.getValueInCell("Sheet1",3,2),"1.1");
        Assert.assertEquals(excelObj.getValueInCell("Sheet1",3,3),"2");
        Assert.assertEquals(excelObj.getValueInCell("Sheet1",3,4),"0.1");

    }
}
