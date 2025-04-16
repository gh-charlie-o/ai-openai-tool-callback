package com.carloso.ai.openaitoolcallback.service;

import com.carloso.ai.openaitoolcallback.dto.Currencies;
import com.carloso.ai.openaitoolcallback.dto.CurrencyExchangeResponse;

public interface AlphavantageSvc {
    CurrencyExchangeResponse getExchangeRateData(final String from, String to);
    Currencies getCurrencies();
}
