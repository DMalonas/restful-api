package events.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author DMalonas
 */
// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
@Data
@AllArgsConstructor
@NoArgsConstructor

@JsonTypeName("tournament1")
public class Tournament1 extends Tournament {
    @JsonProperty public String tournamentId;
    @JsonProperty public String tournamentName;
    @JsonProperty public String forecast;
    @JsonProperty public String courseName;
    @JsonProperty public String countryCode;
    @JsonProperty public String startDate;
    @JsonProperty public String endDate;
    @JsonProperty public String roundCount;
}