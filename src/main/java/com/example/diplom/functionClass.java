package com.example.diplom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class functionClass {

    public <T> void searchMethod(TextField searchField, String searchBDName, String columnName, TableView<T> tableView, Class<T> clazz) {
        ConBD cb = new ConBD();
        Connection connection = cb.ConnectBd();

        if (connection == null) {
            System.out.println("Failed to make connection!");
            return;
        }

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            String searchText = "%" + newValue + "%";
            String query = "SELECT * FROM " + searchBDName + " WHERE " + columnName + " LIKE ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, searchText);
                ResultSet resultSet = statement.executeQuery();

                ObservableList<T> dataList = FXCollections.observableArrayList();
                while (resultSet.next()) {
                    T instance = clazz.getDeclaredConstructor().newInstance();
                    for (Field field : clazz.getDeclaredFields()) {
                        field.setAccessible(true);
                        field.set(instance, resultSet.getObject(field.getName()));
                    }
                    dataList.add(instance);
                }

                tableView.setItems(dataList);

                // Dynamically set TableColumn values
                for (TableColumn<T, ?> column : tableView.getColumns()) {
                    String columnNameInData = column.getId();
                    if (columnNameInData != null) {
                        column.setCellValueFactory(new PropertyValueFactory<>(columnNameInData));
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}


