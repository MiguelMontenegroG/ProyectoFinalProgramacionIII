package Proyecto.model;


import Proyecto.enums.EstadoReserva;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reserva {
    //------atributos----//
    private LocalDateTime fechaSolicitud;
    private LocalDateTime fechaPlanificadaViaje;
    private String clienteInvolucrado;
    private int cantidadPersonaViejan;
    private String paqueteTuristicoSeleccionado;
    private String guiaTutistico;
    //---------clase--------//
    private EstadoReserva estandoReserva;
    private GuiaTuristico guiaTuristicoReserva;
    private Cliente clienteReserva;
    private PaqueteTuristico paqueteTuristico;

}