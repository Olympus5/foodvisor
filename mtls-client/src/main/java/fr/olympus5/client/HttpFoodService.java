package fr.olympus5.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Arrays;
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
        return Arrays.asList(restTemplate.getForObject("/foods/seasonal/{month}",
                Food[].class,
                month.getDisplayName(TextStyle.FULL, Locale.ENGLISH).toLowerCase()));
    }

    @Override
    public List<Food> getAllFoods() {
        return Arrays.asList(restTemplate.getForObject("/foods", Food[].class));
    }
}
