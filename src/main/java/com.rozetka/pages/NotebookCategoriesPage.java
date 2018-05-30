package com.rozetka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NotebookCategoriesPage extends AnyPage{
    public NotebookCategoriesPage(PageManager pages) {
        super(pages);
    }

    @FindBy(xpath = "//div[@class='pab-cell pab-img-45']")
    private List<WebElement> notebookBrands;

    @FindBy(xpath = "(//*[@class='pab-items-i'])[1]")
    private WebElement asusNotebooks;

    @FindBy(xpath = "(//*[@class='m-cat-subl-i'])[17]")
    private WebElement priceFilter;

    public int getNotebookBrands() {
        return notebookBrands.size();
    }

    public AsusNotebooksPage getAsusNotebooksPage(){
        asusNotebooks.click();
        return pages.asusNotebooksPage;
    }

    public NotebooksPage selectFilter(){
        priceFilter.click();
        return pages.notebooksPage;
    }

}
