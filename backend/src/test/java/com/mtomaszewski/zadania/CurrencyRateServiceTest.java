package com.mtomaszewski.zadania;
import com.mtomaszewski.zadania.client.NbpCurrencyClientApi;
import com.mtomaszewski.zadania.dto.Currency.CurrencyRequestDto;
import com.mtomaszewski.zadania.dto.Currency.CurrencyResponseDto;
import com.mtomaszewski.zadania.service.RequestService;

import com.mtomaszewski.zadania.service.serviceImpl.CurrencyRateServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CurrencyRateServiceTest {

    @InjectMocks
    private CurrencyRateServiceImpl currencyRateService;
    @Mock
    private NbpCurrencyClientApi nbpCurrencyClientApi;

    @Mock
    private RequestService requestService;

    @BeforeEach
    public void setUp() {
        when(nbpCurrencyClientApi.getCurrencyRate("USD")).thenReturn(12.34);
    }

    @Test
    public void getCurrentValueCommand() {
        CurrencyRequestDto currencyRequest = new CurrencyRequestDto("USD", "John Snow");
        CurrencyResponseDto response =  currencyRateService.getCurrentValueCommand(currencyRequest);

        assertEquals(12.34, response.getValue());
        verify(nbpCurrencyClientApi, times(1)).getCurrencyRate("USD");
        verify(requestService, times(1)).saveRequestToDb(currencyRequest, 12.34);
    }
}
