module com.example.pokemongame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.pokemongame to javafx.fxml;
    exports com.example.pokemongame;
}