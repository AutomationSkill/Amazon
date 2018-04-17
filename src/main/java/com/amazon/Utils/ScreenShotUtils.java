package com.amazon.Utils;

import com.amazon.core.BrowserDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.http.client.utils.DateUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by arulelango on 18/03/18.
 */
public class ScreenShotUtils {
    @After({"@Functional"})
    public static void embedScreenshot(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) BrowserDriver.getDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/jpeg"); //stick it in the report
                scenario.write(scenario.getName());
                scenario.write(String.valueOf(scenario.getStatus()));
                File outputFile = new File(System.getProperty("user.dir") + "/target/cucumber-html-reports/"
                        + scenario.getName() + ".jpeg");
                FileOutputStream outputStream = new FileOutputStream(outputFile);
                outputStream.write(screenshot);
            } catch (WebDriverException somePlatformsDontSupportScreeshots) {
                System.err.println(somePlatformsDontSupportScreeshots.getMessage());
            }
        }
    }
}
