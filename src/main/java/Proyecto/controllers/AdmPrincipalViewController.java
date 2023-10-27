package Proyecto.controllers;


import Proyecto.enums.Ciudades;
import Proyecto.enums.Clima;
import Proyecto.enums.Lenguajes;
import Proyecto.exceptions.*;
import Proyecto.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.*;

public class AdmPrincipalViewController {
    private final AgenciaViajes agenciaViajes = AgenciaViajes.getInstance();
    private ArrayList<String> imagenes = new ArrayList<>();
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
    private Button btnAdmDestinoSeleccionarImag;

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
    private TableColumn<GuiaTuristico, String> clAdmGuiasContrasenia;

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
    private TextArea txtAdmDestinoDescripcion;

    @FXML
    private TextField txtAdmDestinoNombre;

    @FXML
    private ImageView imagenView;

    @FXML
    private PasswordField txtAdmGuiaContrasenia;

    @FXML
    private TextField txtAdmGuiaCorreoElectronico;

    @FXML
    private TextField txtAdmGuiaExperencia;

    @FXML
    private TextField txtAdmGuiaIdentificacion;

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
    void SeleccionarImagAdmDestinoAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            String rutaImagen = file.getAbsolutePath();
            imagenes.add(rutaImagen);
            Image imagen = new Image(file.toURI().toString());
            imagenView.setImage(imagen);
        }
    }

    @FXML
    void actualizarAdmDestinoAction(ActionEvent event) {
        actualizarDestinoAdm();
    }

    private void actualizarDestinoAdm() {
        String nombre = txtAdmDestinoNombre.getText();
        String descripcion = txtAdmDestinoDescripcion.getText();
        String valorClima = comboxOpcionesClima.getValue();
        String valorCiudad = comboxOpcionesCiudad.getValue();
        Clima clima = null;
        Ciudades ciudad = null;
        if (valorClima != null) {
            clima = Clima.obtenerNombreClima(valorClima);
        }
        if (valorCiudad != null) {
            ciudad = Ciudades.obtenerNombreCiudades(valorCiudad);
        }
        try {
            boolean esDestinoActualizado;
            if (destinoSeleccionado != null) {
                esDestinoActualizado = agenciaViajes.actualizarDestino(destinoSeleccionado.getNombre(), nombre, ciudad, descripcion, imagenes, clima);
                if (esDestinoActualizado) {
                    tableAdmDestino.refresh();
                    mostrarMensaje("Notificación", "El destino", "se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                    limpiarCamposDestino();
                    tableAdmDestino.getSelectionModel().select(null);
                }
            }
        } catch (CampoObligatorio | SeleccioneCargar | SeleccionarNoOpcion e) {
            mostrarMensaje("Notificación", "El destino no se ha actualizado", e.getMessage(), Alert.AlertType.ERROR);
        }
    }


    @FXML
    void actualizarAdmGuiaAction(ActionEvent event) {
        actualizarAdmGuia();
    }

    private void actualizarAdmGuia() {
        String nombreCompleto = txtAdmGuiaNombreCompleto.getText();
        String identificacion = txtAdmGuiaIdentificacion.getText();
        String usuario = txtAdmGuiaCorreoElectronico.getText();
        String password = txtAdmGuiaContrasenia.getText();
        String valorLenguajes = comboxOpcionesLenjuajes.getValue();

        int experiencia = 0;
        if (!txtAdmGuiaExperencia.getText().isEmpty()) {
            experiencia = Integer.parseInt(txtAdmGuiaExperencia.getText());
        }
        Lenguajes lenguajes = null;
        if (valorLenguajes != null) {
            lenguajes = Lenguajes.obtenerNombreLenguajes(valorLenguajes);
        }
        try {
            boolean esGuiaTuristicoActualizado;
            if (guiaTuristicoSeleccionado != null) {
                esGuiaTuristicoActualizado = agenciaViajes.actualizarGuiaTuristico(guiaTuristicoSeleccionado.getIdentificacion(), nombreCompleto, identificacion, usuario, password, experiencia, lenguajes);
                if (esGuiaTuristicoActualizado) {
                    tableAdmGuias.refresh();
                    mostrarMensaje("Notificación", "La guia turistico", "se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                    limpiarCamposGuias();
                    tableAdmGuias.getSelectionModel().select(null);
                }
            }
        } catch (CampoNegativo | CampoObligatorio | SeleccionarNoOpcion e) {
            mostrarMensaje("Notificación", "La guia turistico no se ha actualizado", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void actualizarAdmPaqueteAction(ActionEvent event) {

    }

    @FXML
    void agregarAdmDestinoAction(ActionEvent event) {
        crearDestinoAdm();
    }

    private void crearDestinoAdm() {
        String nombre = txtAdmDestinoNombre.getText();
        String descripcion = txtAdmDestinoDescripcion.getText();
        String valorClima = comboxOpcionesClima.getValue();
        String valorCiudad = comboxOpcionesCiudad.getValue();
        Clima climas = null;
        Ciudades ciudades = null;
        if (valorClima != null) {
            climas = Clima.obtenerNombreClima(valorClima);
        }
        if (valorCiudad != null) {
            ciudades = Ciudades.obtenerNombreCiudades(valorCiudad);
        }
        try {
            Destino destino;
            destino = agenciaViajes.crearDestino(nombre, ciudades, descripcion, imagenes, climas);
            if (destino != null) {
                listaDestinoData.add(destino);
                mostrarMensaje("Notificación", "El destino", "se ha creado con éxitosamente", Alert.AlertType.INFORMATION);
                limpiarCamposDestino();
            }
        } catch (CampoObligatorio | InformacionNoExiste | SeleccionarNoOpcion | SeleccioneCargar e) {
            mostrarMensaje("Notificación", "El destino se no ha creado", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void limpiarCamposDestino() {
        txtAdmDestinoDescripcion.setText("");
        txtAdmDestinoNombre.setText("");
        imagenView.setImage(null);
        comboxOpcionesCiudad.setValue("");
        comboxOpcionesClima.setValue("");
        destinoSeleccionado = null;
    }

    @FXML
    void agragarAdmGuiaAction(ActionEvent event) {
        agragarAdmGuia();
    }

    private void agragarAdmGuia() {
        String nombreCompleto = txtAdmGuiaNombreCompleto.getText();
        String identificacion = txtAdmGuiaIdentificacion.getText();
        String usuario = txtAdmGuiaCorreoElectronico.getText();
        String password = txtAdmGuiaContrasenia.getText();
        String valorLenguajes = comboxOpcionesLenjuajes.getValue();
        int experiencia = 0;
        if (!txtAdmGuiaExperencia.getText().isEmpty()) {
            experiencia = Integer.parseInt(txtAdmGuiaExperencia.getText());
        }
        Lenguajes lenguajes = null;
        if (valorLenguajes != null) {
            lenguajes = Lenguajes.obtenerNombreLenguajes(valorLenguajes);
        }
        try {
            GuiaTuristico guiaTuristico;
            guiaTuristico = agenciaViajes.crearGuiaTuristico(nombreCompleto, identificacion, usuario, password, experiencia, lenguajes);
            if (guiaTuristico != null) {
                listaGuiaTuristicoData.add(guiaTuristico);
                mostrarMensaje("Notificación", "La guia turistico", "se ha creado con éxitosamente", Alert.AlertType.INFORMATION);
                limpiarCamposGuias();
            }
        } catch (CampoNegativo | CampoObligatorio | SeleccionarNoOpcion e) {
            mostrarMensaje("Notificación", "La guia turistico se no ha creado", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void limpiarCamposGuias() {
        txtAdmGuiaNombreCompleto.setText("");
        txtAdmGuiaIdentificacion.setText("");
        txtAdmGuiaExperencia.setText("");
        txtAdmGuiaCorreoElectronico.setText("");
        txtAdmGuiaContrasenia.setText("");
        comboxOpcionesLenjuajes.setValue("");
        guiaTuristicoSeleccionado = null;
    }

    @FXML
    void agregarAdmPaqueteAction(ActionEvent event) {

    }

    @FXML
    void eliminarAdmDestinoAction(ActionEvent event) {
        eliminarAdmDestino();
    }

    private void eliminarAdmDestino() {
        boolean destinoEliminado;
        if (destinoSeleccionado != null) {
            if (mostrarMensajeConfirmacion("¿Esta seguro de eliminar al destino?")) {
                destinoEliminado = agenciaViajes.eliminarDestino(destinoSeleccionado.getNombre());
                if (destinoEliminado == true) {
                    listaDestinoData.remove(destinoSeleccionado);
                    tableAdmDestino.refresh();
                    tableAdmDestino.getSelectionModel().clearSelection();
                    limpiarCamposDestino();
                    mostrarMensaje("Notificacion destino", "Destino eliminado",
                            "El destino se ha eliminado con exito", Alert.AlertType.INFORMATION);
                } else {
                    mostrarMensaje("Notificacion destino", "destino no eliminado", "El destino no se puede eliminar",
                            Alert.AlertType.ERROR);
                }
            }
        }
    }

    @FXML
    void eliminarAdmGuiaAction(ActionEvent event) {
        eliminarAdmGuia();
    }

    private void eliminarAdmGuia() {
        boolean guiaTuristicoEliminado;
        if (guiaTuristicoSeleccionado != null) {
            if (mostrarMensajeConfirmacion("¿Esta seguro de eliminar al guia turistico?")) {
                guiaTuristicoEliminado = agenciaViajes.eliminarGuiaTuristico(guiaTuristicoSeleccionado.getIdentificacion());
                if (guiaTuristicoEliminado == true) {
                    listaGuiaTuristicoData.remove(guiaTuristicoSeleccionado);
                    tableAdmGuias.refresh();
                    tableAdmGuias.getSelectionModel().clearSelection();
                    limpiarCamposGuias();
                    mostrarMensaje("Notificacion guia turistico", "Guia turistico eliminado",
                            "La guia turistico se ha eliminado con exito", Alert.AlertType.INFORMATION);
                } else {
                    mostrarMensaje("Notificacion guia turistico", "Guia turistico no eliminado", "La guia turistico no se puede eliminar",
                            Alert.AlertType.ERROR);
                }
            }
        }
    }

    @FXML
    void eliminarAdmPaqueteAction(ActionEvent event) {

    }

    @FXML
    void nuevoAdmDestinoAction(ActionEvent event) {
        limpiarCamposDestino();
        tableAdmDestino.getSelectionModel().select(null);
    }

    @FXML
    void nuevoAdmGuiaAction(ActionEvent event) {
        limpiarCamposGuias();
        tableAdmGuias.getSelectionModel().select(null);
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
        inicializarDestinoView();
        inicializarGuiasView();
    }

    private void inicializarGuiasView() {
        this.clAdmGuiasNombreCompleto.setCellValueFactory(new PropertyValueFactory<>("nombreCompleto"));
        this.clAdmGuiasIdentificacion.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
        this.clAdmGuiasLenguajes.setCellValueFactory(celda -> new SimpleStringProperty(celda.getValue().getLenguaje().getNombreLenguajes()));
        this.clAdmGuiasExperiencia.setCellValueFactory(new PropertyValueFactory<>("experiencia"));
        this.clAdmGuiasCorreoElectronico.setCellValueFactory(new PropertyValueFactory<>("correo"));
        this.clAdmGuiasContrasenia.setCellValueFactory(new PropertyValueFactory<>("password"));
        tableAdmGuias.getItems().clear();
        tableAdmGuias.setItems(getListaGuiaTuristicoData());
        tableAdmGuias.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                guiaTuristicoSeleccionado = newSelection;
                mostraInformacionGuias(guiaTuristicoSeleccionado);
            }
        });
    }

    private void mostraInformacionGuias(GuiaTuristico guiaTuristicoSeleccionado) {
        if (guiaTuristicoSeleccionado != null) {
            txtAdmGuiaNombreCompleto.setText(guiaTuristicoSeleccionado.getNombreCompleto());
            txtAdmGuiaIdentificacion.setText(guiaTuristicoSeleccionado.getIdentificacion());
            String lenguaje = String.valueOf(guiaTuristicoSeleccionado.getLenguaje());
            comboxOpcionesLenjuajes.setValue(lenguaje);
            txtAdmGuiaExperencia.setText(String.valueOf(guiaTuristicoSeleccionado.getExperiencia()));
            txtAdmGuiaCorreoElectronico.setText(guiaTuristicoSeleccionado.getCorreo());
            txtAdmGuiaContrasenia.setText(guiaTuristicoSeleccionado.getPassword());
        }
    }

    private void inicializarDestinoView() {
        this.clAdmDestinoNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.clAdmDestinoCiudad.setCellValueFactory(celda -> new SimpleStringProperty(celda.getValue().getCiudad().getNombreCiudad()));
        this.clAdmDestinoClima.setCellValueFactory(celda -> new SimpleStringProperty(celda.getValue().getClima().getNombreClima()));
        this.clAdmDestinoDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        tableAdmDestino.getItems().clear();
        tableAdmDestino.setItems(getListaDestinoData());
        tableAdmDestino.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                destinoSeleccionado = newSelection;
                mostraInformacionDestino(destinoSeleccionado);
            }
        });
    }

    private void mostraInformacionDestino(Destino destinoSeleccionado) {

        if (destinoSeleccionado != null) {
            txtAdmDestinoNombre.setText(destinoSeleccionado.getNombre());

            String clima = String.valueOf(destinoSeleccionado.getClima());
            comboxOpcionesClima.setValue(clima);

            String ciudad = String.valueOf(destinoSeleccionado.getCiudad());
            comboxOpcionesCiudad.setValue(ciudad);

            imagenView.setImage(new Image(destinoSeleccionado.getImagenes().get(0)));

            String descripcion = destinoSeleccionado.getDescripcion();
            txtAdmDestinoDescripcion.setText(descripcion);
        }
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


    //-------------------------ObservableList---------------------------------//

    public ObservableList<Destino> getListaDestinoData() {
        listaDestinoData.addAll(agenciaViajes.getListaDestinos());
        return listaDestinoData;
    }

    public ObservableList<GuiaTuristico> getListaGuiaTuristicoData() {
        for (Persona persona : agenciaViajes.getListaPersona()) {
            if (persona instanceof GuiaTuristico) {
                listaGuiaTuristicoData.addAll((GuiaTuristico) persona);
            }
        }
        return listaGuiaTuristicoData;
    }

    //-------------------------Mostrar mensaje---------------------------------//
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
