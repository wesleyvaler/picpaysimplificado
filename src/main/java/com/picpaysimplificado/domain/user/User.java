package com.picpaysimplificado.domain.user;

import java.math.BigDecimal;

import com.picpaysimplificado.dto.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String Name;
    
    private String lastName;
    
    private String firstName;
    
    @Column(unique = true)
    private String Doccument;
    
    @Column(unique = true)
    private String email;
    
    
    private String passoword;
    
    private BigDecimal Balance;
    
    @Enumerated(EnumType.STRING)
    private UserType userType;
    
	public UserType getUserType() {
		// TODO Auto-generated method stub
		return null;
	}
	public BigDecimal getBalance() {
		// TODO Auto-generated method stub
		return null;
	}

    public User(UserDTO date){
        this.firstName = date.firstName();
        this.userType = date.userType();
        this.passoword = date.password();
        this.email = date.email();
        this.Balance = date.Balance();
        this.Doccument = date.document();
    }
}
