package com.example.com.market.controllers;

import com.example.com.market.models.Users;
import com.example.com.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CabinetController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/Cabinet")
    public String cabinet(Model model, @RequestParam int UserId) {
        Users user = userRepository.findById(UserId).get();
        model.addAttribute("user", user);
        return "Cabinet";
    }
}
