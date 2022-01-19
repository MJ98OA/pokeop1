package com.example.pokemongame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController<Private> implements Initializable {
    @FXML
    private GridPane escenarioPokemons;

    @FXML
    private Label textoelegir;

    @FXML
    private Label textosalir;



    Random r=new Random();
    int aleatorio=r.nextInt(200-100+1)+100;
    public List<Pokemons> pokemons = new ArrayList<>();
    public List<Pokemons> getData() {
        List<Pokemons> pokemons = new ArrayList<>();
        List<Pokemons> listaPokemons=new ArrayList<>();
        Pokemons p1=new Pokemons("Miu",23,"src\\main\\java\\com\\example\\pokemongame\\img\\miu.png","src\\main\\java\\com\\example\\pokemongame\\img\\male.png","src\\main\\java\\com\\example\\pokemongame\\img\\ps.png",aleatorio,aleatorio,true);
        Pokemons p2=new Pokemons("Bulbasaur",23,"src\\main\\java\\com\\example\\pokemongame\\img\\bulbasaur.png","src\\main\\java\\com\\example\\pokemongame\\img\\male.png","src\\main\\java\\com\\example\\pokemongame\\img\\ps.png",aleatorio,aleatorio,false);
        Pokemons p3=new Pokemons("Squirtle",23,"src\\main\\java\\com\\example\\pokemongame\\img\\squirtle.png","src\\main\\java\\com\\example\\pokemongame\\img\\male.png","src\\main\\java\\com\\example\\pokemongame\\img\\ps.png",aleatorio,aleatorio,false);
        Pokemons p4=new Pokemons("Miu2",23,"src\\main\\java\\com\\example\\pokemongame\\img\\miu.png","src\\main\\java\\com\\example\\pokemongame\\img\\male.png","src\\main\\java\\com\\example\\pokemongame\\img\\ps.png",aleatorio,aleatorio,false);
        Pokemons p5=new Pokemons("Bulbasaur2",23,"src\\main\\java\\com\\example\\pokemongame\\img\\bulbasaur.png","src\\main\\java\\com\\example\\pokemongame\\img\\male.png","src\\main\\java\\com\\example\\pokemongame\\img\\ps.png",aleatorio,aleatorio,false);
        Pokemons p6=new Pokemons("Squirtle2",23,"src\\main\\java\\com\\example\\pokemongame\\img\\squirtle.png","src\\main\\java\\com\\example\\pokemongame\\img\\male.png","src\\main\\java\\com\\example\\pokemongame\\img\\ps.png",aleatorio,aleatorio,false);
        listaPokemons.add(p1);
        listaPokemons.add(p2);
        listaPokemons.add(p3);
        listaPokemons.add(p4);
        listaPokemons.add(p5);
        listaPokemons.add(p6);


        Pokemons pokemon;

        for (int i = 0; i < 6; i++) {
            pokemon = new Pokemons();
            pokemon.setNombrepokemon(listaPokemons.get(i).getNombrepokemon());
            pokemon.setNivelpokemon(20);
            File f = new File(listaPokemons.get(i).getImgenpokemon());
            pokemon.setImgenpokemon(f.toURI().toString());

            File f1 = new File("src\\main\\java\\com\\example\\pokemongame\\img\\genero.png");
            pokemon.setImagengenero(f1.toURI().toString());

            File f2 = new File("src\\main\\java\\com\\example\\pokemongame\\img\\ps.png");
            pokemon.setImagenps(f2.toURI().toString());

            pokemon.setVidaMaxima(200);
            pokemon.setVidaActual(200);

            pokemon.seleccionado=listaPokemons.get(i).seleccionado;
            pokemons.add(pokemon);
        }
        return pokemons;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pokemons.addAll(getData());

        int columnas=0;
        int filas=0;

        try {
        for(int i=0;i<pokemons.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("modelo.fxml"));

            AnchorPane anchorPane = fxmlLoader.load();

            ModelController modelController = fxmlLoader.getController();
            modelController.setData(pokemons.get(i));

            escenarioPokemons.add(anchorPane,columnas++,filas);
            if(columnas==3){
                columnas=0;
                filas++;
            }
        }




        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}