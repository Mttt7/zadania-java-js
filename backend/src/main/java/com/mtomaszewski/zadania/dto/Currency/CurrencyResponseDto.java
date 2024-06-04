package com.mtomaszewski.zadania.dto.Currency;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CurrencyResponseDto {
    Double value;
}
