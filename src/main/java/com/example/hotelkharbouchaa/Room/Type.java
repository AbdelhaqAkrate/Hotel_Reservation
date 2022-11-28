package com.example.hotelkharbouchaa.Room;

public class Type {
    private int id;
    private String name;
    public Type()
    {
        
    }
    public Type(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Type(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setIdType(int idType) {
        this.id = idType;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
