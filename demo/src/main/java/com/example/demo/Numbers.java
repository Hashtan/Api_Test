package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Numbers {

    private List<Integer> numbers;
    private String sortingType;
}
