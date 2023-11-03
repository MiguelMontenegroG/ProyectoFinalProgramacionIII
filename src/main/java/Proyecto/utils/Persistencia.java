package Proyecto.utils;

import Proyecto.model.Destino;
import Proyecto.model.GuiaTuristico;
import Proyecto.model.PaqueteTuristico;
import lombok.extern.java.Log;

import java.io.IOException;
import java.util.List;

@Log
public class Persistencia {

    // Ruta del archivo donde se guardan los datos de los destinos.
    public static final String RUTA_ARCHIVO_DESTINO = "src/main/resources/persistencia/destinos.txt";
    public static final String RUTA_ARCHIVO_GUIAS = "src/main/resources/persistencia/guias.txt";
    public static final String RUTA_ARCHIVO_PAQUETES = "src/main/resources/persistencia/paquetes.txt";

    //    public static final String RUTA_ARCHIVO_ALQUILER = "src/main/resources/persistencia/alquiler.ser";


    //----------------------Destino---------------------------//
    public static void escribirDestino(Destino destino) {
        try {
            String linea = destino.getNombre() + ";" +
                    destino.getCiudad() + ";" +
                    destino.getClima()+ ";" +
                    destino.getImagenes() + ";" +
                    destino.getDescripcion();
            ArchivoUtils.escribirArchivoBufferedWriter(RUTA_ARCHIVO_DESTINO, List.of(linea), true);
        } catch (IOException e) {
            log.severe(e.getMessage());
        }
    }

    public static void escribirGuiaTuristico(GuiaTuristico guiaTuristico) {
        try {
            String linea = guiaTuristico.getNombreCompleto()+";"+
                    guiaTuristico.getIdentificacion()+";"+
                    guiaTuristico.getLenguaje()+";"+
                    guiaTuristico.getExperiencia()+";"+
                    guiaTuristico.getCorreo()+";"+
                    guiaTuristico.getPassword();
            ArchivoUtils.escribirArchivoBufferedWriter(RUTA_ARCHIVO_GUIAS,List.of(linea),true);
        }catch (IOException e) {
            log.severe(e.getMessage());
        }
    }

    public static void escribirPaqueteTuristico(PaqueteTuristico paqueteTuristico) {
        try {
            String linea = paqueteTuristico.getNombre() + ";" +
                    paqueteTuristico.getDuracion() + ";" +
                    paqueteTuristico.getServiciosAdicionales() + ";" +
                    paqueteTuristico.getPrecio() + ";" +
                    paqueteTuristico.getCupoMaxPersona() + ";" +
                    paqueteTuristico.getFechaDisponibles();
            ArchivoUtils.escribirArchivoBufferedWriter(RUTA_ARCHIVO_PAQUETES, List.of(linea), true);
        } catch (IOException e) {
            log.severe(e.getMessage());
        }

    }

//    public static ArrayList<Cliente> leerCliente() {
//        ArrayList<Cliente> clientes = new ArrayList<>();
//        try {
//            ArrayList<String> lineas = ArchivoUtils.leerArchivo(RUTA_ARCHIVO_CLIENTE);
//            for (String linea : lineas) {
//                String[] partes = linea.split(";");
//                clientes.add(new Cliente(partes[0],
//                        partes[1],
//                        partes[2],
//                        partes[3],
//                        partes[4],
//                        partes[5]));
//            }
//        } catch (IOException e) {
//            log.severe(e.getMessage());
//        }
//        return clientes;
//    }
//
//    //---------------------------ALQUILER-------------------------------//
//    public static void escribirAlquiler(List<Alquiler> alquileres) {
//        try {
//            ArchivoUtils.serializarObjeto(RUTA_ARCHIVO_ALQUILER, alquileres);
//        } catch (IOException e) {
//            log.severe(e.getMessage());
//        }
//    }
//    public static ArrayList<Alquiler> leerAlquiler(){
//        ArrayList<Alquiler> alquileres = new ArrayList<>();
//        try {
//            alquileres = (ArrayList<Alquiler>) ArchivoUtils.deserializarObjeto(RUTA_ARCHIVO_ALQUILER);
//        } catch (IOException | ClassNotFoundException e) {
//            log.severe(e.getMessage());
//        }
//        return alquileres;
//    }

}