package com.rozetka.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NotebookCategoriesPageTest extends TestBase {

    @Test
    public void getSizeOfNotebooks(){
        app.getNavigationHelper().navigateToNotebookCategoriesPage();
        Assert.assertEquals(app.getNavigationHelper().getTtitleOfPage(),"Ноутбуки - Rozetka.ua | Купить ноутбук в Киеве, Харькове, Одессе, Львове: цена, отзывы, продажа, купить ноутбуки");
        app.getNavigationHelper().getNotebooksSize();
        Assert.assertEquals(app.getNavigationHelper().getNotebooksSize(),8);
    }

}
