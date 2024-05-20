package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatId;

    @ManyToOne
    @JoinColumn(name = "senderId")
    private Users sender;

    @ManyToOne
    @JoinColumn(name = "recipientId")
    private Users recipient;

    // Constructors
    public ChatRoom() {}

    // Getters and setters
    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public Users getSender() {
        return sender;
    }

    public void setSender(Users sender) {
        this.sender = sender;
    }

    public Users getRecipient() {
        return recipient;
    }

    public void setRecipient(Users recipient) {
        this.recipient = recipient;
    }

    // toString method
    @Override
    public String toString() {
        return "ChatRoom{" +
                "chatId=" + chatId +
                ", sender=" + sender +
                ", recipient=" + recipient +
                '}';
    }
}
