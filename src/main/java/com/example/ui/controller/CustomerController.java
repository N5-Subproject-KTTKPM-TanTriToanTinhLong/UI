package com.example.ui.controller;

import com.example.ui.model.Customer;
import com.example.ui.model.Food;
import com.example.ui.service.CustomerService;
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

    @GetMapping
    public String getAllCustomer(@RequestParam(defaultValue = "1") Long id, Model model){
        model.addAttribute("customers", customerService.getAllCustomer());
        model.addAttribute("idFood", id);
        return "customer";
    }

    @PostMapping
    public String saveCustomer(Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }
}
