package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ListPage;

import java.util.HashMap;

public class CartTest extends BaseTest {

    @Test(dataProvider = "DataAsHashMap",dataProviderClass = dataprovider.Dataprovider.class)
    public void presentInCart1(HashMap<String,String> hm) throws InterruptedException {
        String product = "ZARA COAT 3";
        ListPage listpage = getLoginObject().login("nikhilj1993@gmail.com","Test1234!");
        listpage.addProductToCart(product);
        Thread.sleep(4000);
        listpage.clickOnCartButton();
        System.out.println("**********************************"+listpage.numberOfItemsInCart());
        listpage.signOut();
    }

    @Test(dataProvider = "DataAsHashMap",dataProviderClass = dataprovider.Dataprovider.class)
    public void presentInCart2(HashMap<String,String> hm) throws InterruptedException {
        String product = "ZARA COAT 3";
        ListPage listpage = getLoginObject().login("nikhilj1993@gmail.com","Test1234!");
        listpage.addProductToCart(product);
        Thread.sleep(4000);
        listpage.clickOnCartButton();
        listpage.signOut();
    }
}
