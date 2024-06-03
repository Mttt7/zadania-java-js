package com.mtomaszewski.zadania.dto.Client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NbpApiResponse {
    private String table;
    private String no;
    private String effectiveDate;
    private List<Rate> rates;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Rate {
        private String currency;
        private String code;
        private Double mid;
    }
}