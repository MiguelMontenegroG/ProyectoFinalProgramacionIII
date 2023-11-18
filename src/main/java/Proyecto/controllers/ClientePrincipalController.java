package Proyecto.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import Proyecto.enums.Ciudades;
import Proyecto.enums.Clima;
import Proyecto.model.AgenciaViajes;
import Proyecto.model.Cliente;
import Proyecto.model.Destino;
import Proyecto.model.PaqueteTuristico;
import Proyecto.utils.ArchivoUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class ClientePrincipalController implements Initializable {


    String rutaArchivo = "src/main/resources/persistencia/clientes.txt";
    String rutaArchivoPq = "src/main/resources/persistencia/paquetes.txt";
    public AnchorPane misViajesForm;
    private Cliente clienteAutenticado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarCliente;

    @FXML
    private Button btnAgregarGuiaRes;

    @FXML
    private Button btnBuscarpq;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Button btnConfirmarReserva;

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
    private ComboBox<String> cbxPrecio;

    @FXML
    private TableColumn<PaqueteTuristico, Integer> colCupo;

    @FXML
    private TableColumn<PaqueteTuristico, Integer> colDuracion;

    @FXML
    private TableColumn<PaqueteTuristico, LocalDateTime> colFechaDisponible;

    @FXML
    private TableColumn<PaqueteTuristico, String> colNombre;

    @FXML
    private TableColumn<PaqueteTuristico, Double> colPrecio;

    @FXML
    private TableColumn<PaqueteTuristico, String> colServicioAdicional;

    @FXML
    private TableColumn<?, ?> colCorreoGuiaRes;

    @FXML
    private TableColumn<?, ?> colExperienciaRes;
    @FXML
    private TableColumn<?, ?> colLenguajeRes;
    @FXML
    private TableColumn<?, ?> colNombreGuiaRes;
    private ObservableList<PaqueteTuristico> paqueteTuristicos = FXCollections.observableArrayList();


    @FXML
    private AnchorPane estadisticaForm;

    @FXML
    private ImageView imagenView;

    @FXML
    private ImageView imgViewDestino1;

    @FXML
    private ImageView imgViewDestino2;

    @FXML
    private ImageView imgViewDestino3;
    @FXML
    private Label lblResCanPersonas;

    @FXML
    private Label lblResCliente;

    @FXML
    private Label lblResFechPLanificada;

    @FXML
    private Label lblResFechaSolicitud;

    @FXML
    private Label lblResPqTuristico;

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
    private TableView<PaqueteTuristico> tblPqCliente;

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
    private ObservableList<PaqueteTuristico> listaPaqueteTuristicos = FXCollections.observableArrayList();
    @FXML
    void filtDestino(ActionEvent event) {
        actualizarTabla();

    }

    @FXML
    void filtFecha(ActionEvent event) {
        actualizarTabla();

    }

    @FXML
    void filtPrecio(ActionEvent event) {
        actualizarTabla();

    }


    @FXML
    void ActualizarPerfilCliente(ActionEvent event) {


        String nuevoNombre = txtNombrePerfil.getText();
        String nuevoCorreo = txtCorreoPerfil.getText();
        String nuevaDireccion = txtDireccionPerfil.getText();
        String nuevoTelefono = txtTelefonoPerfil.getText();

        //obtienes los nuevos datos y actualizas el objeto Cliente.
        clienteAutenticado.setNombreCompleto(nuevoNombre);
        clienteAutenticado.setCorreo(nuevoCorreo);
        clienteAutenticado.setDireccionResidencia(nuevaDireccion);
        clienteAutenticado.setTelefono(nuevoTelefono);


        //  actualiza los campos en la interfaz.
        actualizarCampos();

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
        cbxCiudad.setValue(null);
        cbxClima.setValue(null);
        cbxDestino.setValue(null);
        cbxPrecio.setValue(null);
        ldFechaIda.setValue(null);

        // Luego, actualiza la tabla
        actualizarTabla();


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
        perfilForm.setVisible(false);
        reservaForm.setVisible(true);
        paquetesForm.setVisible(false);
        misViajesForm.setVisible(false);


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
                String[] datosCliente = linea.split(",");

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
        ObservableList<String> precios = FXCollections.observableArrayList(
                "menos de 500.000",
                "500.000 a 1.000.000",
                "1.000.000 a 2.000.000",
                "mas de 2.000.000"
        );

        // Asignar la lista al ComboBox
        cbxPrecio.setItems(precios);



        // Puedes agregar un listener para manejar eventos de selección si es necesario
        cbxPrecio.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Seleccionaste: " + newValue);
        });
        // Configura las columnas de la TableView
        colCupo.setCellValueFactory(new PropertyValueFactory<>("cupoMaxPersona"));
        colDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));
        colFechaDisponible.setCellValueFactory(new PropertyValueFactory<>("fechaDisponibles"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colServicioAdicional.setCellValueFactory(new PropertyValueFactory<>("serviciosAdicionales"));


        // Lee los datos de los paquetes turísticos desde el archivo
        cargarPaquetesDesdeArchivo("src/main/resources/persistencia/paquetes.txt");

        // Asigna la lista a la TableView
        tblPqCliente.setItems(listaPaqueteTuristicos);
    }

    private void cargarPaquetesDesdeArchivo(String rutaArchivoPq) {
        try {
            List<String> lineasPaquetes = ArchivoUtils.leerArchivoBufferedReader(rutaArchivoPq);

            for (String linea : lineasPaquetes) {
                // Asumiendo que tus paquetes están separados por comas o algún otro delimitador
                String[] partes = linea.split(";");

                for (int i = 0; i < partes.length; i++) {
                    System.out.println("Parte " + i + ": " + partes[i]);
                }


                // Asegúrate de que haya suficientes partes para construir un PaqueteTuristico
                if (partes.length >= 6) {
                    int cupoMaxPersona = Integer.parseInt(partes[4]);
                    int duracion = Integer.parseInt(partes[1]);
                    LocalDateTime fechaDisponibles = LocalDateTime.parse(partes[5]); // Ajusta el formato según tu necesidad
                    String nombre = partes[0];
                    double precio = Double.parseDouble(partes[3]);
                    ArrayList<String> serviciosAdicionales = new ArrayList<>(Arrays.asList(partes[2].split(";")));

                    // Crea un nuevo PaqueteTuristico y agrégalo a la lista
                    PaqueteTuristico paquete = new PaqueteTuristico(nombre, duracion, serviciosAdicionales, precio, cupoMaxPersona, fechaDisponibles);
                    listaPaqueteTuristicos.add(paquete);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("Error de Lectura", "Hubo un error al leer el archivo de paquetes.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void actualizarTabla() {
        // Crea una lista filtrada que envuelva tu lista original
        FilteredList<PaqueteTuristico> listaFiltrada = new FilteredList<>(listaPaqueteTuristicos, p -> true);

        // Aplica filtros basados en las selecciones de ComboBox
        listaFiltrada.setPredicate(paquete -> {
//            boolean ciudadCoincide = cbxCiudad.getValue() == null || paquete.getCiudad().equals(cbxCiudad.getValue());
//            boolean climaCoincide = cbxClima.getValue() == null || paquete.getClima().equals(cbxClima.getValue());
            boolean destinoCoincide = cbxDestino.getValue() == null || paquete.getNombre().equals(cbxDestino.getValue());
            boolean precioCoincide = cbxPrecio.getValue() == null || cumpleCriterioPrecio(paquete, cbxPrecio.getValue());
            boolean fechaCoincide = ldFechaIda.getValue() == null || cumpleCriterioFechaIda(paquete, ldFechaIda.getValue().atStartOfDay());

            return fechaCoincide && destinoCoincide && precioCoincide;
        });

        // Envuelve la lista filtrada en una SortedList
        SortedList<PaqueteTuristico> listaOrdenada = new SortedList<>(listaFiltrada);

        // Vincula el comparador de SortedList al comparador de TableView
        listaOrdenada.comparatorProperty().bind(tblPqCliente.comparatorProperty());

        // Establece los elementos de TableView como la lista ordenada y filtrada
        tblPqCliente.setItems(listaOrdenada);
    }

    private boolean cumpleCriterioPrecio(PaqueteTuristico paquete, String criterioPrecio) {
        if (criterioPrecio == null) {
            return true; // No se aplica el filtro de precio
        }

        switch (criterioPrecio) {
            case "menos de 500.000":
                return paquete.getPrecio() < 500000;
            case "500.000 a 1.000.000":
                return paquete.getPrecio() >= 500000 && paquete.getPrecio() <= 1000000;
            case "1.000.000 a 2.000.000":
                return paquete.getPrecio() > 1000000 && paquete.getPrecio() <= 2000000;
            case "mas de 2.000.000":
                return paquete.getPrecio() > 2000000;
            default:
                return false; // Caso predeterminado si el criterio no coincide con ninguno
        }


    }
    private boolean cumpleCriterioFechaIda(PaqueteTuristico paquete, LocalDateTime fechaIda) {
        if (fechaIda == null) {
            return true; // Si no se selecciona ninguna fecha de ida, entonces cumple el criterio
        }

        LocalDateTime fechaIdaPaquete = paquete.getFechaDisponibles();

        // Comparar con la fecha de ida del paquete
        return fechaIdaPaquete != null && fechaIdaPaquete.toLocalDate().isEqual(ChronoLocalDate.from(fechaIda));
    }

    public void confirmarReserva(ActionEvent actionEvent) {
    }

    public void agregarGuiaRes(ActionEvent actionEvent) {
    }
    //------------------------ reservaForm-------------------------------------------------------------------------

}







