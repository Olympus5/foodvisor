package fr.olympus5.client;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;
import java.time.Month;

public class MonthDeserializer extends JsonDeserializer<Month> {
    @Override
    public Month deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        if (node.isTextual()) {
            String monthStr = node.asText();
            return Month.valueOf(monthStr.toUpperCase());
        }

        throw new InvalidFormatException(p, "Expected a string value for Month", node, String.class);
    }
}
