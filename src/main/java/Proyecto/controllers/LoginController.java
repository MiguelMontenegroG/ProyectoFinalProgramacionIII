package Proyecto.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class LoginController {

    @FXML
    private Label adminlb;

    @FXML
    private Label adminusuariolb;

    @FXML
    private PasswordField adminuser;

    @FXML
    private Label passlb;

    @FXML
    private PasswordField adminpass;

    @FXML
    private Button adminbt;

    @FXML
    private Label clientelb;

    @FXML
    private Label usuarioClientelb;

    @FXML
    private PasswordField clienteuser;

    @FXML
    private Label contrasenaClientelb;

    @FXML
    private PasswordField clientepass;

    @FXML
    private Button clientebt;

    @FXML
    void handleAdminButtonAction(ActionEvent event) {
        // Lógica para el inicio de sesión de administrador
    }

    @FXML
    void handleClienteButtonAction(ActionEvent event) {
        // Lógica para el inicio de sesión de cliente
    }
}
