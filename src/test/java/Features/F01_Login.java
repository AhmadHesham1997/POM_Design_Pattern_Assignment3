//This package contains the test class for the login feature of the application.
// It uses the Page Object Model (POM) design pattern to separate the test logic from the page interactions.
// The test class includes setup and teardown methods to initialize and close the browser,
// as well as test methods for both positive and negative login scenarios.
// The assertions are made using TestNG's Assert class to verify the expected outcomes of the login attempts.
//We separate the test class (Features.F01_Login) from the page classes (Util_Pages.P01_HomePage, Util_Pages.P02_LoginPage,
// and Util_Pages.P03_AssertionPage) to keep our code organized and maintainable.
//and because i move through 3 pages on the website which is the home page, the login page, and the assertion page
// so it is better to have a separate class for each page to handle the interactions and assertions related to that page.
package Features;

import Util_Pages.P01_HomePage;
import Util_Pages.P02_LoginPage;
import Util_Pages.P03_AssertionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
// Its prefer to put each method that goes to a separate page in a separate class file
// Page Object Model POM design pattern
// Features.F01_Login is the test class
// Util_Pages.P02_LoginPage is the page class
public class F01_Login {
    WebDriver driver;
    // We create an instance of the Util_Pages.P02_LoginPage class to use its methods in our test cases
    P02_LoginPage loginPage;
    P01_HomePage homePage;
    P03_AssertionPage assertionPage;

    @BeforeMethod
    public void setUp() {
        // Initialize ChromeDriver
        driver = new ChromeDriver();
        // Navigate to the main website
        driver.get("https://the-internet.herokuapp.com");
        // Initialize the login page object where we passed the driver instance to the constructor of Util_Pages.P02_LoginPage class to the Features.F01_Login test class
        //so both driver instances are the same and we can use it to interact with the web elements on the page
        // Initialize page objects
        // We create an instance of the Util_Pages.P01_HomePage class to use its methods in our test cases
        homePage = new P01_HomePage(driver);
        // We create an instance of the Util_Pages.P02_LoginPage class to use its methods in our test cases
        loginPage = new P02_LoginPage(driver);
        // We create an instance of the Util_Pages.P03_AssertionPage class to use its methods in our test cases
        assertionPage = new P03_AssertionPage(driver);
        // Navigate to the form authentication page
        homePage.navigateToFormAuthenticationPage();
    }

    @Test
    public void TC_A() {
        // Positive test case
        loginPage.loginTest("tomsmith", "SuperSecretPassword!");
        // We use the assertion method from the Util_Pages.P03_AssertionPage class to verify that the login was successful
        Assert.assertTrue(assertionPage.assertValidLogin(), "Login was not successful!");
    }
    @Test
    public void TC_B() {
        // Negative test case
        loginPage.loginTest("invalidUser", "SuperSecretPassword!");
        // We use the assertion method from the Util_Pages.P02_LoginPage class to verify that the invalid login was handled correctly
        Assert.assertTrue(loginPage.assertInvalidLogin(), "Invalid login was not handled correctly!");
    }


    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
