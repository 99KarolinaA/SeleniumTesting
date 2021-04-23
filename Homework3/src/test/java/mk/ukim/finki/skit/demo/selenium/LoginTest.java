package mk.ukim.finki.skit.demo.selenium;

import mk.ukim.finki.skit.demo.Pages.HomePage;
import mk.ukim.finki.skit.demo.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = getDriver();
    }


    @Test
    public void shouldOpen() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
    }

    //T1: Login with invalid credentials and check error message
    @Test
    public void LoginWithInvalidCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("test123", "error");
        String errorMessage = loginPage.getErrorMessage();
        System.out.println(errorMessage);
        assertEquals(errorMessage, "Invalid user credentials exception");

    }
    //T2: Login with empty username and check error message
    @Test
    public void LoginWithEmptyUsername() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("", "test");
        String errorMessage = loginPage.getErrorMessage();
        System.out.println(errorMessage);
        assertEquals(errorMessage, "Invalid user credentials exception");

    }

    //T3: Login successfully and check if you are navigated to the homepage
    @Test
    public void SuccessfulLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("test", "test");
        assertTrue(new HomePage(driver).isLoaded());

    }

    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/Karolina/Spring_projects_Faculty/Softverski_kvalitet_i_testiranja/Homework3/src/main/resources/drivers/chromedriver.exe");
        return new ChromeDriver();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

}
