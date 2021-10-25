package com.example.com.market.controllers;

import com.example.com.market.models.AllEntities;
import com.example.com.market.models.Orders;
import com.example.com.market.repository.ItemRepository;
import com.example.com.market.repository.OrderRepository;
import com.example.com.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AllordersController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/Allorders")
    private String allorder(Model model){
        List<AllEntities> allEntitiesList = new ArrayList<>();
        for (Orders o : orderRepository.findAll()){
            AllEntities temp = new AllEntities();
            temp.setName(userRepository.findById(o.getUserId()).get().getName());
            temp.setSurname(userRepository.findById(o.getUserId()).get().getSurname());
            temp.setItemname(itemRepository.findById(o.getItemId()).get().getName());
            temp.setSum(o.getSum());
            temp.setTotal(temp.getSum()*itemRepository.findById(o.getItemId()).get().getPrice());
            allEntitiesList.add(temp);
        }
        model.addAttribute("model", allEntitiesList);
        return "Allorders";
    }
}
