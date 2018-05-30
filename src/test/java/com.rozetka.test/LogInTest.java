package com.rozetka.test;




import org.testng.Assert;
import org.testng.annotations.Test;

import static com.rozetka.applogic2.UserHelper.userLogIn;


public class LogInTest extends TestBase {


    @Test
    public void loginOk()  {
        app.getNavigationHelper().getLoginForm();
        app.getUserHelper().loginAs(userLogIn);
        Assert.assertTrue(app.getNavigationHelper().confirmProfileIsDisplayed());
    }
}
