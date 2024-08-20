package api.handlers;

import api.models.people.PeopleResponse;
import api.models.people.Person;
import api.services.PeopleApiService;
import io.restassured.response.Response;
import lombok.SneakyThrows;

public class PeopleApiHandler extends BaseApiHandler {
    private final PeopleApiService peopleApiService = new PeopleApiService();
    public record AllRecordsNumberAndPerPage(int count, int perPage) {}

    @SneakyThrows
    public AllRecordsNumberAndPerPage getPeopleNumber()  {
        Response response = peopleApiService.getAllPeople();
        PeopleResponse peopleResponse = objectMapper.readValue(response.asString(), PeopleResponse.class);
        int count = peopleResponse.getCount();
        int size = peopleResponse.getResults().size();
        return new AllRecordsNumberAndPerPage(count,size);
    }

    public int calculateTotalRequests(AllRecordsNumberAndPerPage allRecordsNumberAndPerPage) {
        int fullPages = allRecordsNumberAndPerPage.count() / allRecordsNumberAndPerPage.perPage();
        if (allRecordsNumberAndPerPage.count() % allRecordsNumberAndPerPage.perPage() > 0) {
            fullPages++;
        }
        return fullPages;
    }

    @SneakyThrows
    public PeopleResponse getPeopleByPage(int pageNumber) {
        Response response = peopleApiService.getPeopleByPage(pageNumber);
        return objectMapper.readValue(response.asString(), PeopleResponse.class);
    }

    @SneakyThrows
    public Person findPersonByName(String name)  {
        AllRecordsNumberAndPerPage peopleNumber = getPeopleNumber();
        int totalRequests = calculateTotalRequests(peopleNumber);

        for (int page = 1; page <= totalRequests; page++) {
            PeopleResponse peopleResponse = getPeopleByPage(page);

            for (Person person : peopleResponse.getResults()) {
                if (person.getName().contains(name)) {
                    return person;
                }
            }
        }
        throw new RuntimeException("Person with name " + name + " not found.");
    }

    public Person findOldestPerson() {
        Person oldestPerson = null;
        double oldestAge = Double.MIN_VALUE;

        AllRecordsNumberAndPerPage peopleNumber = getPeopleNumber();
        int totalRequests = calculateTotalRequests(peopleNumber);

        for (int page = 1; page <= totalRequests; page++) {
            PeopleResponse peopleResponse = getPeopleByPage(page);

            for (Person person : peopleResponse.getResults()) {
                String birthYear = person.getBirthYear();
                if (birthYear != null && !birthYear.equals("unknown")) {
                    double age = parseAge(birthYear);
                    if (age > oldestAge) {
                        oldestAge = age;
                        oldestPerson = person;
                    }
                }
            }
        }
        return oldestPerson;
    }

    private double parseAge(String birthYear) {
        birthYear = birthYear.toUpperCase().replace("BBY", "").trim();
        try {
            return Double.parseDouble(birthYear);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
