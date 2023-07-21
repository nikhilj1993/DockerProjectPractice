package pages;

import basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }
    By userNameTextbox = By.id("userEmail");
    By passwordTextbox = By.id("userPassword");
    By submitButton = By.id("login");
    By loginErrorContainer = By.cssSelector(".ng-trigger-flyInOut");
    By loginErrorMessage = By.cssSelector(".toast-message");
    By noEmailError = By.xpath("//form[contains(@class,'ng-invalid')]" +
            "//div//label[@for='email']//following-sibling::div//div");
    By noPasswordError = By.xpath("//form[contains(@class,'ng-invalid')]//" +
            "div//label[@for='password']//following-sibling::div//div");

    public ListPage login(String userName, String password){
        driver.findElement(userNameTextbox).sendKeys(userName);
        driver.findElement(passwordTextbox).sendKeys(password);
        driver.findElement(submitButton).click();
        return new ListPage(driver);
    }

    public String getLoginErrorMessage(){
        waitUntilElementIsPresent(loginErrorContainer,10);
        return driver.findElement(loginErrorMessage).getText();
    }

    public String getNoEmailError(){
        return driver.findElement(noEmailError).getText();
    }

    public String getNoPasswordError(){
        return driver.findElement(noPasswordError).getText();
    }

}
