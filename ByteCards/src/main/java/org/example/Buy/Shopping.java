package org.example.Buy;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

public class Shopping {
    private BigInteger id;
    private BigDecimal amount;
    private LocalDateTime dateTime;
    private String establishment;
    private String category;
    private BigInteger numberCard;
    private BigInteger clientCpf;

    public Shopping(BigDecimal amount,LocalDateTime dateTime,String establishment,String category,BigInteger numberCard,BigInteger clientCpf){
        this.amount =amount;
        this.dateTime = dateTime;
        this.establishment = establishment;
        this.category = category;
        this.numberCard =numberCard;
        this.clientCpf =clientCpf;




    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getClientCpf() {
        return clientCpf;
    }

    public void setClientCpf(BigInteger clientCpf) {
        this.clientCpf = clientCpf;
    }

    public BigInteger getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(BigInteger numberCard) {
        this.numberCard = numberCard;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getEstablishment() {
        return establishment;
    }

    public void setEstablishment(String establishment) {
        this.establishment = establishment;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "Shopping{" +
                "id=" + id +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                ", establishment='" + establishment + '\'' +
                ", category='" + category + '\'' +
                ", numberCard=" + numberCard +
                ", clientCpf=" + clientCpf +
                '}';
    }
}
