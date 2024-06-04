package com.mtomaszewski.zadania.service.serviceImpl;

import com.mtomaszewski.zadania.client.NbpCurrencyClientApi;
import com.mtomaszewski.zadania.dto.Currency.CurrencyRequestDto;
import com.mtomaszewski.zadania.dto.Currency.CurrencyResponseDto;
import com.mtomaszewski.zadania.mapper.CurrencyMapper;
import com.mtomaszewski.zadania.model.Currency;
import com.mtomaszewski.zadania.service.CurrencyRateService;
import com.mtomaszewski.zadania.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyRateServiceImpl implements CurrencyRateService {

    private final NbpCurrencyClientApi nbpCurrencyClientApi;
    private final RequestService requestService;
    @Override
    public CurrencyResponseDto getCurrentValueCommand(CurrencyRequestDto currencyRequest) {
        Double rate = nbpCurrencyClientApi.getCurrencyRate(currencyRequest.getCurrency());
        requestService.saveRequestToDb(currencyRequest, rate);

        return CurrencyMapper.mapToCurrencyResponseDto(rate);
    }


}
