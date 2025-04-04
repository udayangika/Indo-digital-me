package tech.lolc.indo.digitalme.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import tech.lolc.indo.digitalme.pages.CheckLoginPage;
import tech.lolc.indo.digitalme.tests.SetUp;

import java.time.Duration;

public class LoginUtils {
    @FindBy(id ="btn-login")
    WebElement byLoginButton1;
  private WebDriver driver;

    public LoginUtils(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);// Initialize driver
    }


    public void clickLogin() {

        byLoginButton1.click();

    }


}

