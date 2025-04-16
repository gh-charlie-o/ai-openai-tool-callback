package com.carloso.ai.openaitoolcallback.service;

import com.carloso.ai.openaitoolcallback.client.AlphavantageHttpClient;
import com.carloso.ai.openaitoolcallback.dto.Currencies;
import com.carloso.ai.openaitoolcallback.dto.CurrencyExchangeResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AlphavantageSvcImpl implements AlphavantageSvc {
    @Value("${app.alphavantage.api-key}")
    private String apikey;

    private final Currencies currencies;

    private final AlphavantageHttpClient alphavantageHttpClient;

    public AlphavantageSvcImpl(final Currencies currencies,
                               final AlphavantageHttpClient alphavantageHttpClient) {
        this.currencies = currencies;
        this.alphavantageHttpClient = alphavantageHttpClient;
    }

    @Override
    public CurrencyExchangeResponse getExchangeRateData(String from, String to) {
        return this.alphavantageHttpClient.getExchangeRateData(from, to, this.apikey);
    }

    @Override
    public Currencies getCurrencies() {
        return currencies;
    }


}
