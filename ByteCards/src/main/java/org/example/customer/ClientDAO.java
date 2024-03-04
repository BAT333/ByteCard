package org.example.customer;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    private Connection con;
    public ClientDAO(Connection con){
        this.con = con;
    }

    public void register(Client client){
        String sql = "INSERT INTO cliente(Cpf, Nome , Email , Telefone) VALUES (?,?,?,?)";
        try {
            con.setAutoCommit(false);
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setBigDecimal(1,client.getCpf());
            statement.setString(2,client.getName());
            statement.setString(3, client.getEmail());
            statement.setBigDecimal(4,client.getTelephone());
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

    public List<Client> list(){
        List<Client> clients = new ArrayList<>();
        String sql = "select * from cliente";
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet set =  statement.executeQuery();
            while (set.next()){
                BigDecimal cpf = set.getBigDecimal(1);
                String name = set.getString(2);
                String email = set.getString(3);
                BigDecimal telephone = set.getBigDecimal(4);
                Client client = new Client(cpf,name,email,telephone);
                clients.add(client);
            }
        }catch (SQLException ex){
            throw new RuntimeException(ex);

        }

        return clients;

    }
}
