package Proyecto.agenciaViajes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aplicacion extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader( Aplicacion.class.getResource("/views/admPrincipal.fxml") );
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("AGENCIA VIAJES");
        stage.show();
    }
    public static void main(String[] args) {
        launch(Aplicacion.class,args);
    }
}
