package com.myBank.cards.cards.dto;

import lombok.Data;

@Data
public class CardsDto {

    private String mobileNumber;

    private Long cardNumber;

    private String cardType;

    private int totalLimit;

    private int amountUsed;

    private int availableAmount;
}
