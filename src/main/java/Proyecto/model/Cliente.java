package Proyecto.model;

import lombok.*;

@Setter
@Getter
@ToString
public class Cliente extends Persona {

    private String telefono;
    private String direccionResidencia;
    public Cliente(String nombreCompleto, String identificacion, String usuario, String pasword, String telefono, String direccionResidencia) {
        super(nombreCompleto, identificacion, usuario, pasword);
        this.telefono = telefono;
        this.direccionResidencia = direccionResidencia;
    }

}
