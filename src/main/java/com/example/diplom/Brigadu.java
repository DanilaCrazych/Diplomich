package com.example.diplom;

public class Brigadu {
    int Id;
    String Brigadir;
    String Sotrudniki;
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getBrigadir() {
        return Brigadir;
    }

    public void setBrigadir(String brigadir) {
        Brigadir = brigadir;
    }
    public String getSotrudniki() {
        return Sotrudniki;
    }

    public void setSotrudniki(String sotrudniki) {
        Sotrudniki = sotrudniki;
    }
    public Brigadu(int id, String brigadir, String sotrudniki) {
        Id = id;
        Brigadir = brigadir;
        Sotrudniki = sotrudniki;
    }
}
