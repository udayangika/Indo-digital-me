package tech.lolc.indo.digitalme.utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import tech.lolc.indo.digitalme.pages.CheckLoginPage;
import tech.lolc.indo.digitalme.pages.UserManagemntPage;

public class Testutils {
    public static void loadUserManagementPage(WebDriver driver) {
        LoginUtils loginUtils = new LoginUtils(driver);
        CheckLoginPage checkLoginPage = new CheckLoginPage(driver);
        UserManagemntPage userManagemntPage = new UserManagemntPage(driver);

        loginUtils.clickLogin();
        checkLoginPage.typeUsername("NOVI").typePassword("Lolc@1234").clickLogin1();
        checkLoginPage.clickRolePageTile();
        userManagemntPage.clickMenu();
        userManagemntPage.getPageButton();
        Assert.assertTrue(userManagemntPage.getPageButton(), "User management page is not loaded");
    }
}
