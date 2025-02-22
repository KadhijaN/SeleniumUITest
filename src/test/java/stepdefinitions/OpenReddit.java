package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RedditHomePage;
import pages.RedditLoginPage;
import pages.RedditSearchPage;
import pages.RedditPostPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import static java.lang.Thread.sleep;

public class OpenReddit {
    WebDriver driver;
    RedditHomePage homePage;
    RedditLoginPage loginPage;
    RedditSearchPage searchPage;
    RedditPostPage postPage;

    @Given("I open the Reddit website")
    public void openRedditWebsite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.reddit.com/");

        // Initialize Page Objects
        homePage = new RedditHomePage(driver);
        loginPage = new RedditLoginPage(driver);
        searchPage = new RedditSearchPage(driver);
        postPage = new RedditPostPage(driver);

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("✅ Successfully navigated to Reddit using Google Chrome!");
    }

    @When("I log in with username {string} and password {string}")
    public void loginToReddit(String username, String password) {
        homePage.clickLoginButton();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginSubmit();
        System.out.println("✅ Login attempted for user: " + username);
    }

    @Then("I should see my Reddit homepage")
    public void verifyRedditHomepage() {
        homePage.verifyRedditHomepage();
    }

    @When("I search for subreddit {string}")
    public void searchForSubreddit(String subreddit) {
        searchPage.searchSubreddit(subreddit);
        System.out.println("✅ Subreddit '" + subreddit + "' selected!");
    }

    @Then("I should open the first subreddit result and print the top post title")
    public void openFirstSubredditResultAndPrintTitle() {
        String title = postPage.getTopPostTitle();
        System.out.println("🔝 TOP POST TITLE: " + title);
    }

    @Then("I should toggle the upvote or downvote on the second post")
    public void toggleUpvoteDownvote() {
        postPage.toggleUpvoteDownvote();
        System.out.println("✅ Toggled upvote/downvote on the second post!");
        try {
            sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
