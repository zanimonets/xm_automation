package api.handlers;

import api.models.film.Film;
import api.services.FilmApiService;
import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.util.List;

public class FilmApiHandler extends BaseApiHandler {
    private final FilmApiService peopleApiService = new FilmApiService();

    @SneakyThrows
    public Film findFilmWithFewestPlanets(List<String> urls) {
        Film filmWithFewestPlanets = null;

        for (String url : urls) {
            Response response = peopleApiService.sendGetRequest(url);
            Film film = objectMapper.readValue(response.asString(), Film.class);
            if (filmWithFewestPlanets == null || film.getPlanets().size() < filmWithFewestPlanets.getPlanets().size()) {
                filmWithFewestPlanets = film;
            }
        }
        return filmWithFewestPlanets;
    }
}
