package Util_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P02_LoginPage {
    WebDriver driver1;
    //locators
    final private By usernameField = By.id("username");
    final private By passwordField = By.id("password");
    final private By loginButton = By.className("fa-sign-in");
    final private By successMessage = By.id("flash");

    //constructor
    //We create a constructor to initialize the WebDriver instance that will be passed from the test class (Features.F01_Login)
    //this.driver1 = driver; means we are assigning the driver instance passed from the test class to the local driver1 variable
    // in this page class so that we can use it to interact with the web elements on the page
    public P02_LoginPage(WebDriver driver) {
        this.driver1 = driver;
    }

    //methods

    //method to perform login action
    //this method is in a separate class called Util_Pages.P02_LoginPage because it is related to the login page
    // and it is used to perform the login action for both positive and negative scenarios
    //We made the method parameterized to accept different username and password for positive and negative scenarios
    public void loginTest(String username, String password) {
        //enter username and password and click login button
        driver1.findElement(usernameField).sendKeys(username);
        driver1.findElement(passwordField).sendKeys(password);
        driver1.findElement(loginButton).click();
    }


    //negative scenario
    //this method is in a separate class called Util_Pages.P02_LoginPage
    // because it is related to the login page and it is used to assert the invalid login scenario
    //we didn't create a separate class for the negative scenario because it is related to the same page and it is used to assert the same element (successMessage) but with different text for the negative scenario
   public boolean assertInvalidLogin(){
       WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));

       return wait.until(
               ExpectedConditions.visibilityOfElementLocated(successMessage)
       ).getText().contains("Your username is invalid!");
    }
}
