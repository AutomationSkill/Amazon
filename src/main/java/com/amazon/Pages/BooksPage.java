package com.amazon.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.amazon.blocks.BooksModuleWebElements.*;


/**
 * Created by arulelango on 18/03/18.
 */
public class BooksPage {

    private WebDriver driver;

    public BooksPage(WebDriver driver){
        this.driver =driver;
    }

    @FindBy(how = How.XPATH,using = BOOKS_HEADER)
    WebElement booksHeader;
    @FindBy(how = How.XPATH,using = BOOKS_TITLE)
    WebElement booksTitle;
    @FindBy(how = How.XPATH,using = BOOK_FORMAT)
    WebElement bookType;
    @FindBy(how = How.XPATH,using = BOOK_PRICE)
    WebElement bookPrice;
    @FindBy(how = How.ID,using = GAME_OF_THRONES_DETAILS)
    WebElement bookDetails;
    @FindBy(how = How.XPATH,using = GAME_OF_THRONES_BOOKFORMAT)
    WebElement gameBookType;


    public void assertBooksPageTitle(){
        booksHeader.isDisplayed();
    }
    
    public void assertBooksTitle(){
        booksTitle.isDisplayed();
    }

    public void assertBookType(String expectedType){
      String  typeActual = bookType.getText();
      typeActual.equals(expectedType);

    }
    public void assertBookPrice(String expectedPrice){
        String priceActual = bookPrice.getText();
        priceActual.equals(expectedPrice);
    }
    public void navigateToBookDetails(String expectedBookName){
        booksTitle.click();
        String actualBookName = bookDetails.getText();
        Assert.assertEquals(expectedBookName,actualBookName);
    }
    public void assertBookTypeInBookDetailsPage(String expectedType){
        String actualBookType = gameBookType.getText();
        Assert.assertEquals(expectedType,actualBookType);

    }

}
