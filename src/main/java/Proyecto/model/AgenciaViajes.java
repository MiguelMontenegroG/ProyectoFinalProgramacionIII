package Proyecto.model;

import lombok.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Setter
@Getter
@ToString
public class AgenciaViajes {

    //------atributos----//
    private String nombreEmpresa;

    //------Clases----//
    private ArrayList<Persona> listaPersona;
    private ArrayList<Reserva> listaReservas;
    private ArrayList<PaqueteTuristico> listaPaqueteTuristicos;
    private ArrayList<Destino> listaDestinos;

    //-----LOGGER----//
    private static final Logger LOGGER = Logger.getLogger(AgenciaViajes.class.getName());

    //Variable que tendrá la instancia de esta clase
    private static AgenciaViajes agenciaViajes;

    /**
     * Constructor debe ser privado para que ninguna otra clase pueda crear instancias de esta clase
     */
    private AgenciaViajes() {
        registrarArchivoLogger(); // Llamada al método para registrar el archivo del logger.
        this.listaPersona = new ArrayList<>();

        this.listaDestinos = new ArrayList<>();

        this.listaPaqueteTuristicos = new ArrayList<>();

        this.listaReservas = new ArrayList<>();

    }

    /**
     * Método para registrar el archivo del logger.
     */
    private void registrarArchivoLogger() {
        try {
            FileHandler fh = new FileHandler("logs.log", true);
            fh.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fh);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        LOGGER.log(Level.INFO, "Se crea una nueva instancia de AgenciaViajes");
    }

    //------------------------------  Singleton -----------------------------------------//
    /**
     * Método que se usará en las otras clases que requieran una instancia de esta clase
     *
     * @return Instancia del objeto Empresa
     */
    public static AgenciaViajes getInstance() {
        if (agenciaViajes == null) {
            agenciaViajes = new AgenciaViajes();
        }
        return agenciaViajes;
    }





}
