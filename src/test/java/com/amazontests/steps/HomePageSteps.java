package com.amazontests.steps;

import com.amazon.constants.Browsers;
import com.amazon.constants.TestContext;
import com.amazon.core.WebDriverFactory;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class HomePageSteps {
    public static WebDriver driver;
    private Logger logger;



    public HomePageSteps() {
        driver = WebDriverFactory.getInstance().createDriver(Browsers.CHROME);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }


    @Given("^user enters amazon$")
    public void user_enters_amazon() {
        driver.get(TestContext.getBaseUrl());
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
}
