package com.example.hotelkharbouchaa.Image;
import java.util.*;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import com.Database.DbConnecting.DbConnecting;

public class ImageRepository {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    //save  images
    public void saveImage(Image images) throws ClassNotFoundException {
        try {
            connection = DbConnecting.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO image (name, idroom) VALUES(?, ?)");
            preparedStatement.setString(1, images.getName());
            preparedStatement.setInt(2, images.getIdR());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    //getting roome images
    public List<Image> getImages(int idR) throws ClassNotFoundException {
        List<Image> images = new ArrayList<>();
        try {
            connection = DbConnecting.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM image WHERE idroom = ?");
            preparedStatement.setInt(1, idR);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Image image = new Image(resultSet.getInt(1), resultSet.getString(2));
                images.add(image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return images;
    }

       
   
}
