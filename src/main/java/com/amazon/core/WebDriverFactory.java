package com.amazon.core;

import com.amazon.constants.ApplicationConstants;
import com.amazon.constants.Browsers;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.log4j.Logger;
import org.openqa.selenium.safari.SafariDriver;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static com.amazon.constants.ApplicationConstants.CHROME_DRIVER_LOC;

/**
 * Created by arulelango on 18/03/18.
 */
public class WebDriverFactory {

    private static final Logger LOGGER = Logger.getLogger(WebDriverFactory.class.getName());

    public final static String CHROME_DRIVER_PATH = "src/main/resources/chromedriver.exe";
    private static WebDriverFactory webDriverFactory = new WebDriverFactory();
    private static final String MESSAGE = "Request Driver :";
    private static final String UNKNOWN_ENVIRONMENT = "Unknown Environment :";
    private static final String BROWSER_PROP_KEY = "browser";
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    private WebDriverFactory() {
    }

    public static WebDriverFactory getInstance() {
        return webDriverFactory;
    }


    public WebDriver createDriver(Browsers browsers) {
        WebDriver driver = null;
        LOGGER.info(MESSAGE + browsers);
        switch (browsers) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver",ApplicationConstants.CHROME_DRIVER_LOC);
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("marionette", true);
                driver = new FirefoxDriver(capabilities);
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver",getChromeDriverPath());
                driver = new ChromeDriver();
        }
        return driver;
    }

    private String getChromeDriverPath() {
            return CHROME_DRIVER_LOC;
    }

//    private String getChromeDriverPath() {
//        Platform platform = Platform.getCurrent();
//        LOGGER.info("Platform :" + platform);
//        if (Platform.MAC.is(platform)) {
//            return CHROME_DRIVER_LOC;
//        } else if (Platform.WIN10.is(platform)) {
//            return CHROME_DRIVER_PATH;
//        } else {
//            throw new IllegalArgumentException(UNKNOWN_ENVIRONMENT);
//        }
//    }

    private static DesiredCapabilities getIECapabilities() {
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                true);
        return capabilities;
    }


}
