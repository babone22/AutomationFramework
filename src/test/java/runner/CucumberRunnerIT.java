package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by alex on 04/04/2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/test-report",
        "json:target/test-report.json", "junit:target/test-report.xml"},
        tags = {""}
)
public class CucumberRunnerIT {
}
