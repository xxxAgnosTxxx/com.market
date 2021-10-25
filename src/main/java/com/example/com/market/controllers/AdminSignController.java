package com.example.com.market.controllers;

import com.example.com.market.models.Items;
import com.example.com.market.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminSignController {
    private String login="admin";
    private String pass="admin";

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/AdminSign")
    public String adminsign(Model model){
        return "AdminSign";
    }

    @PostMapping("/AdminSign")
    public String postAdminsign(Model model, @RequestParam String Login, @RequestParam String Password){
        if(Login.equals(login)&&Password.equals(pass)){
            Iterable<Items> items = itemRepository.findAll();
            model.addAttribute("items", items);
            return "Admin";
        }
        else return "AdminSign";
    }
}
