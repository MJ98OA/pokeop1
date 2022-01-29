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
import javafx.scene.paint.Paint;
import org.controlsfx.control.PropertySheet;

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
    private ImageView pokemonEnemigo;

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
    private Label vidaActualA;

    @FXML
    private Label vidaActualE;

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
        botonesAtaquesOn();
        botonesMenuInicioOf();

    }

    @FXML
    void bcancelar(MouseEvent event) {
        botonesAtaquesOf();
        botonesMenuInicioOn();
    }

    @FXML
    void mostrarvida(MouseEvent event) {
        vidaActualA.setVisible(true);
        psimgA.setVisible(false);
    }

    @FXML
    void mostrarvidaE(MouseEvent event) {
        vidaActualE.setVisible(true);
        psimgE.setVisible(false);
    }

    @FXML
    void ocultarvida(MouseEvent event) {
        vidaActualA.setVisible(false);
        psimgA.setVisible(true);
    }

    @FXML
    void ocultarvidaE(MouseEvent event) {
        vidaActualE.setVisible(false);
        psimgE.setVisible(true);
    }

    private Pokemons datosMiPokemon;

    private List<Pokemons>listaPokemons;

    private ModelController modelController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Pokemons> listaPokemons=new ArrayList<>();
        Pokemons p1=new Pokemons("Miutu",123,"src\\main\\java\\com\\example\\pokemongame\\img\\mewtwo.gif","src\\main\\java\\com\\example\\pokemongame\\img\\male.png","src\\main\\java\\com\\example\\pokemongame\\img\\ps.png",200,200,true);
        Pokemons p2=new Pokemons("Aggron",73,"src\\main\\java\\com\\example\\pokemongame\\img\\aggron-mega.gif","src\\main\\java\\com\\example\\pokemongame\\img\\male.png","src\\main\\java\\com\\example\\pokemongame\\img\\ps.png",180,180,false);
        listaPokemons.add(p1);
        listaPokemons.add(p2);
        this.listaPokemons=listaPokemons;
        try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("modelo.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();

        ModelController modelController = fxmlLoader.getController();
        this.modelController=modelController;
        this.datosMiPokemon=modelController.mipokemon;
        botonesAtaquesOf();
        cargarDatosPokemon();
        cargarDatosPokemonEnemigo();




        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void botonesAtaquesOf(){
        txAtaque1.setVisible(false);
        txAtaque2.setVisible(false);
        txAtaque3.setVisible(false);
        txCancelar.setVisible(false);
    }

    public void botonesAtaquesOn(){
        txAtaque1.setVisible(true);
        txAtaque2.setVisible(true);
        txAtaque3.setVisible(true);
        txCancelar.setVisible(true);
    }

    public void botonesMenuInicioOf(){
        bAtacar.setVisible(false);
        bCurar.setVisible(false);
    }

    public void botonesMenuInicioOn(){
        bAtacar.setVisible(true);
        bCurar.setVisible(true);
    }

    public void cargarDatosPokemon(){
        nombreMiPokemon.setText(datosMiPokemon.getNombrepokemon());
        Image imgMiPokemon=new Image(datosMiPokemon.getImgenpokemon());
        miPokemon.setImage(imgMiPokemon);
        nivelMiPokemon.setText(""+datosMiPokemon.getNivelpokemon());
        vidaMiPokemon.setProgress(1.0);
        vidaMiPokemon.setStyle("-fx-accent: #00FA00");
        Image imgps=new Image(datosMiPokemon.getImagenps());
        psimgA.setImage(imgps);
        vidaActualA.setText(datosMiPokemon.getVidaActual()+"");
        vidaActualA.setVisible(false);

    }



    public void cargarDatosPokemonEnemigo(){
        nombrePokemonEnemigo.setText(listaPokemons.get(1).getNombrepokemon());
        File f1 = new File(listaPokemons.get(1).getImgenpokemon());
        listaPokemons.get(1).setImgenpokemon(f1.toURI().toString());
        Image imgPokemonEnemigo=new Image(listaPokemons.get(1).getImgenpokemon());
        pokemonEnemigo.setImage(imgPokemonEnemigo);

        nivelPokemonEnemigo.setText(""+listaPokemons.get(1).getNivelpokemon());
        vidaPokemonEnemigo.setStyle("-fx-accent: #00FA00");
        vidaPokemonEnemigo.setProgress(1.0);
        File f2 = new File(listaPokemons.get(1).getImagenps());
        listaPokemons.get(1).setImagenps(f2.toURI().toString());
        Image imgPsE=new Image(listaPokemons.get(1).getImagenps());
        psimgE.setImage(imgPsE);


        vidaActualE.setText(listaPokemons.get(1).getVidaActual()+"");
        vidaActualE.setVisible(false);

    }






}

