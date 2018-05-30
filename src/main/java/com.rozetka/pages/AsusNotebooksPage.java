package com.rozetka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AsusNotebooksPage extends AnyPage {
    public AsusNotebooksPage(PageManager pages){super(pages);}

    @FindBy(xpath = "//div[@class='g-i-tile g-i-tile-catalog']")
    private List<WebElement> listOfAsusNotebooks;

    @FindBy(xpath = "(//*[@class='btn-link-i'])[2]")
    private WebElement listButton;

    @FindBy(xpath = "//*[@class='g-i-list-middle-part']")
    private List<WebElement> listOfAsusNotebooksAfterSwitch;

    @FindBy(xpath = "//*[@class='g-i-more-link-text']")
    private  WebElement loadMoreButton;

    @FindBy(xpath = "//*[@class='g-i-list-title']")
    private List<WebElement> listAfterLoadMore;

    public int getSizeAsusNotebooks(){
        return listOfAsusNotebooks.size();
    }

    public int getSizeAfterLoad(){
        return listAfterLoadMore.size();
    }

    public AsusNotebooksPage switchToList(){
        listButton.click();
        return this;
    }


    public AsusNotebooksPage linkToLoadMore(){
        loadMoreButton.click();
        return pages.asusNotebooksPage;
    }

    public int getSizeAsusNotebooksAfterSwitch(){
        return listOfAsusNotebooksAfterSwitch.size();
    }
}
