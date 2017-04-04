package helpers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import unirest.RestFacade;

/**
 * Created by alex on 04/04/2017.
 */
@Slf4j
public class StepsHelper {

    protected final RestFacade restFacade;
    protected final ObjectMapper mapper;

    public StepsHelper() {
        this.restFacade = new RestFacade();
        this.mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }


}
