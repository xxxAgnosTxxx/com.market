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
public class IndexController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/")
    public String index(Model model){
        Iterable<Items> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "index";
    }

    @PostMapping("/")
    public String postindex(Model model, @RequestParam String btn, @RequestParam String itemname) {
        List<Items> items = new ArrayList<>();
        if (btn.equals("low")) {
            for(Items i : itemRepository.findAll()) items.add(i);
            for (int i = 1; i<items.size(); i++){
                int j=i-1;
                Items tmp = items.get(i);
                while (j>=0&&items.get(j).getPrice()>tmp.getPrice()){
                    items.set(j+1, items.get(j));
                    j-=1;
                }
                items.set(j+1,tmp);
            }
            model.addAttribute("items", items);
            return "index";
        }
        else if(btn.equals("high")){
            for(Items i : itemRepository.findAll()) items.add(i);
            for (int i = 1; i<items.size(); i++){
                int j=i-1;
                Items tmp = items.get(i);
                while (j>=0&&items.get(j).getPrice()<tmp.getPrice()){
                    items.set(j+1, items.get(j));
                    j-=1;
                }
                items.set(j+1,tmp);
            }
            model.addAttribute("items", items);
            return "index";
        }
        else if(btn.equals("search")){
            if(!itemname.equals(null)){
                for (Items i : itemRepository.findAll()){
                    if(i.getName().equals(itemname)){
                        items.add(i);
                        model.addAttribute("items", items);
                        return "index";
                    }
                }
                return "index";
            }
            return "index";
        }
        return "index";
    }
}