package org.example.customer;

import org.example.DataBase.ConnectionFactory;
import org.example.validation.Validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientService {
    private List<Client> clients = new ArrayList<>();
    private ConnectionFactory factory;

    public ClientService(){
        this.factory = new ConnectionFactory();

    }

    public void accessClient(Client client){
        //System.out.println("NON-EXISTENT CPF: "+ client.getCpf().bitLength());
        // confirir cpf tem digito suficiente
        // telefone
        // email
if(Validation.validationClient(client)) {
    for (Client show : this.customerListing()) {
        if (client.equals(show)) {
            throw new RuntimeException("EXISTING CUSTOMER");
        }
    }
}else {
    throw new RuntimeException("ERR CUSTOMER");
}
        ClientDAO dao = new ClientDAO(factory.connect());
        dao.register(client);
        System.out.println(" Customer Registered Successfully ");



    }
    public List<Client> customerListing(){
        ClientDAO dao = new ClientDAO(factory.connect());
        Collections.sort(dao.list());
        if(dao.list().isEmpty()){
            System.out.println("NOT A REGISTERED CUSTOMER");
        }
        return dao.list();
    }

}
