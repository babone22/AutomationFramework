package steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import cucumber.api.java.en.Given;
import helpers.StepsHelper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

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
        System.out.println("The id from the JSON is " + userObject.getBody().getUserId());
    }

    @Given("^I make a POST request to \"([^\"]*)\" as String$")
    public void iMakeAPOSTRequestToAsString(String address) throws Throwable {
        HttpResponse<String> response = restFacade.postObjectAsString(address);
        System.out.println(response.getBody());
    }

    @Given("^I make a POST request to \"([^\"]*)\" with object$")
    public void iMakeAPOSTRequestToWithObject(final String address, final List<User> users) throws Throwable {
        for (User user : users) {
            final int status = restFacade.postObject(address, user).getStatus();
            assertEquals("Request has failed ", 201, status);

        }
    }


    @Given("^I convert Object to map$")
    public void iConvertObjectToMap(Map<String, String> map) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.convertValue(map, User.class);
        System.out.println(user.toString());
    }
}

@Data
@AllArgsConstructor
class User {
    private int userId;
    private int id;
    private String title;
    private String body;

}
