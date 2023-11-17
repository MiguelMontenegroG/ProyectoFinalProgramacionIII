package Proyecto.model;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class PaqueteTuristico implements Serializable {

    private String nombre;
    private int duracion;
    private ArrayList<String> serviciosAdicionales;
    private Double precio;
    private int cupoMaxPersona;
    private LocalDateTime fechaDisponibles;

    //-------clase---//
    private ArrayList<Destino> listaDestinos = new ArrayList<Destino>();

    public PaqueteTuristico(String nombre, int duracion, ArrayList<String> serviciosAdicionales, Double precio, int cupoMaxPersona, LocalDateTime fechaDisponibles) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.serviciosAdicionales = serviciosAdicionales;
        this.precio = precio;
        this.cupoMaxPersona = cupoMaxPersona;
        this.fechaDisponibles = fechaDisponibles;
    }

}
