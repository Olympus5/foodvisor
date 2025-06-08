package fr.olympus5.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

@Service
public class HttpFoodService implements FoodService {
    private final RestTemplate restTemplate;

    @Autowired
    public HttpFoodService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Food> getSeasonalFoods(Month month) {
        return restTemplate.exchange("/foods/seasonal/{month}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Food>>() {
                },
                month.getDisplayName(TextStyle.FULL, Locale.ENGLISH).toLowerCase()).getBody();
    }

    @Override
    public List<Food> getAllFoods() {
        return restTemplate.exchange("/foods",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Food>>() {
                }).getBody();
    }
}
