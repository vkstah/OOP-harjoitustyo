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

    public Asiakas getAsiakas() {
        return asiakas;
    }

    public void setAsiakas(Asiakas asiakas) {
        this.asiakas = asiakas;
    }

    public int getVarattavienPaikkojenLkm() {
        return varattavienPaikkojenLkm;
    }

    public void setVarattavienPaikkojenLkm(int varattavienPaikkojenLkm) {
        this.varattavienPaikkojenLkm = varattavienPaikkojenLkm;
    }

    public Elokuva getElokuva() {
        return elokuva;
    }

    public void setElokuva(Elokuva elokuva) {
        this.elokuva = elokuva;
    }
}
