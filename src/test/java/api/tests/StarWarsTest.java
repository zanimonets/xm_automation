package api.tests;

import api.handlers.FilmApiHandler;
import api.handlers.PeopleApiHandler;
import api.models.film.Film;
import api.models.people.Person;
import api.services.PeopleApiService;
import core.ArrayUtils;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.List;

public class StarWarsTest extends BaseAPITest {

    private final FilmApiHandler filmApiHelper = new FilmApiHandler();
    private final PeopleApiService peopleApiService = new PeopleApiService();
    private final PeopleApiHandler peopleApiHelper = new PeopleApiHandler();

    @Test
    void starWarsDataTest() {
        String heroName = "Vader";
        Person testPerson = peopleApiHelper.findPersonByName(heroName);
        Assertions.assertThat(testPerson.getName()).contains(heroName);

        List<String> filmsWithHeroParticipation = testPerson.getFilms();
        Film filmWithFewestPlanets = filmApiHelper.findFilmWithFewestPlanets(filmsWithHeroParticipation);
        Assertions.assertThat(filmWithFewestPlanets.getTitle()).isEqualTo("A New Hope");

        String heroStarship = testPerson.getStarships().get(0);
        List<String> starships = filmWithFewestPlanets.getStarships();

        boolean listContainsItem = ArrayUtils.isListContainsItem(starships, heroStarship);
        Assertions.assertThat(listContainsItem).isTrue();

        Person oldestPerson = peopleApiHelper.findOldestPerson();
        Assertions.assertThat(oldestPerson.getName()).isEqualTo("Yoda");
        Assertions.assertThat(oldestPerson.getBirthYear()).isEqualTo("896BBY");
    }

    @Test
    void peopleApiEndpointSchemaValidationTest() {
        peopleApiService.getAllPeople().then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/people-schema.json"));
    }
}
