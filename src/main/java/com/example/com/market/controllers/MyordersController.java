package com.example.com.market.controllers;

import com.example.com.market.models.Items;
import com.example.com.market.models.ItemsInOrders;
import com.example.com.market.models.Orders;
import com.example.com.market.repository.ItemRepository;
import com.example.com.market.repository.OrderRepository;
import com.example.com.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyordersController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/Myorders")
    public String Myorders(Model model, @RequestParam int UserId){
        List<Orders> orders=new ArrayList<>();
        for(Orders o : orderRepository.findAll())   if(o.getUserId()==UserId)   orders.add(o);
        List<ItemsInOrders> inOrders = new ArrayList<>();
        for (Orders o : orders){
            ItemsInOrders temp = new ItemsInOrders();
            temp.setItemname(itemRepository.findById(o.getItemId()).get().getName());
            temp.setSum(o.getSum());
            temp.setPrice(itemRepository.findById(o.getItemId()).get().getPrice());
            temp.setTotal(temp.getPrice()*temp.getSum());
            temp.setUsername(UserId);
            inOrders.add(temp);
        }
        model.addAttribute("ListOrders", inOrders);
        return "Myorders";
    }
}
