package com.picpaysimplificado.dto;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal value, long senderId, long receiverId) {
}