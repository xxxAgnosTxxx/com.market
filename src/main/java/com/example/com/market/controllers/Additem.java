package com.example.com.market.controllers;

import com.example.com.market.models.Items;
import com.example.com.market.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static java.lang.Integer.parseInt;

@Controller
public class Additem {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/Additem")
    public String additem(Model model){
        return "Additem";
    }

    @PostMapping("/Additem")
    public String postadd(Model model, @RequestParam String Name, @RequestParam String Price, @RequestParam String Sum){
        if (Name==null||Price==null||Sum==null) return "Additem";
        Items item = new Items(Name, parseInt(Price), parseInt(Sum));
        itemRepository.save(item);
        return "Additem";
    }
}
