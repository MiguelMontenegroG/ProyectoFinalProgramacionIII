package Proyecto.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaqueteTuristico {
    //---------------------//
    private String nombre;
    private int duracion;
    private ArrayList<String> serviciosAdicionales;
    private Double precio;
    private int cupoMaxPersona;
    private LocalDateTime fechaDisponibles;

    //-------clase---//
    private ArrayList<Destino> listaDestinos = new ArrayList<Destino>();


}
