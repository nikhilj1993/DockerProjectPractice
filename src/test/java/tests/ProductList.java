package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ListPage;

import java.util.*;

public class ProductList extends BaseTest {

    @Test(priority=1,dataProvider = "DataAsHashMap",dataProviderClass = dataprovider.Dataprovider.class)
    public void isProductsPresent(HashMap<String,String> hm) throws InterruptedException {
        System.out.println(hm);
     //   String[] products = (hm.get("products")).split(",");
       String[] products = {"ZARA COAT 3","IPHONE 13 PRO","ADIDAS ORIGINAL"};
       ListPage listpage = getLoginObject().login("nikhilj1993@gmail.com","Test1234!");
       List<String> expectedProductNames = Arrays.asList(products);

       HashSet<String> actualProductNames = listpage.getProductNames();
        Assert.assertEquals(Set.of(products),actualProductNames);
        listpage.signOut();

    }
    @Test(priority=2,dataProvider = "DataAsHashMap",dataProviderClass = dataprovider.Dataprovider.class)
    public void addToCart(HashMap<String,String> hm) throws InterruptedException {
        ListPage listpage = getLoginObject().login("nikhilj1993@gmail.com","Test1234!");
        listpage.addProductToCart(hm.get("product"));
        System.out.println("**********************************"+listpage.numberOfItemsInCart());
        Thread.sleep(4000);
        listpage.signOut();
    }
}
