package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ChatMessage;
import com.example.demo.repository.ChatMessageRepository;

import java.util.List;

@Service
public class ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    public List<ChatMessage> getAllChatMessages() {
        return chatMessageRepository.findAll();
    }

    public ChatMessage createChatMessage(ChatMessage chatMessage) {
        return chatMessageRepository.save(chatMessage);
    }

    public ChatMessage getChatMessageById(Long id) {
        return chatMessageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chat message not found with id: " + id));
    }

    public ChatMessage updateChatMessage(Long id, ChatMessage newChatMessage) {
        ChatMessage existingChatMessage = getChatMessageById(id);
        existingChatMessage.setChatRoom(newChatMessage.getChatRoom());
        existingChatMessage.setSender(newChatMessage.getSender());
        existingChatMessage.setRecipient(newChatMessage.getRecipient());
        existingChatMessage.setContent(newChatMessage.getContent());
        existingChatMessage.setTimeStamp(newChatMessage.getTimeStamp());
        return chatMessageRepository.save(existingChatMessage);
    }

    public void deleteChatMessage(Long id) {
        chatMessageRepository.deleteById(id);
    }
}
