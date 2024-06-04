package com.mtomaszewski.zadania.mapper;

import com.mtomaszewski.zadania.dto.Request.RequestResponseDto;
import com.mtomaszewski.zadania.model.Request;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestMapper {

    public static RequestResponseDto mapToRequestResponseDto(Request request){
        return RequestResponseDto.builder()
                .currency(request.getCurrency().getCode())
                .name(request.getUser().getName())
                .date(request.getCreatedAt())
                .value(request.getRate())
                .build();
    }
}
