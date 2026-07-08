package com.smartaps.smartchat.repository;

import com.smartaps.smartchat.domain.Otp;
import com.smartaps.smartchat.domain.Client;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface OtpRepository extends CrudRepository<Otp, Long> {
    // Pour vérifier un code valide non encore utilisé
    Optional<Otp> findByCodeAndClientAndUtiliseFalse(String code, Client client);
}
