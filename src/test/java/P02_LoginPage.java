import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_LoginPage {
    WebDriver driver1;
    //locators
    final private By usernameField = By.id("username");
    final private By passwordField = By.id("password");
    final private By loginButton = By.className("fa-sign-in");
    final private By successMessage = By.id("flash");
    //getting form authentication link by xpath using link text
    final private By formAuthenticationLink = By.xpath("//a[text()='Form Authentication']");
    //constructor
    //We create a constructor to initialize the WebDriver instance that will be passed from the test class (F01_Login)
    //this.driver1 = driver; means we are assigning the driver instance passed from the test class to the local driver1 variable
    // in this page class so that we can use it to interact with the web elements on the page
    public P02_LoginPage(WebDriver driver) {
        this.driver1 = driver;
    }

    //methods
    //method to navigate to form authentication page
    //this method should be in a separate class called P00_HomePage but for simplicity we are keeping it here
    void navigateToFormAuthenticationPage() {
        driver1.findElement(formAuthenticationLink).click();
    }
    //method to perform login action
    //this method should be in a separate class called P02_LoginPage but for simplicity we are keeping it here
    //We made the method parameterized to accept different username and password for positive and negative scenarios
    void loginTest(String username, String password) {
        //enter username and password and click login button
        driver1.findElement(usernameField).sendKeys(username);
        driver1.findElement(passwordField).sendKeys(password);
        driver1.findElement(loginButton).click();
    }

    //methods for assertions
    //positive scenario
    //this method should be in a separate class called P03_SecureAreaPage but for simplicity we are keeping it here
    boolean assertValidLogin(){
        return driver1.findElement(successMessage).getText().contains("You logged into a secure area!");
    }
    //negative scenario
    //this method should be in a separate class called P02_LoginPage but for simplicity we are keeping it here
    boolean assertInvalidLogin(){
        return driver1.findElement(successMessage).getText().contains("Your username is invalid!");
    }
}
