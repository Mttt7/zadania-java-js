package com.mtomaszewski.zadania;

import com.mtomaszewski.zadania.model.Currency;
import com.mtomaszewski.zadania.repository.CurrencyRepository;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.mtomaszewski.zadania.service.serviceImpl.CurrencyServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class CurrencyServiceTest {

    @Mock
    private CurrencyRepository currencyRepository;

    @InjectMocks
    private CurrencyServiceImpl currencyService;

    @BeforeEach
    void setUp() {
        var currency = new Currency();
        currency.setCode("USD");
        when(currencyRepository.findByCode("USD")).thenReturn(Optional.of(currency));
        when(currencyRepository.findByCode("GBP")).thenReturn(Optional.empty());
        when(currencyRepository.save(any(Currency.class))).thenAnswer(invocation -> invocation.getArgument(0));
    }

    @Test
    public void getCurrencyByCode_found() {
        Currency foundCurrency = currencyService.getCurrencyByCode("USD");
        assertEquals("USD", foundCurrency.getCode());
        verify(currencyRepository, times(1)).findByCode("USD");
    }

    @Test
    public void getCurrencyByCode_notFound() {
        Currency newCurrency = currencyService.getCurrencyByCode("GBP");
        assertEquals("GBP", newCurrency.getCode());
        verify(currencyRepository, times(1)).findByCode("GBP");
        verify(currencyRepository, times(1)).save(any(Currency.class));
    }
}
