package com.example.diplom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetDate {
    public ObservableList<Naryadu> listNaryadu = FXCollections.observableArrayList();
    public ObservableList<Klient> listKlient = FXCollections.observableArrayList();
    public ObservableList<Object> listObject = FXCollections.observableArrayList();
    public ObservableList<Sotrudniki> listSotrudniki = FXCollections.observableArrayList();
    public ObservableList<Brigadu> listBrigadu = FXCollections.observableArrayList();
    ConBD cb = new ConBD();
    public void getDataNaryadu() {
        listNaryadu.clear();
        cb.ConnectBd();
        try {
            Statement statement = cb.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Naryadu");
            while (resultSet.next()) {
                listNaryadu.add(new Naryadu(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10)));
            }
        } catch (SQLException e) {
            System.out.println("Connection failed...");
            System.out.println(e);
        }
    }
    public void getDataKlient() throws SQLException {
        listKlient.clear();
        cb.ConnectBd();
        try {
            Statement statement = cb.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Klient");
            while (resultSet.next()) {
                listKlient.add(new Klient(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
            }
        } catch (SQLException e) {
            System.out.println("Connection failed...");
            System.out.println(e);
        }
        cb.connecctionclose();
    }
    public void getDataObject() throws SQLException {
        listObject.clear();
        cb.ConnectBd();
        try {
            Statement statement = cb.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Object");
            while (resultSet.next()) {
                listObject.add(new Object(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8)));
            }
        } catch (SQLException e) {
            System.out.println("Connection failed...");
            System.out.println(e);
        }
        cb.connecctionclose();
    }
    public void getDataSotrudniki() throws SQLException {
        listSotrudniki.clear();
        cb.ConnectBd();
        try {
            Statement statement = cb.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Sotrudniki");
            while (resultSet.next()) {
                listSotrudniki.add(new Sotrudniki(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6)));
            }
        } catch (SQLException e) {
            System.out.println("Connection failed...");
            System.out.println(e);
        }
        cb.connecctionclose();
    }
    public void getDataBrigadu() throws SQLException {
        listBrigadu.clear();
        cb.ConnectBd();
        try {
            Statement statement = cb.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Brigadu");
            while (resultSet.next()) {
                listBrigadu.add(new Brigadu(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
        } catch (SQLException e) {
            System.out.println("Connection failed...");
            System.out.println(e);
        }
        cb.connecctionclose();
    }
}