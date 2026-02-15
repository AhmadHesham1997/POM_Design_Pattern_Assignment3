package Features;

import Base.BaseTest;
import Util_Pages.P01_HomePage;
import Util_Pages.P04_DropdownPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class F02_Dropdown extends BaseTest {
    //we create an instance of home page class to use its methods in our test cases
    P01_HomePage homePage;
    P04_DropdownPage dropdownPage;

    @Test
    void selectElementFromDropdown() {
        //instantion
        homePage = new P01_HomePage(driver);
        dropdownPage = new P04_DropdownPage(driver);
        //navigate to dropdown page
        homePage.navigateToDropdownPage();
        //call the method to select an option from the dropdown
        dropdownPage.selectOptionFromDropdown("Option 2");
        //assert that the selected option is correct
       Assert.assertTrue(dropdownPage.isOptionSelected(), "Option 2 is not selected!");
    }


}
