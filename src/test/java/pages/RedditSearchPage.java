package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Thread.sleep;

public class RedditSearchPage {
    WebDriver driver;
    Actions actions;

    public RedditSearchPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void searchSubreddit(String subreddit) {
        Actions actions = new Actions(driver);
        for (int i = 0; i < 7; i++) {
            actions.sendKeys(Keys.TAB).perform();
            try {
                sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        actions.sendKeys(subreddit).perform();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        System.out.println("✅ Selected the subreddit 'sports' in the dropdown");
    }
}
