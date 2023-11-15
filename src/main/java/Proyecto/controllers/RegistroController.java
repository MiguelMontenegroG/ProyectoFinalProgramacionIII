package Proyecto.controllers;

import Proyecto.utils.ArchivoUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RegistroController {

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

    @FXML
    private Label nomComlb;

    @FXML
    private Label correolb;

    @FXML
    private TextField nomComtf;

    @FXML
    private TextField correotf;

    @FXML
    private TextField direcciontf;

    @FXML
    private TextField telefonotf;
    String rutaArchivo = "src/main/resources/persistencia/clientes.txt";

    private void mostrarAlerta(String titulo, String encabezado, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarAlertaPositiva(String titulo, String encabezado, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION); // Utiliza INFORMATION en lugar de ERROR
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    void handleCrearCuentaButtonAction(ActionEvent event) {
        String usuario = adminuser.getText();
        String contrasena = adminpass.getText();
        String nombreCompleto = nomComtf.getText();
        String correo = correotf.getText();
        String telefono = telefonotf.getText();
        String direccion = direcciontf.getText();

        if (!usuario.isEmpty() && !contrasena.isEmpty() && !nombreCompleto.isEmpty() && !correo.isEmpty() && !telefono.isEmpty() && !correo.isEmpty()) {
            try {

                List<String> datosActuales = ArchivoUtils.leerArchivoBufferedReader(rutaArchivo);

                String nuevoDato = usuario + "," + contrasena + "," + nombreCompleto + "," + correo + "," + telefono + "," + direccion;

                datosActuales.add(nuevoDato);

                ArchivoUtils.escribirArchivoBufferedWriter(rutaArchivo, datosActuales, false);

                adminuser.clear();
                adminpass.clear();
                nomComtf.clear();
                correotf.clear();
                telefonotf.clear();
                direcciontf.clear();

                mostrarAlertaPositiva("Registro Exitoso", "Datos registrados con exito", "");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            mostrarAlerta("Error de registro", "Falta de informacion", "Por favor, llena todos los espacion");
        }
    }
}