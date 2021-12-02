package com.example.ui.service;

import com.example.ui.model.Food;
import com.example.ui.vo.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private RestTemplate restTemplate;

    private String url = "https://n5-subprj-foody.herokuapp.com/api/food";

    public List<Food> getAllFoods(String token) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<ResponseTemplateVO> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<List<Food>> responseEntity
                = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<Food>>() {
                });
        List<Food> foodList = responseEntity.getBody();
        return foodList;
    }

    public void saveFood(Food food, String token){

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<Food> httpEntity = new HttpEntity<>(food, headers);

        restTemplate.postForEntity(url, httpEntity, String.class);
    }

    public Food findFood(Long id, String token){

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<ResponseTemplateVO> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<Food> responseEntity
                = restTemplate.exchange(url + "/" + id, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<Food>() {
                });
        Food food = responseEntity.getBody();
        return food;
    }

}
