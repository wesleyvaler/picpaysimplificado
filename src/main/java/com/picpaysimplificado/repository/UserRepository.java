package com.picpaysimplificado.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.wesleyvaler.domain.user.User;

public interface UserRepository extends JpaRepository<User , Long> {
   
	Optional<User> findByDocument(String Document);

    Optional<User> findUserById(Long id);

}
