package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
    
@CucumberOptions(tags = "", features = {"./src/test/resources/featuresss/LoginPage.feature"}, glue = {"definitions"},
                 plugin = {})

public class Runner extends AbstractTestNGCucumberTests {

}
