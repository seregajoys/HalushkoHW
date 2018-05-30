package com.rozetka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends AnyPage {
    public ProfilePage (PageManager pages){super(pages);}

    @FindBy(xpath = "//*[@id=\"confirm_email_btn\"]")
    private WebElement confirmEmailButton;

    @FindBy(xpath = "//*[@class='profile-m-edit-signout']")
    private WebElement logoutLink;

    @FindBy(xpath = "(//*[@class='profile-info-l-i-text'])[1]")
    private WebElement userName;

    @FindBy(xpath = "(//*[@class='profile-info-l-i-text'])[2]")
    private WebElement userEmail;

    @Override
    public ProfilePage ensurePageLoaded() {
        super.ensurePageLoaded();

        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        return this;
    }

    public ProfilePage clickLogoutLink(){
        pages.homePage.clickUserProfilePage();
        pages.profilePage.logoutLink.click();
        return this;
    }

    public Boolean checkConfirmEmailPresent(){
        ensurePageLoaded();
        return confirmEmailButton.isDisplayed();
    }

    public String getUsername(){
    return userName.getText();
    }

    public String getEmail(){
    return userEmail.getText();
    }


}

