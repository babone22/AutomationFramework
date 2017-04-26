package runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by alex on 04/04/2017.
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"classpath:features/*.feature"},
        tags = {"@serenity"}
)

public class CucumberRunnerIT {
}
