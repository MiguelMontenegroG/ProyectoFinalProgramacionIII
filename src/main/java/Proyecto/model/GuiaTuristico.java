package Proyecto.model;

import Proyecto.enums.Lenguajes;
import lombok.*;
@NoArgsConstructor
@Setter
@Getter
public class GuiaTuristico extends Persona{

    private int experiencia;
    private Lenguajes lenguaje;

    public GuiaTuristico(String nombreCompleto, String identificacion, String correo, String password, int experiencia, Lenguajes lenguaje) {
        super(nombreCompleto, identificacion, correo, password);
        this.experiencia = experiencia;
        this.lenguaje = lenguaje;
    }

}
