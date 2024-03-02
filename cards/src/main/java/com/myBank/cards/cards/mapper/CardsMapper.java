package com.myBank.cards.cards.mapper;

import com.myBank.cards.cards.dto.CardsDto;
import com.myBank.cards.cards.entity.Cards;

public class CardsMapper {


    public static CardsDto cardsToCardsDto(Cards cards, CardsDto cardsDto){
        cardsDto.setMobileNumber(cards.getMobileNumber());
        cardsDto.setCardNumber(cards.getCardNumber());
        cardsDto.setCardType(cards.getCardType());
        cardsDto.setAmountUsed(cards.getAmountUsed());
        cardsDto.setTotalLimit(cards.getTotalLimit());
        cardsDto.setAvailableAmount(cards.getAvailableAmount());

        return cardsDto;
    }
    public static Cards cardsDtoToCards(CardsDto cardsDto, Cards cards){
        cards.setMobileNumber(cardsDto.getMobileNumber());
        cards.setCardNumber(cardsDto.getCardNumber());
        cards.setCardType(cardsDto.getCardType());
        cards.setAmountUsed(cardsDto.getAmountUsed());
        cards.setTotalLimit(cardsDto.getTotalLimit());
        cards.setAvailableAmount(cardsDto.getAvailableAmount());
        return cards;
    }
}
