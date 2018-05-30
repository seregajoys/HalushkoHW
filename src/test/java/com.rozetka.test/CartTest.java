package com.rozetka.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends TestBase {

    @Test
    public void cartIsEmptyTest(){
        Assert.assertTrue(app.getNavigationHelper().cartIsEmpty());
    }
}
