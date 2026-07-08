package com.smartaps.smartchat.service;

import com.smartaps.smartchat.domain.Session;
import com.smartaps.smartchat.domain.Client;
import com.smartaps.smartchat.repository.SessionRepository;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    // Méthode utilisée par le MessageProcessingService
    public Session obtenirSession(Client client) {
        return sessionRepository.findByClientAndActiveTrue(client)
                .orElseGet(() -> sessionRepository.save(
                        Session.builder()
                                .client(client)
                                .active(true)
                                .etatCourant("ACCUEIL") // État initial [1]
                                .dateCreation(new Date())
                                .build()));
    }

    // Permet de faire avancer l'automate de conversation
    public void changerEtat(Session session, String nouvelEtat) {
        session.setEtatCourant(nouvelEtat);
        sessionRepository.save(session);
    }
}