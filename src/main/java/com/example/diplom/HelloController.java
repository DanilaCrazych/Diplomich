package com.example.diplom;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    ObservableList<Naryadu> listNaryadu;
    ObservableList<Object> listObject;
    ObservableList<Klient> listKlient;
    ObservableList<Sotrudniki> listSotrudniki;
    ObservableList<Brigadu> listBrigadu;
    GetDate gd = new GetDate();
    ConBD cb = new ConBD();
    @FXML
    private TextField KlFIO, KlTel, KlAd, ObNaz, ObYurLico, ObAd, ObTel, ObPochta, NarNaz, NarOp, NarOb, NarAd, NarIspolin, NarZap, NarS, NarDo, NarSos, TFUdKl, TFUdOb;
    @FXML
    private TextArea TAObOpOb, TAObOpAd, TAKlOpAd;
    @FXML
    private Pane NaryaduPane, AdresaPane, BrigaduPane, SotrudnikiPane, AvtorizP, NewOb, NewNr, NewKl, VuhodPane, VoprosPane, NewBrigada,NewSotrudnik, IzmenitSotrudnik, IzmenitBrigada;
    @FXML
    private BorderPane borderP;
    @FXML
    private ComboBox ComboNarOb2, ComboNarIspolin, ComboNarSos;
    @FXML
    private DatePicker DataNar;
    @FXML
    private TableColumn<Klient, Integer> Klient_Id;
    @FXML
    private TableColumn<Klient, String> Klient_FIO;
    @FXML
    private TableColumn<Klient, String> Klient_Tel;
    @FXML
    private TableColumn<Klient, String> Klient_Ad;
    @FXML
    private TableColumn<Klient, String> Klient_OpAd;
    @FXML
    private TableView<Klient> Klient;
    @FXML
    private TableColumn<Object, Integer> Object_Id;
    @FXML
    private TableColumn<Object, String> Object_Naz;
    @FXML
    private TableColumn<Object, String> Object_OpOb;
    @FXML
    private TableColumn<Object, String> Object_YurLico;
    @FXML
    private TableColumn<Object, String> Object_Ad;
    @FXML
    private TableColumn<Object, String> Object_OpAd;
    @FXML
    private TableColumn<Object, String> Object_Pochta;
    @FXML
    private TableColumn<Object, String> Object_Tel;
    @FXML
    private TableView<Object> Object;
    @FXML
    private TableColumn<Naryadu, Integer> Nar_Id;
    @FXML
    private TableColumn<Naryadu, String> Nar_Naz;
    @FXML
    private TableColumn<Naryadu, String> Nar_Op;
    @FXML
    private TableColumn<Naryadu, String> Nar_Kl;
    @FXML
    private TableColumn<Naryadu, String> Nar_Ad;
    @FXML
    private TableColumn<Naryadu, String> Nar_Is;
    @FXML
    private TableColumn<Naryadu, Date> Nar_Zap;
    @FXML
    private TableColumn<Naryadu, String> Nar_S;
    @FXML
    private TableColumn<Naryadu, String> Nar_Do;
    @FXML
    private TableColumn<Naryadu, String> Nar_Sostoyanie;
    @FXML
    private TableView<Naryadu> Nar;
    @FXML
    private TableColumn<Sotrudniki, Integer> Sotrudniki_Id;
    @FXML
    private TableColumn<Sotrudniki, String> Sotrudniki_FIO;
    @FXML
    private TableColumn<Sotrudniki, String> Sotrudniki_Tel;
    @FXML
    private TableColumn<Sotrudniki, String> Sotrudniki_Pochta;
    @FXML
    private TableView<Sotrudniki> Sotrudniki;
    @FXML
    private TableColumn<Brigadu, Integer> Brigadu_Id;
    @FXML
    private TableColumn<Brigadu, String> Brigadu_Brigadir;
    @FXML
    private TableColumn<Brigadu, String> Brigadu_Sotrudnik;
    @FXML
    private TableView<Brigadu> Brigadu;
    String url = "jdbc:mysql://virps.ru:3106/Diplomich";
    String user = "diplomich";
    String password = "danila080808";
    private Connection connection;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cb.ConnectBd();
        gd.getDataNaryadu();
        listNaryadu = gd.listNaryadu;
        try {
            this.connection = DriverManager.getConnection(this.url, this.user, this.password);
            Nar_Id.setCellValueFactory(new PropertyValueFactory<Naryadu, Integer>("Id"));
            Nar_Naz.setCellValueFactory(new PropertyValueFactory<Naryadu, String>("Nazvanie"));
            Nar_Op.setCellValueFactory(new PropertyValueFactory<Naryadu, String>("Opisanie"));
            Nar_Kl.setCellValueFactory(new PropertyValueFactory<Naryadu, String>("Klient"));
            Nar_Ad.setCellValueFactory(new PropertyValueFactory<Naryadu, String>("Adres"));
            Nar_Is.setCellValueFactory(new PropertyValueFactory<Naryadu, String>("Ispolnitel"));
            Nar_Zap.setCellValueFactory(new PropertyValueFactory<Naryadu, Date>("Zaplanirovan"));
            Nar_S.setCellValueFactory(new PropertyValueFactory<Naryadu, String>("S"));
            Nar_Do.setCellValueFactory(new PropertyValueFactory<Naryadu, String>("Do"));
            Nar_Sostoyanie.setCellValueFactory(new PropertyValueFactory<Naryadu, String>("Sostoyanie"));
            Nar.setItems(listNaryadu);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        NaryaduPane.setVisible(true);
        AdresaPane.setVisible(false);
//        GrahikPane.setVisible(false);
        SotrudnikiPane.setVisible(false);
        NewNr.setVisible(false);
        NewKl.setVisible(false);
        NewOb.setVisible(false);
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @FXML
    public void onCloseKl2() {
        NewKl.setVisible(false);
    }

    @FXML
    public void onCloseNr2() {
        NewNr.setVisible(false);
    }

    @FXML
    public void onCloseOb2() {
        NewOb.setVisible(false);
    }

    @FXML
    public void onCloseKl() {
        NewKl.setVisible(false);
    }

    @FXML
    public void onCloseNr() {
        NewNr.setVisible(false);
    }

    @FXML
    public void onCloseOb() {
        NewOb.setVisible(false);
    }

    //    @FXML
//    public void onComboAd() {
//        for (int i = 0; i < listObject.size(); i++){
//            ComboNarOb.getItems().add(listObject.get(i));
//        }
//    }
//    @FXML
//    protected void onComboIspolin() {
//        for (int i = 0; i < listSotrudniki.size(); i++){
//            ComboNarIspolin.getItems().add(listSotrudniki.get(i));
//        }
//    }
    @FXML
    protected void FILLFalse(){
        NewBrigada.setVisible(false);
        NewSotrudnik.setVisible(false);
        IzmenitBrigada.setVisible(false);
        IzmenitSotrudnik.setVisible(false);

    }
    @FXML
    protected void onDobNK() {
        FILLFalse();
        NewKl.setVisible(false);
        NewNr.setVisible(false);
        NewOb.setVisible(true);
        VuhodPane.setVisible(false);
        VoprosPane.setVisible(false);

    }
    @FXML
    protected void AktivVuhod() {
        FILLFalse();
        borderP.setVisible(false);
        AvtorizP.setVisible(true);
    }
    @FXML
    protected void AktivVopros() {
        FILLFalse();
        VoprosPane.setVisible(true);
        VuhodPane.setVisible(false);
    }
    @FXML
    protected void AktivPochta() {
        FILLFalse();
        VuhodPane.setVisible(true);
        VoprosPane.setVisible(false);
    }


    @FXML
    protected void OnDobOb() {
        FILLFalse();
        NewOb.setVisible(true);
        NewNr.setVisible(false);
        NewKl.setVisible(false);
        VuhodPane.setVisible(false);
        VoprosPane.setVisible(false);
    }

    @FXML
    protected void OnDobNr() {
        FILLFalse();
        NewNr.setVisible(true);
        NewKl.setVisible(false);
        NewOb.setVisible(false);
        VuhodPane.setVisible(false);
        VoprosPane.setVisible(false);
    }

    @FXML
    protected void OnDobKl() {
        FILLFalse();
        NewKl.setVisible(true);
        NewNr.setVisible(false);
        NewOb.setVisible(false);
        VuhodPane.setVisible(false);
        VoprosPane.setVisible(false);
    }

    @FXML
    protected void OnMenuVhod() {

        borderP.setVisible(true);
        AvtorizP.setVisible(false);

    }

    @FXML
    protected void AktivUdKl() {

    }
    @FXML
    protected void AktivUdOb() {

    }
    @FXML
    protected void OnDobSot() {
        FILLFalse();
        NewSotrudnik.setVisible(true);
    }

    @FXML
    protected void OnDobBrig() {
        FILLFalse();
        NewBrigada.setVisible(true);
    }

    @FXML
    protected void OnIzmSot() {
        FILLFalse();
        IzmenitSotrudnik.setVisible(true);
    }

    @FXML
    protected void OnIzmBrig() {
        FILLFalse();
        IzmenitBrigada.setVisible(true);
    }
    @FXML
    protected void onZagOb(){}
    @FXML
    protected void onZagKl(){}
    @FXML
    protected void onZagSot(){}
    @FXML
    protected void OpenMenuNaryadu() {
        cb.ConnectBd();
        gd.getDataNaryadu();
        listNaryadu = gd.listNaryadu;
        try {
            Nar_Id.setCellValueFactory(new PropertyValueFactory<Naryadu, Integer>("Id"));
            Nar_Naz.setCellValueFactory(new PropertyValueFactory<Naryadu, String>("Nazvanie"));
            Nar_Op.setCellValueFactory(new PropertyValueFactory<Naryadu, String>("Opisanie"));
            Nar_Kl.setCellValueFactory(new PropertyValueFactory<Naryadu, String>("Klient"));
            Nar_Ad.setCellValueFactory(new PropertyValueFactory<Naryadu, String>("Adres"));
            Nar_Is.setCellValueFactory(new PropertyValueFactory<Naryadu, String>("Ispolnitel"));
            Nar_Zap.setCellValueFactory(new PropertyValueFactory<Naryadu, Date>("Zaplanirovan"));
            Nar_S.setCellValueFactory(new PropertyValueFactory<Naryadu, String>("S"));
            Nar_Do.setCellValueFactory(new PropertyValueFactory<Naryadu, String>("Do"));
            Nar_Do.setCellValueFactory(new PropertyValueFactory<Naryadu, String>("Sщstщyanie"));
            Nar.setItems(listNaryadu);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        NaryaduPane.setVisible(true);
        AdresaPane.setVisible(false);
        BrigaduPane.setVisible(false);
        SotrudnikiPane.setVisible(false);
        NewNr.setVisible(false);
        NewKl.setVisible(false);
        NewOb.setVisible(false);
        VuhodPane.setVisible(false);
        VoprosPane.setVisible(false);
    }

    @FXML
    protected void OpenMenuAdresa() throws SQLException {
        gd.getDataKlient();
        gd.getDataObject();
        listKlient = gd.listKlient;
        try {
            Klient_Id.setCellValueFactory(new PropertyValueFactory<Klient, Integer>("Id"));
            Klient_FIO.setCellValueFactory(new PropertyValueFactory<Klient, String>("FIO"));
            Klient_Tel.setCellValueFactory(new PropertyValueFactory<Klient, String>("Telefon"));
            Klient_Ad.setCellValueFactory(new PropertyValueFactory<Klient, String>("Adres"));
            Klient_OpAd.setCellValueFactory(new PropertyValueFactory<Klient, String>("OpisanieAd"));
            Klient.setItems(listKlient);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        listObject = gd.listObject;
        try {
            Object_Id.setCellValueFactory(new PropertyValueFactory<Object, Integer>("Id"));
            Object_Naz.setCellValueFactory(new PropertyValueFactory<Object, String>("Nazvanie"));
            Object_OpOb.setCellValueFactory(new PropertyValueFactory<Object, String>("OpisanieOb"));
            Object_Ad.setCellValueFactory(new PropertyValueFactory<Object, String>("Adres"));
            Object_OpAd.setCellValueFactory(new PropertyValueFactory<Object, String>("OpisanieAd"));
            Object_YurLico.setCellValueFactory(new PropertyValueFactory<Object, String>("YurLico"));
            Object_Tel.setCellValueFactory(new PropertyValueFactory<Object, String>("Telefon"));
            Object_Pochta.setCellValueFactory(new PropertyValueFactory<Object, String>("Pochta"));
            Object.setItems(listObject);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        NaryaduPane.setVisible(false);
        AdresaPane.setVisible(true);
        BrigaduPane.setVisible(false);
        SotrudnikiPane.setVisible(false);
        NewNr.setVisible(false);
        NewKl.setVisible(false);
        NewOb.setVisible(false);
        VuhodPane.setVisible(false);
        VoprosPane.setVisible(false);
    }

    @FXML
    protected void OpenMenuBrigadu() throws SQLException{
        gd.getDataBrigadu();
        listBrigadu = gd.listBrigadu;
        try {
            Brigadu_Id.setCellValueFactory(new PropertyValueFactory<Brigadu, Integer>("Id"));
            Brigadu_Brigadir.setCellValueFactory(new PropertyValueFactory<Brigadu, String>("Brigadir"));
            Brigadu_Sotrudnik.setCellValueFactory(new PropertyValueFactory<Brigadu, String>("Sotrudniki"));
            Brigadu.setItems(listBrigadu);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        NaryaduPane.setVisible(false);
        AdresaPane.setVisible(false);
        BrigaduPane.setVisible(true);
        SotrudnikiPane.setVisible(false);
        NewNr.setVisible(false);
        NewKl.setVisible(false);
        NewOb.setVisible(false);
        VuhodPane.setVisible(false);
        VoprosPane.setVisible(false);
    }

    @FXML
    protected void OpenMenuSotrudniki() throws SQLException {
        gd.getDataSotrudniki();
        listSotrudniki = gd.listSotrudniki;
        try {
            Sotrudniki_Id.setCellValueFactory(new PropertyValueFactory<Sotrudniki, Integer>("Id"));
            Sotrudniki_FIO.setCellValueFactory(new PropertyValueFactory<Sotrudniki, String>("FIO"));
            Sotrudniki_Tel.setCellValueFactory(new PropertyValueFactory<Sotrudniki, String>("Telefon"));
            Sotrudniki_Pochta.setCellValueFactory(new PropertyValueFactory<Sotrudniki, String>("Pochta"));
            Sotrudniki.setItems(listSotrudniki);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        NaryaduPane.setVisible(false);
        AdresaPane.setVisible(false);
        BrigaduPane.setVisible(false);
        SotrudnikiPane.setVisible(true);
        NewNr.setVisible(false);
        NewKl.setVisible(false);
        NewOb.setVisible(false);
        VuhodPane.setVisible(false);
        VoprosPane.setVisible(false);
    }


//    @FXML
//    protected void onZagKl() throws SQLException {
//        String FIO = (KlFIO.getText());
//        String Telefon = (KlTel.getText());
//        String Adres = (KlAd.getText());
//        String OpisanieAd = (TAKlOpAd.getText());
//        try {
//            String quary = "INSERT INTO `Diplomich`.`Klient` (`FIO`, `Telefon`, `Adres`, `OpisanieAd`) VALUES ('" + FIO + "', '" + Telefon + "', '" + Adres + "', '" + OpisanieAd + "');";
//            PreparedStatement preparedStatement = connection.prepareStatement(quary);
//            int rows = preparedStatement.executeUpdate();
//            System.out.println("Успешно");
//        } catch (SQLException e) {
//            System.out.println("Неуспешно");
//            printSQLException(e);
//        }
//        KlFIO.clear();
//        TAKlOpAd.clear();
//        KlTel.clear();
//        KlAd.clear();
//        NewKl.setVisible(false);
//        this.OpenMenuAdresa();
//    }

//    @FXML
//    protected void onZagOb() throws SQLException {
//        String Nazvanie = (ObNaz.getText());
//        String OpisanieOb = (TAObOpOb.getText());
//        String Adres = (ObAd.getText());
//        String OpisanieAd = (TAObOpAd.getText());
//        String YurLico = (ObYurLico.getText());
//        String Telefon = (ObTel.getText());
//        String Pochta = (ObPochta.getText());
//        try {
//            String quary = "INSERT INTO `Diplomich`.`Object` (`Nazvanie`, `OpisanieOb`, `Adres`, `OpisanieAd`, `YurLico`, `Telefon`, `Pochta`) VALUES ('" + Nazvanie + "', '" + OpisanieOb + "', '" + Adres + "', '" + OpisanieAd + "', '" + YurLico + "', '" + Telefon + "', '" + Pochta + "');";
//            PreparedStatement preparedStatement = connection.prepareStatement(quary);
//            int rows = preparedStatement.executeUpdate();
//            System.out.println("Успешно");
//        } catch (SQLException e) {
//            System.out.println("Неуспешно");
//            printSQLException(e);
//        }
//        ObNaz.clear();
//        TAObOpOb.clear();
//        ObAd.clear();
//        TAObOpAd.clear();
//        ObYurLico.clear();
//        ObTel.clear();
//        ObPochta.clear();
//        NewOb.setVisible(false);
//        this.OpenMenuAdresa();
//    }

//    @FXML
//    protected void onZagNar() throws SQLException {
//        String Nazvanie = (NarNaz.getText());
//        String Opisanie = (NarOp.getText());
//        String Klient = ComboNarOb.getValue().toString();
//        String Adres = (NarAd.getText());
//        String Ispolnitel = ComboNarIspolin.getValue().toString();
//        String Zaplanirovan = (DataNar.toString());
//        String S = (NarS.getText());
//        String Do = (NarDo.getText());
//        String Sostoyanie = (NarSos.getText());
//        try {
//            String quary = "INSERT INTO `Diplomich`.`Naryadu` (`Nazvanie`, `Opisanie`, `Klient`, `Adres`, `, `Ispolnitel``, `Zaplanirovan`, `S`, `Do`, `Sostoyanie`) VALUES ('" + Nazvanie + "', '" + Opisanie + "', '" + Klient + "', '" + Adres + "', '" + Ispolnitel + "', '" + Zaplanirovan + "', '" + S + "', '" + Do + "', '" + Sostoyanie + "');";
//            PreparedStatement preparedStatement = connection.prepareStatement(quary);
//            int rows = preparedStatement.executeUpdate();
//            System.out.println("Успешно");
//        } catch (SQLException e) {
//            System.out.println("Неуспешно");
//            printSQLException(e);
//        }
//        NarNaz.clear();
//        NarOp.clear();
//        NarAd.clear();
//        NarS.clear();
//        NarDo.clear();
//        ComboNarOb.getItems().clear();
//        DataNar.cancelEdit();
//        ComboNarIspolin.getItems().clear();
//        NarSos.clear();
//        NewOb.setVisible(false);
//        this.OpenMenuAdresa();
//    }

//    @FXML
//    protected void AktivUdKl() throws SQLException {
//        int idTime = Integer.parseInt(TFUdKl.getText());
//        listKlient.remove(idTime - 1);
//        while (idTime < listKlient.size() + 1) {
//            int idNew = idTime - 1;
//            listKlient.set(idTime - 1, new Klient(idTime, listKlient.get(idNew).FIO, listKlient.get(idNew).OpisanieAd, listKlient.get(idNew).Telefon, listKlient.get(idNew).Adres));
//            idTime++;
//        }
//        this.OpenMenuAdresa();
//    }

//    @FXML
//    protected void AktivUdOb() throws SQLException {
//        int idTime = Integer.parseInt(TFUdOb.getText());
//        listObject.remove(idTime - 1);
//        while (idTime < listObject.size() + 1) {
//            int idNew = idTime - 1;
//            listObject.set(idTime - 1, new Object(idTime, listObject.get(idNew).Nazvanie, listObject.get(idNew).OpisanieOb, listObject.get(idNew).Adres, listObject.get(idNew).OpisanieAd, listObject.get(idNew).YurLico, listObject.get(idNew).Telefon, listObject.get(idNew).Pochta));
//            idTime++;
//        }
//        this.OpenMenuAdresa();
//    }
}
