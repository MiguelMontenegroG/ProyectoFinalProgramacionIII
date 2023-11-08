package Proyecto.model;

import Proyecto.enums.Lenguajes;
import lombok.*;
@NoArgsConstructor
@Setter
@Getter
@ToString(callSuper=true)
public class GuiaTuristico extends Persona{

    private int experiencia;
    private Lenguajes lenguaje;

    public GuiaTuristico(String nombreCompleto, String identificacion, String usuario, String pasword, int experiencia, Lenguajes lenguaje) {
        super(nombreCompleto, identificacion, usuario, pasword);
        this.experiencia = experiencia;
        this.lenguaje = lenguaje;
    }

}