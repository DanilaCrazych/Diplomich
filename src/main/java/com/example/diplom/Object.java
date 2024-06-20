package com.example.diplom;

public class Object {
    int Id;
    String Nazvanie;
    String OpisanieOb;
    String YurLico;
    String Adres;
    String OpisanieAd;
    String Pochta;
    String Telefon;


    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNazvanie() {
        return Nazvanie;
    }

    public void setNazvanie(String Nazvanie) {
        this.Nazvanie = Nazvanie;
    }

    public String getOpisanieOb() {
        return OpisanieOb;
    }

    public void setOpisanieOb(String OpisanieOb) {
        this.OpisanieOb = OpisanieOb;
    }
    public String getOpisanieAd() {
        return OpisanieAd;
    }

    public void setOpisanieAd(String OpisanieAd) {
        this.OpisanieAd = OpisanieAd;
    }
    public String getYurLico() {
        return YurLico;
    }

    public void setYurLico(String YurLico) {
        this.YurLico = YurLico;
    }

    public String getAdres() {
        return Adres;
    }

    public void setAdres(String Adres) {
        this.Adres = Adres;
    }
    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String Telefon) {
        this.Telefon = Telefon;
    }
    public String getPochta() {
        return Pochta;
    }

    public void setPochta(String Pochta) {
        this.Pochta = Pochta;
    }

    public Object(int Id,  String Nazvanie, String OpisanieOb, String YurLico, String Adres, String OpisanieAd, String Pochta, String Telefon) {
        this.Id = Id;
        this.Nazvanie = Nazvanie;
        this.OpisanieOb = OpisanieOb;
        this.OpisanieAd = OpisanieAd;
        this.Pochta = Pochta;
        this.YurLico = YurLico;
        this.Adres = Adres;
        this.Telefon = Telefon;
    }
}
