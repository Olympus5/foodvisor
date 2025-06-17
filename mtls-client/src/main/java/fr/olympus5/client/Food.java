package fr.olympus5.client;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.Month;
import java.util.Collections;
import java.util.List;

public record Food(String name, String family, @JsonDeserialize(contentUsing = MonthDeserializer.class) List<Month> consumptionMonths) {
    public Food(String name, String family, List<Month> consumptionMonths) {
        this.name = name;
        this.family = family;
        this.consumptionMonths = Collections.unmodifiableList(consumptionMonths);
    }
}
