package com.picpaysimplificado.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.dto.UserDTO;
import com.picpaysimplificado.repository.UserRepository;




@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void ValidadeTransaction(User Sender, BigDecimal amount) throws Exception {
        if (Sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Usuario lojista não esta permitido a realizar transação");
        }
        if (Sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("Saldo insuficiente");
        }
    }

    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
    }

    public void saveUser(User user) {
        this.repository.save(user);
    }

    public User createUser(UserDTO data) {
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }


    public List<User> getAllUsers() {
            return this.repository.findAll();
    }
}
