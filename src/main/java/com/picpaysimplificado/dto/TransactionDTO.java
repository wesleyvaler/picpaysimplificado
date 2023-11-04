package com.picpaysimplificado.dto;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal value, Long senderID, Long receiverID) {

}
