package com.demo.example.student_library_management.converters;

import com.demo.example.student_library_management.model.Card;
import com.demo.example.student_library_management.requestDto.CardRequestDto;

public class CardConverters {
    public static Card convertsCardRequestDtoToCard(CardRequestDto cardRequestDto){
        Card card=new Card();
        card.setCardStatus(cardRequestDto.getCardStatus());
        return card;
    }
}
