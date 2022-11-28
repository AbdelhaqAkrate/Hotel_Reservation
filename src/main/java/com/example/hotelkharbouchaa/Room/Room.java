package com.example.hotelkharbouchaa.Room;

public class Room {
    private int idR;
    private int num;
    private int idType;
    private String status;
    private String description;
    private double tarif;
    public Room()
    {
        //
    }
    public Room(int num, int idType, double tarif, String status, String description) {
        this.num = num;
        this.idType = idType;
        this.tarif = tarif;
        this.status = status;
        this.description = description;
    }
    public Room(int idR, int num, int idType, double tarif, String status, String description) {
        this.idR = idR;
        this.num = num;
        this.idType = idType;
        this.tarif = tarif;
        this.status = status;
        this.description = description;
    }
    public int getIdR() {
        return idR;
    }
    public void setIdR(int idR) {
        this.idR = idR;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public int getIdType() {
        return idType;
    }
    public void setIdType(int idType) {
        this.idType = idType;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getTarif() {
        return tarif;
    }
    public void setTarif(double tarif) {
        this.tarif = tarif;
    }


    
}   
