package fr.olympus5.client;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class MonthDeserializerTest {
    private MonthDeserializer deserializer;
    private ObjectMapper mapper;
    private DeserializationContext ctx;

    @BeforeEach
    void setUp() {
        deserializer = new MonthDeserializer();
        mapper = new ObjectMapper();
        ctx = mapper.getDeserializationContext();
    }

    @Test
    void testDeserialize_ValidMonth() throws IOException {
        String json = "\"january\"";
        JsonParser parser = mapper.getFactory().createParser(json);
        parser.nextToken();

        Month result = deserializer.deserialize(parser, ctx);

        assertEquals(Month.JANUARY, result);
    }

    @Test
    void testDeserialize_ValidMonthCaseInsensitive() throws IOException {
        String json = "\"AuGuSt\"";
        JsonParser parser = mapper.getFactory().createParser(json);
        parser.nextToken();

        Month result = deserializer.deserialize(parser, ctx);

        assertEquals(Month.AUGUST, result);
    }

    @Test
    void testDeserialize_InvalidMonthString() throws IOException {
        String json = "\"notamonth\"";
        JsonParser parser = mapper.getFactory().createParser(json);
        parser.nextToken();

        assertThrows(IllegalArgumentException.class, () -> deserializer.deserialize(parser, ctx));
    }

    @Test
    void testDeserialize_NonStringNode() throws IOException {
        String json = "123";
        JsonParser parser = mapper.getFactory().createParser(json);
        parser.nextToken();

        assertThrows(InvalidFormatException.class, () -> deserializer.deserialize(parser, ctx));
    }
}
