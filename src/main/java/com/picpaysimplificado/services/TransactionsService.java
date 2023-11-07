package com.picpaysimplificado.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.github.wesleyvaler.domain.user.User;
import com.picpaysimplificado.domain.transaction.Transaction;
import com.picpaysimplificado.dto.TransactionDTO;

@Service
public class TransactionsService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TransactionsService repository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public void createTransaction(TransactionDTO transaction) throws Exception {
		User sender = this.userService.findUserById(transaction.senderId());
		User receiver = this.userService.findUserById(transaction.receiverId());
		
		userService.ValidateTransaction(sender, transaction.value());
		
		 boolean isAuthored = this.authorizeTransaction(sender, transaction.value());
	        if (!isAuthored) {
	            throw new Exception("Transação não Autorizada");
	        }
	        Transaction newtransaction = new Transaction();
	        newtransaction.setAmount(transaction.value());
	        newtransaction.setSender(sender);
	        newtransaction.setReceiver(receiver);
	        newtransaction.setTimesLocalDateTime(LocalDateTime.now());

	        sender.setBalance(sender.getBalance().subtract(transaction.value()));
	        receiver.setBalance((receiver.getBalance().add(transaction.value())));

	        this.userService.saveUser(sender);
	        this.userService.saveUser(receiver);
	        userService.saveUser(sender);
	        userService.saveUser(receiver);
	    }

	    private void save(Transaction newtransaction) {
	        this.repository.save(newtransaction);
	    }


	    public boolean authorizeTransaction(User sender, BigDecimal amount) {
	        ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity("https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6", Map.class);

	        if (authorizationResponse.getStatusCode() == HttpStatus.OK) {
	            String message = (String) authorizationResponse.getBody().get("message");
	            return "Autorizado".equalsIgnoreCase(message);
	        }
	        return false;

	    }
	}