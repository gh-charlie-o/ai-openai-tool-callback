package com.carloso.ai.openaitoolcallback.client;

import com.carloso.ai.openaitoolcallback.dto.CurrencyExchangeResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface AlphavantageHttpClient {

    @GetExchange("/query?function=CURRENCY_EXCHANGE_RATE&from_currency={from}&to_currency={to}&apikey={apikey}")
    CurrencyExchangeResponse getExchangeRateData(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable String apikey);
}
