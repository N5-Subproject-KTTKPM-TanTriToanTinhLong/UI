package com.example.ui.controller;

import com.example.ui.model.Food;
import com.example.ui.service.CustomerService;
import com.example.ui.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String getAllFood(Model model, HttpSession session){
        String token = (String) session.getAttribute("token");
        try {
            model.addAttribute("foods", foodService.getAllFoods(token));
        }catch (Exception e){
            return "redirect:/login";
        }

        model.addAttribute("food", new Food());
        return "food";
    }

    @PostMapping
    public String saveFood(Food food, HttpSession session){
        String token = (String) session.getAttribute("token");
        foodService.saveFood(food, token);
        return "redirect:/foods";
    }
}
