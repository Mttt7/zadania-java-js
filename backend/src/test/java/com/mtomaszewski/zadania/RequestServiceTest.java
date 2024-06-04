package com.mtomaszewski.zadania;


import com.mtomaszewski.zadania.dto.Request.RequestResponseDto;
import com.mtomaszewski.zadania.model.Currency;
import com.mtomaszewski.zadania.model.User;
import com.mtomaszewski.zadania.service.CurrencyService;
import com.mtomaszewski.zadania.service.UserService;
import com.mtomaszewski.zadania.service.serviceImpl.RequestServiceImpl;
import org.springframework.boot.test.context.SpringBootTest;
import com.mtomaszewski.zadania.dto.Currency.CurrencyRequestDto;
import com.mtomaszewski.zadania.repository.RequestRepository;
import com.mtomaszewski.zadania.model.Request;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

import java.util.List;

@SpringBootTest
public class RequestServiceTest {

    @InjectMocks
    private RequestServiceImpl requestService;

    @Mock
    private UserService userService;

    @Mock
    private RequestRepository requestRepository;

    @Mock
    private CurrencyService currencyService;

    @BeforeEach
    void setUp() {
        User user = new User();
        user.setName("John Snow");
        when(userService.getUserByName(anyString())).thenReturn(user);

        Currency currency = new Currency();
        currency.setCode("USD");
        when(currencyService.getCurrencyByCode(anyString())).thenReturn(currency);

        when(requestRepository.save(any(Request.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Request request = new Request();
        request.setUser(user);
        request.setCurrency(currency);
        request.setRate(3.520);
        when(requestRepository.findAll()).thenReturn(Arrays.asList(request));
    }

    @Test
    void saveRequestToDb() {
        CurrencyRequestDto currencyRequest = new CurrencyRequestDto("USD","John Snow");
        double rate = 3.520;

        requestService.saveRequestToDb(currencyRequest, rate);

        verify(userService, times(1)).getUserByName(anyString());
        verify(currencyService, times(1)).getCurrencyByCode(anyString());
        verify(requestRepository, times(1)).save(any(Request.class));
    }

    @Test
    void getAllRequests() {
        List<RequestResponseDto> requests = requestService.getAllRequests();

        assertEquals(1, requests.size());
        verify(requestRepository, times(1)).findAll();
    }
}
