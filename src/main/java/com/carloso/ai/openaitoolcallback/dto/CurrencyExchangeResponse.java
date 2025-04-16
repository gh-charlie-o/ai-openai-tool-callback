package com.carloso.ai.openaitoolcallback.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CurrencyExchangeResponse(
    @JsonProperty("Realtime Currency Exchange Rate")
    ExchangeRateData exchangeRateData) { }