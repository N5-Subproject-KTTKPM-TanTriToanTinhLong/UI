package com.example.ui.service;

import com.example.ui.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private RestTemplate restTemplate;

    private String url = "https://n5-subprj-food.herokuapp.com/api/food";

    public List<Food> getAllFoods() {
        ResponseEntity<List<Food>> responseEntity
                = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Food>>() {
                });
        List<Food> foodList = responseEntity.getBody();
        return foodList;
    }

    public void saveFood(Food food){
        restTemplate.postForEntity(url, food, String.class);
    }

    public Food findFood(Long id){
        Food food = restTemplate.getForObject(url + "/" + id, Food.class);
        return food;
    }

}
