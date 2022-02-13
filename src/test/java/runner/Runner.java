package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "html: target/cucumber.html", "json:target/cucumber.json"},
        features = "src/test/resources",
        glue = {"stepDef", "utils"}

)
public class Runner extends AbstractTestNGCucumberTests {
}
