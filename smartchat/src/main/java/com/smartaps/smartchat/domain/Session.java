package com.smartaps.smartchat.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@Builder
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSession; 

    private String etatCourant; 

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation; 

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateExpiration; 

    @Builder.Default
    private Boolean active = true;

    @OneToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private List<Message> messages;



}