package com.rozetka.applogic2;

import com.rozetka.applogic.IProductHelper;
import com.rozetka.model.Product;

public class ProductHelper extends DriverBasedHelper implements IProductHelper {

    public ProductHelper(ApplicationManager manager){
        super(manager.getWebDriver());
    }

    @Override
    public void setProductName(Product product) {
        pages.homePage
                .setProductField(product.getProduct())
                .searchButtonClick();


    }

    public static Product productForSearch = new Product().setProduct("Iphone");
}
