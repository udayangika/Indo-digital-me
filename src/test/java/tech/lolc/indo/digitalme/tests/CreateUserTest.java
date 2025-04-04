package tech.lolc.indo.digitalme.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tech.lolc.indo.digitalme.pages.CheckLoginPage;
import tech.lolc.indo.digitalme.pages.CreateUserPage;
import tech.lolc.indo.digitalme.pages.UserManagemntPage;
import tech.lolc.indo.digitalme.utils.LoginUtils;
import tech.lolc.indo.digitalme.utils.Testutils;

public class CreateUserTest extends SetUp {
    private static final Logger logger = LogManager.getLogger(CreateUserTest.class);

    UserManagemntPage userManagemntPage;
    UserManagemntTest userManagemntTest;
    LoginUtils loginUtils;
    CheckLoginPage checkLoginPage;
    CheckLoginPageTest checkLoginPageTest;
    CreateUserPage createUserPage;

    @BeforeMethod
    public void setUp() {

        super.setUp();
        loginUtils=new LoginUtils(driver);
        checkLoginPage =new CheckLoginPage(driver);
        checkLoginPageTest=new CheckLoginPageTest();
        userManagemntPage=new UserManagemntPage(driver);
        createUserPage=new CreateUserPage(driver);


    }
    @Test
    public void createUser(){
        //load user management page
        Testutils.loadUserManagementPage(driver);
        //load create user button
        createUserPage.clickCreateUserbtn();
        Assert.assertEquals(createUserPage.getTitlePopUp(), "User Details", "Not direct to the dashboard");
        createUserPage.typeUsername("TEST1");
        //createUserPage.selectBranch(3);
        String selectedBranch = createUserPage.selectBranch(3);
        Assert.assertEquals(selectedBranch, "SUKMAJAYA", "Branch not loaded");
        String selectedRole = createUserPage.selectRole(2);
        Assert.assertEquals(selectedRole, "Branch Manager", "Role not loaded");




    }


}
