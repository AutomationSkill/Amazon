package com.amazon.core;

import com.amazon.Pages.BasketPage;
import com.amazon.Pages.BooksPage;
import com.amazon.Pages.SearchPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by arulelango on 18/03/18.
 */
public class BaseStep {

    protected WebDriver getDriver() {
        return BrowserDriver.getDriver();
    }


    protected SearchPage searchPage;

    protected BooksPage booksPage;

    protected BasketPage basketPage;



}
