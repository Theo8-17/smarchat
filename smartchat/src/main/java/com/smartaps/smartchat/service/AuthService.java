package com.smartaps.smartchat.service;

import com.smartaps.smartchat.domain.Client;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public boolean verifierPin(Client client, String pinSaisi) {
        // Vérification sécurisée du code PIN [2]
        return client.getPin() != null && client.getPin().equals(pinSaisi);
    }
}