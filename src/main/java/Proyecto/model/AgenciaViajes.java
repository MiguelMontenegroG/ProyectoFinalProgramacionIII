package Proyecto.model;

import Proyecto.enums.Ciudades;
import Proyecto.enums.Clima;
import Proyecto.enums.Lenguajes;
import Proyecto.exceptions.*;
import Proyecto.utils.Persistencia;
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

    //----------------------DESTINO----------------------//
    //----------------------CREAR------------------------//

    /**
     * Método para crear un nuevo destino.
     *
     * @param nombre      El nombre del destino.
     * @param ciudad      La ciudad del destino.
     * @param descripcion La descripción del destino.
     * @param imagenes    Una lista de imágenes del destino.
     * @param clima       El clima del destino.
     * @return Retorna un objeto de tipo Destino.
     * @throws InformacionNoExiste Se lanza cuando la información no existe.
     * @throws CampoObligatorio    Se lanza cuando falta un campo obligatorio.
     * @throws SeleccionarNoOpcion Se lanza cuando no se selecciona una opción.
     * @throws SeleccioneCargar    Se lanza cuando no se selecciona cargar.
     */
    public Destino crearDestino(String nombre, Ciudades ciudad, String descripcion, ArrayList<String> imagenes, Clima clima) throws InformacionNoExiste, CampoObligatorio, SeleccionarNoOpcion, SeleccioneCargar {
        Destino nuevoDestino;
        // Muestra los campos obligatorios.
        mostrarDestinoCampoObligatorio(nombre, ciudad, descripcion, imagenes, clima);

        nuevoDestino = new Destino();
        nuevoDestino.setNombre(nombre);
        nuevoDestino.setCiudad(ciudad);
        nuevoDestino.setDescripcion(descripcion);
        nuevoDestino.setImagenes(imagenes);
        nuevoDestino.setClima(clima);

        getListaDestinos().add(nuevoDestino);

        // Registra en el logger que el destino se ha creado exitosamente.
        LOGGER.log(Level.INFO, "El destino se ha creado exitosamente : " + nombre);

        // Escribe la lista de los Destinos en la persistencia de datos.
        Persistencia.escribirDestino(nuevoDestino);

        return nuevoDestino;
    }

    /**
     * Este método verifica si los campos obligatorios están presentes.
     *
     * @param nombre      El nombre que se va a verificar.
     * @param ciudad      La ciudad que se va a verificar.
     * @param descripcion La descripción que se va a verificar.
     * @param imagenes    Las imágenes que se van a verificar.
     * @param clima       El clima que se va a verificar.
     * @throws CampoObligatorio Se lanza esta excepción cuando un campo obligatorio está vacío.
     */
    private void mostrarDestinoCampoObligatorio(String nombre, Ciudades ciudad, String descripcion, ArrayList<String> imagenes, Clima clima) throws CampoObligatorio, SeleccionarNoOpcion, SeleccioneCargar {
        // Si el nombre está vacío, registra un error y lanza una excepción.
        if (nombre == null || nombre.isEmpty()) {
            LOGGER.log(Level.SEVERE, "El nombre es obligatorio de campo");
            throw new CampoObligatorio("El nombre es obligatorio de campo");
        }
        // Si la ciudad está vacía, registra un error y lanza una excepción.
        if (ciudad == null) {
            LOGGER.log(Level.SEVERE, "Por favor, selecciona una opción para  la ciudad.");
            throw new SeleccionarNoOpcion("Por favor, selecciona una opción para  la ciudad.");
        }
        // Si la clima está vacía, registra un error y lanza una excepción.
        if (clima == null) {
            LOGGER.log(Level.SEVERE, "Por favor, selecciona una opción para el clima.");
            throw new SeleccionarNoOpcion("Por favor, selecciona una opción para el clima.");
        }
        // Si el descripcio está vacío, registra un error y lanza una excepción.
        if (descripcion == null || descripcion.isEmpty()) {
            LOGGER.log(Level.SEVERE, "El descripcio es obligatorio de campo");
            throw new CampoObligatorio("El descripcio es obligatorio de campo");
        }
        // Si la imágen está vacía, registra un error y lanza una excepción.
        if (imagenes == null || imagenes.isEmpty()) {
            LOGGER.log(Level.SEVERE, "Por favor, Seleccione un archivo para cargar.");
            throw new SeleccioneCargar("Por favor, Seleccione un archivo para cargar.");
        }

    }
    //----------------------ACTUALIZAR-------------------//

    /**
     * Este método se utiliza para actualizar la información de un destino específico.
     *
     * @param nombreNuevo El nombre del destino que se va a actualizar.
     * @param ciudad      La ciudad del destino que se va a actualizar.
     * @param descripcion La descripción del destino que se va a actualizar.
     * @param imagenes    Una lista de imágenes del destino que se va a actualizar.
     * @param clima       El clima del destino que se va a actualizar.
     * @return Retorna verdadero si el destino se actualiza exitosamente, de lo contrario retorna falso.
     * @throws CampoObligatorio    Se lanza esta excepción si algún campo obligatorio está vacío.
     * @throws SeleccioneCargar    Se lanza esta excepción si no se selecciona ninguna opción para cargar.
     * @throws SeleccionarNoOpcion Se lanza esta excepción si no se selecciona ninguna opción.
     */
    public boolean actualizarDestino(String nombreActual, String nombreNuevo, Ciudades ciudad, String descripcion, ArrayList<String> imagenes, Clima clima) throws CampoObligatorio,SeleccioneCargar, SeleccionarNoOpcion {
        Destino destino = obtenerDestino(nombreActual);
        boolean esDestinoActualizado = false;

        mostrarDestinoCampoObligatorio(nombreNuevo, ciudad, descripcion, imagenes, clima);

        if (destino != null) {
            destino.setNombre(nombreNuevo);
            destino.setCiudad(ciudad);
            destino.setDescripcion(descripcion);
            destino.setImagenes(imagenes);
            destino.setClima(clima);

            LOGGER.info("Destino actualizado exitosamente.");
            esDestinoActualizado = true;
        } else {
            LOGGER.severe("No se encontró el destino para actualizar.");
        }
        return esDestinoActualizado;
    }

    /**
     * Este método busca un objeto Destino en la lista de destinos por su nombre.
     *
     * @param nombreActual El nombre del destino que se está buscando.
     * @return Retorna el objeto Destino si se encuentra en la lista; de lo contrario, retorna null.
     */
    private Destino obtenerDestino(String nombreActual) {
        Destino destinoEncontrado = null;
        for (Destino destino : listaDestinos) {
            if (destino.getNombre().equals(nombreActual)) {
                destinoEncontrado = destino;
                break;
            }
        }
        return destinoEncontrado;
    }

    //----------------------ELIMINAR---------------------//

    /**
     * Este método elimina un objeto Destino de la lista de destinos por su nombre.
     *
     * @param nombre El nombre del destino que se desea eliminar.
     * @return Retorna true si el destino se eliminó exitosamente; de lo contrario, retorna false.
     */
    public boolean eliminarDestino(String nombre) {
        Destino destino = obtenerDestino(nombre);
        if (destino != null) {
            getListaDestinos().remove(destino);
            LOGGER.info("Destino eliminado exitosamente. " + nombre);
            return true;
        }
        LOGGER.severe("El destino no se puede eliminar");
        return false;
    }

    //----------------------GUIAS----------------------//
    //----------------------CREAR------------------------//

    /**
     * Este método crea un nuevo objeto GuiaTuristico y lo añade a la lista de personas.
     *
     * @param nombreCompleto El nombre completo del guía turístico.
     * @param identificacion La identificación del guía turístico.
     * @param usuario El correo electrónico del guía turístico.
     * @param password La contraseña del guía turístico.
     * @param experiencia La experiencia del guía turístico.
     * @param lenguaje El lenguaje que habla el guía turístico.
     * @return Retorna el objeto GuiaTuristico creado.
     * @throws CampoNegativo Se lanza si se introduce un valor negativo donde no se permite.
     * @throws CampoObligatorio Se lanza si se deja un campo obligatorio vacío.
     * @throws SeleccionarNoOpcion Se lanza si no se selecciona ninguna opción donde se requiere.
     */
    public GuiaTuristico crearGuiaTuristico(String nombreCompleto, String identificacion, String usuario, String password, int experiencia, Lenguajes lenguaje) throws CampoNegativo, CampoObligatorio, SeleccionarNoOpcion {
        GuiaTuristico nuevoGuiaTuristico;
        mostrarGuiasCampoObligatorio(nombreCompleto, identificacion, usuario, password, experiencia, lenguaje);
        nuevoGuiaTuristico = new GuiaTuristico();
        nuevoGuiaTuristico.setNombreCompleto(nombreCompleto);
        nuevoGuiaTuristico.setIdentificacion(identificacion);
        nuevoGuiaTuristico.setCorreo(usuario);
        nuevoGuiaTuristico.setPassword(password);
        nuevoGuiaTuristico.setExperiencia(experiencia);
        nuevoGuiaTuristico.setLenguaje(lenguaje);
        getListaPersona().add(nuevoGuiaTuristico);
        LOGGER.log(Level.INFO, "La guia turistico se ha creado exitosamente : " + identificacion);
        Persistencia.escribirGuiaTuristico(nuevoGuiaTuristico);
        return nuevoGuiaTuristico;
    }

    /**
     * Este método verifica si los campos obligatorios para la creación de un objeto GuiaTuristico están presentes y son válidos.
     *
     * @param nombreCompleto El nombre completo del guía turístico.
     * @param identificacion La identificación del guía turístico.
     * @param usuario El correo electrónico del guía turístico.
     * @param password La contraseña del guía turístico.
     * @param experiencia La experiencia del guía turístico.
     * @param lenguaje El lenguaje que habla el guía turístico.
     * @throws CampoObligatorio Se lanza si se deja un campo obligatorio vacío.
     * @throws CampoNegativo Se lanza si se introduce un valor negativo donde no se permite.
     * @throws SeleccionarNoOpcion Se lanza si no se selecciona ninguna opción donde se requiere.
     */
    private void mostrarGuiasCampoObligatorio(String nombreCompleto, String identificacion, String usuario, String password, int experiencia, Lenguajes lenguaje) throws CampoObligatorio, CampoNegativo, SeleccionarNoOpcion {
        if (nombreCompleto == null || nombreCompleto.isEmpty()) {
            LOGGER.log(Level.SEVERE, "El nombre completo es obligatorio de campo");
            throw new CampoObligatorio("El nombre completo es obligatorio de campo");
        }
        if (identificacion == null || identificacion.isEmpty()) {
            LOGGER.log(Level.SEVERE, "El identificacion es obligatorio de campo");
            throw new CampoObligatorio("El identificacion es obligatorio de campo");
        }
        if (usuario == null || usuario.isEmpty()) {
            LOGGER.log(Level.SEVERE, "El usuario es obligatorio de campo");
            throw new CampoObligatorio("El usuario es obligatorio de campo");
        }
        if (password == null || password.isEmpty()) {
            LOGGER.log(Level.SEVERE, "La contraseña es obligatorio de campo");
            throw new CampoObligatorio("La contraseña es obligatorio de campo");
        }
        if (experiencia < 0 || experiencia == 0) {
            LOGGER.log(Level.SEVERE, "La experiencia estos no sean negativos o esta vacio");
            throw new CampoNegativo("La experiencia estos no sean negativos o esta vacio");
        }
        if (lenguaje == null) {
            LOGGER.log(Level.SEVERE, "Por favor, selecciona una opción para el lenguaje.");
            throw new SeleccionarNoOpcion("Por favor, selecciona una opción para  el lenguaje.");
        }
    }
    //----------------------ACTUALIZAR-------------------//
    public boolean actualizarGuiaTuristico(String identificacionActual,String nombreCompleto, String identificacionNuevo, String usuario, String password, int experiencia, Lenguajes lenguaje) throws CampoNegativo, CampoObligatorio, SeleccionarNoOpcion {
        mostrarGuiasCampoObligatorio(nombreCompleto,identificacionNuevo,usuario,password,experiencia,lenguaje);
        GuiaTuristico guiaTuristico = obtenerGuiaTuristico(identificacionActual);
        boolean esGuiaTuristicoActualizado=false;
        if (guiaTuristico!=null){
            guiaTuristico.setNombreCompleto(nombreCompleto);
            guiaTuristico.setIdentificacion(identificacionNuevo);
            guiaTuristico.setExperiencia(experiencia);
            guiaTuristico.setCorreo(usuario);
            guiaTuristico.setPassword(password);
            LOGGER.info("Guia turistico actualizado exitosamente.");
            esGuiaTuristicoActualizado = true;
        }else {
            LOGGER.severe("No se encontró la guia turistico para actualizar.");
        }
        return esGuiaTuristicoActualizado;
    }
    private GuiaTuristico obtenerGuiaTuristico(String identificacionActual) {
        GuiaTuristico guiaTuristicoEncontrado = null;
        for (Persona persona : listaPersona) {
            if (persona instanceof GuiaTuristico) {
                if (persona.getIdentificacion().equals(identificacionActual)){
                    guiaTuristicoEncontrado = (GuiaTuristico) persona;
                    break;
                }
            }
        }
        return guiaTuristicoEncontrado;
    }
    //----------------------ELIMINAR---------------------//
    public boolean eliminarGuiaTuristico(String identificacion) {
        GuiaTuristico guiaTuristico = obtenerGuiaTuristico(identificacion);
        if (guiaTuristico!=null){
            getListaPersona().remove(guiaTuristico);
            LOGGER.info("Guia turistico eliminado exitosamente. " + identificacion);
            return true;
        }
        LOGGER.severe("La guia turistico  no se puede eliminar");
        return false;
    }

    //----------------------PAQUETES----------------------//
    //----------------------CREAR------------------------//
    //----------------------ACTUALIZAR-------------------//
    //----------------------ELIMINAR---------------------//
}
