package com.rozetka.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageManager {

    private WebDriver driver;

    public HomePage homePage;
    public CreditPage creditPage;
    public SignUpPage signUpPage;
    public SearchResultPage searchResultPage;
    public ComputersAndNotebooksPage computersAndNotebooksPage;
    public NotebookCategoriesPage notebookCategoriesPage;
    public NotebooksPage notebooksPage;
    public ProfilePage profilePage;
    public AsusNotebooksPage asusNotebooksPage;
    public ProductPage productPage;

    public PageManager(WebDriver driver) {
        this.driver = driver;
        homePage = initElements(new HomePage(this));
        creditPage = initElements(new CreditPage(this));
        signUpPage = initElements(new SignUpPage(this));
        searchResultPage = initElements(new SearchResultPage(this));
        computersAndNotebooksPage = initElements(new ComputersAndNotebooksPage(this));
        notebookCategoriesPage = initElements(new NotebookCategoriesPage(this));
        notebooksPage = initElements(new NotebooksPage(this));
        profilePage = initElements(new ProfilePage(this));
        asusNotebooksPage = initElements(new AsusNotebooksPage(this));
        productPage = initElements(new ProductPage(this));
    }

    private <T extends Page> T initElements(T page) {
        PageFactory.initElements(driver, page);
        return page;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

}
