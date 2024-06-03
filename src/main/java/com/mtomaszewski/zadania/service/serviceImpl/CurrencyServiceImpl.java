package com.mtomaszewski.zadania.service.serviceImpl;

import com.mtomaszewski.zadania.client.NbpCurrencyClientApi;
import com.mtomaszewski.zadania.dto.Currency.CurrencyRequestDto;
import com.mtomaszewski.zadania.dto.Currency.CurrencyResponseDto;
import com.mtomaszewski.zadania.mapper.CurrencyMapper;
import com.mtomaszewski.zadania.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final NbpCurrencyClientApi nbpCurrencyClientApi;
    @Override
    public CurrencyResponseDto getCurrentValueCommand(CurrencyRequestDto currencyRequest) {
        Double rate = nbpCurrencyClientApi.getCurrencyRate(currencyRequest.getCurrency());
        return CurrencyMapper.mapToCurrencyResponseDto(currencyRequest.getName(),rate);
    }
}
