package fr.olympus5.client;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.LambdaDslObject;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.V4Pact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.time.Month;
import java.util.*;
import java.util.function.Consumer;

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
                .body(newJsonArray(a -> {
                    a.object(newFruitJsonGenerator("Apples", List.of(Month.JANUARY, Month.FEBRUARY)));
                    a.object(newFruitJsonGenerator("Apricots", List.of(Month.MAY, Month.JUNE)));
                    a.object(newFruitJsonGenerator("Blueberries", List.of(Month.JUNE, Month.JULY)));
                    a.object(newVegetableJsonGenerator("Carrots", List.of(Month.JANUARY, Month.DECEMBER)));
                    a.object(newVegetableJsonGenerator("Corn", List.of(Month.JUNE, Month.JULY, Month.AUGUST)));
                    a.object(newVegetableJsonGenerator("Eggplant", List.of(Month.JULY, Month.AUGUST)));
                }).build())
                .toPact(V4Pact.class);
    }

    @Pact(consumer = "MealClient", provider = "MealService")
    public V4Pact noFoodsExist(PactDslWithProvider builder) {
        return builder.given("no foods exist")
                .uponReceiving("get all foods")
                .method("GET")
                .path("/foods")
                .willRespondWith()
                .headers(headers())
                .status(200)
                .body("[]")
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
                .body(newJsonArray(a -> {
                    a.object(newVegetableJsonGenerator("Corn", List.of(Month.JUNE, Month.JULY, Month.AUGUST)));
                    a.object(newFruitJsonGenerator("Blueberries", List.of(Month.JUNE, Month.JULY)));
                    a.object(newFruitJsonGenerator("Apples", List.of(Month.JANUARY, Month.FEBRUARY)));
                }).build())
                .toPact(V4Pact.class);
    }

    @Pact(consumer = "MealClient", provider = "MealService")
    public V4Pact seasonalFoodsDoNotExist(PactDslWithProvider builder) {
        return builder.given("seasonal foods for october do not exist")
                .uponReceiving("get seasonal foods for october")
                .method("GET")
                .path("/foods/seasonal/october")
                .willRespondWith()
                .headers(headers())
                .status(404)
                .toPact(V4Pact.class);
    }

    @Test
    @PactTestFor(pactMethod = "getAllFoods")
    void getAllFoods(MockServer mockServer) {
        HttpFoodService foodService = new HttpFoodService(new RestTemplateBuilder()
                .rootUri(mockServer.getUrl())
                .build());
        List<Food> expectedFoods = List.of(
                newFruit("Apples", Month.JANUARY, Month.FEBRUARY),
                newFruit("Apricots", Month.MAY, Month.JUNE),
                newFruit("Blueberries", Month.JUNE, Month.JULY),
                newVegetable("Carrots", Month.JANUARY, Month.DECEMBER),
                newVegetable("Corn", Month.JUNE, Month.JULY, Month.AUGUST),
                newVegetable("Eggplant", Month.JULY, Month.AUGUST)
        );

        var foods = foodService.getAllFoods();

        assertEquals(expectedFoods, foods);
    }

    @Test
    @PactTestFor(pactMethod = "noFoodsExist")
    void noFoodsExists(MockServer mockServer) {
        HttpFoodService foodService = new HttpFoodService(new RestTemplateBuilder()
                .rootUri(mockServer.getUrl())
                .build());

        var foods = foodService.getAllFoods();

        assertTrue(foods.isEmpty());
    }

    @Test
    @PactTestFor(pactMethod = "getSeasonalFoods")
    void getSeasonalFoods(MockServer mockServer) {
        HttpFoodService foodService = new HttpFoodService(new RestTemplateBuilder().
                rootUri(mockServer.getUrl())
                .build());
        List<Food> expectedFoods = List.of(
                newVegetable("Corn", Month.JUNE, Month.JULY, Month.AUGUST),
                newFruit("Blueberries", Month.JUNE, Month.JULY),
                newFruit("Apples", Month.JANUARY, Month.FEBRUARY)
        );

        var foods = foodService.getSeasonalFoods(Month.SEPTEMBER);

        assertEquals(expectedFoods, foods);
    }

    @Test
    @PactTestFor(pactMethod = "seasonalFoodsDoNotExist")
    void seasonalFoodsDoNotExist(MockServer mockServer) {
        HttpFoodService foodService = new HttpFoodService(new RestTemplateBuilder()
                .rootUri(mockServer.getUrl())
                .build());

        HttpClientErrorException exception = assertThrows(HttpClientErrorException.class, () -> foodService.getSeasonalFoods(Month.OCTOBER));

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }

    private Map<String, String> headers() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; charset=utf-8");
        return headers;
    }

    private static Food newFruit(String name, Month... consumptionMonths) {
        return new Food(name, "fruit", Arrays.asList(consumptionMonths));
    }

    private static Food newVegetable(String name, Month... consumptionMonths) {
        return new Food(name, "vegetable", Arrays.asList(consumptionMonths));
    }

    private static Consumer<LambdaDslObject> newFruitJsonGenerator(String name, List<Month> consumptionMonths) {
        return o -> {
            o.stringType("name", name);
            o.array("consumptionMonths", m -> {
                for (Month month : consumptionMonths) {
                    m.stringValue(capitalize(month.name()));
                }
            });
            o.stringType("family", "fruit");
        };
    }

    private static Consumer<LambdaDslObject> newVegetableJsonGenerator(String name, List<Month> consumptionMonths) {
        return o -> {
            o.stringType("name", name);
            o.array("consumptionMonths", m -> {
                for (Month month : consumptionMonths) {
                    m.stringValue(capitalize(month.name()));
                }
            });
            o.stringType("family", "vegetable");
        };
    }

    private static String capitalize(String s) {
        return s.charAt(0) + s.substring(1).toLowerCase(Locale.ENGLISH);
    }
}