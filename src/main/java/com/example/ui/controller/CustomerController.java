package com.example.ui.controller;

import com.example.ui.model.Customer;
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

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private FoodService foodService;
    @GetMapping
    public String getAllCustomer(@RequestParam(defaultValue = "1") Long id, Model model){
        model.addAttribute("customers", customerService.getAllCustomer());
        model.addAttribute("idFood", id);
        model.addAttribute("food", foodService.findFood(id));
        model.addAttribute("customer", new Customer());
        return "customer";
    }

    @PostMapping
    public String saveCustomer(Model model, Customer customer, @RequestParam(defaultValue = "1") Long idFood){
        System.out.println(idFood);
        customer.setFoodId(idFood);
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }
}
