package com.smartaps.smartchat.repository;

import com.smartaps.smartchat.domain.Client;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long> {
    Optional<Client> findByTelephone(String telephone);
    Optional<Client> findByCoreBankingId(String coreBankingId);
}