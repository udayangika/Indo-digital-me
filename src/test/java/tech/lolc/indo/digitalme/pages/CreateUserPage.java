package tech.lolc.indo.digitalme.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CreateUserPage {
    private final WebDriver driver;

    // Constructor to initialize WebDriver
    public CreateUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "btn-create-user")
    WebElement byCreateUserBtn;
    @FindBy(id = "inpt-username")
    WebElement byCrUsernma;
    @FindBy(id = "slct-branch")
    WebElement userBranchDropdown;
    @FindBy(id = "slct-roles")
    WebElement userRoleDropdown;

    // Locate the input search field inside dropdown
    @FindBy(css = "#slct-branch_list .ant-select-item")
    List<WebElement> dropdownOptions;
    // Locate all dropdown options

    @FindBy(css = "h5.ant-typography.css-jod01u")
    WebElement byUserTitle;

    public CreateUserPage clickCreateUserbtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Increased timeout for stability
        wait.until(ExpectedConditions.visibilityOf(byCreateUserBtn));
        byCreateUserBtn.click();
        return this;
    }

    public String getTitlePopUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Increased timeout for stability
        wait.until(ExpectedConditions.visibilityOf(byUserTitle));
        return byUserTitle.getText();
    }

    public CreateUserPage typeUsername(String username) {
        byCrUsernma.sendKeys(username);
        return this;
    }

    public String selectBranch(int index) {
        userBranchDropdown.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> options = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".ant-select-item")));

        if (!options.isEmpty()) {
            if (index >= 0 && index < options.size()) {
                String selectedBranch = options.get(index).getText();  // Get the branch name
                options.get(index).click();
                return selectedBranch;
            } else {
                System.out.println("Invalid index: " + index + ". Available options: " + options.size());
            }
        } else {
            System.out.println("Dropdown options not found!");
        }


        return null;
    }
    public String selectRole(int index) {
        userRoleDropdown.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> options = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.ant-select.ant-select-outlined.ant-select-in-form-item.ant-select-status-success")));

        if (!options.isEmpty()) {
            if (index >= 0 && index < options.size()) {
                String selectedRole = options.get(index).getText();  // Get the branch name
                options.get(index).click();
                return selectedRole;
            } else {
                System.out.println("Invalid index: " + index + ". Available options: " + options.size());
            }
        } else {
            System.out.println("Dropdown options not found!");
        }


        return null;
    }
}



