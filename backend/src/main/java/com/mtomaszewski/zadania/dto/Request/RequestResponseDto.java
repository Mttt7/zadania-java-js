package com.mtomaszewski.zadania.dto.Request;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class RequestResponseDto {

    private String currency;
    private String name;
    private Date date;
    private Double value;

}
