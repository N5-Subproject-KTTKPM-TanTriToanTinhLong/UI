package com.example.ui.controller;

import com.example.ui.model.LoginRequest;
import com.example.ui.model.SignupRequest;
import com.example.ui.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping
    public String loginForm(Model model){
        model.addAttribute("account", new SignupRequest());
        return "login";
    }

    @PostMapping
    public String login(LoginRequest account){
        loginService.login(account);
        return "index";
    }
}
