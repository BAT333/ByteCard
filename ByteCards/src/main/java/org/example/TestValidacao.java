package org.example;

import org.example.Card.Card;
import org.example.validation.Validation;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestValidacao {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("([1-9]+[1-9]+[1-9]?)");
        Matcher matcher = pattern.matcher("123444444567899876543");
        if(matcher.find()){
            System.out.println("PASSOU ");
        }else {
            System.out.println("ERRO ");
        }

        if ("1234567899876543".length() != 16){
            System.out.println(true);
        }else{
            System.out.println("1234567899876547".length());
        }
    }

    }

