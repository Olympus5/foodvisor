package fr.olympus5.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class HttpFoodService implements FoodService {
    private final RestTemplate restTemplate;

    @Autowired
    public HttpFoodService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<String> getSeasonalFoods(String season) {
        return restTemplate.exchange("/foods/seasonal/{season}",
                org.springframework.http.HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {},
                season).getBody();
    }
}
