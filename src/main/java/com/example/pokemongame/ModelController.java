package com.example.pokemongame;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class ModelController {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader (isr);
    @FXML
    private ProgressBar barravidapokemon;

    @FXML
    private Button botonseleccion;

    @FXML
    public HBox fondoeleccion;

    @FXML
    private ImageView iconopspokemon;

    @FXML
    private ImageView imgpokemon;

    @FXML
    private Label nivelpokemon;

    @FXML
    private Label nombrepokemon;

    @FXML
    private ImageView sexopokemon;

    @FXML
    private Label vidaActual;

    @FXML
    private Label vidaMaxima;


    private HelloController controllerVentanaAnterior;

    @FXML
    public void seleccionPokemon(MouseEvent event){
        pokemons.setSeleccionado(true);
        controllerVentanaAnterior.pokemonSeleccionado();
        fondoeleccion.setStyle("-fx-background-color: blue");
        //fondoeleccion.setStyle("-fx-background-color: red");


    }


    private Pokemons pokemons;

    public void setData(Pokemons pokemons, HelloController controller){
            this.controllerVentanaAnterior = controller;
            this.pokemons=pokemons;
            nombrepokemon.setText(pokemons.getNombrepokemon());
            nivelpokemon.setText("Nv"+pokemons.getNivelpokemon());
            vidaActual.setText(""+pokemons.getVidaActual());
            Image imggenero=new Image(pokemons.getImagengenero());
            sexopokemon.setImage(imggenero);
            Image imgpoke=new Image(pokemons.getImgenpokemon());
            imgpokemon.setImage(imgpoke);
            Image imgps=new Image(pokemons.getImagenps());
            iconopspokemon.setImage(imgps);
            barravidapokemon.setStyle("-fx-accent: #00FA00");
            pokemons.setSeleccionado(false);

    }


    public void pokemonNoSeleccionado() {
        fondoeleccion.setStyle("-fx-background-color: red");
    }
}
