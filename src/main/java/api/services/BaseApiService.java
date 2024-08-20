package api.services;

import core.config.Configuration;
import core.config.ConfigurationManager;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class BaseApiService {

    private static final Configuration config = ConfigurationManager.config();
    protected final String baseUrl = config.apiUrl();

    public RequestSpecification setUp() {
        return RestAssured.given()
                .filters(
                        new RequestLoggingFilter(),
                        new ResponseLoggingFilter()
                );
    }

    public Response sendGetRequest(String url) {
        return setUp()
                .get(url)
                .then()
                .extract()
                .response();
    }
}
