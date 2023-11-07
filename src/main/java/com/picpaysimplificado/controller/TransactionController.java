package com.picpaysimplificado.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picpaysimplificado.domain.transaction.Transaction;
import com.picpaysimplificado.dto.TransactionDTO;
import com.picpaysimplificado.services.TransactionsService;

@RestController()
@RequestMapping("/transactions")

public class TransactionController {

    private TransactionsService transactionsService;

    @PostMapping
    public Transaction CreateTransactions(@RequestBody TransactionDTO transaction) throws Exception {
        Transaction newTransactions = transactionsService.createTransaction(transaction);
        return new ResponseEntity<>(newTransactions, HttpStatus.CREATED).getBody();
    }
    @PostMapping
    public ResponseEntity<List<Transaction>> getAllTransactions(){
        List<Transaction> transactions = this.transactionsService.findAll();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
}