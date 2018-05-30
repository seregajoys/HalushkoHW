package com.rozetka.pages;

import com.rozetka.model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends AnyPage {
    public HomePage(PageManager pages) {
        super(pages);
    }

    @FindBy(xpath = "//a[@name='signin']")
    private WebElement logInForm;

    @FindBy(xpath = "//*[@class='auth-f-signup']")
    private WebElement signUpForm;

    @FindBy(xpath = "(//*[@class='input-text auth-input-text'])[1]")
    private WebElement emailInput ;

    @FindBy(xpath = "(//*[@class='input-text auth-input-text'])[2]")
    private WebElement passInput ;

    @FindBy(xpath = "//*[@name='auth_submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id='rz-search']/form/div[1]/div[2]/input")
    private WebElement searchInput ;

    @FindBy(xpath = "//span[@class='btn-link btn-link-green']")
    private WebElement searchButton ;

    @FindBy(xpath = "//a[@class='hub-i-link hub-i-cart-link sprite-side whitelink']")
    private WebElement cartButton ;

    @FindBy(xpath = "//a[@name='profile']")
    private WebElement profileButton;

    @FindBy(xpath = "//*[@class='m-top']/li[2]")
    private WebElement creditLink;

    @FindBy (xpath = "//span[@class='exponea-close-cross']")
    private WebElement sranuybanner;

    @FindBy(xpath = "//*[@id='drop-block']")
    private WebElement dropBlock;

    @FindBy(xpath = "(//*[@name='fat_menu_link'])[1]")
    private WebElement computersAndNotebooksPageLink;


    public HomePage ensurePageLoaded() {
         super.ensurePageLoaded();

         wait.until(ExpectedConditions.elementToBeClickable(By.className("header-user-link sprite-side whitelink xhr")));
         return this;
    }

    public CreditPage openCreditLink() {
        creditLink.click();
        return pages.creditPage;
    }

    public HomePage setEmailField(String email){
        emailInput.sendKeys(email);
        return this;
    }

    public HomePage setPassowrdField(String password){
        passInput.sendKeys(password);
        return this;
    }


    public HomePage setProductField(String product){
        searchInput.sendKeys(product);
        return this;
    }

    public HomePage getLogInForm(){
        logInForm.click();
        return this;
    }

    public SearchResultPage searchButtonClick(){
        searchButton.click();
        return pages.searchResultPage;
    }

    public HomePage clickSubmitButton(){
    signInButton.click();
    return this;
    }

    public Boolean profileIsDisplayed(){
        if (profileButton.isDisplayed()) return true;
        else return false;
    }

    public SignUpPage getSignUpPage()  {
        logInForm.click();

       if (sranuybanner != null){
            sranuybanner.click();
        }
        else {
           signUpForm.click();
       }

        signUpForm.click();
        return pages.signUpPage;
    }


    public HomePage clickToCart(){
        cartButton.click();
        return this;
    }

public ProfilePage clickUserProfilePage(){
        profileButton.click();
        return pages.profilePage;
}
/*
public HomePage clickLogoutLink(){
        profileButton.click();
        return this;
}
*/

    public Boolean checkCartIsEmpty(){
        return dropBlock.isDisplayed();
    }

    public ComputersAndNotebooksPage getComputersAndNotebooksPage(){
        wait.until(ExpectedConditions.elementToBeClickable(computersAndNotebooksPageLink));
        computersAndNotebooksPageLink.click();
        return pages.computersAndNotebooksPage;
    }
}
