package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Api {

    private final testService service;

    @Autowired
    public Api (testService service){
        this.service = service;
    }

    @GetMapping("/numbers/status/ping")
    public String andrzejGrubba(){
        return service.getPong();
    }

    @GetMapping("/numbers/get")
    public Numbers getOne(){
        return service.getOne();
    }

    @PostMapping("numbers/sort-command")
    public List<Integer> sortingApi (@RequestBody Numbers numbers){
        return service.sorting(numbers);
    }

    @GetMapping("currencies/get-current-value-command")
    public Double getCurrencyApi (@RequestParam String currency) {
        return service.getCurrency(currency);
    }
}
