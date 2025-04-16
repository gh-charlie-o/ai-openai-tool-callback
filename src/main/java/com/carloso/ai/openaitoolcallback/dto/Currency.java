package com.carloso.ai.openaitoolcallback.dto;

import com.carloso.ai.openaitoolcallback.enums.CurrencyType;

public record Currency(CurrencyType type, String code, String name) {
}
