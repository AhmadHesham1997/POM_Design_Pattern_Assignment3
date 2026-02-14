//This Page Object Model (POM) class represents the home page of the application.
// It contains a WebDriver instance to interact with the web elements on the page,
// as well as locators for the elements we want to interact with.
// The class includes a constructor to initialize the WebDriver and a method to navigate to the form authentication page
// by clicking on the corresponding link. This design allows us to keep our test logic separate from the page interactions,
// making our tests more maintainable and easier to read.
package Util_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_HomePage {
    WebDriver driver1;
    //locators
    //this locator is for the form authentication link on the home page
    final private By formAuthenticationLink = By.xpath("//a[text()='Form Authentication']");
    //this locator is for the dropdown link on the home page
    final private By dropdownLink = By.xpath("//a[text()='Dropdown']");
    //constructor
    public P01_HomePage(WebDriver driver) {
        this.driver1 = driver;
    }
    //methods
    //this method is in a separate class called Util_Pages.P01_HomePage
    // because it is related to the home page and it is used to navigate to the form authentication page
   public void navigateToFormAuthenticationPage() {
        driver1.findElement(formAuthenticationLink).click();
    }
    //this method is in a separate class called Util_Pages.P01_HomePage
    // because it is related to the home page and it is used to navigate to the dropdown page
    public void navigateToDropdownPage() {
        driver1.findElement(dropdownLink).click();
    }
}
