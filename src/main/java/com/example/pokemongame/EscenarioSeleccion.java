package com.example.pokemongame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EscenarioSeleccion extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(EscenarioSeleccion.class.getResource("Escenario.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 900, 550);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}