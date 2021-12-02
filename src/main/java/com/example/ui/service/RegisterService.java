package com.example.ui.service;

import com.example.ui.model.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RegisterService {

    @Autowired
    private RestTemplate restTemplate;

    private String url = "https://n5-subprj-foody.herokuapp.com/auth/register";

    public void register(SignupRequest signupRequest){
        restTemplate.postForEntity(url, signupRequest, String.class);
    }
}
