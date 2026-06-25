package com.smartaps.smartchat.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Getter @Setter 
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaction; 

    @Column(unique = true, nullable = false)
    private String reference; 

    private String typeTransaction; 

    private Double montant; 

    @Temporal(TemporalType.TIMESTAMP)
    @Builder.Default
    private Date dateTransaction = new Date(); 

    @Builder.Default
    private String statut = "EN_ATTENTE"; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_compte_source")
    private Compte compteSource;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_compte_destination")
    private Compte compteDestination;
}