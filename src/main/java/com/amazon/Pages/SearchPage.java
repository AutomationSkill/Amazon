package com.amazon.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import static com.amazon.blocks.SearchModuleWebElements.*;


/**
 * Created by arulelango on 18/03/18.
 */
public class SearchPage{

        private WebDriver driver;
        private Select select;

        public SearchPage(WebDriver driver){this.driver=driver;}

        @FindBy(how = How.ID, using = SEARCH_DROPDOWN_BOX_ID)
        private WebElement searchAll;

        @FindBy(how = How.ID,using = SEARCH_TEXT_FIELD_ID)
        private WebElement searchText;

        @FindBy(how = How.XPATH,using = SUBMIT_BUTTON)
        private WebElement submit;





        public void clickSearchDropDownForBooks(){
            select = new Select(searchAll);
            select.selectByVisibleText("Books");

        }

        public void EnterTextToSearch(String textToEnter){

            searchText.sendKeys(textToEnter);
            submit.click();
        }

}
