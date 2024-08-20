package api.models.people;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PeopleResponse {

    private int count;
    private String next;
    private String previous;
    private List<Person> results;
}
