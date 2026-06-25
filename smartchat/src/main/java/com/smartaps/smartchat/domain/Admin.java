package com.smartaps.smartchat.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@Builder
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdmin;

    private String nom;

    private String prenom;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    private String motDePasse;

    @Builder.Default
    private String role = "ADMIN";

    @Builder.Default
    private String statut = "ACTIF";

    @OneToMany(mappedBy = "admin")
    private List<Client> clients;

    @OneToMany(mappedBy = "admin")
    private List<Campagne> campagnes;

}