package com.mtomaszewski.zadania.service.serviceImpl;


import com.mtomaszewski.zadania.model.Currency;
import com.mtomaszewski.zadania.repository.CurrencyRepository;
import com.mtomaszewski.zadania.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    @Override
    public Currency getCurrencyByCode(String code) {
        return currencyRepository.findByCode(code).orElseGet(
                ()->createNewCurrency(code)
        );
    }

    private Currency createNewCurrency(String code) {
        Currency currency = new Currency();
        currency.setCode(code);
        return currencyRepository.save(currency);
    }
}
