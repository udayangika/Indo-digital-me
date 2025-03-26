package tech.lolc.indo.digitalme.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.util.HashMap;
import java.util.Map;

public class SetUp {

     WebDriver driver;



    @BeforeMethod
        public void setUp() {
            //close the browser info bar
            ChromeOptions options= new ChromeOptions();
            //script run headless
            //options.addArguments("--headless");
            options.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
            //create a map to disable password and autofill
            Map<String, Object> prefs= new HashMap<>();
            prefs.put("credentials_enable_service",false); //disable password manager
            prefs.put("profile.password_manager_enabled",false); //disable password manager popup
            options.setExperimentalOption("prefs",prefs);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://indodigitalmeuat.lolc.com/indo-digital-loan"); // Sample URL

        }


        @AfterMethod
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }


