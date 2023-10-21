package Proyecto.model;


import Proyecto.enums.Ciudades;
import Proyecto.enums.Clima;
import lombok.*;

import java.util.ArrayList;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Destino {

    private String nombre;
    private Ciudades ciudad;
    private String descripcio;
    private ArrayList<String> imagenes;
    private Clima clima;

}
