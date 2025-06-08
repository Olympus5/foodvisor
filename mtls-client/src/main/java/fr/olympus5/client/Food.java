package fr.olympus5.client;

import java.util.Collections;
import java.util.List;

public record Food(String name, String family, List<String> consumptionMonths) {
    public Food(String name, String family, List<String> consumptionMonths) {
        this.name = name;
        this.family = family;
        this.consumptionMonths = Collections.unmodifiableList(consumptionMonths);
    }
}
