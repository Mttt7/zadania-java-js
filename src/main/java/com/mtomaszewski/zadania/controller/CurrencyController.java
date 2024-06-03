package com.mtomaszewski.zadania.controller;


import com.mtomaszewski.zadania.dto.Currency.CurrencyRequestDto;
import com.mtomaszewski.zadania.dto.Currency.CurrencyResponseDto;
import com.mtomaszewski.zadania.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currencies")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CurrencyController {

    private final CurrencyService currencyService;

    @PostMapping("/get-current-currency-value-command")
    public ResponseEntity<CurrencyResponseDto> getCurrentCurrencyValueCommand(@RequestBody CurrencyRequestDto currencyRequest){
        CurrencyResponseDto res = currencyService.getCurrentValueCommand(currencyRequest);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
