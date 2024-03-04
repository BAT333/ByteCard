package org.example.validation;

import org.example.Card.Card;
import org.example.customer.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Validation {
    public static boolean validationCard(Card card){
        Pattern pattern = Pattern.compile("([1-9]+[1-9]+[1-9]+[1-9]+[1-9]+[1-9]+[1-9]+[1-9]+[1-9]+[1-9]+[1-9]+[1-9]+[1-9]+[1-9]+[1-9]+[1-9]+)");
        Pattern regexcvv = Pattern.compile("([1-9]+[1-9]+[1-9]+)");
        Matcher matcher = pattern.matcher(card.getNumberCard().toString());
        Matcher matchercvv = regexcvv.matcher(card.getCvv().toString());
        if (card.getNumberCard().toString().length() != 16&&card.getCvv().toString().length() !=3){
            return false;
        }else{
            if(matcher.find()&&matchercvv.find()){
                return true;
            }else{
                return false;
            }
        }
    }
    public static boolean validationClient(Client client){
        Pattern regexCpf = Pattern.compile("([1-9]+[1-9]+[1-9]+[1-9]+[1-9]+[1-9]+[1-9]+[1-9]+[1-9]+[1-9]+[1-9]+)");
        Pattern regextelephone = Pattern.compile("([1-9]+[1-9]+[1-9]+)");
        Matcher matchercpf = regexCpf.matcher(client.getCpf().toString());
        Matcher matchertelephone = regextelephone.matcher(client.getCpf().toString());
        String redex = "([a-zA-Z\\d\\._-])+@([a-z])+\\.com[\\.br]*";
        Pattern regexEmail = Pattern.compile(redex);
        Matcher matcherEmail = regexEmail.matcher(client.getEmail());


        if (client.getCpf().toString().length() != 11&&client.getTelephone().toString().length() !=12){
            return false;
        }else{
            if(matchercpf.find()&&matchertelephone.find()&&matcherEmail.find()){
                return true;
            }else{
                return false;
            }
        }
    }
}
