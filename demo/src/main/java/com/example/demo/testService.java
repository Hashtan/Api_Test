package com.example.demo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
@Slf4j
public class testService {

    private static final String NBP_API_URL = "http://api.nbp.pl/api/exchangerates/tables/A?format=json";

    public String getPong(){
        return "pong";
    }

    public List<Integer> sorting (Numbers numbers){
        if (Objects.equals(numbers.getSortingType(), "ASC")){
            Collections.sort(numbers.getNumbers());
            return numbers.getNumbers();
        }
        else if (Objects.equals(numbers.getSortingType(), "DESC")){
            Collections.sort(numbers.getNumbers());
            Collections.reverse(numbers.getNumbers());
            return numbers.getNumbers();
        }
        else {
            System.out.println("Błędne dane");
            return null;
        }
    }

    public Double getCurrency(String currency){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TableDto[]> forEntity = restTemplate.getForEntity(NBP_API_URL, TableDto[].class);
        TableDto[] body = forEntity.getBody();
        assert body != null;
        List<Double> table = Arrays.stream(body)
                .map(TableDto::getRates)
                .flatMap(Collection::stream)
                .filter(e -> Objects.equals(e.getCode(), currency))
                .map(RatesDto::getMid).toList();
       return table.get(0);
    }

    public Numbers getOne(){
        return new Numbers(initialize(), "ASC");

    }
    public List<Integer> initialize (){
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(10);
        list.add(1);
        return list;
    }
}