package com.mtomaszewski.zadania.mapper;


import com.mtomaszewski.zadania.dto.Currency.CurrencyResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyMapper {

    public static CurrencyResponseDto mapToCurrencyResponseDto(String name, Double rate){
        return CurrencyResponseDto
                .builder()
                .name(name)
                .value(rate)
                .build();
    }


}
