package com.picpaysimplificado.domain.user;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wesleyvaler.repositories.UserRepository;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepository repository;
    @Autowired
    private User user;

    public void ValidadeTransaction(User Sender , BigDecimal amount) throws Exception {
        if(Sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Usuario lojista não esta permitido a realizar transação");
        }
        if(Sender.getBalance().compareTo(amount) < 0 ){
            throw new Exception("Saldo insuficiente");
        }
    }
    public com.github.wesleyvaler.domain.user.User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
    }

    @Override
    public void Save(User user) {
    }
}