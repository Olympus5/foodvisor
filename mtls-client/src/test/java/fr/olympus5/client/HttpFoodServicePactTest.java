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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
                    a.object(newFruitJsonGenerator("Apples", List.of("January", "February", "March", "September", "October", "November", "December")));
                    a.object(newFruitJsonGenerator("Apricots", List.of("May", "June")));
                    a.object(newVegetableJsonGenerator("Arugula", List.of("April")));
                    a.object(newVegetableJsonGenerator("Artichokes", List.of("March")));
                    a.object(newVegetableJsonGenerator("Asparagus", List.of("March", "April", "May")));
                    a.object(newVegetableJsonGenerator("Beets", List.of("September")));
                    a.object(newVegetableJsonGenerator("Bell peppers", List.of("June", "August")));
                    a.object(newFruitJsonGenerator("Blackberries", List.of("July")));
                    a.object(newFruitJsonGenerator("Blood oranges", List.of("February")));
                    a.object(newFruitJsonGenerator("Blueberries", List.of("June", "July")));
                    a.object(newVegetableJsonGenerator("Broccoli", List.of("February")));
                    a.object(newVegetableJsonGenerator("Brussels sprouts", List.of("January", "October", "November")));
                    a.object(newVegetableJsonGenerator("Cabbage", List.of("February", "October", "December")));
                    a.object(newVegetableJsonGenerator("Carrots", List.of("January", "December")));
                    a.object(newVegetableJsonGenerator("Cauliflower", List.of("February", "October")));
                    a.object(newFruitJsonGenerator("Cherries", List.of("May", "June", "July")));
                    a.object(newVegetableJsonGenerator("Corn", List.of("June", "July", "August")));
                    a.object(newFruitJsonGenerator("Cranberries", List.of("October", "November")));
                    a.object(newVegetableJsonGenerator("Cucumbers", List.of("June", "July")));
                    a.object(newVegetableJsonGenerator("Eggplant", List.of("July", "August")));
                    a.object(newVegetableJsonGenerator("Fava beans", List.of("May")));
                    a.object(newFruitJsonGenerator("Figs", List.of("August", "September")));
                    a.object(newFruitJsonGenerator("Grapefruits", List.of("January", "February", "March")));
                    a.object(newFruitJsonGenerator("Grapes", List.of("August", "September", "October")));
                    a.object(newVegetableJsonGenerator("Green beans", List.of("May", "July")));
                    a.object(newVegetableJsonGenerator("Kale", List.of("January", "September", "December")));
                    a.object(newFruitJsonGenerator("Kumquats", List.of("February")));
                    a.object(newVegetableJsonGenerator("Leeks", List.of("January", "November", "December")));
                    a.object(newFruitJsonGenerator("Lemons", List.of("January", "March")));
                    a.object(newVegetableJsonGenerator("Lettuce", List.of("April")));
                    a.object(newFruitJsonGenerator("Melons", List.of("July", "August")));
                    a.object(newFruitJsonGenerator("Nectarines", List.of("July")));
                    a.object(newVegetableJsonGenerator("New potatoes", List.of("April")));
                    a.object(newVegetableJsonGenerator("Okra", List.of("August")));
                    a.object(newFruitJsonGenerator("Oranges", List.of("January", "March", "April", "December")));
                    a.object(newVegetableJsonGenerator("Parsnips", List.of("January", "November", "December")));
                    a.object(newFruitJsonGenerator("Peaches", List.of("June", "July", "August")));
                    a.object(newFruitJsonGenerator("Pears", List.of("January", "February", "September", "October", "November", "December")));
                    a.object(newVegetableJsonGenerator("Peas", List.of("April", "May")));
                    a.object(newFruitJsonGenerator("Persimmons", List.of("November")));
                    a.object(newFruitJsonGenerator("Plums", List.of("July", "August", "September")));
                    a.object(newFruitJsonGenerator("Pomegranates", List.of("January", "October", "November", "December")));
                    a.object(newVegetableJsonGenerator("Pumpkins", List.of("September", "October")));
                    a.object(newVegetableJsonGenerator("Radishes", List.of("March", "April")));
                    a.object(newVegetableJsonGenerator("Ramps", List.of("April")));
                    a.object(newFruitJsonGenerator("Raspberries", List.of("June", "July")));
                    a.object(newVegetableJsonGenerator("Rhubarb", List.of("March", "April", "May")));
                    a.object(newVegetableJsonGenerator("Rutabagas", List.of("February")));
                    a.object(newVegetableJsonGenerator("Spinach", List.of("March")));
                    a.object(newVegetableJsonGenerator("Spring onions", List.of("March")));
                    a.object(newFruitJsonGenerator("Strawberries", List.of("April", "May", "June")));
                    a.object(newVegetableJsonGenerator("Summer squash", List.of("June")));
                    a.object(newVegetableJsonGenerator("Sweet corn", List.of("August")));
                    a.object(newVegetableJsonGenerator("Sweet potatoes", List.of("February", "September", "November")));
                    a.object(newFruitJsonGenerator("Tangerines", List.of("December")));
                    a.object(newFruitJsonGenerator("Tomatoes", List.of("June", "July", "August")));
                    a.object(newVegetableJsonGenerator("Turnips", List.of("January", "October")));
                    a.object(newVegetableJsonGenerator("Winter squash", List.of("January", "November")));
                    a.object(newVegetableJsonGenerator("Zucchini", List.of("May", "August")));
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
                    a.object(newVegetableJsonGenerator("Pumpkins", List.of("September", "October")));
                    a.object(newFruitJsonGenerator("Pears", List.of("January", "February", "September", "October", "November", "December")));
                    a.object(newFruitJsonGenerator("Grapes", List.of("August", "September", "October")));
                    a.object(newFruitJsonGenerator("Apples", List.of("January", "February", "March", "September", "October", "November", "December")));
                    a.object(newVegetableJsonGenerator("Winter squash", List.of("January", "November")));
                    a.object(newVegetableJsonGenerator("Kale", List.of("January", "September", "December")));
                    a.object(newVegetableJsonGenerator("Sweet potatoes", List.of("February", "September", "November")));
                    a.object(newVegetableJsonGenerator("Beets", List.of("September")));
                    a.object(newFruitJsonGenerator("Figs", List.of("August", "September")));
                    a.object(newFruitJsonGenerator("Plums", List.of("July", "August", "September")));
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
                newFruit("Apples", "January", "February", "March", "September", "October", "November", "December"),
                newFruit("Apricots", "May", "June"),
                newVegetable("Arugula", "April"),
                newVegetable("Artichokes", "March"),
                newVegetable("Asparagus", "March", "April", "May"),
                newVegetable("Beets", "September"),
                newVegetable("Bell peppers", "June", "August"),
                newFruit("Blackberries", "July"),
                newFruit("Blood oranges", "February"),
                newFruit("Blueberries", "June", "July"),
                newVegetable("Broccoli", "February"),
                newVegetable("Brussels sprouts", "January", "October", "November"),
                newVegetable("Cabbage", "February", "October", "December"),
                newVegetable("Carrots", "January", "December"),
                newVegetable("Cauliflower", "February", "October"),
                newFruit("Cherries", "May", "June", "July"),
                newVegetable("Corn", "June", "July", "August"),
                newFruit("Cranberries", "October", "November"),
                newVegetable("Cucumbers", "June", "July"),
                newVegetable("Eggplant", "July", "August"),
                newVegetable("Fava beans", "May"),
                newFruit("Figs", "August", "September"),
                newFruit("Grapefruits", "January", "February", "March"),
                newFruit("Grapes", "August", "September", "October"),
                newVegetable("Green beans", "May", "July"),
                newVegetable("Kale", "January", "September", "December"),
                newFruit("Kumquats", "February"),
                newVegetable("Leeks", "January", "November", "December"),
                newFruit("Lemons", "January", "March"),
                newVegetable("Lettuce", "April"),
                newFruit("Melons", "July", "August"),
                newFruit("Nectarines", "July"),
                newVegetable("New potatoes", "April"),
                newVegetable("Okra", "August"),
                newFruit("Oranges", "January", "March", "April", "December"),
                newVegetable("Parsnips", "January", "November", "December"),
                newFruit("Peaches", "June", "July", "August"),
                newFruit("Pears", "January", "February", "September", "October", "November", "December"),
                newVegetable("Peas", "April", "May"),
                newFruit("Persimmons", "November"),
                newFruit("Plums", "July", "August", "September"),
                newFruit("Pomegranates", "January", "October", "November", "December"),
                newVegetable("Pumpkins", "September", "October"),
                newVegetable("Radishes", "March", "April"),
                newVegetable("Ramps", "April"),
                newFruit("Raspberries", "June", "July"),
                newVegetable("Rhubarb", "March", "April", "May"),
                newVegetable("Rutabagas", "February"),
                newVegetable("Spinach", "March"),
                newVegetable("Spring onions", "March"),
                newFruit("Strawberries", "April", "May", "June"),
                newVegetable("Summer squash", "June"),
                newVegetable("Sweet corn", "August"),
                newVegetable("Sweet potatoes", "February", "September", "November"),
                newFruit("Tangerines", "December"),
                newFruit("Tomatoes", "June", "July", "August"),
                newVegetable("Turnips", "January", "October"),
                newVegetable("Winter squash", "January", "November"),
                newVegetable("Zucchini", "May", "August")
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
                newVegetable("Pumpkins", "September", "October"),
                newFruit("Pears", "January", "February", "September", "October", "November", "December"),
                newFruit("Grapes", "August", "September", "October"),
                newFruit("Apples", "January", "February", "March", "September", "October", "November", "December"),
                newVegetable("Winter squash", "January", "November"),
                newVegetable("Kale", "January", "September", "December"),
                newVegetable("Sweet potatoes", "February", "September", "November"),
                newVegetable("Beets", "September"),
                newFruit("Figs", "August", "September"),
                newFruit("Plums", "July", "August", "September")
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

    private static Food newFruit(String name, String ...consumptionMonths) {
        return new Food(name, "fruit", Arrays.asList(consumptionMonths));
    }

    private static Food newVegetable(String name, String ...consumptionMonths) {
        return new Food(name, "vegetable", Arrays.asList(consumptionMonths));
    }

    private static Consumer<LambdaDslObject> newFruitJsonGenerator(String name, List<String> consumptionMonths) {
        return o -> {
            o.stringType("name", name);
            o.array("consumptionMonths", m -> {
                for (String month : consumptionMonths) {
                    m.stringValue(month);
                }
            });
            o.stringType("family", "fruit");
        };
    }
    
    private static Consumer<LambdaDslObject> newVegetableJsonGenerator(String name, List<String> consumptionMonths) {
        return o -> {
            o.stringType("name", name);
            o.array("consumptionMonths", m -> {
                for (String month : consumptionMonths) {
                    m.stringValue(month);
                }
            });
            o.stringType("family", "vegetable");
        };
    }
}