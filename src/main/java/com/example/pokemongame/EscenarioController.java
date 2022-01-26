package com.example.pokemongame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EscenarioController implements Initializable {


    @FXML
    private Button bAtacar;

    @FXML
    private Button bCurar;

    @FXML
    private AnchorPane fondoBatalla;

    @FXML
    private ImageView miPokemon;

    @FXML
    private Label nivelMiPokemon;

    @FXML
    private Label nivelPokemonEnemigo;

    @FXML
    private Label nombreMiPokemon;

    @FXML
    private Label nombrePokemonEnemigo;

    @FXML
    private Pane pokemonEnemigo;

    @FXML
    private ImageView psimgA;

    @FXML
    private ImageView psimgE;

    @FXML
    private Label txAtaque1;

    @FXML
    private Label txAtaque2;

    @FXML
    private Label txAtaque3;

    @FXML
    private Label txCancelar;

    @FXML
    private ProgressBar vidaMiPokemon;

    @FXML
    private ProgressBar vidaPokemonEnemigo;

    @FXML
    void bAtaque1(MouseEvent event) {

    }

    @FXML
    void bAtaque2(MouseEvent event) {

    }

    @FXML
    void bAtaque3(MouseEvent event) {

    }

    @FXML
    void bCurar(MouseEvent event) {

    }

    @FXML
    void bMenuAtaques(MouseEvent event) {

    }

    @FXML
    void bcancelar(MouseEvent event) {

    }





    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Pokemons> listaPokemons=new ArrayList<>();
        Pokemons p1=new Pokemons("Miutu",123,"src\\main\\java\\com\\example\\pokemongame\\img\\mewtwo.gif","src\\main\\java\\com\\example\\pokemongame\\img\\male.png","src\\main\\java\\com\\example\\pokemongame\\img\\ps.png",200,200,true);
        Pokemons p2=new Pokemons("Aggron",73,"src\\main\\java\\com\\example\\pokemongame\\img\\aggron-mega.gif","src\\main\\java\\com\\example\\pokemongame\\img\\male.png","src\\main\\java\\com\\example\\pokemongame\\img\\ps.png",180,180,false);
        listaPokemons.add(p1);
        listaPokemons.add(p2);

        try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("modelo.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();
        ModelController modelController = fxmlLoader.getController();
        Pokemons p=modelController.devolvercontrolador();
        nombreMiPokemon.setText(p.getNombrepokemon());
        Image imgMiPokemon=new Image(p.getImgenpokemon());
        miPokemon.setImage(imgMiPokemon);
        nivelMiPokemon.setText(""+p.getNivelpokemon());
        vidaMiPokemon.setStyle(""+p.getVidaActual());
        txAtaque1.setVisible(false);
        txAtaque2.setVisible(false);
        txAtaque3.setVisible(false);
        txCancelar.setVisible(false);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}

