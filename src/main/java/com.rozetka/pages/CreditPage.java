package com.rozetka.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreditPage extends AnyPage {
    public CreditPage(PageManager pages) {
        super(pages);
    }

    @FindBy(xpath = "//*[@class='credit-rules-list']/div[1]")
    private WebElement creditRules1;

    @FindBy(xpath = "//*[@class='credit-rules-list']/div[2]")
    private WebElement creditRules2;
    @FindBy(xpath = "//*[@class='credit-rules-list']/div[3]")
    private WebElement creditRules3;
    @FindBy(xpath = "//*[@class='credit-rules-list']/div[4]")
    private WebElement creditRules4;
    @FindBy(xpath = "(//*[@class='rz-credit-terms-td rz-credit-terms-td-age'])[4]")
    private WebElement creditTermsAge;
    @FindBy(xpath = "//*[@class='rz-credit-block']/h2[contains(text(),\"Условия кредитования\")]")
    private WebElement creditTermsTitle;
    @FindBy(xpath = "(//*[@class='rz-credit-terms-tr'])[5]/td[1]")
    private WebElement creditPackTitle;
    @FindBy(xpath = "(//*[@class='rz-credit-terms-tr'])[5]/td[2]")
    private WebElement creditPeriod;
    @FindBy(xpath = "(//*[@class='rz-credit-terms-tr'])[5]/td[3]")
    private WebElement creditRate;
    @FindBy(xpath = "(//*[@class='rz-credit-terms-tr'])[5]/td[4]")
    private WebElement creditComission;
    @FindBy(xpath = "(//*[@class='rz-credit-terms-tr'])[5]/td[5]")
    private WebElement creditSingleComission;
    @FindBy(xpath = "(//*[@class='rz-credit-terms-tr'])[5]/td[6]")
    private WebElement creditFirstDeposit;
    @FindBy(xpath = "(//table)[1]/tbody/tr[1]/td")
    private List<WebElement> column;
    @FindBy(xpath = "(//table)[1]/tbody/tr[@class='rz-credit-terms-tr']")
    private List<WebElement> creditNames;


    public Boolean getCreditRules1() {
        return creditRules1.isDisplayed();
    }

    public Boolean getCreditRules2() {
        return creditRules2.isDisplayed();
    }

    public Boolean getCreditRules3() {
        return creditRules3.isDisplayed();
    }

    public Boolean getCreditRules4() {
        return creditRules4.isDisplayed();
    }

    public CreditPage scrollToElement() {
        Actions builder = new Actions(driver);
        builder.moveToElement(creditTermsAge).build().perform();
        return this;
    }

    public String checkCreditTermsAge() {
        return creditTermsAge.getText();
    }

    public String checkTableTitle() {
        return creditTermsTitle.getText();
    }

    public String checkCreditPackTitle() {
        return creditPackTitle.getText();
    }

    public String checkCreditPeriod() {
        return creditPeriod.getText();
    }

    public String checkCreditRate() {
        return creditRate.getText();
    }

    public String checkCreditComission() {
        return creditComission.getText();
    }

    public String checkCreditSingleComission() {
        return creditSingleComission.getText();
    }

    public String checkCreditFirstDeposit() {
        return creditFirstDeposit.getText();
    }

    public String getValueFromTable(String packetName, String condition){
        for (WebElement creditName : creditNames) {
            RemoteWebElement row = (RemoteWebElement) creditName;
            if (row.getText().contains(packetName)) {
                for (int i = 0; i < column.size(); i++) {
                    WebElement c = column.get(i);
                    if ((c.getText().contains(condition))) {
                        return row.findElementsByClassName("rz-credit-terms-td").get(i).getText();
                    }
                }
            }
        }
        return "";
    }
}
