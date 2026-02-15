package Util_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class P04_DropdownPage {
    WebDriver driver2;
    //locators
    private final By dropdownLink = By.id("dropdown");
    //constructor
    public P04_DropdownPage(WebDriver driver) {

        this.driver2 = driver;
    }
    //methods
    // This method is responsible for selecting an option from the dropdown menu on the dropdown page.
    public void selectOptionFromDropdown(String option) {
        // This method is responsible for selecting an option from the dropdown menu on the dropdown page.
        // You can implement the logic to interact with the dropdown element and select the desired option here.
        // For example, you can use Selenium's Select class to select an option by visible text, value, or index.
        // Select an option from the dropdown menu
        WebElement dropdown = driver2.findElement(dropdownLink);
        Select select = new Select(dropdown);
        select.selectByVisibleText(option);
    }

    //Assertion method to verify that the selected option is correct
    //We didnt create a separate class for the assertion of the dropdown page
    // because it is related to the same page and it is used to assert the same element (dropdown)
    // but with different text for the assertion of the dropdown page
    public boolean isOptionSelected() {
        return driver2.findElement(dropdownLink).getText().contains("Option 2");
    }
}
