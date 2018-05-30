package com.rozetka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends AnyPage {
    public SearchResultPage(PageManager pages) {
        super(pages);
    }

    @FindBy(xpath = "(//div[@class='g-i-tile-i-title clearfix'])[1]")
    private WebElement firstItem;

    public ProductPage openProductPage(){
        firstItem.click();
        return pages.productPage;
    }
}
