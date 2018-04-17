package com.amazontests.steps;

import com.amazon.Pages.BooksPage;
import com.amazon.core.BaseStep;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.PageFactory;

import static com.amazontests.steps.HomePageSteps.driver;

public class BooksDetailsPageSteps extends BaseStep{
    private BooksPage booksPage;


    public BooksDetailsPageSteps(){
        booksPage = PageFactory.initElements(driver, BooksPage.class);
    }

    @Then("^user is in books module$")
    public void user_is_in_books_module() {
        booksPage.assertBooksPageTitle();
    }


    @Then("^verify the first item has the title \"([^\"]*)\"$")
    public void verifyTheFirstItemHasTheTitle(String title) {
        booksPage.assertBooksTitle();
    }

    @Then("^verify the book type is \"([^\"]*)\"$")
    public void verifyTheBookTypeIs(String bookType) {
        booksPage.assertBookType(bookType);
    }

    @Then("^verify the book price \"([^\"]*)\"$")
    public void verifyTheBookPrice(String expectedPrice) {
        booksPage.assertBookPrice(expectedPrice);
    }

    @Then("^navigate to \"([^\"]*)\"$")
    public void navigateTo(String selectedBook) {
        booksPage.navigateToBookDetails(selectedBook);
    }

    @Then("^verify the book type in book details page as \"([^\"]*)\"$")
    public void verifyTheBookTypeInBookDetailsPageAs(String expectedBookType) {
        booksPage.assertBookTypeInBookDetailsPage(expectedBookType);
    }



}
