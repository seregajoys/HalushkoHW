package com.rozetka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputersAndNotebooksPage extends AnyPage{
    public ComputersAndNotebooksPage(PageManager pages){super(pages);}

    @FindBy(xpath = "(//*[@class='pab-h3-link'])[1]")
    private WebElement navigateToNotebooksCategoriesPage;

    public NotebookCategoriesPage getToNotebooksCategoriesPage(){
        navigateToNotebooksCategoriesPage.click();
        return pages.notebookCategoriesPage;
    }
}
