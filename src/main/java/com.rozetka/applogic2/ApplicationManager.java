package com.rozetka.applogic2;


import com.rozetka.applogic.IApplicationManager;
import com.rozetka.util.Browser;
import com.rozetka.util.PropertyLoader;
import com.rozetka.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class ApplicationManager implements IApplicationManager {
    private NavigationHelper navHelper;
    private UserHelper userHelper;
    private WebDriver driver;
    private String baseUrl;
    private String devUrl;
    private String browserName;
    private ProductHelper productHelper;

    public ApplicationManager() {
        baseUrl = PropertyLoader.loadProperty("site.url");
        browserName = PropertyLoader.loadProperty("browser.name");
        String gridHubUrl = PropertyLoader.loadProperty("grid2.hub");

        Browser browser = new Browser();
        browser.setName(PropertyLoader.loadProperty("browser.name"));
        browser.setVersion(PropertyLoader.loadProperty("browser.version"));
        browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));

        String username = PropertyLoader.loadProperty("user.username");
        String password = PropertyLoader.loadProperty("user.password");


        driver = WebDriverFactory.getInstance(gridHubUrl, browser, username, password);
//        driver = WebDriverFactory.getInstance(browserName, username, password);
        driver.manage().window().maximize();


        navHelper = new NavigationHelper (this);
        userHelper = new UserHelper(this);
        productHelper = new ProductHelper(this);


    }

    protected WebDriver getWebDriver() { return driver; }
    protected String getBaseUrl() { return baseUrl; }

    @Override
    public NavigationHelper getNavigationHelper() {
        return navHelper;
    }

    @Override
    public UserHelper getUserHelper(){
        return userHelper;
    }

    @Override
    public ProductHelper getProductHelper() {
        return productHelper;
    }

    @Override
    public WebDriver getWebdriver() {
        return driver;
    }

    @Override
    public void stop() {
        if (driver != null) {
            driver.close();
            System.out.println("driver close");
            driver.quit();
            System.out.println("driver quit");
        }
    }

    @Override
    public void close() {
//        if (driver != null) {
        driver.manage().deleteAllCookies();
//            driver.close();
//        }
    }

}
