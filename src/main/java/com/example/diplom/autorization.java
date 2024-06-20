package com.example.diplom;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class autorization {
    ConBD cb = new ConBD();
    @FXML
    private Button VhodMenu;
    @FXML
    private Pane NaryaduPane, AdresaPane, BrigaduPane, SotrudnikiPane, AvtorizP, NewOb, NewNr, NewKl, VuhodPane, VoprosPane, NewBrigada,NewSotrudnik, IzmenitSotrudnik, IzmenitBrigada;
    @FXML
    private BorderPane borderP;
    @FXML
    private TextField Mail_login, password_login;


    public void autorization(){
        ConBD cb = new ConBD();
        private Connection connection;
        String query = "SELECT mail, password FROM users WHERE login LIKE '" + Mail_login.getText() + "'";
        String loginAuth = "";
        String passAuth = "";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                loginAuth = resultSet.getString(1);
                passAuth = resultSet.getString(2);
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        if (login_loginField.getText().equals("") | login_passField.getText().equals("")) {
            login_error.setText("Введите логин и пароль!");
            login_error.setVisible(true);
        } else if (login_loginField.getText().equals(loginAuth)||login_passField.getText().equals(passAuth)) {
            login_page.setVisible(false);
            main_page.setVisible(true);
        } else {
            login_error.setText("Неверный логин или пароль!");
            login_error.setVisible(true);}
    }
    }
}
