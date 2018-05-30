package com.rozetka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends AnyPage{
    public SignUpPage(PageManager pages) {
        super(pages);
    }

    @FindBy(xpath = "//*[@id=\"signup_form\"]/div[1]/input")
    private WebElement userNameField;

    @FindBy(xpath = "//*[@id='signup_form']/div[2]/input")
    private WebElement emailFieldOnSignUp;

    @FindBy(xpath = "//*[@id=\"signup_form\"]/div[3]/input")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@class='btn-link btn-link-green btn-link-sign']")
    private WebElement signUpButton;

    @FindBy(xpath = "//*[@class='signup-title']")
    private WebElement headTitle;

    @FindBy(xpath = "(//*[@class='btn-link-i'])[1]")
    private WebElement clickSubmitOnSignUp;

    public SignUpPage setUsername(String username) {
        userNameField.sendKeys(username);
        return this;
    }
    public SignUpPage setPasswrod (String passwrod){
        passwordField.sendKeys(passwrod);
        return this;
    }

    public ProfilePage clickSumbit(){
        clickSubmitOnSignUp.click();
        return pages.profilePage;
    }

    public SignUpPage setEmail(String email){
        emailFieldOnSignUp.sendKeys(email);
        return this;
    }

    public ProfilePage getNewUser (String username, String email, String password) {
        setUsername(username);
        setEmail(email);
        setPasswrod(password);
        signUpButton.click();
        return pages.profilePage;
    }
}
