package api.services;

import io.restassured.response.Response;

public class PeopleApiService extends BaseApiService{

    private final String basePeopleUrl = baseUrl + "/people";

    public Response getAllPeople() {
        return sendGetRequest(basePeopleUrl);
    }

    public Response getPeopleByPage(int page) {
        return setUp()
                .queryParam("page", page)
                .get(basePeopleUrl)
                .then()
                .extract()
                .response();
    }
}
