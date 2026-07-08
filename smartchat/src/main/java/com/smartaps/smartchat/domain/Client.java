package com.smartaps.smartchat.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    @Column(unique = true, nullable = false)
    private String coreBankingId;

    private String nom;
    private String prenom;

    @Column(unique = true, nullable = false)
    private String telephone;

    private String pin;

    @Builder.Default
    private Boolean serviceActif = true;

    @Temporal(TemporalType.DATE)
    private Date dateActivation;

    @Builder.Default
    private String statut = "ACTIF";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_admin")
    private Admin admin;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Compte> comptes;

    @OneToMany(mappedBy = "client")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "client")
    private List<Otp> otps;

    @OneToOne(mappedBy = "client")
    private Session session;

    @ManyToMany
    @JoinTable(name = "client_campagne", joinColumns = @JoinColumn(name = "id_client"), inverseJoinColumns = @JoinColumn(name = "id_campaign"))
    private List<Campagne> campagnes;

    @OneToMany(mappedBy = "client")
    private List<Message> messages;
}