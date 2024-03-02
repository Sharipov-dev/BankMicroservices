package com.myBank.cards.cards.service;

import com.myBank.cards.cards.dto.CardsDto;
import com.myBank.cards.cards.entity.Cards;

public interface ICardService {
    void createCard(String mobileNumber);
    CardsDto getCardDetails(String mobileNumber);
    boolean updateCardDetails(CardsDto cardsDto);
    boolean deleteCard(String mobileNumber);
}
