package com.rozetka.applogic;



import com.rozetka.applogic2.NavigationHelper;
import com.rozetka.applogic2.ProductHelper;
import com.rozetka.applogic2.UserHelper;
import org.openqa.selenium.WebDriver;


public interface IApplicationManager {

    NavigationHelper getNavigationHelper();
    WebDriver getWebdriver();
    UserHelper getUserHelper();
    ProductHelper getProductHelper();




    void stop();
    void close();
}
