package Features;

import Util_Pages.P01_HomePage;
import Util_Pages.P04_DropdownPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class F02_Dropdown {
    WebDriver driver2;
    //we create an instance of home page class to use its methods in our test cases
    P01_HomePage homePage2;
    P04_DropdownPage dropdownPage;
    @BeforeMethod
    void setUp() {
        // Initialize WebDriver and navigate to the dropdown page
        driver2 = new ChromeDriver();
        driver2.get("https://the-internet.herokuapp.com/");

        // Initialize the home page object
        homePage2 = new P01_HomePage(driver2);
        // Initialize the dropdown page object
        dropdownPage = new P04_DropdownPage(driver2);
        //call the method to navigate to the dropdown page
        homePage2.navigateToDropdownPage();
    }
    @Test
    void selectElementFromDropdown() {
        //call the method to select an option from the dropdown
        dropdownPage.selectOptionFromDropdown("Option 2");
        //assert that the selected option is correct
        boolean isOption2Selected = dropdownPage.isOptionSelected();
        Assert.assertTrue(isOption2Selected);
    }

    @AfterMethod
    void tearDown() {
        // Close the browser after each test
        driver2.quit();
    }
}
