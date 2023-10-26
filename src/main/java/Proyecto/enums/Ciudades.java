package Proyecto.enums;

import lombok.Getter;
import lombok.Setter;

public enum Ciudades {
    BOGOTÁ("Bogotá"),
    MEDELLÍN("Medellín"),
    CALI("Cali"),
    BARRANQUILLA("Barranquilla"),
    CARTAGENA("Cartagena"),
    SOLEDAD("Soledad"),
    CÚCUTA("Cúcuta"),
    IBAGUÉ("Ibagué"),
    SOACHA("Soacha"),
    VILLAVICENCIO("Villavicencio"),
    BUCARAMANGA("Bucaramanga"),
    SANTA_MARTA("Santa Marta"),
    VALLEDUPAR("Valledupar"),
    BELLO("Bello"),
    PEREIRA("Pereira"),
    MONTERÍA("Montería"),
    PASTO("Pasto"),
    BUENAVENTURA("Buenaventura"),
    MANIZALES("Manizales"),
    NEIVA("Neiva"),
    PALMIRA("Palmira"),
    RIOHACHA("Riohacha"),
    SINCELEJO("Sincelejo"),
    POPAYÁN("Popayán"),
    ITAGÜÍ("Itagüí"),
    FLORIDABLANCA("Floridablanca"),
    ENVIGADO("Envigado"),
    TULUÁ("Tuluá"),
    SAN_ANDRÉS_DE_TUMACO("San Andrés de Tumaco"),
    DOSQUEBRADAS("Dosquebradas"),
    APARTADÓ("Apartadó"),
    TUNJA("Tunja"),
    GIRÓN("Girón"),
    URIBIA("Uribia"),
    BARRANCABERMEJA("Barrancabermeja"),
    FLORENCIA("Florencia"),
    TURBO("Turbo"),
    MAICAO("Maicao"),
    PIEDECUESTA("Piedecuesta"),
    YOPAL("Yopal");

    @Setter
    @Getter
    private String nombreCiudad;
    Ciudades(String nombreCiudad){
        this.nombreCiudad = nombreCiudad;
    }

    public static Ciudades obtenerNombreCiudades(String nombreCiudad) {
        for (Ciudades c : Ciudades.values()) {
            if (c.getNombreCiudad().equalsIgnoreCase(nombreCiudad)) {
                return c;
            }
        }
        return null;
    }
}
