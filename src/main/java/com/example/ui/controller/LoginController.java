package com.example.ui.controller;

import com.example.ui.model.JwtResponse;
import com.example.ui.model.LoginRequest;
import com.example.ui.model.SignupRequest;
import com.example.ui.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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
    public String login(LoginRequest account, HttpSession session){
        ResponseEntity<JwtResponse> jwt = loginService.login(account);
        session.setAttribute("token", jwt.getBody().getToken());
        session.setAttribute("username", jwt.getBody().getUsername());
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("token");
        session.removeAttribute("username");
        return "redirect:/login";
    }
}
