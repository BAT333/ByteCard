package org.example.Card;

import org.example.DataBase.ConnectionFactory;
import org.example.customer.ClientDAO;
import org.example.validation.Validation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardService {
    private List<Card> cards = new ArrayList<>();
    private ConnectionFactory factory;
    public CardService(){

        this.factory = new ConnectionFactory();
    }
    public void registerCard(Card card){

        if(Validation.validationCard(card)){
            for(Card show:this.listCardregister()) {
                if (card.equals(show)) {
                    throw new RuntimeException("THIS CARD ALREADY EXISTS\n");
                }
            }
        }else{
            throw new RuntimeException("THIS CARD ALREADY \n");
        }
        CardDAO dao = new CardDAO(this.factory.connect());
        dao.register(card);



    }
    public List<Card> listCard(){
        CardDAO dao = new CardDAO(factory.connect());
        Collections.sort(dao.cardList());
        if(dao.cardList().isEmpty()){
            System.out.println("NOT A REGISTERED CARD");
        }
        return dao.cardList();
    }
    public List<Card> listCardregister(){
        CardDAO dao = new CardDAO(factory.connect());
        Collections.sort(dao.cardList());
        return dao.cardList();

    }
    public void activateCard(BigDecimal numberCard){
        CardDAO dao = new CardDAO(factory.connect());
        dao.activate(numberCard);

    }
    public void cancelCard(BigDecimal numberCard){
        CardDAO dao = new CardDAO(factory.connect());
        dao.cancel(numberCard);

    }
    public void limitCard(BigDecimal numberCard, BigDecimal limitCard){
        CardDAO dao = new CardDAO(factory.connect());
        dao.limitCard(numberCard,limitCard);

    }
    public void delete(){
        CardDAO dao = new CardDAO(factory.connect());
        dao.deleteCard();
    }

}
