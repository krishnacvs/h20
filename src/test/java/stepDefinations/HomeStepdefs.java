package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeStepdefs {
    private WebDriver driver;

    @Given("User is on landing page")

    public void userIsOnLandingPage() {
        System.out.println("User is on landing page");
        System.setProperty("webdriver.chrome.driver", "C:\\workspace\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println(driver);
        driver.get("http://localhost:8080/");
    }

    @When("User loads the application url")
    public void user_loads_the_application_url() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User loads the application url");
        String s = "all-countries-list";
        var e1 = driver.findElement(By.cssSelector("a.all-countries-list"));
        if(!e1.getText().equals("Link")) {
            throw new io.cucumber.java.PendingException();
        }
    }

    @Then("Home page is populated")
    public void home_page_is_populated() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Home page is populated");
        var e1 = driver.findElement(By.cssSelector("a.all-countries-list"));
        e1.click();
    }

    @And("Navigate to Countries Link")
    public void navigate_to_countries_link() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Navigate to Countries Link");
    }
}
