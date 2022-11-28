package com.example.hotelkharbouchaa.Client;
import java.sql.*;
import java.util.*;

import com.Database.DbConnecting.DbConnecting;
public class ClientRepository {
    
    public int addClient(Client client) {
        int idC = 0;
        try {
            Connection connection = DbConnecting.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO client (nom,prenom,email,adresse,tel,code) VALUES(?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            connection = DbConnecting.getConnection();
            preparedStatement.setString(1, client.getNom());
            preparedStatement.setString(2, client.getPrenom());
            preparedStatement.setString(3,client.getEmail());
            preparedStatement.setString(4, client.getAdresse());
            preparedStatement.setInt(5, client.getTel());
            preparedStatement.setString(6, client.getCode());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()) {
                idC = resultSet.getInt(1);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return idC;
    }
    //get all clients
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        try {
            Connection connection = DbConnecting.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM client");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                clients.add(new Client(resultSet.getInt("id"), resultSet.getString("nom"), resultSet.getString("prenom"),resultSet.getString("email"), resultSet.getString("adress"), resultSet.getInt("tel"), resultSet.getString("code")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clients;
    }

}

