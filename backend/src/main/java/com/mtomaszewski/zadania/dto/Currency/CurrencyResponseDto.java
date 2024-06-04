package com.mtomaszewski.zadania.dto.Currency;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class CurrencyResponseDto {
    Double value;

}
