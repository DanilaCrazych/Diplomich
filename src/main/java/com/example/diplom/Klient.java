package com.example.diplom;
public class Klient {
        int Id;
        String FIO;
        String Telefon;
        String Adres;
        String OpisanieAd;
    public int getId() {
        return Id;
    }

    public void setId(int id) {Id = id;}

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        FIO = FIO;
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

    public void setOpisanieAd(String OpisanieAd) {
        OpisanieAd = OpisanieAd;
    }

    public Klient(int id, String fio, String telefon, String adres, String opisanieAd) {
        Id = id;
        FIO = fio;
        Telefon = telefon;
        Adres = adres;
        OpisanieAd = opisanieAd;
    }
}
