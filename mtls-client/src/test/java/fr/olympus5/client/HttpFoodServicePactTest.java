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

import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static au.com.dius.pact.consumer.dsl.LambdaDsl.newJsonArray;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(PactConsumerTestExt.class)
class HttpFoodServicePactTest {

    @Pact(consumer = "MealClient", provider = "MealService")
    public V4Pact getAllFoods(PactDslWithProvider builder) {
        return builder.given("foods exist")
                .uponReceiving("get all foods")
                .method("GET")
                .path("/foods")
                .willRespondWith()
                .headers(headers())
                .status(200)
                .body(newJsonArray(a -> a.stringValue("Apples")
                        .stringValue("Apricots")
                        .stringValue("Arugula")
                        .stringValue("Artichokes")
                        .stringValue("Asparagus")
                        .stringValue("Beets")
                        .stringValue("Bell peppers")
                        .stringValue("Blackberries")
                        .stringValue("Blood oranges")
                        .stringValue("Blueberries")
                        .stringValue("Broccoli")
                        .stringValue("Brussels sprouts")
                        .stringValue("Cabbage")
                        .stringValue("Carrots")
                        .stringValue("Cauliflower")
                        .stringValue("Cherries")
                        .stringValue("Corn")
                        .stringValue("Cranberries")
                        .stringValue("Cucumbers")
                        .stringValue("Eggplant")
                        .stringValue("Fava beans")
                        .stringValue("Figs")
                        .stringValue("Grapefruits")
                        .stringValue("Grapes")
                        .stringValue("Green beans")
                        .stringValue("Kale")
                        .stringValue("Kumquats")
                        .stringValue("Leeks")
                        .stringValue("Lemons")
                        .stringValue("Lettuce")
                        .stringValue("Melons")
                        .stringValue("Nectarines")
                        .stringValue("New potatoes")
                        .stringValue("Okra")
                        .stringValue("Oranges")
                        .stringValue("Parsnips")
                        .stringValue("Peaches")
                        .stringValue("Pears")
                        .stringValue("Peas")
                        .stringValue("Peppers")
                        .stringValue("Persimmons")
                        .stringValue("Plums")
                        .stringValue("Pomegranates")
                        .stringValue("Pumpkins")
                        .stringValue("Radishes")
                        .stringValue("Ramps")
                        .stringValue("Raspberries")
                        .stringValue("Rhubarb")
                        .stringValue("Rutabagas")
                        .stringValue("Spinach")
                        .stringValue("Spring onions")
                        .stringValue("Strawberries")
                        .stringValue("Summer squash")
                        .stringValue("Sweet corn")
                        .stringValue("Sweet potatoes")
                        .stringValue("Tangerines")
                        .stringValue("Tomatoes")
                        .stringValue("Turnips")
                        .stringValue("Winter squash")
                        .stringValue("Zucchini")).build())
                .toPact(V4Pact.class);
    }

    @Pact(consumer = "MealClient", provider = "MealService")
    public V4Pact getSeasonalFoods(PactDslWithProvider builder) {
        return builder.given("seasonal foods exist")
                .uponReceiving("get seasonal foods for september")
                .method("GET")
                .path("/foods/seasonal/september")
                .willRespondWith()
                .headers(headers())
                .status(200)
                .body(newJsonArray(a -> a.stringValue("Apples")
                        .stringValue("Pears")
                        .stringValue("Grapes")
                        .stringValue("Tomatoes")
                        .stringValue("Bell Peppers")
                        .stringValue("Kale")
                        .stringValue("Mushrooms")
                        .stringValue("Walnuts")
                        .stringValue("Chestnuts")).build())
                .toPact(V4Pact.class);
    }

    @Test
    @PactTestFor(pactMethod = "getAllFoods")
    void getAllFoods(MockServer mockServer) {
        HttpFoodService foodService = new HttpFoodService(new RestTemplateBuilder()
                .rootUri(mockServer.getUrl())
                .build());
        List<String> expected = List.of("Apples", "Apricots", "Arugula", "Artichokes", "Asparagus", "Beets", "Bell peppers", "Blackberries", "Blood oranges", "Blueberries", "Broccoli", "Brussels sprouts", "Cabbage", "Carrots", "Cauliflower", "Cherries", "Corn", "Cranberries", "Cucumbers", "Eggplant", "Fava beans", "Figs", "Grapefruits", "Grapes", "Green beans", "Kale", "Kumquats", "Leeks", "Lemons", "Lettuce", "Melons", "Nectarines", "New potatoes", "Okra", "Oranges", "Parsnips", "Peaches", "Pears", "Peas", "Peppers", "Persimmons", "Plums", "Pomegranates", "Pumpkins", "Radishes", "Ramps", "Raspberries", "Rhubarb", "Rutabagas", "Spinach", "Spring onions", "Strawberries", "Summer squash", "Sweet corn", "Sweet potatoes", "Tangerines", "Tomatoes", "Turnips", "Winter squash", "Zucchini");

        var foods = foodService.getAllFoods();

        assertEquals(expected, foods);
    }

    @Test
    @PactTestFor(pactMethod = "getSeasonalFoods")
    void getSeasonalFoods(MockServer mockServer) {
        HttpFoodService foodService = new HttpFoodService(new RestTemplateBuilder().
                rootUri(mockServer.getUrl())
                .build());
        List<String> expected = List.of("Apples", "Pears", "Grapes", "Tomatoes", "Bell Peppers", "Kale", "Mushrooms", "Walnuts", "Chestnuts");

        var foods = foodService.getSeasonalFoods(Month.SEPTEMBER);

        assertEquals(expected, foods);
    }

    private Map<String, String> headers() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; charset=utf-8");
        return headers;
    }
}