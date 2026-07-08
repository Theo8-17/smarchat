package com.smartaps.smartchat.repository;

import com.smartaps.smartchat.domain.Transaction;
import com.smartaps.smartchat.domain.Client;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;
import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    Optional<Transaction> findByReference(String reference);

    List<Transaction> findByClientOrderByDateTransactionDesc(Client client);
}
