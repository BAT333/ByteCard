package org.example.Card;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CardDAO {
    private Connection con;
    public CardDAO(Connection con){
        this.con =con;
    }
    public void register(Card card){
        String sql ="INSERT INTO cartao (Numero_cartao, Validade, CVV, Limite, statuos, Cliente_Cpf) VALUES (?, ?, ?, ?, ?, ?)" ;

        try {
            con.setAutoCommit(false);
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setBigDecimal(1,card.getNumberCard());
            statement.setDate(2, Date.valueOf(card.getDate()));
            statement.setInt(3,card.getCvv());
            statement.setBigDecimal(4,card.getLimit());
            statement.setBoolean(5, card.isStatus());
            statement.setBigDecimal(6,card.getClientCpf());
            statement.execute();
            con.commit();
            con.close();
        }catch (SQLException ex){
            try {
                con.rollback();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }

            throw new RuntimeException(ex);
        }


    }
    public List<Card> cardList(){
        List<Card> cards = new ArrayList<>();
        String sql = "select * from cartao";
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                BigDecimal numbreCard = set.getBigDecimal(1);
                LocalDate date = set.getDate(2).toLocalDate();
                int cvv = set.getInt(3);
                BigDecimal limit = set.getBigDecimal(4);
                boolean status = set.getBoolean(5);
                BigDecimal clientCpf = set.getBigDecimal(6);


                Card card = new Card(numbreCard,date,cvv,limit,status,clientCpf);
                cards.add(card);
            }
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return cards;
    }
    public void activate(BigDecimal numberCard){
        String sql = "update cartao set cartao.statuos = 1 where Numero_cartao = ?";
        try {
            con.setAutoCommit(false);
            PreparedStatement statement =  con.prepareStatement(sql);
            statement.setBigDecimal(1,numberCard);
            statement.execute();
            con.commit();
            statement.close();
            con.close();

        }catch (SQLException ex){
            try {
                con.rollback();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
            throw new RuntimeException(ex);
        }

    }
    public void cancel(BigDecimal numberCard){
        String sql = "update cartao set cartao.statuos = 0 where Numero_cartao = ?";
        try {
            con.setAutoCommit(false);
            PreparedStatement statement =  con.prepareStatement(sql);
            statement.setBigDecimal(1,numberCard);
            statement.execute();
            con.commit();
            statement.close();
            con.close();

        }catch (SQLException ex){
            try {
                con.rollback();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
            throw new RuntimeException(ex);
        }

    }
    public void limitCard(BigDecimal numberCard,BigDecimal limit){
        String sql = "update cartao set cartao.Limite = ? where Numero_cartao = ?";
        try {
            con.setAutoCommit(false);
            PreparedStatement statement =  con.prepareStatement(sql);
            statement.setBigDecimal(1,limit);
            statement.setBigDecimal(2,numberCard);
            statement.execute();
            con.commit();
            statement.close();
            con.close();

        }catch (SQLException ex){
            try {
                con.rollback();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
            throw new RuntimeException(ex);
        }

    }
    public void deleteCard(){
        String sql ="delete from cartao where statuos = 0 ";
        try {
            con.setAutoCommit(false);
            PreparedStatement statement = con.prepareStatement(sql);
            statement.execute();
            con.commit();
            statement.execute();
            con.close();

        }catch (SQLException ex){
            try {
                con.rollback();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
            throw new RuntimeException(ex);

        }
    }


}
