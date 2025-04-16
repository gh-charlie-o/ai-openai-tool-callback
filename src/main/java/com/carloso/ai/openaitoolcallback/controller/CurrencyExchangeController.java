package com.carloso.ai.openaitoolcallback.controller;

import com.carloso.ai.openaitoolcallback.dto.Currencies;
import com.carloso.ai.openaitoolcallback.dto.CurrencyExchangeResponse;
import com.carloso.ai.openaitoolcallback.service.AlphavantageSvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
    private final AlphavantageSvc alphavantageSvc;
    private final Currencies currencies;

    public CurrencyExchangeController(final AlphavantageSvc alphavantageSvc,
                                      final Currencies currencies) {
        this.alphavantageSvc = alphavantageSvc;
        this.currencies = currencies;
    }

    @GetMapping("/exchange-rate/{from}/{to}")
    @ResponseBody CurrencyExchangeResponse getExchangeRateData(@PathVariable String from, @PathVariable String to) {
        return this.alphavantageSvc.getExchangeRateData(from, to);
    }

    @GetMapping("/currencies")
    @ResponseBody
    Currencies getCurrencies() {
        return this.alphavantageSvc.getCurrencies();
    }
}
