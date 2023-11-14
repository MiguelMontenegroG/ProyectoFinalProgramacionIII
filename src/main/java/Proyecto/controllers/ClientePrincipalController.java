package Proyecto.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ClientePrincipalController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarCliente;

    @FXML
    private Button btnBuscarpq;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Button btnEstadistica;

    @FXML
    private Button btnNuevo;

    @FXML
    private Button btnPaquetes;

    @FXML
    private Button btnPerfii;

    @FXML
    private Button btnReservar;

    @FXML
    private Button btnReservas;

    @FXML
    private Button btnVerImagenes;

    @FXML
    private ComboBox<?> cbxCiudad;

    @FXML
    private ComboBox<?> cbxClima;

    @FXML
    private ComboBox<?> cbxDestino;

    @FXML
    private ComboBox<?> cbxPaquete;

    @FXML
    private ComboBox<?> cbxPrecio;

    @FXML
    private TableColumn<?, ?> colCupo;

    @FXML
    private TableColumn<?, ?> colDuracion;

    @FXML
    private TableColumn<?, ?> colFechaDisponible;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TableColumn<?, ?> colPrecio;

    @FXML
    private TableColumn<?, ?> colServicioAdicional;

    @FXML
    private AnchorPane estadisticaForm;

    @FXML
    private ImageView imagenView;

    @FXML
    private DatePicker ldFechaIda;

    @FXML
    private DatePicker ldxFechaRegreso;

    @FXML
    private AnchorPane paquetesForm;

    @FXML
    private AnchorPane perfilForm;

    @FXML
    private AnchorPane pqForm;

    @FXML
    private TableView<?> tblPqCliente;

    @FXML
    private TextField txtCorreoPerfil;

    @FXML
    private TextField txtDireccionPerfil;

    @FXML
    private TextField txtIdPerfil;

    @FXML
    private TextField txtNombrePerfil;

    @FXML
    private TextField txtTelefonoPerfil;

    @FXML
    void ActualizarPerfilCliente(ActionEvent event) {

    }

    @FXML
    void NuevopqCLiente(ActionEvent event) {

    }

    @FXML
    void buscarPaqueteCliente(ActionEvent event) {

    }

    @FXML
    void cerrarSesionClienteAction(ActionEvent event) {

    }

    @FXML
    void mostrarVenPer(ActionEvent event) {

    }

    @FXML
    void mostrarVenPerCLiente(ActionEvent event) {

    }

    @FXML
    void mostrarVenPqCliente(ActionEvent event) {

    }

    @FXML
    void mostraraVenMisViajesCLiente(ActionEvent event) {

    }

    @FXML
    void reservarPq(ActionEvent event) {

    }

    @FXML
    void verImagenesPq(ActionEvent event) {

    }

}
