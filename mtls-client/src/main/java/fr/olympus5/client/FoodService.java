package fr.olympus5.client;

import java.time.Month;
import java.util.List;

public interface FoodService {
    List<String> getSeasonalFoods(Month september);
    List<Food> getAllFoods();
}
