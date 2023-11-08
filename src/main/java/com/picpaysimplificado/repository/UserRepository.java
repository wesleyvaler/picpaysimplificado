package com.picpaysimplificado.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.picpaysimplificado.domain.user.User;


@Repository
public interface UserRepository extends JpaRepository<User , Long> {
   
	Optional<User> findByDocument(String Document);

    Optional<User> findUserById(Long id);

}
