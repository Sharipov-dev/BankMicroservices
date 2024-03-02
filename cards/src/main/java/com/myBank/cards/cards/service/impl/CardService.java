package com.myBank.cards.cards.service.impl;

import com.myBank.cards.cards.dto.CardsDto;
import com.myBank.cards.cards.exception.CardAlreadyExistsException;
import com.myBank.cards.cards.constants.CardsConstants;
import com.myBank.cards.cards.entity.Cards;
import com.myBank.cards.cards.exception.ResourceNotFoundException;
import com.myBank.cards.cards.mapper.CardsMapper;
import com.myBank.cards.cards.repository.CardsRepository;
import com.myBank.cards.cards.service.ICardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardService implements ICardService {

    private CardsRepository cardsRepository;

    @Override
    public void createCard(String mobileNumber) {
        Optional<Cards> foundCard = cardsRepository.findByMobileNumber(mobileNumber);
        if(foundCard.isPresent()){
            throw new CardAlreadyExistsException(
                    "Customer with given Mobile Number exists: " + mobileNumber);
        }
        cardsRepository.save(createNewCard(mobileNumber));
    }

    @Override
    public CardsDto getCardDetails(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Cards", "MobileNumber", mobileNumber)
        );
        return CardsMapper.cardsToCardsDto(cards, new CardsDto());
    }

    @Override
    public boolean updateCardDetails(CardsDto cardsDto) {
        Cards cards = cardsRepository.findByMobileNumber(cardsDto.getMobileNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Cards", "mobileNumber", cardsDto.getMobileNumber())
        );
        CardsMapper.cardsDtoToCards(cardsDto, cards);
        cardsRepository.save(cards);
        return true;
    }

    @Override
    public boolean deleteCard(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Cards", "MobileNumber", mobileNumber)
        );
        cardsRepository.deleteById(cards.getCardId());
        return true;
    }

    public Cards createNewCard(String mobileNumber){
        Cards newCard = new Cards();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(randomCardNumber);
        newCard.setAmountUsed(0);
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        return newCard;
    }

}
