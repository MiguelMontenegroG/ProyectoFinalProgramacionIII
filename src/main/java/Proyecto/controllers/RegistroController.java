package Proyecto.controllers;

import Proyecto.utils.ArchivoUtils;
import javafx.fxml.FXML;

import Proyecto.utils.ArchivoUtils;
import javafx.scene.control.PasswordField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegistroController {

    @FXML
    private Label adminusuariolb;

    @FXML
    private PasswordField adminuser;

    @FXML
    private Label passlb;

    @FXML
    private PasswordField adminpass;

    @FXML
    private Button crearCuentabt;

    @FXML
    void handleCrearCuentaButtonAction(ActionEvent event) {
        String usuario = adminuser.getText();
        String contrasena = adminpass.getText();

        // Verificar si se ingresaron datos válidos antes de guardarlos en el archivo
        if (!usuario.isEmpty() && !contrasena.isEmpty()) {
            try {
                String rutaArchivo = "persistencia/clientes.txt";
                List<String> datos = new ArrayList<>();
                datos.add(usuario + "," + contrasena);

                // Usar ArchivoUtils para escribir en el archivo
                ArchivoUtils.escribirArchivoBufferedWriter(rutaArchivo, datos, true);

                // Limpiar los campos de entrada después de guardar los datos
                adminuser.clear();
                adminpass.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}