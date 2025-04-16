package com.carloso.ai.openaitoolcallback.config;

import com.carloso.ai.openaitoolcallback.dto.Currencies;
import com.carloso.ai.openaitoolcallback.dto.Currency;
import com.carloso.ai.openaitoolcallback.enums.CurrencyType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Configuration
public class CurrencyConfig {
    @Value("classpath:currency/digital_currency_list.csv")
    private Resource digitalCurrenciesFile;

    @Value("classpath:currency/physical_currency_list.csv")
    private Resource physicalCurrenciesFile;

    @Bean
    public Currencies buildCurrencies() throws IOException {
        final List<Currency> digital = new ArrayList<>();

        // Digital currencies
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(digitalCurrenciesFile.getInputStream()))) {
            // Skip header
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    digital.add(new Currency(CurrencyType.DIGITAL, parts[0], parts[1]));
                }
            }

            digital.sort(Comparator.comparing(Currency::code));
        }

        // Physical currencies
        final List<Currency> physical = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(physicalCurrenciesFile.getInputStream()))) {
            // Skip header
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    physical.add(new Currency(CurrencyType.PHYSICAL, parts[0], parts[1]));
                }
            }

            physical.sort(Comparator.comparing(Currency::code));
        }

        final Currencies currencies = new Currencies();
        currencies.setDigital(digital);
        currencies.setPhysical(physical);

        return currencies;
    }

}
