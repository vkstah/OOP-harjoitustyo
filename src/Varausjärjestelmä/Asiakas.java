package Varausjärjestelmä;

import java.util.ArrayList;

public class Asiakas {
    private String nimi;
    private int ika;
    private ArrayList<Varaus> varaukset;

    public Asiakas(String nimi, int ika) {
        varaukset = new ArrayList<>();
        this.nimi = nimi;
        this.ika = ika;
    }
}
