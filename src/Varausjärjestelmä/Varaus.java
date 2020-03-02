package Varausjärjestelmä;

import java.util.ArrayList;

public class Varaus {
    private ArrayList<Sali> salit;
    private Asiakas asiakas;
    private int varattavienPaikkojenLkm;

    public Varaus(Asiakas asiakas, int varattavienPaikkojenLkm) {
        salit = new ArrayList<Sali>();
        this.asiakas = asiakas;
        this.varattavienPaikkojenLkm = varattavienPaikkojenLkm;
    }
}
