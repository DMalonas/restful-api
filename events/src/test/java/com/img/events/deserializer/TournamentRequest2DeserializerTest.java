package com.img.events.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.img.events.model.Tournament2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
@JsonTest
@ExtendWith(SpringExtension.class)
class TournamentRequest2DeserializerTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testDeserialize() throws IOException {
        String json = "{\n" +
                "    \"tournamentUUID\":\"87fc6650-e114-4179-9aef-6a9a13030f80\",\n" +
                "    \"golfCourse\":\"Happy Days Golf Club\",\n" +
                "    \"competitionName\":\"South West Invitational\",\n" +
                "    \"hostCountry\":\"United States Of America\",\n" +
                "    \"epochStart\":\"1638349200\",\n" +
                "    \"epochFinish\":\"1638468000\",\n" +
                "    \"rounds\":\"2\",\n" +
                "    \"playerCount\":\"35\"\n" +
                "}";
        Tournament2 tournament2 = objectMapper.readValue(json, Tournament2.class);

        Assertions.assertEquals("87fc6650-e114-4179-9aef-6a9a13030f80", tournament2.getTournamentUUID());
    }
}
