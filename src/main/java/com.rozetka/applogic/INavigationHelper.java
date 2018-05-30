package com.rozetka.applogic;


public interface INavigationHelper {

    void openMainPage();
    void openRelativeUrl(String url);
    void switchToNewTab();
    void refreshPage();
    void navigateToHomePage();
    void navigateToCreditPage();
    void navigateToSignUpPage() throws InterruptedException;
    void getLoginForm();
    void navigateToComputersAndNotebooksPage();
    //void navigateToNotebooksPage();
    void switchViewModeToList();
    void navigateToAsusNotebooksPage();
    void clickToLoadMore();
    void navigateToNotebookCategoriesPage();

    //void getSearchResultPage();
    void scrollToTerms();
    boolean getCreditRule1();
    boolean getCreditRule2();
    boolean getCreditRule3();
    boolean getCreditRule4();
    String getCreditTermsAge();
    int getNotebooksSize();
    int getAsusNotebookSize();
    int getAsusNotebookSizeAfterSwitch();
    int getSizeAfterLoadMoreAsus();
    void selectFilter1();
    void removeFilter();
    boolean checkFilterIsEnable();
    void openProductPage();
    void addProductToCart();
    boolean productIsAddedToCart();
    void getSignUp();
    boolean confirmEmailIsPresent();
    boolean confirmProfileIsDisplayed();
    boolean cartIsEmpty();



}
