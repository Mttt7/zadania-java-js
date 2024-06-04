package com.mtomaszewski.zadania.service;

import com.mtomaszewski.zadania.dto.Currency.CurrencyRequestDto;
import com.mtomaszewski.zadania.dto.Currency.CurrencyResponseDto;
import com.mtomaszewski.zadania.model.Currency;

public interface CurrencyRateService {
    CurrencyResponseDto getCurrentValueCommand(CurrencyRequestDto currencyRequest);
}
