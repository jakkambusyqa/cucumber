package definitions;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.util.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageDefinitions {
    private static WebDriver driver;
   // public final static int TIMEOUT = 5;
 
    @Before
    public void setUp() {
 
        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
 
    }
    
 
    @Given("User is on HRMLogin page {string}")
    public void loginTest(String url) {
 
        driver.get(url);
 
    }
 
    @When("User enters username as {string} and password as {string}")
    public void goToHomePage(String userName, String passWord) {
 
        // login to application
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(passWord);
        driver.findElement(By.xpath("//*[@class='oxd-form']/div[3]/button")).submit();
 
        // go the next page
    }
    @Then("User should be able to login sucessfully and new page open")
    public void user_should_be_able_to_login_sucessfully_and_new_page_open() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    	String url=driver.getCurrentUrl();  
      //Verify new page - HomePage
           assertEquals(url, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }
 
 
    @Then("User should be able to see error message {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {
 
        String actualErrorMessage = driver.findElement(By.xpath("//*[@class='orangehrm-login-error']/div[1]/div[1]/p")).getText();
 
        // Verify Error Message
        assertEquals(actualErrorMessage, expectedErrorMessage);
 
    }
}
