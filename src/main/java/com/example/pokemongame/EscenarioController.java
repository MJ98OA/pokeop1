package com.example.pokemongame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EscenarioController implements Initializable {



    @FXML
    public AnchorPane fondoBatalla;


    @FXML
    public ImageView miPokemon;

    @FXML
    public Label trucutu;

    private ModelController modelController;
    private Pokemons pokemio;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        trucutu.setText(pokemio.getNombrepokemon());




    }

    public void obtenerPoke(Pokemons pokemons, ModelController controller) throws IOException {
        this.modelController = controller;
        this.pokemio=pokemons;

    }

}

