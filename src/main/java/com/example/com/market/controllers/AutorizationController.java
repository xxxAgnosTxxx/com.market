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
public class AutorizationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/Autorization")
    public String autorize(Model model){
        return "Autorization";
    }

    @PostMapping("/Autorization")
    public String postAutorize(@Valid @RequestParam String Name, @Valid @RequestParam String Surname, @Valid @RequestParam String Password, Model model){
        if (Name==""||Surname==""||Password=="")  return "Autorization";
        Iterable<Users> users = userRepository.findAll();
        for(Users u : users){
            if(u.getName().equals(Name)&&u.getSurname().equals(Surname)&&u.getPassword().equals(Password)){
                model.addAttribute("user", u);
                return "Cabinet";
            }
        }
        Users user = new Users(Name, Surname, Password);
        userRepository.save(user);
        model.addAttribute("user", user);
        return "Cabinet";
    }
}
