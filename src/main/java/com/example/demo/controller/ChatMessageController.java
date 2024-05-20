package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ChatMessage;
import com.example.demo.service.ChatMessageService;

import java.util.List;

@RestController
@RequestMapping("/api/chatmessages")
public class ChatMessageController {

    @Autowired
    private ChatMessageService chatMessageService;

    @GetMapping
    public List<ChatMessage> getAllChatMessages() {
        return chatMessageService.getAllChatMessages();
    }

    @PostMapping
    public ChatMessage createChatMessage(@RequestBody ChatMessage chatMessage) {
        return chatMessageService.createChatMessage(chatMessage);
    }

    @GetMapping("/{id}")
    public ChatMessage getChatMessageById(@PathVariable Long id) {
        return chatMessageService.getChatMessageById(id);
    }

    @PutMapping("/{id}")
    public ChatMessage updateChatMessage(@PathVariable Long id, @RequestBody ChatMessage chatMessage) {
        return chatMessageService.updateChatMessage(id, chatMessage);
    }

    @DeleteMapping("/{id}")
    public void deleteChatMessage(@PathVariable Long id) {
        chatMessageService.deleteChatMessage(id);
    }
}
