package fr.olympus5.client;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.V4Pact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(PactConsumerTestExt.class)
class HttpFoodServicePactTest {

    @Pact(consumer = "MealBatch", provider = "MealService")
    public V4Pact getSeasonalFoods(PactDslWithProvider builder) {
        return builder.given("seasonal foods exist")
                .uponReceiving("get seasonal foods for september")
                .method("GET")
                .path("/foods/seasonal/september")
                .willRespondWith()
                .headers(headers())
                .status(200)
                .body("[\"Apples\",\"Pears\",\"Grapes\",\"Tomatoes\",\"Bell Peppers\",\"Kale\",\"Mushrooms\",\"Walnuts\",\"Chestnuts\"]")
                .toPact(V4Pact.class);
    }

    @Test
    @PactTestFor(pactMethod = "getSeasonalFoods")
    void getSeasonalFoods(MockServer mockServer) {
        HttpFoodService foodService = new HttpFoodService(new RestTemplateBuilder().
                rootUri(mockServer.getUrl())
                .build());
        String season = "september";

        var foods = foodService.getSeasonalFoods(season);

        assertNotNull(foods);
        assertFalse(foods.isEmpty());
        assertEquals(9, foods.size());
        assertTrue(foods.contains("Apples"));
        assertTrue(foods.contains("Pears"));
        assertTrue(foods.contains("Grapes"));
        assertTrue(foods.contains("Tomatoes"));
        assertTrue(foods.contains("Bell Peppers"));
        assertTrue(foods.contains("Kale"));
        assertTrue(foods.contains("Mushrooms"));
        assertTrue(foods.contains("Walnuts"));
        assertTrue(foods.contains("Chestnuts"));
    }

    private Map<String, String> headers() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; charset=utf-8");
        return headers;
    }
}