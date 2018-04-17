package com.amazontests.steps;


import com.amazon.Pages.SearchPage;
import com.amazon.core.BaseStep;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;

import static com.amazontests.steps.HomePageSteps.driver;


public class SearchPageSteps extends BaseStep{

    private SearchPage search;


    public SearchPageSteps(){
        search = PageFactory.initElements(driver, SearchPage.class);
    }



    @When("^user selects book tab$")
    public void user_selects_book_tab() {
        search.clickSearchDropDownForBooks();
    }

    @When("^user enters bookname \"([^\"]*)\"$")
    public void userEntersBookname(String bookName) {
        search.EnterTextToSearch(bookName);
    }


}
