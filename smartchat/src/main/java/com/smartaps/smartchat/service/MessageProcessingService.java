package com.smartaps.smartchat.service;

import com.smartaps.smartchat.domain.*;
import com.smartaps.smartchat.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageProcessingService {

    private final AuthService authService;
    private final SessionService sessionService;
    private final NotificationService notificationService;
    private final ClientRepository clientRepository;
    private final CoreBankingService coreBankingService;

    public MessageProcessingService(AuthService as, SessionService ss,
            NotificationService ns, ClientRepository cr,
            CoreBankingService cbs) {
        this.authService = as;
        this.sessionService = ss;
        this.notificationService = ns;
        this.clientRepository = cr;
        this.coreBankingService = cbs;
    }

    public void processIncomingMessage(String fromMobile, String rawBody) {
        Client client = clientRepository.findByTelephone(fromMobile)
                .orElseThrow(() -> new RuntimeException("Client inconnu"));

        Session session = sessionService.obtenirSession(client);
        String response;

        // Logique conversationnelle [1]
        if ("ACCUEIL".equals(session.getEtatCourant())) {
            response = "Bienvenue. Saisissez votre PIN :";
            sessionService.changerEtat(session, "ATTENTE_PIN");
        } else if ("ATTENTE_PIN".equals(session.getEtatCourant())) {
            if (authService.verifierPin(client, rawBody)) {
                String solde = coreBankingService.recupererSolde(client);
                response = "Authentifié ! Votre solde est de : " + solde;
                sessionService.changerEtat(session, "ACCUEIL");
            } else {
                response = "PIN incorrect. Réessayez :";
            }
        } else {
            response = "Commande non reconnue.";
        }

        notificationService.envoyerReponse(fromMobile, response);
    }
}