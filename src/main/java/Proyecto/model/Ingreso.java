package Proyecto.model;

import Proyecto.enums.Ciudades;
import Proyecto.enums.Clima;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class Ingreso {
    private String usuario;
    private String contrasena;
}
