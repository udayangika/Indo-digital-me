package tech.lolc.indo.digitalme.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tech.lolc.indo.digitalme.pages.CheckLoginPage;
import tech.lolc.indo.digitalme.pages.UserManagemntPage;
import tech.lolc.indo.digitalme.testng.TestData;
import tech.lolc.indo.digitalme.utils.LoginUtils;

public class CheckLoginPageTest extends SetUp {

    private static final Logger logger = LogManager.getLogger(CheckLoginPageTest.class);


    @Test(description = "Check whether Correct login image1   is displayed ")
    public void testLoginPageImageElements1() {
        CheckLoginPage loginPageIndo = new CheckLoginPage(driver);


        if (loginPageIndo.isImageLoaded()) {
            logger.info("Logo Image1 is loaded successfully.");
        } else {
            logger.error("Logo Image2 failed to load.");
        }

    }

    @Test(description = "Check whether Correct login image2  is displayed ")
    public void testLoginPageImageElements2() {
        CheckLoginPage loginPageIndo = new CheckLoginPage(driver);


        if (loginPageIndo.isImageLoaded2()) {
            logger.info("Logo Image2 is loaded successfully.");
        } else {
            logger.error("Logo Image2 failed to load.");
        }

    }

    @Test(description = "Check whether Correct IL description is loaded in the  login page")
    public void testLoginPageDescriptionIL() {
        CheckLoginPage loginPageIndo = new CheckLoginPage(driver);


        if (loginPageIndo.isIlDescriptionLoaded()) {
            logger.info("IL Description is loaded successfully.");
        } else {
            logger.error("IL Description is failed to load.");
        }

    }

    @Test(description = "Check whether Correct GRPL description is loaded in the  login page")
    public void testLoginPageDescriptionGRPL() {
        CheckLoginPage loginPageIndo = new CheckLoginPage(driver);


        if (loginPageIndo.isGrplDescriptionLoaded()) {
            logger.info("GRPL Description is loaded successfully.");
        } else {
            logger.error("GRPL Description is failed to load.");
        }

    }

    @Test(description = "Check whether Correct footer description is loaded in the  login page")
    public void testLoginPageFooterDescription() {
        CheckLoginPage loginPageIndo = new CheckLoginPage(driver);


        if (loginPageIndo.isFooterDescriptionLoaded()) {
            logger.info("footer Description is loaded successfully.");
        } else {
            logger.error("footer Description is failed to load.");
        }

    }

   // @Test(description = "Check whether Login button is clickable")
//    public void testLoginPageLoginButton() {
//        ClickLoginBu();
//
//    }
    @Test(description = "Check whether Login button is clickable")
    public  void ClickLoginBu() {
        CheckLoginPage loginPageIndo = new CheckLoginPage(driver);


        loginPageIndo.clickLogin();
        Assert.assertEquals(loginPageIndo.getTitle(), "Sign In");
    }

    @Test(dataProvider = "userRoles", dataProviderClass = TestData.class, description = "Check login with multiple user roles with Menu items")
    public void testLoginWithValidCredentials(String uname, String pass, String expecMessage, String expecMessage1, String expecMessage2,String role) {
         ClickLoginBu();

        CheckLoginPage loginPage = new CheckLoginPage(driver);
        loginPage.typeUsername(uname).typePassword(pass).clickLogin1();
        Assert.assertEquals(loginPage.getTitleRole(), expecMessage, "Title is mismatched");
        Assert.assertEquals(loginPage.getTitleRoleDes(), expecMessage1, "Role Title is mismatched");
        loginPage.clickRolePageTile();
        Assert.assertEquals(loginPage.getTitleDashboard(), expecMessage2, "Not direct to the dashboard");
        // Assert that the menu is loaded for the given role
        Assert.assertTrue(loginPage.isMenuLoaded(role), role + " menu is not loaded correctly.");
        //Menu collapse
        loginPage.toggleMenu();
        Assert.assertTrue(loginPage.isMenuCollapsed(), "Menu should be collapsed");
        //Menu expand
        loginPage.toggleMenu();
        Assert.assertTrue(loginPage.isMenuExpanded(), "Menu should be Expanded");

    }


    @Test(dataProvider = "invalid-login-credentials", dataProviderClass = TestData.class, description = "Check Login With Invalid credentials")
    public void testLoginWithInvalidCredentials(String invaliduname, String invalidpass, String expectedMessage) {
        ClickLoginBu();
        CheckLoginPage loginPage = new CheckLoginPage(driver);
        loginPage.typeUsername(invaliduname).typePassword(invalidpass).clickLogin1();
        Assert.assertEquals(loginPage.getErrorMsgInvalid(), expectedMessage, "Error message is not displayed");

    }

    @Test(dataProvider = "empty-login-credentials", dataProviderClass = TestData.class, description = "Check Login With Empty credentials")
    public void testLoginWithEmptyCredentials(String username, String password) {
        ClickLoginBu();
        CheckLoginPage loginPage = new CheckLoginPage(driver);
        loginPage.typeUsername(username).typePassword(password).clickLogin1();
        Assert.assertEquals(loginPage.GetErrorMsgEmptyCred(), "Please fill out this field.", "Validation message mismatch");
    }

}
