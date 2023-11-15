package com.picpaysimplificado.domain.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.picpaysimplificado.domain.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "transactions")
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "Id")

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private BigDecimal amount;
    @ManyToOne
    @JoinColumn(name = "send.id")
    private User sender;
    @ManyToOne
    @JoinColumn(name = "receiver.id")
    private User receiver;
    private LocalDateTime timesLocalDateTime;
      
    
	public Transaction() {
		super();
	}
	
	public Transaction(long id, BigDecimal amount, User sender, User receiver, LocalDateTime timesLocalDateTime) {
		super();
		Id = id;
		this.amount = amount;
		this.sender = sender;
		this.receiver = receiver;
		this.timesLocalDateTime = timesLocalDateTime;
	}
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public User getSender() {
		return sender;
	}
	
	public void setSender(User sender) {
		this.sender = sender;
	}
	
	public User getReceiver() {
		return receiver;
	}
	
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	
	public LocalDateTime getTimesLocalDateTime() {
		return timesLocalDateTime;
	}
	
	public void setTimesLocalDateTime(LocalDateTime timesLocalDateTime) {
		this.timesLocalDateTime = timesLocalDateTime;
	}
}
