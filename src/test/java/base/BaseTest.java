package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class BaseTest {
   // public static WebDriver driver;
    public static ThreadLocal<LoginPage> lp=new ThreadLocal<>();
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void launchBrowser() throws IOException {
        if(getDriver()==null||getDriver().toString().contains("null")) {
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +
                    "//src//test//resources//configuration//config.properties");
            prop.load(fis);
            if(System.getProperty("browser")!=null){
                initializeDriver(System.getProperty("browser"),Boolean.parseBoolean(prop.getProperty("debug")));
            }
            else {
                initializeDriver(prop.getProperty("browser").trim().toLowerCase(),Boolean.parseBoolean(prop.getProperty("debug")));
            }
            lp.set(new LoginPage(getDriver()));
        }
        getDriver().get("https://rahulshettyacademy.com/client");
        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver(){
        return driver.get();
    }
    public static LoginPage getLoginObject(){
        return lp.get();
    }

    public void initializeDriver(String browser,boolean debug) throws MalformedURLException {
        if(debug){
            if(browser.equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().setup();
                driver.set( new ChromeDriver());
            }
            else if(browser.equalsIgnoreCase("firefox")){

                WebDriverManager.firefoxdriver().setup();
                driver.set( new FirefoxDriver());
               }

            else if(browser.equalsIgnoreCase("edge")){
                WebDriverManager.edgedriver().setup();
                driver.set( new EdgeDriver());
            }
        }
        else {
            if (browser.equalsIgnoreCase("chrome")) {

                // driver.set( new ChromeDriver());
                MutableCapabilities options = new ChromeOptions();
                driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options));

            } else if (browser.equalsIgnoreCase("firefox")) {
            /*
            WebDriverManager.firefoxdriver().setup();
            driver.set( new FirefoxDriver());*/
                FirefoxOptions options = new FirefoxOptions();
                options.setAcceptInsecureCerts(true);
                driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options));
            } else if (browser.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
            }
        }
    }

    @AfterMethod
    public void closeBrowser(){
        getDriver().quit();
    }
}
