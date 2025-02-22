package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

import static java.lang.Thread.sleep;

public class RedditPostPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public RedditPostPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTopPostTitle() {
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement topPost = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//a[contains(@id, 'post-title-t3_')])[2]")));
        return topPost.getText();
    }

    public void toggleUpvoteDownvote() {
        Actions actions = new Actions(driver);
        for (int i = 0; i < 42; i++) {
            actions.sendKeys(Keys.TAB).perform();
            try {
                sleep(100);
            } catch (InterruptedException ignored) {
            }
        }
        //Getting the currently active element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement focusedElement = (WebElement) js.executeScript("return document.activeElement;");
        // Check if the focused element is enabled
        if (!focusedElement.isEnabled()) {
            actions.sendKeys(Keys.ENTER).perform();
            System.out.println("Upvote button is enabled now!!");
        } else {
            actions.sendKeys(Keys.TAB).perform();
            actions.sendKeys(Keys.ENTER).perform();
            System.out.println("Downvote button is enabled!!");
        }
    }
}
