package com.amazon.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.amazon.blocks.BasketModuleWebElements.*;


/**
 * Created by arulelango on 18/03/18.
 */
public class BasketPage
{
    private WebDriver driver;
    public BasketPage(){
        this.driver = driver;
    }

    @FindBy(how = How.ID,using = ADD_TO_BASKET)
    WebElement addToBasket;
    @FindBy(how = How.XPATH,using = NOTIFICATION)
    WebElement notification;
    @FindBy(how = How.XPATH,using = SUBTOTAL_ITEM_NOTIFICATION)
    WebElement subTotalNotofication;
    @FindBy(how = How.ID,using = EDIT_BASKET)
    WebElement editBasket;
    @FindBy(how = How.XPATH,using = SHOPPING_BASKET)
    WebElement shoppingBasket;
    @FindBy(how = How.XPATH,using = BASKET_LIST_SUBTOTAL)
    WebElement basketListSubtotal;
    @FindBy(how = How.XPATH,using = BOOKTITLE_BASKET)
    WebElement bookTitleBasketPage;
    @FindBy(how = How.XPATH,using = BOOKFORMAT_BASKET)
    WebElement bookFormatBasketPage;
    @FindBy(how = How.XPATH,using = BOOKPRICE_BASKET)
    WebElement bookPriceBasketPage;
    @FindBy(how = How.ID,using = QUANTITY_BASKET)
    WebElement quantityBasketPage;
    @FindBy(how = How.ID,using = SUBTOTAL_BASKET)
    WebElement subTotalBasketPage;


    public void addToBasket(){
        addToBasket.click();
    }

    public void assertNotification(String expectedNotification){
        notification.isDisplayed();
        String actualNotification = notification.getText();
        Assert.assertEquals(expectedNotification,actualNotification);


    }
    public void assertSubTotalDisplayed(String expectedItem){
        subTotalNotofication.isDisplayed();
        String actualItems= subTotalNotofication.getText();
        Assert.assertEquals(expectedItem,actualItems);
    }

    public void selectEditBasket(){
        editBasket.click();
    }
    public void assertShoppingBasketTitle(String expectedShoppingBasketTitle){
        String actualShoppingBasketTitle = shoppingBasket.getText();
        Assert.assertEquals(expectedShoppingBasketTitle,actualShoppingBasketTitle);
    }
    public void assertBookInBasketList(String expectedBookTitle){
        String actualBookTitle = bookTitleBasketPage.getText();
        Assert.assertEquals(expectedBookTitle,actualBookTitle);
    }
    public void assertBookFormatInBasketPage(String expectedBookFormat){
        String actualBookFormatInBasketPage = bookFormatBasketPage.getText();
        Assert.assertEquals(expectedBookFormat,actualBookFormatInBasketPage);
    }
    public void assertBookPriceInBasketPage(String expectedPrice){
        String actualPriceInBasketPage = bookPriceBasketPage.getText();
        Assert.assertEquals(expectedPrice,actualPriceInBasketPage);
    }
    public void assertQuantityInBasketPage(String expectedQuantity){
        String actualQuantityInBasketPage =quantityBasketPage.getText();
        Assert.assertEquals(expectedQuantity,actualQuantityInBasketPage);
    }
    public void assertSubTotalInBasketPage(String expectedSubTotal){
        String actualSubTotalInBasketPage =subTotalBasketPage.getText();
        Assert.assertEquals(expectedSubTotal,actualSubTotalInBasketPage);
    }

}
