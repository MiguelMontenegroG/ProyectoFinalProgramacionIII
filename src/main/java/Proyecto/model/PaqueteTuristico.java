package Proyecto.model;

import Proyecto.enums.Ciudades;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaqueteTuristico implements Serializable {

    @Getter
    private String nombre;
    @Getter
    private int duracion;
    @Getter
    private ArrayList<String> serviciosAdicionales;
    @Getter
    private Double precio;
    private Integer cupoMaxPersona;
    private LocalDateTime fechaDisponibles;


    //-------clase---//
    private ArrayList<Destino> listaDestinos = new ArrayList<Destino>();

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setServiciosAdicionales(ArrayList<String> serviciosAdicionales) {
        this.serviciosAdicionales = serviciosAdicionales;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCupoMaxPersona() {
        return cupoMaxPersona;
    }

    public void setCupoMaxPersona(Integer cupoMaxPersona) {
        this.cupoMaxPersona = cupoMaxPersona;
    }

    public LocalDateTime getFechaDisponibles() {
        return fechaDisponibles;
    }

    public void setFechaDisponibles(LocalDateTime fechaDisponibles) {
        this.fechaDisponibles = fechaDisponibles;
    }

    public ArrayList<Destino> getListaDestinos() {
        return listaDestinos;
    }

    public void setListaDestinos(ArrayList<Destino> listaDestinos) {
        this.listaDestinos = listaDestinos;
    }

    @Override
    public String toString() {
        return "PaqueteTuristico " +
                "serviciosAdicionales=" + serviciosAdicionales +
                ' ';
    }

    public PaqueteTuristico(String nombre, int duracion, ArrayList<String> serviciosAdicionales, Double precio, int cupoMaxPersona, LocalDateTime fechaDisponibles) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.serviciosAdicionales = serviciosAdicionales;
        this.precio = precio;
        this.cupoMaxPersona = cupoMaxPersona;
        this.fechaDisponibles = fechaDisponibles;
    }
}
