package com.amazontests.steps;

import com.amazon.Pages.BasketPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;

import static com.amazontests.steps.HomePageSteps.driver;

public class BasketSteps {
    private BasketPage basketPage;


    public BasketSteps(){
        basketPage = PageFactory.initElements(driver,BasketPage.class);

    }

    @When("^user add the book to basket$")
    public void userAddTheBookToBasket() {
        basketPage.addToBasket();
    }

    @Then("^verify the notification is shown as \"([^\"]*)\"$")
    public void verifyTheNotificationIsShownAs(String notification) {
        basketPage.assertNotification(notification);

    }

    @Then("^verify basket subtotal items are \"([^\"]*)\"$")
    public void verifyBasketSubtotalItemsAre(String subtotalItems) {
        basketPage.assertSubTotalDisplayed(subtotalItems);

    }

    @When("^user selects edit basket$")
    public void userSelectsEditBasket() {
        basketPage.selectEditBasket();
    }

    @Then("^verify the user is in shopping basket page \"([^\"]*)\"$")
    public void verifyTheUserIsInShoppingBasketPage(String expectedShoppingBasket) {
        basketPage.assertShoppingBasketTitle(expectedShoppingBasket);
    }

    @Then("^verify the book \"([^\"]*)\" is shown in the list$")
    public void verifyTheBookIsShownInTheList(String bookTitle) {
        basketPage.assertBookInBasketList(bookTitle);
    }

    @Then("^verify the book type in basket is \"([^\"]*)\"$")
    public void verifyTheBookTypeInBasketIs(String format) {
        basketPage.assertBookFormatInBasketPage(format);
    }

    @Then("^verify the price in basket page is \"([^\"]*)\"$")
    public void verifyThePriceInBasketPageIs(String price) {
        basketPage.assertBookPriceInBasketPage(price);
    }

    @Then("^verify the quantity in basket page is \"([^\"]*)\"$")
    public void verifyTheQuantityInBasketPageIs(String quantity) {
        basketPage.assertQuantityInBasketPage(quantity);
    }

    @Then("^verify the subtotal price in basket page as \"([^\"]*)\"$")
    public void verifyTheSubtotalPriceInBasketPageAs(String subTotalPrice) {
        basketPage.assertSubTotalInBasketPage(subTotalPrice);
        driver.quit();
    }







}
