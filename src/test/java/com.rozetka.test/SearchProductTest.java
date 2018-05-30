package com.rozetka.test;


import org.testng.Assert;
import org.testng.annotations.Test;

import static com.rozetka.applogic2.ProductHelper.*;

public class SearchProductTest extends TestBase {

    @Test
    public void searchProduct() {
    app.getProductHelper().setProductName(productForSearch);
    app.getNavigationHelper().openProductPage();
    app.getNavigationHelper().addProductToCart();
        Assert.assertTrue(app.getNavigationHelper().productIsAddedToCart());
    }
}
