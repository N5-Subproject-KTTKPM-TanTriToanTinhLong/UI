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

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private FoodService foodService;

    @GetMapping
    public String getAllCustomer(@RequestParam(defaultValue = "1") Long id, Model model, HttpSession session) {
        String token = (String) session.getAttribute("token");
        try {
            model.addAttribute("customers", customerService.getAllCustomer(token));
        }catch (Exception e){
            return "redirect:/login";
        }
        model.addAttribute("idFood", id);

        try {
            model.addAttribute("food", foodService.findFood(id, token));
        }catch (Exception e){
            model.addAttribute("food", null);
        }

        model.addAttribute("customer", new Customer());
        return "customer";
    }

    @PostMapping
    public String saveCustomer(Model model, Customer customer
            , HttpSession session
            , @RequestParam(defaultValue = "1") Long idFood) {
        String token = (String) session.getAttribute("token");

        customer.setFoodId(idFood);
        customerService.saveCustomer(customer, token);
        return "redirect:/customers";
    }
}
