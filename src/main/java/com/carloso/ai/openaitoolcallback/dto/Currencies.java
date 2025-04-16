package com.carloso.ai.openaitoolcallback.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Currencies {
    private List<Currency> physical;
    private List<Currency> digital;

    public List<Currency> getAllCurrencies() {
        List<Currency> allCurrencies = new ArrayList<>();

        if (physical != null) {
            allCurrencies.addAll(physical);
        }

        if (digital != null) {
            allCurrencies.addAll(digital);
        }

        return allCurrencies;

    }

}
