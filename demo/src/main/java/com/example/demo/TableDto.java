package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TableDto {

    private char table;
    private List <RatesDto> rates;
}
