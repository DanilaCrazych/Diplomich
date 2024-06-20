package com.example.diplom;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.IOException;
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/com/example/diplom/Danon4.fxml"));
        Scene scene = new Scene(root, Screen.getPrimary().getBounds().getWidth(), Screen.getPrimary().getBounds().getHeight());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setFullScreen(false);
        stage.show();
    }
    public static void main(String[] args) {launch();
    }
 }


