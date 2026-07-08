package com.smartaps.smartchat.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Campagne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCampaign;

    private String titre;

    @Column(columnDefinition = "TEXT")
    private String contenu;

    private String typeCampagne;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    @Builder.Default
    private String statut = "ACTIVE";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_admin", nullable = false)
    private Admin admin;

}