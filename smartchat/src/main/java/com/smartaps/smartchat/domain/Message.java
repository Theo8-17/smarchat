package com.smartaps.smartchat.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMessage; 

    @Column(columnDefinition = "TEXT")
    private String contenu; 

    private String typeMessage;

    private String canal;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnvoi; 

    @Builder.Default
    private String statut = "ENVOYE"; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_admin", nullable = false)
    private Admin admin;

    @ManyToMany(mappedBy = "campagnes")
    private List<Client> clients;

}