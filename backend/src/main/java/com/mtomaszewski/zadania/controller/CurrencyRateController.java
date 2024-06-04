package com.mtomaszewski.zadania.controller;


import com.mtomaszewski.zadania.dto.Currency.CurrencyRequestDto;
import com.mtomaszewski.zadania.dto.Currency.CurrencyResponseDto;
import com.mtomaszewski.zadania.dto.Request.RequestResponseDto;
import com.mtomaszewski.zadania.service.CurrencyRateService;
import com.mtomaszewski.zadania.service.RequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currencies")
@RequiredArgsConstructor
@CrossOrigin("*")
@Validated
public class CurrencyRateController {

    private final CurrencyRateService currencyRateService;
    private final RequestService requestService;

    @PostMapping("/get-current-currency-value-command")
    public ResponseEntity<CurrencyResponseDto> getCurrentCurrencyValueCommand(@Valid @RequestBody CurrencyRequestDto currencyRequest){
        CurrencyResponseDto res = currencyRateService.getCurrentValueCommand(currencyRequest);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping("/requests")
    public ResponseEntity<List<RequestResponseDto>> getAllRequests(){
       List<RequestResponseDto> res = requestService.getAllRequests();
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
