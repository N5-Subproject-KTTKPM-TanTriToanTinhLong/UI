package com.example.ui.service;

import com.example.ui.model.Customer;
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
public class CustomerService {

    @Autowired
    private RestTemplate restTemplate;

    private String url = "https://n5-subprj-foody.herokuapp.com/api/customer";

    public List<ResponseTemplateVO> getAllCustomer(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<ResponseTemplateVO> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<List<ResponseTemplateVO>> responseEntity
                = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<ResponseTemplateVO>>() {
                });
        List<ResponseTemplateVO> customerList = responseEntity.getBody();
        return customerList;
    }

    public void saveCustomer(Customer customer, String token){

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<Customer> httpEntity = new HttpEntity<>(customer, headers);

        restTemplate.postForEntity(url, httpEntity, String.class);
    }
}
