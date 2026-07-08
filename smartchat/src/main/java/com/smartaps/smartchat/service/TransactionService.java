package com.smartaps.smartchat.service;

import com.smartaps.smartchat.domain.Transaction;
import com.smartaps.smartchat.domain.Compte;
import com.smartaps.smartchat.repository.TransactionRepository;
import com.smartaps.smartchat.repository.CompteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.UUID;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CompteRepository compteRepository;

    public TransactionService(TransactionRepository tr, CompteRepository cr) {
        this.transactionRepository = tr;
        this.compteRepository = cr;
    }

    @Transactional
    public Transaction effectuerVirement(String numSource, String numDest, Double montant) {
        // Recherche des comptes via le Tier 3
        Compte source = compteRepository.findByNumeroCompte(numSource)
                .orElseThrow(() -> new RuntimeException("Compte source inexistant"));
        Compte dest = compteRepository.findByNumeroCompte(numDest)
                .orElseThrow(() -> new RuntimeException("Compte destination inexistant"));

        // Création de la transaction (Une transaction concerne exactement 2 comptes)
        Transaction tx = Transaction.builder()
                .reference(UUID.randomUUID().toString())
                .montant(montant)
                .dateTransaction(new Date())
                .compteSource(source)
                .compteDestination(dest)
                .statut("VALIDE")
                .client(source.getClient())
                .build();

        return transactionRepository.save(tx);
    }
}