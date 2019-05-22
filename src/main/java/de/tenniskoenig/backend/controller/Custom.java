package de.tenniskoenig.backend.controller;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.sun.media.jfxmedia.MediaManager;
import de.tenniskoenig.backend.domain.Played;

import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class Custom extends JsonSerializer<Played> {

    @Override
    public void serialize(Played played, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("firstName", played.getUserID().getFirstName());
        jsonGenerator.writeStringField("lastName", played.getUserID().getLastName());
        jsonGenerator.writeNumberField("points", played.getPoints());
        jsonGenerator.writeNumberField("games", played.getGameID());
        jsonGenerator.writeEndObject();
    }
}
