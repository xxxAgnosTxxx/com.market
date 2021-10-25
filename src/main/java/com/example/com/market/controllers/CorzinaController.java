package com.example.com.market.controllers;

import com.example.com.market.models.Items;
import com.example.com.market.models.Orders;
import com.example.com.market.models.Users;
import com.example.com.market.repository.ItemRepository;
import com.example.com.market.repository.OrderRepository;
import com.example.com.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@Controller
public class CorzinaController {
    List<Items> corzina = new ArrayList<>();
    Users user;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/Corzina")
    public String getcorzina(Model model, @RequestParam String Item, @RequestParam String Sum, @RequestParam int UserId){
        user = userRepository.findById(UserId).get();
        model.addAttribute("user", user);
        if(Item.equals("")||Sum.equals("")) return "Cabinet";
        for (Items i : itemRepository.findAll())    if(i.getName().equals(Item)){
            if(i.getSum()<parseInt(Sum))  return "Cabinet";
            Items item = new Items(i.getId(), i.getName(), i.getPrice(), parseInt(Sum));
            corzina.add(item);
            break;
        }
        return "Cabinet";
    }

    @PostMapping("/Corzina")
    public String postcorzina(Model model, @RequestParam int UserId){
        try {
            if (user.getId() != UserId) {
                corzina.clear();
            }
            model.addAttribute("items", corzina);
            return "Corzina";
        }catch (NullPointerException e){
            user = userRepository.findById(UserId).get();
            return postcorzina(model, UserId);
        }
    }

        @GetMapping("/Offer")
        public String getoffer(Model model){
            for (Items i : corzina){
                Orders o = new Orders(i.getId(), user.getId(), i.getSum());
                orderRepository.save(o);
                Items item = itemRepository.findById(i.getId()).get();
                item.setSum(item.getSum()-i.getSum());
                itemRepository.save(item);
            }
            corzina.clear();
            return "Corzina";
        }

    @PostMapping("/Offer")
    public String postoffer(Model model, @RequestParam String name, @RequestParam int price, @RequestParam int sum){
        for (Items i : corzina){
            if(i.getName().equals(name)&&i.getSum()==sum&&i.getPrice()==price){
                corzina.remove(i);
                break;
            }
        }
        return postcorzina(model, user.getId());
    }
}
