package com.mtomaszewski.zadania.service.serviceImpl;

import com.mtomaszewski.zadania.dto.Currency.CurrencyRequestDto;
import com.mtomaszewski.zadania.dto.Request.RequestResponseDto;
import com.mtomaszewski.zadania.mapper.RequestMapper;
import com.mtomaszewski.zadania.model.Currency;
import com.mtomaszewski.zadania.model.Request;
import com.mtomaszewski.zadania.model.User;
import com.mtomaszewski.zadania.repository.RequestRepository;
import com.mtomaszewski.zadania.service.CurrencyRateService;
import com.mtomaszewski.zadania.service.CurrencyService;
import com.mtomaszewski.zadania.service.RequestService;
import com.mtomaszewski.zadania.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {

    private final UserService userService;
    private final RequestRepository requestRepository;
    private final CurrencyService currencyService;
    @Override
    public void saveRequestToDb(CurrencyRequestDto currencyRequest, Double rate) {
        User user = userService.getUserByName(currencyRequest.getName());
        Currency currency = currencyService.getCurrencyByCode(currencyRequest.getCurrency());

        Request request = new Request();
        request.setCurrency(currency);
        request.setUser(user);
        request.setRate(rate);

        requestRepository.save(request);
    }

    @Override
    public List<RequestResponseDto> getAllRequests() {
        List<Request> requests = requestRepository.findAll();

        return requests.stream().map(RequestMapper::mapToRequestResponseDto).collect(Collectors.toList());

    }


}
