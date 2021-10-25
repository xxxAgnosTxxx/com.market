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
public class ItemchangingController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/Itemchanging")
    public String itemchanging(Model model){
        return "Itemchanging";
    }

    @PostMapping("/Itemchanging")
    public String postchange(Model model, @RequestParam String id, @RequestParam String Price, @RequestParam String Sum){
          if (id=="")  return "Itemchanging";
          Items item = itemRepository.findById(parseInt(id)).get();
          if(Price!="")    item.setPrice(parseInt(Price));
          if (Sum!="")     item.setSum(parseInt(Sum));
          itemRepository.save(item);
          return "Itemchanging";
    }
}
