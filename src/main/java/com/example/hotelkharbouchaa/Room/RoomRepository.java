package com.example.hotelkharbouchaa.Room;
//import dbConnecting form file Database
import com.Database.DbConnecting.DbConnecting;
import com.example.hotelkharbouchaa.Image.Image;

import java.sql.*;
import java.util.*;

public class RoomRepository {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    //Methode to add room and get the id of the room
    public int addRoom(int num, int type , String description,String Status ,Double price) {
        int id = 0;
        try {
            connection = DbConnecting.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO room (num, idtype, description, status, tarif) VALUES(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, num);
            preparedStatement.setInt(2, type);
            preparedStatement.setString(3, description);
            preparedStatement.setString(4, Status);
            preparedStatement.setDouble(5, price);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return id;
        
    }
    //Method for updating room
    public void updateRoom(Room room) {
        try {
            connection = DbConnecting.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE room SET idType = ?, status = ?, description = ? WHERE num = ?");
            preparedStatement.setInt(1, room.getIdType());
            preparedStatement.setString(2, room.getStatus());
            preparedStatement.setString(3, room.getDescription());
            preparedStatement.setInt(4, room.getNum());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //Method for deleting room by number
    public void deleteRoom(int num) {
        try {
            connection = DbConnecting.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM room WHERE num = ?");
            preparedStatement.setInt(1, num);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //Method for get room by number
    public Room getRoom(int num) {
        try {
            connection = DbConnecting.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM room WHERE num = ?");
            preparedStatement.setInt(1, num);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
             //   return new Room(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3), resultSet.getDouble(4), resultSet.getString(5), resultSet.getString(6));
                //return by colmn name
                return new Room(resultSet.getInt("id"), resultSet.getInt("num"), resultSet.getInt("idType"), resultSet.getDouble("tarif"), resultSet.getString("status"), resultSet.getString("description"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    //Method to get all rooms
    public List<Room> getAllRooms() {
        List<Room> rooms = null;
        try {
            connection = DbConnecting.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM room");
            ResultSet resultSet = preparedStatement.executeQuery();
            rooms = new ArrayList<>();
            while (resultSet.next()) {
                rooms.add(new Room(resultSet.getInt(1), resultSet.getInt(2), resultSet.getDouble(3), resultSet.getString(4), resultSet.getString(5)));
            }
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rooms;
    }
    //methode to get room by type
    public List<Room> getRoomByType(int idType) {
        List<Room> rooms = null;
        try {
            connection = DbConnecting.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM room WHERE idtype = ?");
            preparedStatement.setInt(1, idType);
            ResultSet resultSet = preparedStatement.executeQuery();
            rooms = new ArrayList<>();
            while (resultSet.next()) {
                rooms.add(new Room(resultSet.getInt(1), resultSet.getInt(2),resultSet.getInt(3),resultSet.getDouble(6), resultSet.getString(5), resultSet.getString(4)));
            }
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rooms;
    }
    //methode to check if room is exist
    public boolean isRoomExist(int num) {
        try {
            connection = DbConnecting.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM room WHERE num = ?");
            preparedStatement.setInt(1, num);
             resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
    //getting types
    public List<Type> getTypes() {
        List<Type> types = null;
        try {
            connection = DbConnecting.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM type");
            ResultSet resultSet = preparedStatement.executeQuery();
            types = new ArrayList<>();
            while (resultSet.next()) {
                types.add(new Type(resultSet.getInt(1), resultSet.getString(2)));
            }
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return types;
    }
    //getting type by id
    public Type getRoomType(int id) {
        try {
            connection = DbConnecting.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM type WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Type(resultSet.getInt(1), resultSet.getString(2));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    //get room id by num
    public int getRoomId(int num) {
        try {
            connection = DbConnecting.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM room WHERE num = ?");
            preparedStatement.setInt(1, num);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
