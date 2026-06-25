package com.smartaps.smartchat.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@Builder
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompte; 

    @Column(unique = true, nullable = false)
    private String coreAccountId; 

    @Column(unique = true, nullable = false)
    private String numeroCompte; 

    private String typeCompte; 

    @Builder.Default
    private String devise = "XOF"; 

    @Builder.Default
    private String statut = "ACTIF";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "compteSource")
    private List<Transaction> transactionsSortantes;

    @OneToMany(mappedBy = "compteDestination")
    private List<Transaction> transactionsEntrantes;

}