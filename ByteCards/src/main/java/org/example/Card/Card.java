package org.example.Card;

import org.example.customer.Client;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Objects;

public class Card implements Comparable<Card>{
    private BigDecimal numberCard;
    private LocalDate date;
    private Integer cvv;
    private BigDecimal limit;
    private boolean status;
    private BigDecimal clientCpf;

    public Card(BigDecimal numberCard,LocalDate date,int cvv,BigDecimal limit,boolean status,BigDecimal clientCpf){
        this.numberCard = numberCard;
        this.date = date;
        this.cvv =cvv;
        this.limit = limit;
        this.status = status;
        this.clientCpf = clientCpf;
    }
    public BigDecimal getNumberCard(){
        return numberCard;
    }
    public void setNumberCard(BigDecimal numberCard){
        this.numberCard = numberCard;
    }
    public  LocalDate getDate(){
        return date;
    }
    public void setDate(LocalDate date){
        this.date =date;
    }
    public Integer getCvv(){
        return cvv;
    }
    public void setCvv(Integer cvv){
        this.cvv =cvv;
    }
    public BigDecimal getLimit(){
        return limit;
    }
    public void setLimit(BigDecimal limit){
        this.limit = limit;
    }
    public boolean isStatus(){
        return status;
    }
    public void setStatus(boolean status){
        this.status =status;
    }
    public BigDecimal getClientCpf(){
        return clientCpf;
    }
    public void setClientCpf(BigDecimal clientCpf){
        this.clientCpf =clientCpf;
    }


    @Override
    public boolean equals(Object obj) {
        if(obj == null)return false;
        if(this == obj)return true;
        if(this.getClass() != obj.getClass())return false;
        Card card = (Card) obj;
        return numberCard != null&& numberCard.equals(card.numberCard);

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.numberCard);
    }

    @Override
    public int compareTo(Card o) {
        return this.numberCard.compareTo(o.numberCard);
    }

    @Override
    public String toString() {
        return "Card{" +
                "numberCard=" + numberCard +
                ", date=" + date +
                ", cvv=" + cvv +
                ", limit=" + limit +
                ", status=" + status +
                ", clientCpf=" + clientCpf +
                '}';
    }
}
