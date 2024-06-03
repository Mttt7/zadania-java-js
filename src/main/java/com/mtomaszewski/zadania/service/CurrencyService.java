package com.mtomaszewski.zadania.service;

import com.mtomaszewski.zadania.dto.Currency.CurrencyRequestDto;
import com.mtomaszewski.zadania.dto.Currency.CurrencyResponseDto;

import java.util.List;

public interface CurrencyService {
    CurrencyResponseDto getCurrentValueCommand(CurrencyRequestDto currencyRequest);
}
