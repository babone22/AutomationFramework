package helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import cucumber.api.java.Before;

import java.io.IOException;

/**
 * Created by alex on 04/04/2017.
 */
public class Hooks {

    @Before
    public void setup() {
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String Value, Class<T> valueType) {
                try {
                    jacksonObjectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
                    return jacksonObjectMapper.readValue(Value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    jacksonObjectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Unirest.setDefaultHeader("Content-Type", "application/json");
    }
}
