package steps;

import com.mashape.unirest.http.HttpResponse;
import cucumber.api.java.en.Given;
import helpers.StepsHelper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by alex on 04/04/2017.
 */
@Slf4j
public class RestSteps extends StepsHelper {
    @Given("^I make a GET to \"([^\"]*)\" as string$")
    public void iMakeAGETToAsString(final String address) throws Throwable {
        HttpResponse<String> response = restFacade.get(address);
        log.info(String.valueOf(response.getStatus()));
    }

    @Given("^I make a GET to \"([^\"]*)\" as object$")
    public void iMakeAGETToAsObject(final String address) throws Throwable {
        HttpResponse<User> userObject = restFacade.getRequestAsObject(address, User.class);
        System.out.println(userObject.getBody().toString());
    }

    @Data
    @AllArgsConstructor
    class User {
        private int userId;
        private int id;
        private String title;
        private String body;
    }
}
