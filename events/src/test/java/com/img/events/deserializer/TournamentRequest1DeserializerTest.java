package com.img.events.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.img.events.model.Tournament1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

@JsonTest
@ExtendWith(SpringExtension.class)
class TournamentRequest1DeserializerTest {


    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testDeserialize() throws IOException {
        String json = "{\n" +
                "    \"tournamentId\": \"174638\",\n" +
                "    \"tournamentName\": \"Women's Open Championship\",\n" +
                "    \"forecast\": \"fair\",\n" +
                "    \"courseName\": \"Sunnydale Golf Course\",\n" +
                "    \"countryCode\": \"GB\",\n" +
                "    \"startDate\": \"09/07/21\",\n" +
                "    \"endDate\": \"13/07/21\",\n" +
                "    \"roundCount\": \"4\"\n" +
                "}";
        Tournament1 user = objectMapper.readValue(json, Tournament1.class);

        Assertions.assertEquals("174638", user.getTournamentId());
    }

}
