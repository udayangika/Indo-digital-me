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

public class UserManagemntTest extends SetUp {
   
    private static final Logger logger = LogManager.getLogger(UserManagemntTest.class);
    CheckLoginPageTest checkLoginPageTest;
    CheckLoginPage checkLoginPage;
    UserManagemntPage userManagemntPage;
    LoginUtils loginUtils;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        //checkLoginPageTest.driver = this.driver; // Pass the driver instance

        checkLoginPage = new CheckLoginPage(driver);
        userManagemntPage=new UserManagemntPage(driver);
        checkLoginPageTest=new CheckLoginPageTest();
        checkLoginPageTest.driver=this.driver;

    }

    //load user management page

@Test
    public void loadUserManagementPage() {
    loginUtils=new LoginUtils(driver);
        loginUtils.clickLogin();
        checkLoginPage.typeUsername("NOVI").typePassword("Lolc@1234").clickLogin1();
        checkLoginPage.clickRolePageTile();
        UserManagemntPage userManagemntPage=new UserManagemntPage(driver);
        userManagemntPage.clickMenu();
        userManagemntPage.getPageButton();
        Assert.assertTrue(userManagemntPage.getPageButton()," User management page is not loaded");
    }

    @Test(dataProvider = "Search-user", dataProviderClass = TestData.class)
    public void testSearchUser(String usernameToSearch) {

        loadUserManagementPage();
        // Perform the search
        userManagemntPage.searchUser(usernameToSearch);
        // Validate that the search bar contains the entered username
        String actualSearchValue = userManagemntPage.getSearchInputValue();
        Assert.assertEquals(actualSearchValue, usernameToSearch, "Search input does not match the entered username!");
        logger.info("Searched Data loaded.");
        Assert.assertTrue(userManagemntPage.isUserDisplayed(usernameToSearch), "User " + usernameToSearch + " is not displayed in the table!");
        logger.info("Searched data '{}' loaded.", usernameToSearch);
    }

}
