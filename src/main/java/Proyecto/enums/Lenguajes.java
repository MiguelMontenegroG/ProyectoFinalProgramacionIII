package Proyecto.enums;

import lombok.Getter;
import lombok.Setter;

public enum Lenguajes {
    INGLÉS("Inglés"),
    CHINO_MANDARÍN("Chino Mandarín"),
    HINDI("Hindi"),
    ESPAÑOL("Español"),
    FRANCÉS("Francés"),
    ÁRABE_ESTÁNDAR_MODERNO("Árabe Estándar Moderno"),
    BENGALÍ("Bengalí"),
    PORTUGUÉS("Portugués"),
    RUSO("Ruso"),
    URDU("Urdu"),
    INDONESIO("Indonesio"),
    ALEMÁN("Alemán"),
    JAPONÉS("Japonés"),
    MARATÍ("Maratí"),
    TELUGÚ("Telugú"),
    TURCO("Turco"),
    TAMIL("Tamil"),
    CHINO_YUE("Chino Yue"),
    VIETNAMITA("Vietnamita"),
    TAGALO("Tagalo"),
    CHINO_WU("Chino Wu"),
    COREANO("Coreano"),
    PERSA_IRANÍ("Persa Iraní"),
    HAUSA("Hausa"),
    ÁRABE_EGIPCIO("Árabe Egipcio"),
    SUAJILI("Suajili"),
    JAVANÉS("Javanés"),
    ITALIANO("Italiano"),
    PANYABÍ_OCCIDENTAL("Panyabí Occidental"),
    CANARÉS("Canarés"),
    GUYARATI("Guyarati"),
    TAILANDÉS("Tailandés"),
    AMÁRICO("Amárico"),
    BHOSHPURI("Bhoshpuri"),
    PANYABÍ("Panyabí"),
    CHINO_MǏN_NÁN("Chino Mǐn Nán"),
    CHINO_JIN("Chino Jin"),
    YORUBA("Yoruba"),
    CHINO_HAKKA("Chino Hakka"),
    BIRMANO("Birmano"),
    ÁRABE_SUDANÉS("Árabe Sudanés"),
    POLACO("Polaco"),
    ÁRABE_ARGELINO("Árabe Argelino"),
    LINGALA("Lingala");

    @Setter
    @Getter
    String nombreLenguajes;

    Lenguajes (String nombreLenguajes){this.nombreLenguajes=nombreLenguajes;}
    public static Lenguajes obtenerNombreLenguajes(String nombreLenguajes) {
        for (Lenguajes c : Lenguajes.values()) {
            if (c.getNombreLenguajes().equalsIgnoreCase(nombreLenguajes)) {
                return c;
            }
        }
        return null;
    }


}