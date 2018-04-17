package com.amazon.core;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by arulelango on 18/03/18.
 */
public class BasePage {
    private final static int EXPLICIT_TIMEOUT = 60000;

    protected WebDriver getDriver() {
        return BrowserDriver.getDriver();
    }

    protected static final Logger LOGGER = Logger.getLogger(BasePage.class.getName());

    public BasePage() {
        waitForDocumentReadyState();
    }

    protected void waitForDocumentReadyState() {
        Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(EXPLICIT_TIMEOUT, TimeUnit.MILLISECONDS).ignoring(WebDriverException.class)
                .pollingEvery(500, TimeUnit.MILLISECONDS);
        ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver input) {
                return ((JavascriptExecutor) getDriver()).executeScript("return document.readyState;")
                        .equals("complete");
            }
        };
    }

    public void assertContains(String message, String expected, List<String> actual) {
        assertTrue(message + "; expected: " + expected + "; actual: " + actual + ";", actual.contains(expected));
    }

    public void assertContains(String message, String expected, String actual) {
        assertTrue(message + "; expected: " + expected + "; actual: " + actual + ";", actual.contains(expected));
    }

    private String getPageTitle() {
        return getDriver().getTitle();
    }

    protected void assertPageTitle(String pageTitle) {
        assertEquals("Page title does NOT match", getPageTitle(), pageTitle);
    }
}
