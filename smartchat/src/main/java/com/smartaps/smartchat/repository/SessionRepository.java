package com.smartaps.smartchat.repository;

import com.smartaps.smartchat.domain.Session;
import com.smartaps.smartchat.domain.Client;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface SessionRepository extends CrudRepository<Session, Long> {
    Optional<Session> findByClientAndActiveTrue(Client client);
}
