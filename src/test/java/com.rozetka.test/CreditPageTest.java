package com.rozetka.test;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CreditPageTest extends TestBase {

    @Test(priority = 0)
    public void navigateToCreditPageTest() {
        app.getNavigationHelper().navigateToCreditPage();
        Assert.assertEquals(app.getNavigationHelper().getTtitleOfPage(), "Купить в кредит. Способ оформления кредита");

    }

    @Test(priority = 1)
    public void tableTest(){
        app.getNavigationHelper().getCreditRule1();
        app.getNavigationHelper().getCreditRule2();
        app.getNavigationHelper().getCreditRule3();
        app.getNavigationHelper().getCreditRule4();
        Assert.assertTrue(app.getNavigationHelper().getCreditRule1());
        Assert.assertTrue(app.getNavigationHelper().getCreditRule2());
        Assert.assertTrue(app.getNavigationHelper().getCreditRule3());
        Assert.assertTrue(app.getNavigationHelper().getCreditRule4());
        app.getNavigationHelper().scrollToTerms();
        app.getNavigationHelper().getCreditTermsAge();
        Assert.assertEquals(app.getNavigationHelper().getCreditTermsAge(),"21-70");

    }
    @Test(priority = 2)
    public void getValueFromTableTest(){
        Assert.assertEquals(app.getNavigationHelper().getTableValue("0,01% на 5 месяцев", "Льготный период"), "5");

    }
}

