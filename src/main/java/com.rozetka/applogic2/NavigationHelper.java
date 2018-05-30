package com.rozetka.applogic2;


import com.rozetka.applogic.INavigationHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class NavigationHelper extends DriverBasedHelper implements INavigationHelper {
    private String baseUrl;


    public NavigationHelper(ApplicationManager manager) {
        super(manager.getWebDriver());
        this.baseUrl = manager.getBaseUrl();
    }

    @Override
    public void openMainPage() {
        driver.get(baseUrl);
    }

    @Override
    public void openRelativeUrl(String url) {

    }

    @Override
    public void switchToNewTab() {

    }

    @Override
    public void refreshPage() {
        super.driver.navigate().refresh();
    }

    @Override
    public void navigateToHomePage() {

    }

    @Override
    public void navigateToCreditPage() {
        pages.homePage
                .openCreditLink();
    }

    @Override
    public void getLoginForm(){
        pages.homePage.getLogInForm();
    }

    @Override
    public void navigateToComputersAndNotebooksPage() {
        pages.homePage.getComputersAndNotebooksPage();
    }



    @Override
    public void switchViewModeToList() {
        pages.asusNotebooksPage.switchToList();
    }


    @Override
    public void navigateToAsusNotebooksPage() {
     pages.notebookCategoriesPage.getAsusNotebooksPage();
    }

    @Override
    public void clickToLoadMore() {
        pages.asusNotebooksPage.linkToLoadMore();
    }

    @Override
    public void navigateToNotebookCategoriesPage() {
        pages.homePage.getComputersAndNotebooksPage()
                .getToNotebooksCategoriesPage();
    }
/*
    @Override
    public void getSearchResultPage() {
        pages.homePage.searchButtonClick();
    }
    */

/*
    @Override
    public void getSearchResultPage() {
        pages.homePage.searchProduct("Iphone");
    }
    */

   @Override
   public void scrollToTerms(){
    pages.creditPage.scrollToElement();
    }

    @Override
    public boolean getCreditRule1() {
        pages.creditPage.getCreditRules1();
        return true;
    }

    @Override
    public boolean getCreditRule2() {
pages.creditPage.getCreditRules2();
        return true;
    }

    @Override
    public boolean getCreditRule3() {
pages.creditPage.getCreditRules3();
        return true;
    }

    @Override
    public boolean getCreditRule4() {
pages.creditPage.getCreditRules4();
        return true;
    }

    @Override
    public String getCreditTermsAge() {
        return pages.creditPage.checkCreditTermsAge();
    }

    @Override
    public int getNotebooksSize() {
        return pages.notebookCategoriesPage.getNotebookBrands();
    }

    @Override
    public int getAsusNotebookSize() {
        return pages.asusNotebooksPage.getSizeAsusNotebooks();
    }

    @Override
    public int getAsusNotebookSizeAfterSwitch() {
        return pages.asusNotebooksPage.getSizeAsusNotebooksAfterSwitch();
    }

    @Override
    public int getSizeAfterLoadMoreAsus() {
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='g-i-list-title'])[32]")));
       return pages.asusNotebooksPage.getSizeAfterLoad();
    }

    @Override
    public void selectFilter1() {
        pages.notebookCategoriesPage.selectFilter();
    }

    @Override
    public void removeFilter() {
        pages.notebooksPage.clearFilters();
    }

    @Override
    public boolean checkFilterIsEnable() {
        pages.notebooksPage.chekFilterIsSelected();
        return true;
    }

    @Override
    public void openProductPage() {
        pages.searchResultPage.openProductPage();
    }

    @Override
    public void addProductToCart() {

pages.productPage.addToCart();
    }

    @Override
    public boolean productIsAddedToCart() {
       pages.productPage.ensurePageLoaded()
               .productAddedToCart();
        return true;
    }

    @Override
    public void getSignUp() {
        pages.homePage.getSignUpPage();
    }

    @Override
    public boolean confirmEmailIsPresent() {
       pages.profilePage
               .checkConfirmEmailPresent();
        return true;
    }

    @Override
    public boolean confirmProfileIsDisplayed() {
       pages.homePage.ensurePageLoaded()
               .profileIsDisplayed();
        return true;
    }

    @Override
    public boolean cartIsEmpty() {
       pages.homePage.clickToCart();
       pages.homePage.checkCartIsEmpty();
        return true;
    }


    public String getTableValue(String packName, String condition) {
        return pages.creditPage.getValueFromTable(packName , condition);
    }

    @Override
    public void navigateToSignUpPage() {
        pages.homePage.getSignUpPage();
    }

    public String getTtitleOfPage() {
        return pages.creditPage.getTitle();
        }

}
