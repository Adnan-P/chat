package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ChatRoom;
import com.example.demo.repository.ChatRoomRepository;

import java.util.List;

@Service
public class ChatRoomService {

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    public List<ChatRoom> getAllChatRooms() {
        return chatRoomRepository.findAll();
    }

    public ChatRoom createChatRoom(ChatRoom chatRoom) {
        return chatRoomRepository.save(chatRoom);
    }

    public ChatRoom getChatRoomById(Long id) {
        return chatRoomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chat room not found with id: " + id));
    }

    public ChatRoom updateChatRoom(Long id, ChatRoom newChatRoom) {
        ChatRoom existingChatRoom = getChatRoomById(id);
        existingChatRoom.setSender(newChatRoom.getSender());
        existingChatRoom.setRecipient(newChatRoom.getRecipient());
        return chatRoomRepository.save(existingChatRoom);
    }

    public void deleteChatRoom(Long id) {
        chatRoomRepository.deleteById(id);
    }
}
