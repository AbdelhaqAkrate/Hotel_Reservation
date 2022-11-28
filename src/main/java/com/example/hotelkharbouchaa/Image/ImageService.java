package com.example.hotelkharbouchaa.Image;

import java.util.List;

import com.example.hotelkharbouchaa.Room.RoomRepository;

public class ImageService {
    //save image
    public void saveImage(Image images) throws ClassNotFoundException {
        ImageRepository imageRepository = new ImageRepository();
        imageRepository.saveImage(images);
    }
    //getting room images
    public List<Image> getImages(int num) throws ClassNotFoundException {
        ImageRepository imageRepository = new ImageRepository();
        RoomRepository roomRepository = new RoomRepository();
        int id = roomRepository.getRoomId(num);
        return imageRepository.getImages(id);
    }
}
