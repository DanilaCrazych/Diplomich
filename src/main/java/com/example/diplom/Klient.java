package com.example.diplom;

public class Klient {
    private int Id;
    private String FIO;
    private String Telefon;
    private String Adres;
    private String OpisanieAd;

    // Конструктор без параметров
    public Klient() {}

    // Геттеры и сеттеры
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
    }

    public String getAdres() {
        return Adres;
    }

    public void setAdres(String adres) {
        Adres = adres;
    }

    public String getOpisanieAd() {
        return OpisanieAd;
    }

    public void setOpisanieAd(String opisanieAd) {
        OpisanieAd = opisanieAd;
    }

    public Klient(int id, String fio, String telefon, String adres, String opisanieAd) {
        Id = id;
        FIO = fio;
        Telefon = telefon;
        Adres = adres;
        OpisanieAd = opisanieAd;
    }
}
