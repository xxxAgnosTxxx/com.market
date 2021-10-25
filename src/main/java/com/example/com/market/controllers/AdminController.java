package com.example.com.market.controllers;

import com.example.com.market.models.Items;
import com.example.com.market.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/Admin")
    public String Admin(Model model){
        Iterable<Items> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "Admin";
    }

    @PostMapping("/Admin")
    public String postAdmin(Model model, @RequestParam String itemname){
        List<Items> items = new ArrayList<>();
        if(!itemname.equals(null)){
            for (Items i : itemRepository.findAll()){
                if(i.getName().equals(itemname)){
                    items.add(i);
                    model.addAttribute("items", items);
                    return "Admin";
                }
            }
            return "Admin";
        }
        return "Admin";
    }
}
