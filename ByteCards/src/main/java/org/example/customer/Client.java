package org.example.customer;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

public class Client implements Comparable<Client> {
    private BigDecimal cpf;
    private String name;
    private String email;
    private BigDecimal telephone;

    public Client(BigDecimal cpf,String name,String email,BigDecimal telephone){
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }
    public BigDecimal getCpf(){
        return cpf;
    }
    public void setCpf(BigDecimal cpf){
        this.cpf = cpf;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email= email;
    }
    public BigDecimal getTelephone(){
        return telephone;
    }
    public void setTelephone(BigDecimal telephone){
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)return false ;
        if(this == obj)return true;
        if(this.getClass() != obj.getClass())return false;
        Client client = (Client) obj;
        return cpf!= null && cpf.equals(client.cpf);
    }

    @Override
    public int hashCode() {
       // return this.cpf == null? 0 :cpf.hashCode();
        return Objects.hash(cpf);
    }

    @Override
    public int compareTo(Client o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Client{" +
                "cpf=" + cpf +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telephone=" + telephone +
                '}';
    }
}
