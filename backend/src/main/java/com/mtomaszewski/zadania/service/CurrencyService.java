package com.mtomaszewski.zadania.service;

import com.mtomaszewski.zadania.model.Currency;

public interface CurrencyService {
    Currency getCurrencyByCode(String code);
}
