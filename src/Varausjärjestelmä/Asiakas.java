package Varausjärjestelmä;

import java.util.ArrayList;

public class Asiakas {
    private String nimi;
    private int ika;

    public Asiakas(String nimi, int ika) {
        this.nimi = nimi;
        this.ika = ika;
    }


    public String annaNimi() {
        return nimi;
    }


    public int annaIka() {
        return ika;
    }

}
