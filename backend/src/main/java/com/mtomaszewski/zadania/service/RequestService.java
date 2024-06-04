package com.mtomaszewski.zadania.service;

import com.mtomaszewski.zadania.dto.Currency.CurrencyRequestDto;
import com.mtomaszewski.zadania.dto.Request.RequestResponseDto;

import java.util.List;

public interface RequestService {
    void saveRequestToDb(CurrencyRequestDto currencyRequest, Double rate);
    List<RequestResponseDto> getAllRequests();
}
