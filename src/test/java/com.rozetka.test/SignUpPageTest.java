package com.rozetka.test;


import org.testng.Assert;
import org.testng.annotations.Test;

import static com.rozetka.applogic2.UserHelper.basicUser;


public class SignUpPageTest extends TestBase {

    @Test
    public void addNewUser(){
        app.getNavigationHelper().getSignUp();
        app.getUserHelper().signUpAs(basicUser);
        Assert.assertTrue(app.getNavigationHelper().confirmEmailIsPresent());
    }
}
