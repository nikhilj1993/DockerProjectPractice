package pages;

import basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ListPage extends BasePage {
    public ListPage(WebDriver driver){
        super(driver);
    }

    By allProductNames = By.cssSelector(".card-body h5");
    By signOut = By.xpath("(//button[@class='btn btn-custom'])[4]");
    By numberOfItemsInCart = By.xpath("(//button[@class='btn btn-custom'])[3]//label");
    By paginationSection = By.cssSelector("li.pagination-previous");
    By allCards = By.cssSelector(".card");

    public void signOut() throws InterruptedException {
        waitUntilElementIsPresent(signOut,10);
        driver.findElement(signOut).click();
    }
    public HashSet<String> getProductNames(){
        waitUntilElementIsPresent(signOut,10);
        waitUntilElementIsPresent(paginationSection,10);
        List<WebElement> ProductNameElements = driver.findElements(allProductNames);
        HashSet<String> productNames = new HashSet<>();
        for(WebElement productName:ProductNameElements){
            productNames.add(productName.getText().trim());
        }
        return productNames;
    }

    public void addProductToCart(String productName) throws InterruptedException {
        waitUntilElementIsPresent(signOut,10);
        waitUntilElementIsPresent(paginationSection,10);
        List<WebElement> allCardElements = driver.findElements(allCards);
        for(WebElement cardElement:allCardElements){
            if((cardElement.findElement(By.cssSelector("h5")).getText().trim()).equalsIgnoreCase(productName)){
                cardElement.findElement(By.cssSelector("button[style='float: right;']")).click();
            }
        }
    }

    public void clickOnCartButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(numberOfItemsInCart));
        driver.findElement(numberOfItemsInCart).click();
    }


    public String numberOfItemsInCart(){
        return driver.findElement(numberOfItemsInCart).getText();
    }
}
