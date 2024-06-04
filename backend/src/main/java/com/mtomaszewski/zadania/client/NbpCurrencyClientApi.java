package com.mtomaszewski.zadania.client;

import com.mtomaszewski.zadania.dto.Client.NbpApiResponse;
import com.mtomaszewski.zadania.exception.CurrencyNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class NbpCurrencyClientApi {

    private final RestTemplate restTemplate;

    public Double getCurrencyRate(String currencyCode){
        String url = "https://api.nbp.pl/api/exchangerates/tables/A?format=json";
        NbpApiResponse[] response = restTemplate.getForObject(url, NbpApiResponse[].class);
        if (response != null && response.length > 0) {
            for (NbpApiResponse.Rate rate : response[0].getRates()) {
                if (rate.getCode().equals(currencyCode)) {
                    return rate.getMid();
                }
            }
        }
        throw new CurrencyNotFound("Currency of code: '"+currencyCode+ "' not found!");
    }


}
