package unirest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by alex on 04/04/2017.
 */
public class RestFacade {

    public HttpResponse<String> get(final String address) throws UnirestException, UnirestException {
        return Unirest.get(address).asString();
    }

    public <T> HttpResponse<T> getRequestAsObject(String address, Class<T> clazz) throws UnirestException {
        return Unirest.get(address).asObject(clazz);
    }

    public HttpResponse<String> postObjectAsString(String address) throws UnirestException {
        return Unirest.post(address).field("postalcode", 12345).asString();
    }


    public <T> HttpResponse<T> postObject(String address, T clazz) throws UnirestException {
        return Unirest.post(address)
                .body(clazz)
                .asObject((Class<? extends T>) clazz.getClass());
    }
}
