package Varausjärjestelmä;

public class Varaus {
    private Asiakas asiakas;
    private int varattavienPaikkojenLkm;
    private String elokuva;

    public Varaus(Asiakas asiakas, int varattavienPaikkojenLkm, String elokuva) {
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


    public String annaElokuva() {
        return elokuva;
    }

    public void asetaElokuva(String elokuva) {
        this.elokuva = elokuva;
    }
}
