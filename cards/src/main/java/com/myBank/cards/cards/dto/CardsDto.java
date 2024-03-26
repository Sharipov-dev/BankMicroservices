package com.myBank.cards.cards.dto;

import jakarta.validation.constraints.NotEmpty;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CardsDto {

    @NotEmpty
    @Pattern(regexp = "($|[0-9]{10})", message = "mobileNumber must be 10 digits")
    private String mobileNumber;

    @NotEmpty
    @Pattern(regexp = "($|[0-9]{10})")
    private Long cardNumber;

    private String cardType;

    private int totalLimit;

    private int amountUsed;

    private int availableAmount;
}
