package events.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

/**
 * @author DMalonas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public abstract class Tournament {
    private String type;

}
