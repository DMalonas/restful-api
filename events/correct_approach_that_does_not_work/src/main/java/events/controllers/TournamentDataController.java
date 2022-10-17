package events.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import events.model.Tournament;
import events.model.Wrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DMalonas
 */
@RestController
@RequestMapping("/api/tournaments")
public class TournamentDataController {

    @PostMapping
    public ResponseEntity<String> consumeTournament(@RequestBody JsonNode jsonNode) {
        ObjectMapper objectMapper = new ObjectMapper();
        Tournament newJsonNode;
        PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
                .allowIfSubType("com.img.events")
                .allowIfSubType("java.util.ArrayList")
                .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.NON_FINAL);
        List<Tournament> tournaments = new ArrayList<>();

        try {
            String content = objectMapper.writeValueAsString(jsonNode);
            Wrapper wrapper = mapper.readValue(content, Wrapper.class);

            Tournament tournament = mapper.readValue(content, Tournament.class);
            newJsonNode =  objectMapper.readValue(content, Tournament.class);
            newJsonNode = objectMapper.readValue(content, Tournament.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int a = 5;
        return ResponseEntity.ok("");
    }
}
