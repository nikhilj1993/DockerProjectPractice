package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class takeScreenshot {
    public static String takeScreenshot(WebDriver driver, String testCaseName) throws IOException {
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
        File file = new File(path);
        FileUtils.copyFile(source,file);
        return path;
    }
}
