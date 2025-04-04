package tech.lolc.indo.digitalme.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UserManagemntPage {
    @FindBy(xpath = "//span[contains(@class, 'ant-menu-title-content') and text()='User Management']")
    WebElement menuUserMan;
    @FindBy(id = "btn-create-user")
    WebElement byCreateUserButton;
    @FindBy(id = "inpt-search")
    WebElement bySearchBox;
    @FindBy(xpath = "//div[@class='user-list']//div[@class='user-item']")
    List<WebElement> byUserList;
    @FindBy(xpath = "//td[contains(@class, 'ant-table-cell') and text()='NOVEINDRAS']")
    List<WebElement> byUserRaw;

    private final WebDriver driver;

    // Constructor to initialize WebDriver
    public UserManagemntPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public UserManagemntPage clickMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Increased timeout for stability
        wait.until(ExpectedConditions.visibilityOf(menuUserMan));
        menuUserMan.click();
        return this;
    }

    public boolean getPageButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Increased timeout for stability

            wait.until(ExpectedConditions.visibilityOf(byCreateUserButton));
            return byCreateUserButton.isDisplayed();

    }

    public void searchUser(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));  // Increased timeout for stability

        wait.until(ExpectedConditions.visibilityOf(bySearchBox));
        bySearchBox.clear(); // Clear the search bar
        bySearchBox.sendKeys(username); // Enter the username to search
    }

    // Optional: Method to get the search bar's current value (for validation)
    public String getSearchInputValue() {

        return bySearchBox.getAttribute("value");
    }

    public boolean isUserDisplayed(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement userRow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(String.format("//td[contains(@class,'ant-table-cell') and text()='%s']",username))));

        return userRow.isDisplayed();
    }

}