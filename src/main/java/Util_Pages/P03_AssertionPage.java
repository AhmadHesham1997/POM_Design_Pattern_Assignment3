package Util_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//This class is responsible for handling the assertions related to the login functionality.
// It contains a WebDriver instance to interact with the web elements on the page,
// as well as locators for the elements we want to assert. The class includes a constructor
// to initialize the WebDriver and a method to assert that the login was successful
// by checking for a specific success message on the page.
// This design allows us to keep our test logic separate from the page interactions, making our tests more maintainable and easier to read.
public class P03_AssertionPage {
    WebDriver driver1;
    //constructor
    public P03_AssertionPage(WebDriver driver) {

        this.driver1 = driver;
    }
    //locators
    //this method is in a separate class called Util Pages.P03_AssertionPage
    // because it is related to the assertion of the login functionality and it is used to assert the valid login scenario
    //and because we moved to a new page after login, we need to create a new class to handle the assertions related to the new page
    final private By successMessage = By.id("flash");
   public boolean assertValidLogin(){
        return driver1.findElement(successMessage).getText().contains("You logged into a secure area!");
    }
}
