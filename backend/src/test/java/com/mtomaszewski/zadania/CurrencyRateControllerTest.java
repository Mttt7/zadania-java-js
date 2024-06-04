package com.mtomaszewski.zadania;

import com.mtomaszewski.zadania.controller.CurrencyRateController;
import com.mtomaszewski.zadania.dto.Currency.CurrencyRequestDto;
import com.mtomaszewski.zadania.dto.Currency.CurrencyResponseDto;
import com.mtomaszewski.zadania.service.CurrencyRateService;
import com.mtomaszewski.zadania.service.RequestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(CurrencyRateController.class)
public class CurrencyRateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CurrencyRateService currencyRateService;

    @MockBean
    private RequestService requestService;


    @Test
    void getCurrentCurrencyValueCommandTest() throws Exception {
        CurrencyResponseDto responseDto = CurrencyResponseDto
                .builder()
                .value(4.2954)
                .build();

        given(currencyRateService.getCurrentValueCommand(new CurrencyRequestDto("EUR", "Jan Nowak"))).willReturn(responseDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/currencies/get-current-currency-value-command")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"currency\":\"EUR\",\"name\":\"Jan Nowak\"}"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.value").value(4.2954));
    }
}
