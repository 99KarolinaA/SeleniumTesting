package mk.ukim.finki.skit.demo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://parking-compass.herokuapp.com/login");
    }

    public boolean isLoaded() throws InterruptedException {
        Thread.sleep(5000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).isDisplayed();

    }

    public void login(String user, String password) throws InterruptedException {
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(user);
        Thread.sleep(5000);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("input[value='Login']")).click();
        Thread.sleep(5000);

    }


    public String getErrorMessage() {
        WebElement errorPage = driver.findElement(By.cssSelector("div[class='text-danger']"));
        return errorPage.getText();
    }
}

