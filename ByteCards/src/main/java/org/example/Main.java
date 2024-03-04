package org.example;

import org.example.Buy.Shopping;
import org.example.Card.Card;
import org.example.Card.CardService;
import org.example.customer.Client;
import org.example.customer.ClientService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        Client client = new Client(BigDecimal.ZERO,"RAFAEL","RAFAEL@",BigDecimal.ZERO);
        Client client2 = new Client(BigDecimal.ONE,"RAFAEL","RAFAEL@",BigDecimal.ZERO);
        System.out.println(client.equals(client2));
        System.out.println(client);
        Card card = new Card(BigDecimal.ONE, LocalDate.now(),123, BigDecimal.ZERO,true,BigDecimal.ZERO);
        Card card2 = new Card(BigDecimal.ONE, LocalDate.now(),123, BigDecimal.ZERO,true,BigDecimal.ZERO);
        System.out.println(card);
        Shopping shopping = new Shopping(BigDecimal.ZERO, LocalDateTime.now(),"AMARELINHO","ALIMENTAÇÃO",BigInteger.ONE,BigInteger.ZERO);

        Scanner teclado = new Scanner(System.in);
        boolean sair = false;
        ClientService clientService  = new ClientService();

        while (!sair){
            System.out.println("1 CADASTRA CLIENTE\n" +
                    "2 LISTA CLIENTE\n" +
                    "3 SAIR\n");

            int escolha = teclado.nextInt();
            switch (escolha){
                case 1:
                    System.out.println(" CUSTOMER CPF ");
                    BigDecimal cpf = teclado.nextBigDecimal();
                    System.out.println(" CUSTOMER NAME ");
                    String name = teclado.next();
                    System.out.println(" CUSTOMER EMAIL ");
                    String email = teclado.next();
                    System.out.println(" CUSTOMER TELEPHONE ");
                    BigDecimal telephone = teclado.nextBigDecimal();
                    Client client1 = new Client(cpf,name,email,telephone);
                    clientService.accessClient(client1);
                    break;
                case 2:
                    for (Client show:clientService.customerListing()){
                        System.out.println(show);
                    }
                    break;
                default: sair= true;
                    break;



            }
        }
        sair = false;
        CardService service = new CardService();
        while (!sair){
            System.out.println("1 CADASTRA CARTÃO\n" +
                    "2 LISTA CARTÃO\n" +
                    "3 ATIVAR CARTÃO\n" +
                    "4 SAIR");

            int escolha = teclado.nextInt();
            switch (escolha){
                case 1:
                    System.out.println(" NUMBER CARD ");
                    BigDecimal numberCard = teclado.nextBigDecimal();
                    System.out.println(" Card cvv ");
                    int cvv = teclado.nextInt();
                    System.out.println(" limit Card ");
                    BigDecimal limit = teclado.nextBigDecimal();
                    System.out.println(" CUSTOMER CPF ");
                    BigDecimal cpf = teclado.nextBigDecimal();
                    Card card1 = new Card(numberCard,LocalDate.now().plusYears(4).plusMonths(6),cvv,limit,false,cpf);
                    service.registerCard(card1);
                    break;
                case 2:
                    for (Card show: service.listCard()){
                        System.out.println(show);
                    }
                    break;
                case 3:
                    System.out.println(" NUMBER CARD ");
                    BigDecimal numberCardAtiva = teclado.nextBigDecimal();
                    service.activateCard(numberCardAtiva);
                    break;
                default: sair= true;
                    break;



            }


        }


    }
}