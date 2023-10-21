package Proyecto.controllers;


import Proyecto.enums.Ciudades;
import Proyecto.enums.Clima;
import Proyecto.enums.Lenguajes;
import Proyecto.model.AgenciaViajes;
import Proyecto.model.Destino;
import Proyecto.model.GuiaTuristico;
import Proyecto.model.PaqueteTuristico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.*;

public class AdmPrincipalViewController {
    private final AgenciaViajes agenciaViajes = AgenciaViajes.getInstance();

    //---------------------------------------------------------------------------//
    ObservableList<Destino> listaDestinoData = FXCollections.observableArrayList();
    Destino destinoSeleccionado;
    ObservableList<GuiaTuristico> listaGuiaTuristicoData = FXCollections.observableArrayList();
    GuiaTuristico guiaTuristicoSeleccionado;
    ObservableList<PaqueteTuristico> listaPaqueteTuristicoData = FXCollections.observableArrayList();
    PaqueteTuristico paqueteTuristicoSeleccionado;
    //--------------------------------------------------------------------------//
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAdmDestinoActualizar;

    @FXML
    private Button btnAdmDestinoAgragar;

    @FXML
    private Button btnAdmDestinoEliminar;

    @FXML
    private Button btnAdmDestinoNuevo;

    @FXML
    private Button btnAdmGuiaActualizar;

    @FXML
    private Button btnAdmGuiaAgregar;

    @FXML
    private Button btnAdmGuiaEliminar;

    @FXML
    private Button btnAdmGuiaNuevo;

    @FXML
    private Button btnAdmPaqueteActualizar;

    @FXML
    private Button btnAdmPaqueteAgregar;

    @FXML
    private Button btnAdmPaqueteEliminar;

    @FXML
    private Button btnAdmPaqueteNuevo;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Button btnDestinos;

    @FXML
    private Button btnEstadistica;

    @FXML
    private Button btnGuia;

    @FXML
    private Button btnPaquete;
    @FXML
    private AnchorPane destinoForm;

    @FXML
    private AnchorPane estadisticaForm;

    @FXML
    private AnchorPane guiasForm;

    @FXML
    private AnchorPane paquetesForm;

    @FXML
    private ComboBox<String> comboxOpcionesCiudad;

    @FXML
    private ComboBox<String> comboxOpcionesClima;

    @FXML
    private ComboBox<String> comboxOpcionesLenjuajes;

    @FXML
    private TableColumn<Destino, String> clAdmDestinoCiudad;

    @FXML
    private TableColumn<Destino, String> clAdmDestinoClima;

    @FXML
    private TableColumn<Destino, String> clAdmDestinoDescripcion;

    @FXML
    private TableColumn<Destino, String> clAdmDestinoNombre;

    @FXML
    private TableColumn<GuiaTuristico, String> clAdmGuiasContraseña;

    @FXML
    private TableColumn<GuiaTuristico, String> clAdmGuiasCorreoElectronico;

    @FXML
    private TableColumn<GuiaTuristico, String> clAdmGuiasExperiencia;

    @FXML
    private TableColumn<GuiaTuristico, String> clAdmGuiasIdentificacion;

    @FXML
    private TableColumn<GuiaTuristico, String> clAdmGuiasLenguajes;

    @FXML
    private TableColumn<GuiaTuristico, String> clAdmGuiasNombreCompleto;

    @FXML
    private TableColumn<PaqueteTuristico, Integer> clAdmPaqueteCupo;

    @FXML
    private TableColumn<PaqueteTuristico, Integer> clAdmPaqueteDuracion;

    @FXML
    private TableColumn<PaqueteTuristico, LocalDateTime> clAdmPaqueteFechaDisponibles;

    @FXML
    private TableColumn<PaqueteTuristico, String> clAdmPaqueteNombre;

    @FXML
    private TableColumn<PaqueteTuristico, Double> clAdmPaquetePrecio;

    @FXML
    private TableColumn<PaqueteTuristico, String> clAdmPaqueteServicioAdicional;

    @FXML
    private TableView<Destino> tableAdmDestino;

    @FXML
    private TableView<GuiaTuristico> tableAdmGuias;

    @FXML
    private TableView<PaqueteTuristico> tableAdmPaquete;
    @FXML
    private TextField txtAdmDestinoCiudad;
    @FXML
    private TextField txtAdmDestinoClima;

    @FXML
    private TextArea txtAdmDestinoDescripcion;

    @FXML
    private TextField txtAdmDestinoNombre;

    @FXML
    private PasswordField txtAdmGuiaContraseña;

    @FXML
    private TextField txtAdmGuiaCorreoElectronico;

    @FXML
    private TextField txtAdmGuiaExpere;

    @FXML
    private TextField txtAdmGuiaIdentificacion;

    @FXML
    private TextField txtAdmGuiaLenguajes;

    @FXML
    private TextField txtAdmGuiaNombreCompleto;

    @FXML
    private TextField txtAdmPaqueteCupoMaxPersonas;

    @FXML
    private TextField txtAdmPaqueteDuracion;

    @FXML
    private TextField txtAdmPaqueteNombre;

    @FXML
    private TextField txtAdmPaquetePrecio;

    @FXML
    private TextField txtAdmPaqueteServicioAdicionales;

    @FXML
    private DatePicker dataAdmPaqueteFechaDisponible;

    @FXML
    void actualizarAdmDestinoAction(ActionEvent event) {

    }

    @FXML
    void actualizarAdmGuiaAction(ActionEvent event) {

    }

    @FXML
    void actualizarAdmPaqueteAction(ActionEvent event) {

    }

    @FXML
    void agragarAdmGuiaAction(ActionEvent event) {

    }

    @FXML
    void agregarAdmDestinoAction(ActionEvent event) {

    }

    @FXML
    void agregarAdmPaqueteAction(ActionEvent event) {

    }

    @FXML
    void eliminarAdmDestinoAction(ActionEvent event) {

    }

    @FXML
    void eliminarAdmGuiaAction(ActionEvent event) {

    }

    @FXML
    void eliminarAdmPaqueteAction(ActionEvent event) {

    }

    @FXML
    void nuevoAdmDestinoAction(ActionEvent event) {

    }

    @FXML
    void nuevoAdmGuiaAction(ActionEvent event) {

    }

    @FXML
    void nuevoAdmPaqueteAction(ActionEvent event) {

    }

    @FXML
    void cerrarSesionAdmAction(ActionEvent event) {

    }

    @FXML
    void mostrarVentana(ActionEvent event) {
        if (event.getSource() == btnDestinos) {
            destinoForm.setVisible(true);
            guiasForm.setVisible(false);
            paquetesForm.setVisible(false);
            estadisticaForm.setVisible(false);
        } else if (event.getSource() == btnEstadistica) {
            destinoForm.setVisible(false);
            guiasForm.setVisible(false);
            paquetesForm.setVisible(false);
            estadisticaForm.setVisible(true);
        } else if (event.getSource() == btnGuia) {
            destinoForm.setVisible(false);
            guiasForm.setVisible(true);
            paquetesForm.setVisible(false);
            estadisticaForm.setVisible(false);
        } else if (event.getSource() == btnPaquete) {
            destinoForm.setVisible(false);
            guiasForm.setVisible(false);
            paquetesForm.setVisible(true);
            estadisticaForm.setVisible(false);
        }
    }

    @FXML
    void initialize() {
        mostrarCombox();
    }

    private void mostrarCombox() {
        mostrarComboxOpcionesCiudades();
        mostrarComboxOpcionesClimas();
        mostrarComboxOpcionesLenguajes();
    }

    private void mostrarComboxOpcionesLenguajes() {
        ArrayList<Lenguajes> listaLenguaje = new ArrayList<>(Arrays.asList(Lenguajes.values()));
        listaLenguaje.sort(Comparator.comparing(Enum::name));
        ObservableList<String> listaLenguajesFormateadas = FXCollections.observableArrayList();
        for (Lenguajes lenguajes : listaLenguaje) {
            String nombreLenguajes = lenguajes.name().replace("_", " ");
            listaLenguajesFormateadas.add(nombreLenguajes);
        }
        comboxOpcionesLenjuajes.setItems(listaLenguajesFormateadas);
    }

    private void mostrarComboxOpcionesClimas() {
        ArrayList<Clima> listaClima = new ArrayList<>(Arrays.asList(Clima.values()));
        listaClima.sort(Comparator.comparing(Enum::name));
        ObservableList<String> listaClimaFormateadas = FXCollections.observableArrayList();
        for (Clima clima : listaClima) {
            String nombreClima = clima.name().replace("_", " ");
            listaClimaFormateadas.add(nombreClima);
        }
        comboxOpcionesClima.setItems(listaClimaFormateadas);
    }

    private void mostrarComboxOpcionesCiudades() {
        ArrayList<Ciudades> listaCiudades = new ArrayList<>(Arrays.asList(Ciudades.values()));
        listaCiudades.sort(Comparator.comparing(Enum::name));
        ObservableList<String> listaCiudadesFormateadas = FXCollections.observableArrayList();
        for (Ciudades ciudad : listaCiudades) {
            String nombreCiudad = ciudad.name().replace("_", " ");
            listaCiudadesFormateadas.add(nombreCiudad);
        }
        comboxOpcionesCiudad.setItems(listaCiudadesFormateadas);
    }

    //--------------------------------------------------------------------//
    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        return action.get() == ButtonType.OK;
    }
}
