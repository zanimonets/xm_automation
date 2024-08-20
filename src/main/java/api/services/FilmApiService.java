package api.services;

import io.restassured.response.Response;

public class FilmApiService extends BaseApiService{
    private final String baseFilmsUrl = baseUrl + "/films";

    public Response getAllFilms() {
        return sendGetRequest(baseFilmsUrl);
    }

    public Response getFilmById(String filmId) {
        return sendGetRequest(baseFilmsUrl + "/" + filmId);
    }
}
