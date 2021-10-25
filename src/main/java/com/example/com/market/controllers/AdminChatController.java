package com.example.com.market.controllers;

import com.example.com.market.models.Chat;
import com.example.com.market.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static java.lang.Integer.parseInt;

@Controller
public class AdminChatController {
    @Autowired
    private ChatRepository chatRepository;

    @GetMapping("/AdminChat")
    public String getChat(Model model){
        Iterable<Chat> chat = chatRepository.findAll();
        model.addAttribute("chat", chat);
        return "AdminChat";
    }

    @PostMapping("/AdminChat")
    public String postChat(Model model, @RequestParam String num, @RequestParam String Answer){
        if(num.equals("")||Answer.equals(""))   return getChat(model);
        for(Chat c : chatRepository.findAll())  if(c.getId()==parseInt(num)) {
            Chat chat = chatRepository.findById(parseInt(num)).get();
            chat.setAnswer(Answer);
            chatRepository.save(chat);
            Iterable<Chat> chats = chatRepository.findAll();
            model.addAttribute("chat", chats);
            return "AdminChat";
        }
        return getChat(model);
    }
}
