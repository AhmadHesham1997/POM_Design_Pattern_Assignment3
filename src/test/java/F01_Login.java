import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
// Its preferd to put each mehthod that goes to a seperate page in a seprate class file
// Page Object Model POM design pattern
// F01_Login is the test class
// P01_LoginPage is the page class
public class F01_Login {
    WebDriver driver;
    P01_LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        // Initialize ChromeDriver
        driver = new ChromeDriver();
        // Navigate to the main website
        driver.get("https://the-internet.herokuapp.com");
        // Initialize the login page object where we passed the driver instance to the constructor of P01_LoginPage class to the F01_Login test class
        //so both driver instances are the same and we can use it to interact with the web elements on the page
        loginPage = new P01_LoginPage(driver);
        // Navigate to the form authentication page
        loginPage.navigateToFormAuthenticationPage();
    }

    @Test
    public void TC_A() {
        // Positive test case
        loginPage.loginTest("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(loginPage.assertValidLogin(), "Login was not successful!");
    }
    @Test
    public void TC_B() {
        // Negative test case
        loginPage.loginTest("invalidUser", "SuperSecretPassword!");
        Assert.assertTrue(loginPage.assertInvalidLogin(), "Invalid login was not handled correctly!");
    }


    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
