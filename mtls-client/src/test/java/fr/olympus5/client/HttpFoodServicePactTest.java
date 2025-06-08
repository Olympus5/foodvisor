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
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.time.Month;
import java.util.Arrays;
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
                .body(newJsonArray(a -> {
                    a.object(o -> {
                        o.stringType("name", "Apples");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("January");
                            m.stringValue("February");
                            m.stringValue("March");
                            m.stringValue("September");
                            m.stringValue("October");
                            m.stringValue("November");
                            m.stringValue("December");
                        });
                        o.stringType("family", "fruit");
                    });
                    a.object(o -> {
                        o.stringType("name", "Apricots");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("May");
                            m.stringValue("June");
                        });
                        o.stringType("family", "fruit");
                    });
                    a.object(o -> {
                        o.stringType("name", "Arugula");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("April");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Artichokes");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("March");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Asparagus");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("March");
                            m.stringValue("April");
                            m.stringValue("May");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Beets");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("September");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Bell peppers");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("June");
                            m.stringValue("August");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Blackberries");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("July");
                        });
                        o.stringType("family", "fruit");
                    });
                    a.object(o -> {
                        o.stringType("name", "Blood oranges");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("February");
                        });
                        o.stringType("family", "fruit");
                    });
                    a.object(o -> {
                        o.stringType("name", "Blueberries");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("June");
                            m.stringValue("July");
                        });
                        o.stringType("family", "fruit");
                    });
                    a.object(o -> {
                        o.stringType("name", "Broccoli");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("February");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Brussels sprouts");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("January");
                            m.stringValue("October");
                            m.stringValue("November");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Cabbage");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("February");
                            m.stringValue("October");
                            m.stringValue("December");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Carrots");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("January");
                            m.stringValue("December");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Cauliflower");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("February");
                            m.stringValue("October");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Cherries");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("May");
                            m.stringValue("June");
                            m.stringValue("July");
                        });
                        o.stringType("family", "fruit");
                    });
                    a.object(o -> {
                        o.stringType("name", "Corn");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("June");
                            m.stringValue("July");
                            m.stringValue("August");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Cranberries");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("October");
                            m.stringValue("November");
                        });
                        o.stringType("family", "fruit");
                    });
                    a.object(o -> {
                        o.stringType("name", "Cucumbers");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("June");
                            m.stringValue("July");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Eggplant");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("July");
                            m.stringValue("August");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Fava beans");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("May");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Figs");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("August");
                            m.stringValue("September");
                        });
                        o.stringType("family", "fruit");
                    });
                    a.object(o -> {
                        o.stringType("name", "Grapefruits");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("January");
                            m.stringValue("February");
                            m.stringValue("March");
                        });
                        o.stringType("family", "fruit");
                    });
                    a.object(o -> {
                        o.stringType("name", "Grapes");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("August");
                            m.stringValue("September");
                            m.stringValue("October");
                        });
                        o.stringType("family", "fruit");
                    });
                    a.object(o -> {
                        o.stringType("name", "Green beans");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("May");
                            m.stringValue("July");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Kale");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("January");
                            m.stringValue("September");
                            m.stringValue("December");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Kumquats");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("February");
                        });
                        o.stringType("family", "fruit");
                    });
                    a.object(o -> {
                        o.stringType("name", "Leeks");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("January");
                            m.stringValue("November");
                            m.stringValue("December");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Lemons");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("January");
                            m.stringValue("March");
                        });
                        o.stringType("family", "fruit");
                    });
                    a.object(o -> {
                        o.stringType("name", "Lettuce");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("April");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Melons");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("July");
                            m.stringValue("August");
                        });
                        o.stringType("family", "fruit");
                    });
                    a.object(o -> {
                        o.stringType("name", "Nectarines");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("July");
                        });
                        o.stringType("family", "fruit");
                    });
                    a.object(o -> {
                        o.stringType("name", "New potatoes");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("April");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Okra");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("August");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Oranges");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("January");
                            m.stringValue("March");
                            m.stringValue("April");
                            m.stringValue("December");
                        });
                        o.stringType("family", "fruit");
                    });
                    a.object(o -> {
                        o.stringType("name", "Parsnips");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("January");
                            m.stringValue("November");
                            m.stringValue("December");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Peaches");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("June");
                            m.stringValue("July");
                            m.stringValue("August");
                        });
                        o.stringType("family", "fruit");
                    });
                    a.object(o -> {
                        o.stringType("name", "Pears");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("January");
                            m.stringValue("February");
                            m.stringValue("September");
                            m.stringValue("October");
                            m.stringValue("November");
                            m.stringValue("December");
                        });
                        o.stringType("family", "fruit");
                    });
                    a.object(o -> {
                        o.stringType("name", "Peas");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("April");
                            m.stringValue("May");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Persimmons");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("November");
                        });
                        o.stringType("family", "fruit");
                    });
                    a.object(o -> {
                        o.stringType("name", "Plums");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("July");
                            m.stringValue("August");
                            m.stringValue("September");
                        });
                        o.stringType("family", "fruit");
                    });
                    a.object(o -> {
                        o.stringType("name", "Pomegranates");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("January");
                            m.stringValue("October");
                            m.stringValue("November");
                            m.stringValue("December");
                        });
                        o.stringType("family", "fruit");
                    });
                    a.object(o -> {
                        o.stringType("name", "Pumpkins");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("September");
                            m.stringValue("October");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Radishes");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("March");
                            m.stringValue("April");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Ramps");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("April");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Raspberries");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("June");
                            m.stringValue("July");
                        });
                        o.stringType("family", "fruit");
                    });
                    a.object(o -> {
                        o.stringType("name", "Rhubarb");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("March");
                            m.stringValue("April");
                            m.stringValue("May");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Rutabagas");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("February");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Spinach");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("March");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Spring onions");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("March");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Strawberries");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("April");
                            m.stringValue("May");
                            m.stringValue("June");
                        });
                        o.stringType("family", "fruit");
                    });
                    a.object(o -> {
                        o.stringType("name", "Summer squash");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("June");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Sweet corn");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("August");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Sweet potatoes");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("February");
                            m.stringValue("September");
                            m.stringValue("November");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Tangerines");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("December");
                        });
                        o.stringType("family", "fruit");
                    });
                    a.object(o -> {
                        o.stringType("name", "Tomatoes");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("June");
                            m.stringValue("July");
                            m.stringValue("August");
                        });
                        o.stringType("family", "fruit");
                    });
                    a.object(o -> {
                        o.stringType("name", "Turnips");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("January");
                            m.stringValue("October");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Winter squash");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("January");
                            m.stringValue("November");
                        });
                        o.stringType("family", "vegetable");
                    });
                    a.object(o -> {
                        o.stringType("name", "Zucchini");
                        o.array("consumptionMonths", m -> {
                            m.stringValue("May");
                            m.stringValue("August");
                        });
                        o.stringType("family", "vegetable");
                    });
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
                .body(newJsonArray(a -> a.stringValue("Pumpkins")
                        .stringValue("Pears")
                        .stringValue("Grapes")
                        .stringValue("Apples")
                        .stringValue("Squash")
                        .stringValue("Kale")
                        .stringValue("Sweet potatoes")
                        .stringValue("Beets")
                        .stringValue("Figs")
                        .stringValue("Plums")).build())
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
        List<String> expected = List.of("Pumpkins", "Pears", "Grapes", "Apples", "Squash", "Kale", "Sweet potatoes", "Beets", "Figs", "Plums");

        var foods = foodService.getSeasonalFoods(Month.SEPTEMBER);

        assertEquals(expected, foods);
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
}