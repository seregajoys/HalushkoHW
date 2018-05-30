package com.rozetka.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AsusNotebooksPageTest extends TestBase {

    @Test(priority = 0)
    public void getAsusNotebookPage(){
        app.getNavigationHelper().navigateToComputersAndNotebooksPage();
        Assert.assertEquals(app.getNavigationHelper().getTtitleOfPage(), "Компьютеры и ноутбуки - Rozetka.ua | Компьютеры и ноутбуки в Киеве, Харькове, Одессе, Львове: цена, отзывы, продажа, купить оптом компьютеры и ноутбуки");
        app.getNavigationHelper().navigateToAsusNotebooksPage();
        Assert.assertEquals(app.getNavigationHelper().getTtitleOfPage(), "Ноутбуки Asus купить в Киеве: цена, отзывы, продажа | Rozetka.ua");
    }

    @Test(priority = 1)
       public void getAsusNotebookSize() throws InterruptedException {
        app.getNavigationHelper().getAsusNotebookSize();
        Assert.assertEquals(app.getNavigationHelper().getAsusNotebookSize(), 32);
        app.getNavigationHelper().switchViewModeToList();
        app.getNavigationHelper().getAsusNotebookSizeAfterSwitch();
        Thread.sleep(100);
        Assert.assertEquals(app.getNavigationHelper().getAsusNotebookSizeAfterSwitch(), 16);
    }

    @Test(priority = 2)
            public void getSizeAfterLoadMore(){
       app.getNavigationHelper().clickToLoadMore();
        app.getNavigationHelper().getSizeAfterLoadMoreAsus();
        Assert.assertEquals(app.getNavigationHelper().getSizeAfterLoadMoreAsus(),32);



    }
}
