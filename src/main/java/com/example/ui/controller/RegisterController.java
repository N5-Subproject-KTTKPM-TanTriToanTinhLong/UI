package com.example.ui.controller;

import com.example.ui.model.SignupRequest;
import com.example.ui.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping
    public String registerForm(Model model){
        model.addAttribute("account", new SignupRequest());
        return "register";
    }

    @PostMapping
    public String register(@ModelAttribute("account") SignupRequest account){
        Set<String> role = new HashSet<>();
        role.add("USER");
        account.setRole(role);
        registerService.register(account);
        return "login";
    }

}
