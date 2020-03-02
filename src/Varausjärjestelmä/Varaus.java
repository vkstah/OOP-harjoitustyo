package Varausjärjestelmä;

import java.util.ArrayList;

public class Varaus {
    private Asiakas asiakas;
    private int varattavienPaikkojenLkm;
    private Elokuva elokuva;

    public Varaus(Asiakas asiakas, int varattavienPaikkojenLkm, Elokuva elokuva) {
        this.elokuva = elokuva;
        this.asiakas = asiakas;
        this.varattavienPaikkojenLkm = varattavienPaikkojenLkm;
    }

    public Asiakas annaAsiakas() {
        return asiakas;
    }

    public void asetaAsiakas(Asiakas asiakas) {
        this.asiakas = asiakas;
    }

    public int annaVarattavienPaikkojenLkm() {
        return varattavienPaikkojenLkm;
    }


    public Elokuva annaElokuva() {
        return elokuva;
    }

    public void asetaElokuva(Elokuva elokuva) {
        this.elokuva = elokuva;
    }
}
