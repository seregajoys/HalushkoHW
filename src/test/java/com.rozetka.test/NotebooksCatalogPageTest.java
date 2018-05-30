package com.rozetka.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NotebooksCatalogPageTest extends TestBase {

    @Test
    public void clickToSelectFilter() {
        app.getNavigationHelper().navigateToNotebookCategoriesPage();
        Assert.assertEquals(app.getNavigationHelper().getTtitleOfPage(),"Ноутбуки - Rozetka.ua | Купить ноутбук в Киеве, Харькове, Одессе, Львове: цена, отзывы, продажа, купить ноутбуки");
        app.getNavigationHelper().selectFilter1();
        Assert.assertTrue(app.getNavigationHelper().checkFilterIsEnable());
        app.getNavigationHelper().removeFilter();

    }
}
