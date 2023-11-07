package com.picpaysimplificado.dto;

import java.math.BigDecimal;

import com.picpaysimplificado.domain.user.UserType;

public record UserDTO(String firstName, String email, String document, String lastname, BigDecimal Balance, UserType userType, String password) {

}
