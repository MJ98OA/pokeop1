package com.example.pokemongame;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;

import java.io.IOException;


public class ModelController<modelcontroller> {



    @FXML
    private Label barra;

    @FXML
    public ProgressBar barravidapokemon;

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


    private EscenarioSeleccionController controllerVentanaAnterior;

    public static Pokemons mipokemonSeleccionado;




    @FXML
    public void seleccionPokemon (MouseEvent event) throws IOException {

        controllerVentanaAnterior.pokemonSeleccionado();
        fondoeleccion.setStyle("-fx-background-color: #A99DB0");
        nombrepokemon.setTextFill(Paint.valueOf("#E8F6F8"));
        nivelpokemon.setTextFill(Paint.valueOf("#E8F6F8"));
        vidaActual.setTextFill(Paint.valueOf("#E8F6F8"));
        vidaMaxima.setTextFill(Paint.valueOf("#E8F6F8"));
        barra.setTextFill(Paint.valueOf("#E8F6F8"));
        controllerVentanaAnterior.bBatalla.setVisible(true);
        System.out.println(cargadepPokemons.getVidaActual());

        mipokemonSeleccionado = cargadepPokemons;

        System.out.println(mipokemonSeleccionado.getVidaActual());

    }


    public Pokemons cargadepPokemons;

    public void setData(Pokemons pokemons, EscenarioSeleccionController controller) throws IOException {
            this.controllerVentanaAnterior = controller;
            this.cargadepPokemons =pokemons;

            nombrepokemon.setText(pokemons.getNombrepokemon());
            nivelpokemon.setText("Nv"+pokemons.getNivelpokemon());
            vidaActual.setText(""+pokemons.getVidaActual());
            vidaMaxima.setText(""+pokemons.getVidaMaxima());
            Image imggenero=new Image(pokemons.getImagengenero());
            sexopokemon.setImage(imggenero);
            Image imgpoke=new Image(pokemons.getImgenpokemon());
            imgpokemon.setImage(imgpoke);
            Image imgps=new Image(pokemons.getImagenps());
            iconopspokemon.setImage(imgps);
            double resultadovida = (double) pokemons.getVidaActual() / pokemons.getVidaMaxima();
            if(resultadovida>0.7){
                barravidapokemon.setStyle("-fx-accent: #00FA00");
                barravidapokemon.setProgress(resultadovida);
            }
            else
                if(resultadovida>=0.4 && resultadovida<0.7){
                    barravidapokemon.setStyle("-fx-accent:yellow");
                    barravidapokemon.setProgress(resultadovida);
                }
                else{
                    barravidapokemon.setStyle("-fx-accent:red");
                    barravidapokemon.setProgress(resultadovida);
                }


    }


    public void pokemonNoSeleccionado() {
        fondoeleccion.setStyle("-fx-background-color: #524659");
        nombrepokemon.setTextFill(Paint.valueOf("#86C4FF"));
        nivelpokemon.setTextFill(Paint.valueOf("#86C4FF"));
        vidaActual.setTextFill(Paint.valueOf("#86C4FF"));
        vidaMaxima.setTextFill(Paint.valueOf("#86C4FF"));
        barra.setTextFill(Paint.valueOf("#86C4FF"));
    }





}
