package tech.lolc.indo.digitalme.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckLoginPage {
    public boolean isMenuLoaded;
    @FindBy(id = "btn-login")
    WebElement byLoginButton;

    @FindBy(css = "h3.ui.header")
    WebElement bytitle;

    @FindBy(css = "img.w-auto.max-w-xs.md\\:max-w-sm[src='/indo-digital-loan/assets/digitalMe-96114880.png']")
    WebElement imageElement;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div/p")
    WebElement descElement;
    @FindBy(css = "img[src='/indo-digital-loan/assets/LOLC_ICON_LONG-dff8ba3e.png']")
    WebElement imageElement2;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/p")
    WebElement descElement2;
    @FindBy(css = "div.text-center.mt-5.mb-5.text-gray-500.text-sm")
    WebElement footerDescElement;
    @FindBy(id = "usernameUserInput")
    WebElement byUsername;
    @FindBy(id = "password")
    WebElement byPassword;
    @FindBy(xpath = "//button[@data-testid='login-page-continue-login-button']")
    WebElement byLogButton;

    @FindBy(id = "btn-tile-role-0")
    WebElement byUserRoleTitle;
    @FindBy(xpath = "//span[contains(@class, 'ant-menu-title-content') and text()='Dashboard']")
    WebElement menuDasboard;
    @FindBy(xpath = "//span[contains(@class, 'ant-menu-title-content') and text()='User Management']")
    WebElement menuUserMan;
    @FindBy(xpath = "//span[contains(@class, 'ant-menu-title-content') and text()='Applications']")
    WebElement menuApplications;
    @FindBy(xpath = "//span[contains(@class, 'ant-menu-title-content') and text()='SLIK Requests']")
    WebElement menuSlikReq;
    @FindBy(xpath = "//span[contains(@class, 'ant-menu-title-content') and text()='Top-Up Definitions']")
    WebElement menuTopup;
    @FindBy(xpath = "//span[contains(@class, 'ant-menu-title-content') and text()='Reports']")
    WebElement menuReports;
    @FindBy(id = "btn-collapse")
    WebElement menuCollapseButton;
    @FindBy(xpath = " //span[text()='\" + menuItem + \"']\"")
    WebElement menuBar;


//    @FindBy(id = "btn-tile-role-0")
//    WebElement byRolePageClick;
//    @FindBy(css = "li[data-menu-id='menu-/'] .ant-menu-title-content")
//    WebElement byDashboard;
//    @FindBy(how = How.ID, using = "error-msg")
//    WebElement byErrormsginvalidCred;


    private final WebDriver driver;

    // Constructor to initialize WebDriver
    public CheckLoginPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public boolean isImageLoaded() {

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Increased timeout for stability
            wait.until(ExpectedConditions.visibilityOf(imageElement));
//
            return true;

        } catch
        (TimeoutException | NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public boolean isIlDescriptionLoaded() {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Increased timeout for stability
            wait.until(ExpectedConditions.visibilityOf(descElement));

            return true;

        } catch
        (TimeoutException | NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }

    }

    public boolean isImageLoaded2() {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));  // Increased timeout for stability
            wait.until(ExpectedConditions.visibilityOf(imageElement2));

            return true;

        } catch
        (TimeoutException | NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public boolean isGrplDescriptionLoaded() {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Increased timeout for stability
            wait.until(ExpectedConditions.visibilityOf(descElement2));

            return true;

        } catch
        (TimeoutException | NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public boolean isFooterDescriptionLoaded() {
        try {


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Increased timeout for stability
            wait.until(ExpectedConditions.visibilityOf(footerDescElement));

            return true;

        } catch
        (TimeoutException | NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public CheckLoginPage clickLogin() {
        byLoginButton.click();
        return this;

    }


    public CheckLoginPage typeUsername(String username) {
        byUsername.sendKeys(username);
        return this;
    }

    public CheckLoginPage typePassword(String password) {
        byPassword.sendKeys(password);
        return this;
    }

    public CheckLoginPage clickLogin1() {
        byLogButton.click();
        return this;

    }

    public String getTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Increased timeout for stability
        wait.until(ExpectedConditions.visibilityOf(bytitle));
        return bytitle.getText();
    }

    public String getTitleRole() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement byUserRoleTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("h2.text-2xl.font-bold.text-center.text-blue-900")
                )
        );
        return byUserRoleTitle.getText();
    }

    public String getTitleRoleDes() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement byUserRoleDesTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("h3.text-lg.font-semibold.text-blue-900")
                )
        );
        return byUserRoleDesTitle.getText();
    }

    public CheckLoginPage clickRolePageTile() {
        byUserRoleTitle.click();
        return this;
    }

    public String getTitleDashboard() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement byDashboard = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("li[data-menu-id='menu-/'] .ant-menu-title-content")
                )
        );
        return byDashboard.getText();
    }


    public String getErrorMsgInvalid() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement byErrormsginvalidCred = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("error-msg")
                )
        );
        return byErrormsginvalidCred.getText();
    }
    public String GetErrorMsgEmptyCred() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;", byUsername);

    }
    public boolean isMenuLoaded(String role) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        switch (role) {
            case "Administrator":
                wait.until(ExpectedConditions.visibilityOf(menuDasboard));
                return menuDasboard.isDisplayed() && menuUserMan.isDisplayed() && menuApplications.isDisplayed() && menuSlikReq.isDisplayed() && menuReports.isDisplayed() && menuTopup.isDisplayed();
            case "Customer Service Assistance":
                wait.until(ExpectedConditions.visibilityOf(menuDasboard));
                return menuDasboard.isDisplayed() && menuApplications.isDisplayed()&& menuSlikReq.isDisplayed();
            case "Credit Analyst":
                wait.until(ExpectedConditions.visibilityOf(menuDasboard));
                return menuDasboard.isDisplayed() && menuApplications.isDisplayed();
            case "Branch Manager":
                wait.until(ExpectedConditions.visibilityOf(menuDasboard));
                return menuDasboard.isDisplayed() && menuApplications.isDisplayed();
            case "Area Manager":
                wait.until(ExpectedConditions.visibilityOf(menuDasboard));
                return menuDasboard.isDisplayed() && menuApplications.isDisplayed();
            case "SLIK User":
                wait.until(ExpectedConditions.visibilityOf(menuDasboard));
                return menuDasboard.isDisplayed() && menuSlikReq.isDisplayed();
            case "Regional Manager":
                wait.until(ExpectedConditions.visibilityOf(menuDasboard));
                return menuDasboard.isDisplayed() && menuApplications.isDisplayed();
            case "Director":
                wait.until(ExpectedConditions.visibilityOf(menuDasboard));
                return menuDasboard.isDisplayed() && menuApplications.isDisplayed();
            case "Board of Member 1":
                wait.until(ExpectedConditions.visibilityOf(menuDasboard));
                return menuDasboard.isDisplayed() && menuApplications.isDisplayed();
            case "Board of Member 2":
                wait.until(ExpectedConditions.visibilityOf(menuDasboard));
                return menuDasboard.isDisplayed() && menuApplications.isDisplayed();
            case "Board of Member 3":
                wait.until(ExpectedConditions.visibilityOf(menuDasboard));
                return menuDasboard.isDisplayed() && menuApplications.isDisplayed();
            default:

                throw new IllegalArgumentException("Invalid role provided: " + role);
        }

    }
    // Method to click on the menu button
    public void toggleMenu() {
        menuCollapseButton.click();
    }
    public boolean isMenuCollapsed() {
        String usertest= menuDasboard.getText();
        // Implement logic to verify if the menu is collapsed
        return !usertest.isBlank(); // Replace with actual condition
    }
    public boolean isMenuExpanded() {
        // Implement logic to verify if the menu is collapsed
        return menuDasboard.isDisplayed(); // Replace with actual condition
    }







}
