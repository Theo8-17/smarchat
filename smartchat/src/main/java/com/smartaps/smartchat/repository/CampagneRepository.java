package com.smartaps.smartchat.repository;

import com.smartaps.smartchat.domain.Campagne;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;
import java.util.List;

public interface CampagneRepository extends CrudRepository<Campagne, Long> {
    List<Campagne> findByStatut(String statut);
}
