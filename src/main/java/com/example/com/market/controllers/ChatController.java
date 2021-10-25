package com.example.com.market.controllers;

import com.example.com.market.models.Chat;
import com.example.com.market.models.Users;
import com.example.com.market.repository.ChatRepository;
import com.example.com.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChatRepository chatRepository;

    private Users user;

    @GetMapping("/Chat")
    public String getChat(Model model, @RequestParam int UserId){
        user = userRepository.findById(UserId).get();
        List<Chat> chat = new ArrayList<>();
        for(Chat c : chatRepository.findAll())  if(c.getIduser()==UserId)   chat.add(c);
        model.addAttribute("chat", chat);
        return "Chat";
    }

    @PostMapping("/Chat")
    public String postChat(Model model, @RequestParam String Question){
        if(Question.equals("")) return getChat(model, user.getId());
        Chat chat = new Chat(user.getId(), Question, new java.util.Date());
        chatRepository.save(chat);
        List<Chat> chats = new ArrayList<>();
        for(Chat c : chatRepository.findAll())  if(c.getIduser()==user.getId())   chats.add(c);
        model.addAttribute("chat", chats);
        return "Chat";
    }
}
