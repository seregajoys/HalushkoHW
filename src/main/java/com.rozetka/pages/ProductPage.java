package com.rozetka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends AnyPage {
    public ProductPage(PageManager pages){super(pages);}

    @FindBy(xpath = "//*[@name='topurchases']")
    private WebElement buyButton;

    @FindBy(xpath = "//*[@id='cart-popup']/div[2]/div[1]/h2")
    private WebElement popupAddToCart;

    @FindBy(xpath = "//*[@class='exponea-close']")
    private WebElement sranuyBanerOnProductPage;

    public ProductPage ensurePageLoaded() {
        super.ensurePageLoaded();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("cart-title")));
        return this;
    }

    public ProductPage addToCart(){
        if(sranuyBanerOnProductPage.isDisplayed()) {
            sranuyBanerOnProductPage.click();
        }
        buyButton.click();

        return this;
    }
    public Boolean productAddedToCart(){
        return popupAddToCart.isDisplayed();
    }
}
