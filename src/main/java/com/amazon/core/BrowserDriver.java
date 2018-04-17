package com.amazon.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.apache.log4j.Logger;
import java.util.ArrayList;


/**
 * Created by arulelango on 18/03/18.
 */
public class BrowserDriver {

    private static final Logger LOGGER = Logger.getLogger(BrowserDriver.class.getName());

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            setDriver(WebDriverFactory.getDriver());
            Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
        }
        return driver;
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static void close() {
        try {
            getDriver().quit();
            setDriver(null);
            LOGGER.info("Closing the browser");
        } catch (UnreachableBrowserException e) {
            LOGGER.error("Cannot close browser: ");
            e.printStackTrace();
        }
    }

    private static class BrowserCleanup implements Runnable {
        public void run() {
            close();
        }
    }

    public static void loadPage(String url) {
        getDriver().get(url);
        LOGGER.info("Java version: " + Runtime.class.getPackage().getImplementationVersion());
        LOGGER.info("Browser directed to:" + url);
    }

    private static ArrayList<String> tabs;

    public static void switchBrowserTabs() {
        tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
    }

    public static void closeTabAndSwitchBack() {
        getDriver().close();
        getDriver().switchTo().window(tabs.get(0));
    }
}
