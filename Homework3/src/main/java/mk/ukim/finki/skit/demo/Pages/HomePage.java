package mk.ukim.finki.skit.demo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
/*        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("img[src='images/home.png']"))).isDisplayed();*/
        WebElement page = driver.findElement(By.cssSelector("img[src='images/home.png']"));
        return page.isDisplayed();
    }
}
