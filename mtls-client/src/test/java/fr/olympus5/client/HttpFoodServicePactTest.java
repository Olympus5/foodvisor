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
                    a.object(newFruitJsonGenerator("Apples", List.of(Month.JANUARY, Month.FEBRUARY, Month.MARCH, Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER)));
                    a.object(newFruitJsonGenerator("Apricots", List.of(Month.MAY, Month.JUNE)));
                    a.object(newVegetableJsonGenerator("Arugula", List.of(Month.APRIL)));
                    a.object(newVegetableJsonGenerator("Artichokes", List.of(Month.MARCH)));
                    a.object(newVegetableJsonGenerator("Asparagus", List.of(Month.MARCH, Month.APRIL, Month.MAY)));
                    a.object(newVegetableJsonGenerator("Beets", List.of(Month.SEPTEMBER)));
                    a.object(newVegetableJsonGenerator("Bell peppers", List.of(Month.JUNE, Month.AUGUST)));
                    a.object(newFruitJsonGenerator("Blackberries", List.of(Month.JULY)));
                    a.object(newFruitJsonGenerator("Blood oranges", List.of(Month.FEBRUARY)));
                    a.object(newFruitJsonGenerator("Blueberries", List.of(Month.JUNE, Month.JULY)));
                    a.object(newVegetableJsonGenerator("Broccoli", List.of(Month.FEBRUARY)));
                    a.object(newVegetableJsonGenerator("Brussels sprouts", List.of(Month.JANUARY, Month.OCTOBER, Month.NOVEMBER)));
                    a.object(newVegetableJsonGenerator("Cabbage", List.of(Month.FEBRUARY, Month.OCTOBER, Month.DECEMBER)));
                    a.object(newVegetableJsonGenerator("Carrots", List.of(Month.JANUARY, Month.DECEMBER)));
                    a.object(newVegetableJsonGenerator("Cauliflower", List.of(Month.FEBRUARY, Month.OCTOBER)));
                    a.object(newFruitJsonGenerator("Cherries", List.of(Month.MAY, Month.JUNE, Month.JULY)));
                    a.object(newVegetableJsonGenerator("Corn", List.of(Month.JUNE, Month.JULY, Month.AUGUST)));
                    a.object(newFruitJsonGenerator("Cranberries", List.of(Month.OCTOBER, Month.NOVEMBER)));
                    a.object(newVegetableJsonGenerator("Cucumbers", List.of(Month.JUNE, Month.JULY)));
                    a.object(newVegetableJsonGenerator("Eggplant", List.of(Month.JULY, Month.AUGUST)));
                    a.object(newVegetableJsonGenerator("Fava beans", List.of(Month.MAY)));
                    a.object(newFruitJsonGenerator("Figs", List.of(Month.AUGUST, Month.SEPTEMBER)));
                    a.object(newFruitJsonGenerator("Grapefruits", List.of(Month.JANUARY, Month.FEBRUARY, Month.MARCH)));
                    a.object(newFruitJsonGenerator("Grapes", List.of(Month.AUGUST, Month.SEPTEMBER, Month.OCTOBER)));
                    a.object(newVegetableJsonGenerator("Green beans", List.of(Month.MAY, Month.JULY)));
                    a.object(newVegetableJsonGenerator("Kale", List.of(Month.JANUARY, Month.SEPTEMBER, Month.DECEMBER)));
                    a.object(newFruitJsonGenerator("Kumquats", List.of(Month.FEBRUARY)));
                    a.object(newVegetableJsonGenerator("Leeks", List.of(Month.JANUARY, Month.NOVEMBER, Month.DECEMBER)));
                    a.object(newFruitJsonGenerator("Lemons", List.of(Month.JANUARY, Month.MARCH)));
                    a.object(newVegetableJsonGenerator("Lettuce", List.of(Month.APRIL)));
                    a.object(newFruitJsonGenerator("Melons", List.of(Month.JULY, Month.AUGUST)));
                    a.object(newFruitJsonGenerator("Nectarines", List.of(Month.JULY)));
                    a.object(newVegetableJsonGenerator("New potatoes", List.of(Month.APRIL)));
                    a.object(newVegetableJsonGenerator("Okra", List.of(Month.AUGUST)));
                    a.object(newFruitJsonGenerator("Oranges", List.of(Month.JANUARY, Month.MARCH, Month.APRIL, Month.DECEMBER)));
                    a.object(newVegetableJsonGenerator("Parsnips", List.of(Month.JANUARY, Month.NOVEMBER, Month.DECEMBER)));
                    a.object(newFruitJsonGenerator("Peaches", List.of(Month.JUNE, Month.JULY, Month.AUGUST)));
                    a.object(newFruitJsonGenerator("Pears", List.of(Month.JANUARY, Month.FEBRUARY, Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER)));
                    a.object(newVegetableJsonGenerator("Peas", List.of(Month.APRIL, Month.MAY)));
                    a.object(newFruitJsonGenerator("Persimmons", List.of(Month.NOVEMBER)));
                    a.object(newFruitJsonGenerator("Plums", List.of(Month.JULY, Month.AUGUST, Month.SEPTEMBER)));
                    a.object(newFruitJsonGenerator("Pomegranates", List.of(Month.JANUARY, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER)));
                    a.object(newVegetableJsonGenerator("Pumpkins", List.of(Month.SEPTEMBER, Month.OCTOBER)));
                    a.object(newVegetableJsonGenerator("Radishes", List.of(Month.MARCH, Month.APRIL)));
                    a.object(newVegetableJsonGenerator("Ramps", List.of(Month.APRIL)));
                    a.object(newFruitJsonGenerator("Raspberries", List.of(Month.JUNE, Month.JULY)));
                    a.object(newVegetableJsonGenerator("Rhubarb", List.of(Month.MARCH, Month.APRIL, Month.MAY)));
                    a.object(newVegetableJsonGenerator("Rutabagas", List.of(Month.FEBRUARY)));
                    a.object(newVegetableJsonGenerator("Spinach", List.of(Month.MARCH)));
                    a.object(newVegetableJsonGenerator("Spring onions", List.of(Month.MARCH)));
                    a.object(newFruitJsonGenerator("Strawberries", List.of(Month.APRIL, Month.MAY, Month.JUNE)));
                    a.object(newVegetableJsonGenerator("Summer squash", List.of(Month.JUNE)));
                    a.object(newVegetableJsonGenerator("Sweet corn", List.of(Month.AUGUST)));
                    a.object(newVegetableJsonGenerator("Sweet potatoes", List.of(Month.FEBRUARY, Month.SEPTEMBER, Month.NOVEMBER)));
                    a.object(newFruitJsonGenerator("Tangerines", List.of(Month.DECEMBER)));
                    a.object(newFruitJsonGenerator("Tomatoes", List.of(Month.JUNE, Month.JULY, Month.AUGUST)));
                    a.object(newVegetableJsonGenerator("Turnips", List.of(Month.JANUARY, Month.OCTOBER)));
                    a.object(newVegetableJsonGenerator("Winter squash", List.of(Month.JANUARY, Month.NOVEMBER)));
                    a.object(newVegetableJsonGenerator("Zucchini", List.of(Month.MAY, Month.AUGUST)));
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
                    a.object(newVegetableJsonGenerator("Pumpkins", List.of(Month.SEPTEMBER, Month.OCTOBER)));
                    a.object(newFruitJsonGenerator("Pears", List.of(Month.JANUARY, Month.FEBRUARY, Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER)));
                    a.object(newFruitJsonGenerator("Grapes", List.of(Month.AUGUST, Month.SEPTEMBER, Month.OCTOBER)));
                    a.object(newFruitJsonGenerator("Apples", List.of(Month.JANUARY, Month.FEBRUARY, Month.MARCH, Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER)));
                    a.object(newVegetableJsonGenerator("Winter squash", List.of(Month.JANUARY, Month.NOVEMBER)));
                    a.object(newVegetableJsonGenerator("Kale", List.of(Month.JANUARY, Month.SEPTEMBER, Month.DECEMBER)));
                    a.object(newVegetableJsonGenerator("Sweet potatoes", List.of(Month.FEBRUARY, Month.SEPTEMBER, Month.NOVEMBER)));
                    a.object(newVegetableJsonGenerator("Beets", List.of(Month.SEPTEMBER)));
                    a.object(newFruitJsonGenerator("Figs", List.of(Month.AUGUST, Month.SEPTEMBER)));
                    a.object(newFruitJsonGenerator("Plums", List.of(Month.JULY, Month.AUGUST, Month.SEPTEMBER)));
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
                newFruit("Apples", Month.JANUARY, Month.FEBRUARY, Month.MARCH, Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER),
                newFruit("Apricots", Month.MAY, Month.JUNE),
                newVegetable("Arugula", Month.APRIL),
                newVegetable("Artichokes", Month.MARCH),
                newVegetable("Asparagus", Month.MARCH, Month.APRIL, Month.MAY),
                newVegetable("Beets", Month.SEPTEMBER),
                newVegetable("Bell peppers", Month.JUNE, Month.AUGUST),
                newFruit("Blackberries", Month.JULY),
                newFruit("Blood oranges", Month.FEBRUARY),
                newFruit("Blueberries", Month.JUNE, Month.JULY),
                newVegetable("Broccoli", Month.FEBRUARY),
                newVegetable("Brussels sprouts", Month.JANUARY, Month.OCTOBER, Month.NOVEMBER),
                newVegetable("Cabbage", Month.FEBRUARY, Month.OCTOBER, Month.DECEMBER),
                newVegetable("Carrots", Month.JANUARY, Month.DECEMBER),
                newVegetable("Cauliflower", Month.FEBRUARY, Month.OCTOBER),
                newFruit("Cherries", Month.MAY, Month.JUNE, Month.JULY),
                newVegetable("Corn", Month.JUNE, Month.JULY, Month.AUGUST),
                newFruit("Cranberries", Month.OCTOBER, Month.NOVEMBER),
                newVegetable("Cucumbers", Month.JUNE, Month.JULY),
                newVegetable("Eggplant", Month.JULY, Month.AUGUST),
                newVegetable("Fava beans", Month.MAY),
                newFruit("Figs", Month.AUGUST, Month.SEPTEMBER),
                newFruit("Grapefruits", Month.JANUARY, Month.FEBRUARY, Month.MARCH),
                newFruit("Grapes", Month.AUGUST, Month.SEPTEMBER, Month.OCTOBER),
                newVegetable("Green beans", Month.MAY, Month.JULY),
                newVegetable("Kale", Month.JANUARY, Month.SEPTEMBER, Month.DECEMBER),
                newFruit("Kumquats", Month.FEBRUARY),
                newVegetable("Leeks", Month.JANUARY, Month.NOVEMBER, Month.DECEMBER),
                newFruit("Lemons", Month.JANUARY, Month.MARCH),
                newVegetable("Lettuce", Month.APRIL),
                newFruit("Melons", Month.JULY, Month.AUGUST),
                newFruit("Nectarines", Month.JULY),
                newVegetable("New potatoes", Month.APRIL),
                newVegetable("Okra", Month.AUGUST),
                newFruit("Oranges", Month.JANUARY, Month.MARCH, Month.APRIL, Month.DECEMBER),
                newVegetable("Parsnips", Month.JANUARY, Month.NOVEMBER, Month.DECEMBER),
                newFruit("Peaches", Month.JUNE, Month.JULY, Month.AUGUST),
                newFruit("Pears", Month.JANUARY, Month.FEBRUARY, Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER),
                newVegetable("Peas", Month.APRIL, Month.MAY),
                newFruit("Persimmons", Month.NOVEMBER),
                newFruit("Plums", Month.JULY, Month.AUGUST, Month.SEPTEMBER),
                newFruit("Pomegranates", Month.JANUARY, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER),
                newVegetable("Pumpkins", Month.SEPTEMBER, Month.OCTOBER),
                newVegetable("Radishes", Month.MARCH, Month.APRIL),
                newVegetable("Ramps", Month.APRIL),
                newFruit("Raspberries", Month.JUNE, Month.JULY),
                newVegetable("Rhubarb", Month.MARCH, Month.APRIL, Month.MAY),
                newVegetable("Rutabagas", Month.FEBRUARY),
                newVegetable("Spinach", Month.MARCH),
                newVegetable("Spring onions", Month.MARCH),
                newFruit("Strawberries", Month.APRIL, Month.MAY, Month.JUNE),
                newVegetable("Summer squash", Month.JUNE),
                newVegetable("Sweet corn", Month.AUGUST),
                newVegetable("Sweet potatoes", Month.FEBRUARY, Month.SEPTEMBER, Month.NOVEMBER),
                newFruit("Tangerines", Month.DECEMBER),
                newFruit("Tomatoes", Month.JUNE, Month.JULY, Month.AUGUST),
                newVegetable("Turnips", Month.JANUARY, Month.OCTOBER),
                newVegetable("Winter squash", Month.JANUARY, Month.NOVEMBER),
                newVegetable("Zucchini", Month.MAY, Month.AUGUST)
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
                newVegetable("Pumpkins", Month.SEPTEMBER, Month.OCTOBER),
                newFruit("Pears", Month.JANUARY, Month.FEBRUARY, Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER),
                newFruit("Grapes", Month.AUGUST, Month.SEPTEMBER, Month.OCTOBER),
                newFruit("Apples", Month.JANUARY, Month.FEBRUARY, Month.MARCH, Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER),
                newVegetable("Winter squash", Month.JANUARY, Month.NOVEMBER),
                newVegetable("Kale", Month.JANUARY, Month.SEPTEMBER, Month.DECEMBER),
                newVegetable("Sweet potatoes", Month.FEBRUARY, Month.SEPTEMBER, Month.NOVEMBER),
                newVegetable("Beets", Month.SEPTEMBER),
                newFruit("Figs", Month.AUGUST, Month.SEPTEMBER),
                newFruit("Plums", Month.JULY, Month.AUGUST, Month.SEPTEMBER)
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