package Proyecto.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
public abstract class Persona {

    private String nombreCompleto;
    private String identificacion;
    private String correo;
    private String password;

    public Persona(String nombreCompleto, String identificacion, String correo, String password) {
        this.nombreCompleto = nombreCompleto;
        this.identificacion = identificacion;
        this.correo = correo;
        this.password = password;
    }

}
