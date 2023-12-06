package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"classpath:features"},
        glue = {"stepDefinitions"},
        monochrome = true,
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber2.html"},
        tags = "@test"
)
public class MainRunner extends AbstractTestNGCucumberTests {
    /*@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }*/
}
