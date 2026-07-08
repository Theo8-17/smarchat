package com.smartaps.smartchat.repository;

import com.smartaps.smartchat.domain.Compte;
import com.smartaps.smartchat.domain.Client;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;
import java.util.List;

public interface CompteRepository extends CrudRepository<Compte, Long> {
    List<Compte> findByClient(Client client);

    Optional<Compte> findByNumeroCompte(String numeroCompte);
}
