package com.example.ui.service;

import com.example.ui.model.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {

    @Autowired
    private RestTemplate restTemplate;

    private String url = "https://n5-subprj-foody.herokuapp.com/auth/login";

    public void login(LoginRequest acc){
        restTemplate.postForEntity(url, acc, String.class);
    }
}
