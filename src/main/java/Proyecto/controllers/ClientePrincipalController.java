package Proyecto.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Proyecto.enums.Ciudades;
import Proyecto.enums.Clima;
import Proyecto.model.AgenciaViajes;
import Proyecto.model.Cliente;
import Proyecto.model.Destino;
import Proyecto.utils.ArchivoUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ClientePrincipalController implements Initializable {

    String rutaArchivo = "src/main/resources/persistencia/clientes.txt";
    public AnchorPane misViajesForm;
    private Cliente clienteAutenticado;

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
    private ComboBox<Ciudades> cbxCiudad;

    @FXML
    private ComboBox<Clima> cbxClima;

    @FXML
    private ComboBox<String> cbxDestino;

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
    private AnchorPane reservaForm;

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
        // Aquí deberías obtener los nuevos datos del cliente desde la interfaz.
        // Por ejemplo, puedes tener campos de texto editables y obtener sus valores.

        String nuevoNombre = txtNombrePerfil.getText();
        String nuevoCorreo = txtCorreoPerfil.getText();
        String nuevaDireccion = txtDireccionPerfil.getText();
        String nuevoTelefono = txtTelefonoPerfil.getText();

        // Supongamos que obtienes los nuevos datos y actualizas el objeto Cliente.
        clienteAutenticado.setNombreCompleto(nuevoNombre);
        clienteAutenticado.setCorreo(nuevoCorreo);
        clienteAutenticado.setDireccionResidencia(nuevaDireccion);
        clienteAutenticado.setTelefono(nuevoTelefono);


        // Ahora, actualiza los campos en la interfaz.
        actualizarCampos();

        // Muestra una alerta o realiza otras acciones según sea necesario.
        mostrarAlerta("Cliente Actualizado", "Los datos del cliente se han actualizado con éxito.", Alert.AlertType.INFORMATION);
        String nuevaLinea = String.format("%s,%s,%s,%s,%s,%s",
                clienteAutenticado.getIdentificacion(),
                clienteAutenticado.getPassword(),
                clienteAutenticado.getNombreCompleto(),
                clienteAutenticado.getCorreo(),
                clienteAutenticado.getTelefono(),
                clienteAutenticado.getDireccionResidencia());

        actualizarDatosEnArchivo(nuevaLinea);
    }
    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void actualizarCampos() {
        txtIdPerfil.setText(clienteAutenticado.getIdentificacion());
        txtNombrePerfil.setText(clienteAutenticado.getNombreCompleto());
        txtCorreoPerfil.setText(clienteAutenticado.getCorreo());
        txtDireccionPerfil.setText(clienteAutenticado.getDireccionResidencia());
        txtTelefonoPerfil.setText(clienteAutenticado.getTelefono());
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
    void mostrarVenCliente(ActionEvent event) {
        if (event.getSource() == btnPerfii) {
            perfilForm.setVisible(true);
            reservaForm.setVisible(false);
            paquetesForm.setVisible(false);
            misViajesForm.setVisible(false);
        } else if (event.getSource() == btnPaquetes) {
            perfilForm.setVisible(false);
            reservaForm.setVisible(false);
            paquetesForm.setVisible(true);
            misViajesForm.setVisible(false);
        } else if (event.getSource() == btnReservas) {
            perfilForm.setVisible(true);
            reservaForm.setVisible(false);
            paquetesForm.setVisible(false);
            misViajesForm.setVisible(false);
        }


    }


    @FXML
    void reservarPq(ActionEvent event) {

    }

    @FXML
    void verImagenesPq(ActionEvent event) {

    }
    private void actualizarDatosEnArchivo(String nuevaLinea) {
        try {
            List<String> datosActuales = ArchivoUtils.leerArchivoBufferedReader(rutaArchivo);

            // Encuentra y reemplaza la línea existente con el nuevo dato.
            // Supongamos que cada línea es única y se basa en la identificación del cliente.
            for (int i = 0; i < datosActuales.size(); i++) {
                if (datosActuales.get(i).contains(clienteAutenticado.getIdentificacion())) {
                    datosActuales.set(i, nuevaLinea);
                    break;  // Se encontró y actualizó la línea, sale del bucle.
                }
            }

            // Guarda los datos actualizados en el archivo.
            ArchivoUtils.escribirArchivoBufferedWriter(rutaArchivo, datosActuales, false);

            // Muestra una alerta o realiza otras acciones según sea necesario.
            mostrarAlerta("Actualización Exitosa", "Datos actualizados en el archivo.", Alert.AlertType.INFORMATION);

        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("Error de Actualización", "Hubo un error al actualizar el archivo.", Alert.AlertType.ERROR);
        }
    }



        public void initData(Cliente clienteAutenticado) {
            this.clienteAutenticado = clienteAutenticado;

            try {
                // Lee los datos del archivo y busca la línea del cliente actual
                List<String> lineasClientes = ArchivoUtils.leerArchivoBufferedReader(rutaArchivo);
                for (String linea : lineasClientes) {
                    String[] datosCliente = linea.split(";");

                    // Supongamos que el primer campo es la identificación del cliente
                    if (datosCliente.length > 0 && datosCliente[0].equals(clienteAutenticado.getIdentificacion())) {
                        // Establece los datos en los campos correspondientes
                        txtIdPerfil.setText(datosCliente[0]);
                        txtNombrePerfil.setText(datosCliente[2]);
                        txtCorreoPerfil.setText(datosCliente[3]);
                        txtDireccionPerfil.setText(datosCliente[5]);
                        txtTelefonoPerfil.setText(datosCliente[4]);
                        break; // Rompe el bucle una vez que se ha encontrado y configurado el cliente
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                mostrarAlerta("Error de Lectura", "Hubo un error al leer el archivo.", Alert.AlertType.ERROR);
            }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cbxCiudad.getItems().setAll(Ciudades.values());
        cbxClima.getItems().setAll(Clima.values());
        List<Destino> listaDestinos = ArchivoUtils.leerDestinosDesdeArchivo("src/main/resources/persistencia/destinos.txt");

        System.out.println(listaDestinos);

        // Llenar el ComboBox con los nombres de los destinos
        for (Destino destino : listaDestinos) {
            cbxDestino.getItems().add(destino.getNombre());
        }


        cbxDestino.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Acciones cuando se selecciona un destino en el ComboBox
                System.out.println("Destino seleccionado: " + newValue);
            }
        });
    }

}



