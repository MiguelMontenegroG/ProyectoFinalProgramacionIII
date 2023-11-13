package Proyecto.controllers;

import Proyecto.utils.ArchivoUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RegistroController implements Initializable {

    @FXML
    private Label adminusuariolb;

    @FXML
    private Label passlb;

    @FXML
    private PasswordField adminpass;

    @FXML
    private Button crearCuentabt;

    @FXML
    private TextField adminuser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicialización del controlador, si es necesario.
    }
    String rutaArchivo = "src/main/resources/persistencia/clientes.txt";
    @FXML
    void handleCrearCuentaButtonAction(ActionEvent event) {
        String usuario = adminuser.getText();
        String contrasena = adminpass.getText();

        if (!usuario.isEmpty() && !contrasena.isEmpty()) {
            try {
                List<String> datosActuales = ArchivoUtils.leerArchivoBufferedReader(rutaArchivo);

                String nuevoDato = usuario + "," + contrasena;

                datosActuales.add(nuevoDato);

                ArchivoUtils.escribirArchivoBufferedWriter(rutaArchivo, datosActuales, false);

                adminuser.clear();
                adminpass.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}