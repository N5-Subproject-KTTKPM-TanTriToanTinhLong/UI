package com.example.ui.service;

import com.example.ui.model.Customer;
import com.example.ui.vo.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private RestTemplate restTemplate;

    private String url = "https://n5-subprj-customer.herokuapp.com/api/customer";

    public List<ResponseTemplateVO> getAllCustomer() {
        ResponseEntity<List<ResponseTemplateVO>> responseEntity
                = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<ResponseTemplateVO>>() {
                });
        List<ResponseTemplateVO> customerList = responseEntity.getBody();
        return customerList;
    }

    public void saveCustomer(Customer customer){
        restTemplate.postForEntity(url, customer, String.class);
    }
}
