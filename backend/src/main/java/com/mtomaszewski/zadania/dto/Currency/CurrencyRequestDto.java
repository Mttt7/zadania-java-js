package com.mtomaszewski.zadania.dto.Currency;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrencyRequestDto {

    @Pattern(regexp = "^[A-Z]{3}$", message = "Currency must consist of three uppercase letters")
    private String currency;

    @Pattern(regexp = "^[\\p{L}]+\\s+[\\p{L}]+$", message = "Name must contain first and last name separated by a space")
    private String name;
}
