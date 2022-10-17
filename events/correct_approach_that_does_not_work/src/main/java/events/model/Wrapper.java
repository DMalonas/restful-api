package events.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.img.events.model.Tournament;
import com.img.events.model.Tournament1;
import com.img.events.model.Tournament2;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DMalonas
 */
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Wrapper {
    private String type;

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
            property = "type")
    @JsonSubTypes(value = {
            @JsonSubTypes.Type(value = Tournament1.class, name = "tournament1"),
            @JsonSubTypes.Type(value = Tournament2.class, name = "tournament2") }
    )
    private Tournament tournament;
}
