package com.picpaysimplificado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.picpaysimplificado.domain.transaction.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
