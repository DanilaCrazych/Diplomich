package com.example.diplom;

public class Sotrudniki {
    int Id;
    String FIO;
    String Telefon;
    String Pochta;
    String Parol;
    int Administrator;

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
        FIO = FIO;
    }

    public String getPochta() {
        return Pochta;
    }

    public void setPochta(String Pochta) {
        Pochta = Pochta;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
    }

    public String getParol() {
        return Parol;
    }

    public void setParol(String parol) {
        Parol = parol;
    }
    public int getAdministrator() {
        return Administrator;
    }

    public void setAdministrator(int administrator) {
        Administrator = administrator;
    }

    public Sotrudniki(int id, String fio, String telefon, String pochta, String parol, int administrator) {
        Id = id;
        FIO = fio;
        Telefon = telefon;
        Pochta = pochta;
        Parol = parol;
        Administrator = administrator;
    }
}