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

public class RedditLoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public RedditLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        driver.findElement(By.xpath("(//*[contains(@name,'username')])[1]")).sendKeys(username);

    }

    public void enterPassword(String password) {
        driver.findElement(By.xpath("(//*[contains(@name,'password')])[1]")).sendKeys(password);

    }

    public void clickLoginSubmit() {
        driver.findElement(By.xpath("(//span[@class='flex items-center gap-xs' and text()='Log In'])[2]")).click();
        // Switch back to main content
        driver.switchTo().defaultContent();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
