package org.example.DataBase;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection connect(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/ByteCard?user=root&password=Rafael234");
            //return dataSource().getConnection();
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }

    }
    private HikariDataSource dataSource(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/ByteCard");
        config.setUsername("root");
        config.setPassword("Rafael234");
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }

}
