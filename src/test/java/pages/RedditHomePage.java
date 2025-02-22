package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static java.lang.Thread.sleep;

public class RedditHomePage {
    WebDriver driver;
    WebDriverWait wait;

    public RedditHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        try {
            sleep(3000); // Match old sleep delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyRedditHomepage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        boolean isLoggedIn = !driver.findElements(By.xpath("//span[text()='Open inbox']")).isEmpty();
        if(isLoggedIn) {
            System.out.println("✅ Successfully logged into Reddit!");
        }
        else
        {
            System.out.println("❌ Error: Login check failed.");
        }
    }
}
