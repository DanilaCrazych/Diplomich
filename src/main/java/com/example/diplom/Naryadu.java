package com.example.diplom;

import java.util.Date;

public class Naryadu {
    int Id;
    String Nazvanie;
    String Opisanie;
    String Klient;
    String Adres;
    String Ispolnitel;
    String Zaplanirovan;
    String S;
    String Do;
    String Sostoyanie;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    public String getSostoyanie() {
        return Sostoyanie;
    }

    public void setSostoyanie(String Sostoyanie) {
        this.Sostoyanie = Sostoyanie;
    }


    public String getNazvanie() {
        return Nazvanie;
    }

    public void setNazvanie(String Nazvanie) {
        this.Nazvanie = Nazvanie;
    }

    public String getOpisanie() {
        return Opisanie;
    }

    public void setOpisanie(String Opisanie) {
        this.Opisanie = Opisanie;
    }
    public String getKlient() {
        return Klient;
    }

    public void setKlient(String Klient) {
        this.Klient = Klient;
    }

    public String getAdres() {
        return Adres;
    }

    public void setAdres(String Adres) {
        this.Adres = Adres;
    }
    public String getZaplanirovan() {
        return Zaplanirovan;
    }

    public void setZaplanirovan(String Zaplanirovan) {
        this.Zaplanirovan = Zaplanirovan;
    }
    public String getS() {
        return S;
    }

    public void setS(String S) {
        this.S = S;
    }

    public String getDo() {
        return Do;
    }

    public void setDo(String Do) {
        this.Do = Do;
    }
    public String getIspolnitel() {
        return Ispolnitel;
    }

    public void setIspolnitel(String Ispolnitel) {
        this.Ispolnitel = Ispolnitel;
    }

    public Naryadu(int Id,  String Nazvanie, String Opisanie, String Klient, String Adres, String Ispolnitel, String Zaplanirovan, String S, String Do, String Sostoyanie) {
        this.Id = Id;
        this.Nazvanie = Nazvanie;
        this.Opisanie = Opisanie;
        this.Klient = Klient;
        this.Adres = Adres;
        this.Ispolnitel = Ispolnitel;
        this.Zaplanirovan = Zaplanirovan;
        this.S = S;
        this.Do = Do;
        this.Sostoyanie = Sostoyanie;
    }
}

