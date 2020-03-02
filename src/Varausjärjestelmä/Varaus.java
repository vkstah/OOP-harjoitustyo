package Varausjärjestelmä;

import java.util.ArrayList;

public class Varaus {
    private ArrayList<Sali> salit;
    private Asiakas asiakas;
    private int varattavienPaikkojenLkm;
    private int rivi;
    private int sarake;

    public Varaus(Arraylist<Sali> salit, Asiakas asiakas, int varattavienPaikkojenLkm, int rivi, int sarake) {
        salit = new ArrayList<Sali>();
        this.asiakas = asiakas;
        this.varattavienPaikkojenLkm = varattavienPaikkojenLkm;
        this.rivi = rivi;
        this.sarake = sarake;
    }
    
    


}
