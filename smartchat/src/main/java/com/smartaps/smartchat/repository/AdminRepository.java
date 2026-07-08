package com.smartaps.smartchat.repository;

import com.smartaps.smartchat.domain.Admin;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface AdminRepository extends CrudRepository<Admin, Long> {
    Optional<Admin> findByLogin(String login);
}
