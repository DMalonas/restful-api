package events.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author DMalonas
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeName("tournament2")
// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class Tournament2  extends Tournament {
    @JsonProperty public String tournamentUUID;
    @JsonProperty public String golfCourse;
    @JsonProperty public String competitionName;
    @JsonProperty public String hostCountry;
    @JsonProperty public String epochStart;
    @JsonProperty public String epochFinish;
    @JsonProperty public String rounds;
    @JsonProperty public String playerCount;
}