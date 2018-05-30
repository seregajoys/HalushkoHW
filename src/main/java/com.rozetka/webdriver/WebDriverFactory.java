package com.rozetka.webdriver;

import com.rozetka.util.Browser;
import com.rozetka.util.PropertyLoader;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class WebDriverFactory {

    /* Browsers constants */
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String SAFARI = "safari";
    public static final String OPERA = "opera";
    public static final String INTERNET_EXPLORER = "ie";
    public static final String HTML_UNIT = "htmlunit";


    /* Platform constants */
    public static final String WINDOWS = "windows";
    public static final String ANDROID = "android";
    public static final String XP = "xp";
    public static final String VISTA = "vista";
    public static final String MAC = "mac";
    public static final String LINUX = "linux";

    //    private static WebDriver webDriver = null;
    private static WebDriver webDriver;
//    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    /*
     * Factory method to return a RemoteWebDriver instance given the url of the
     * Grid hub and a Browser instance.
     *
     * @param gridHubUrl : grid hub URI
     *
     * @param browser : Browser object containing info around the browser to hit
     *
     * @param username : username for BASIC authentication on the page to test
     *
     * @param password : password for BASIC authentication on the page to test
     *
     * @return RemoteWebDriver
     */
    public static WebDriver getInstance(String gridHubUrl, Browser browser,
                                        String username, String password) {

//        WebDriver webDriver = null;
//        WebDriver webDriver = null;

        DesiredCapabilities capability = new DesiredCapabilities();
        String browserName = browser.getName();
        capability.setJavascriptEnabled(true);

        // In case there is no Hub
        if (gridHubUrl == null || gridHubUrl.length() == 0) {
            return getInstance(browserName, username, password);
        }

        if (CHROME.equals(browserName)) {
            capability = DesiredCapabilities.chrome();
//            capability.setCapability("pageLoadStrategy", "none");
            System.out.println("CHROME CAPABILITIES 1");
        } else if (FIREFOX.equals(browserName)) {
            capability = DesiredCapabilities.firefox();
            capability.setCapability("marionette", true);

            FirefoxProfile ffProfile = new FirefoxProfile();

            // Authenication Hack for Firefox
            if (username != null && password != null) {
                ffProfile.setPreference("network.http.phishy-userpass-length",
                        255);
                capability.setCapability(FirefoxDriver.PROFILE, ffProfile);
            }

            capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
        } else if (INTERNET_EXPLORER.equals(browserName)) {

            capability = DesiredCapabilities.internetExplorer();
            capability
                    .setCapability(
                            InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                            true);
        } else if (SAFARI.equals(browserName)) {
            capability = DesiredCapabilities.safari();


            return webDriver;
        }

        capability = setVersionAndPlatform(capability, browser.getVersion(),
                browser.getPlatform());

        // Create Remote WebDriver
        try {
            webDriver = new RemoteWebDriver(new URL(gridHubUrl), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return webDriver;
    }

    /*
     * Factory method to return a WebDriver instance given the browser to hit
     *
     * @param browser : String representing the local browser to hit
     *
     * @param username : username for BASIC authentication on the page to test
     *
     * @param password : password for BASIC authentication on the page to test
     *
     * @return WebDriver instance
     */
    public static WebDriver getInstance(String browser, String username,
                                        String password) {

        if (webDriver != null) {
            return webDriver;
        }

        if (CHROME.equals(browser)) {

            ChromeDriverService service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(PropertyLoader.loadProperty("chrome.driver.path")))
                    .usingAnyFreePort()
                    .build();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--dns-prefetch-disable");
            options.setHeadless(false);
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");

//            options.addArguments("--start-fullscreen");
//            options.setPageLoadStrategy(PageLoadStrategy.EAGER);

            webDriver = new ChromeDriver(service, options);

            System.out.println("CHROME CAPABILITIES 2");


        } else if (FIREFOX.equals(browser)) {

            FirefoxProfile ffProfile = new FirefoxProfile();
            FirefoxOptions options = new FirefoxOptions();
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);

            // Authenication Hack for Firefox
            if (username != null && password != null) {
                ffProfile.setPreference("network.http.phishy-userpass-length",
                        255);
            }
            System.setProperty("webdriver.gecko.driver", PropertyLoader.loadProperty("gecko.driver.path"));
//            webDriver = new FirefoxDriver((Capabilities) ffProfile);
            webDriver = new FirefoxDriver(options);

        } else if (INTERNET_EXPLORER.equals(browser)) {
            webDriver = new InternetExplorerDriver();

        } else if (SAFARI.equals(browser)) {
            webDriver = new SafariDriver();

        }

        return webDriver;
    }

    /*
     * Helper method to set version and platform for a specific browser
     *
     * @param capability : DesiredCapabilities object coming from the selected
     * browser
     *
     * @param version : browser version
     *
     * @param platform : browser platform
     *
     * @return DesiredCapabilities
     */
    private static DesiredCapabilities setVersionAndPlatform(
            DesiredCapabilities capability, String version, String platform) {
        if (MAC.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.MAC);
        } else if (LINUX.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.LINUX);
        } else if (XP.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.XP);
        } else if (VISTA.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.VISTA);
        } else if (WINDOWS.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.WINDOWS);
        } else if (ANDROID.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.ANDROID);
        } else {
            capability.setPlatform(Platform.ANY);
        }

        if (version != null) {
            capability.setVersion(version);
        }
        return capability;
    }
}
