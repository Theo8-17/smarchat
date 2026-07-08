package com.smartaps.smartchat.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void envoyerReponse(String destinataire, String message) {
        // Logique de transmission vers Messaging Gateway (Twilio) [2]
        System.out.println("Envoi vers " + destinataire + " : " + message);
    }
}