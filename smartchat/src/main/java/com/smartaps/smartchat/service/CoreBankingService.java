package com.smartaps.smartchat.service;

import com.smartaps.smartchat.domain.Client;
import org.springframework.stereotype.Service;

@Service
public class CoreBankingService {
    // Simule l'appel à l'API bancaire pour fournir les soldes [2]
    public String recupererSolde(Client client) {
        // Ici on appellerait l'API réelle
        return "1 500 000 XOF";
    }
}