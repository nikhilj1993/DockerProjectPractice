package dataprovider;

import org.testng.annotations.DataProvider;
import utilities.ExcelUtility;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class Dataprovider {

    @DataProvider(name="DataAsHashMap")
    public Object[][] getDataAsHashMap(Method m, Class c) throws IOException {
        String filename = c.getSimpleName();
        String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\"+filename+".xlsx";
        String sheetName= m.getName();
        ExcelUtility exlObj = new ExcelUtility(filePath);
        int numberOfRows = exlObj.getNumberOfRows(sheetName);
        int numberOfColumns = exlObj.getNumberOfColumns(sheetName);
        Object[][] obj= new Object [numberOfRows-1][1]  ;
        for(int i=2;i<=numberOfRows;i++){
            HashMap<String,String> hm = new HashMap<>();
            for(int j=1;j<=numberOfColumns;j++){
                hm.put(exlObj.getValueInCell(sheetName,j,1),exlObj.getValueInCell(sheetName,j,i));
            }
            obj[i-2][0]=hm;
        }
        return obj;
    }
}
