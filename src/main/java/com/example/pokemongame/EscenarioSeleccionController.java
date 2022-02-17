package com.example.pokemongame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EscenarioSeleccionController<Private> implements Initializable {

    @FXML
    public AnchorPane actualizatodo;

    @FXML
    private GridPane escenarioPokemons;

    @FXML
    private Label textoelegir;

    @FXML
    public Label textosalir;

    @FXML
    public Button bBatalla;



    @FXML
    void iniciarBatalla(MouseEvent event) {


        try {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Batalla.fxml"));
            EscenarioBatallaController escenarioBatallaController = fxmlLoader.getController();
            Scene scene = new Scene(fxmlLoader.load(), 900, 550);
            Stage stage = new Stage();
            stage.setTitle("New Window");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            System.out.println(e);

        }

    }

    ArrayList<ModelController> listaController = new ArrayList<>();
    public List<Pokemons> pokemons = new ArrayList<>();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargartodo();
    }

    public void pokemonSeleccionado() {

        for(ModelController controller: listaController) {
            controller.pokemonNoSeleccionado();
        }

    }



    public void cargartodo(){
        pokemons.addAll(PokemonRepository.getData());

        int columnas=0;
        int filas=0;

        try {

            for(int i=0;i<pokemons.size();i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("modelo.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                ModelController modelController = fxmlLoader.getController();

                modelController.setData(pokemons.get(i), this);

                listaController.add(modelController);

                escenarioPokemons.add(anchorPane,columnas++,filas);
                if(columnas==3){
                    columnas=0;
                    filas++;
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        bBatalla.setVisible(false);
    }

}