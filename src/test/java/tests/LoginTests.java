package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ListPage;

import java.util.HashMap;

public class LoginTests extends BaseTest {

    @Test(priority=-1,dataProvider = "DataAsHashMap",dataProviderClass = dataprovider.Dataprovider.class)
    public void successfulLogin(HashMap<String,String> hm) throws InterruptedException {
        String username = hm.get("username");
        String password = hm.get("password");
        ListPage listPage = getLoginObject().login(username,password);
        listPage.signOut();
    }

    @Test(dataProvider = "DataAsHashMap",dataProviderClass = dataprovider.Dataprovider.class)
    public void unSuccessfulLogin(HashMap<String,String> hm){
        String username = hm.get("username");
        String password = hm.get("password");
        getLoginObject().login(username,password);
        System.out.println("***************************"+getLoginObject().getLoginErrorMessage());
    }

    @Test
    public void emptyEmail(){
        getLoginObject().login("","*********");
        System.out.println("***************************"+getLoginObject().getNoEmailError());
    }

    @Test
    public void emptyPassword(){
        getLoginObject().login("nikhilj1993@gmail.com","");
        System.out.println("***************************"+getLoginObject().getNoPasswordError());
    }


}
