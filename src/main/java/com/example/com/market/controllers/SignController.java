package com.example.com.market.controllers;

import com.example.com.market.models.Users;
import com.example.com.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
public class SignController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/Sign")
    public String sign(Model model) {
        return "Sign";
    }

    @PostMapping("/Sign")
    public String postSign(@RequestParam String Surname,@RequestParam String Password, Model model) {
        if (Surname==""||Password=="")  return "Autorization";
        Iterable<Users> dbUsers = userRepository.findAll();
        for (Users u : dbUsers) {
            if (u.getSurname().equals(Surname) && u.getPassword().equals(Password)) {
                Users user = u;
                model.addAttribute("user", user);
                return "Cabinet";
            }
        }
        return "redirect:/Sign";
    }

}
