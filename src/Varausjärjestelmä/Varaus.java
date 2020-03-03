package Varausjärjestelmä;

public class Varaus {
    private Asiakas asiakas;
    private int varattavienPaikkojenLkm;
    private int rivi;
    private int sarake;
    private Elokuva elokuva;

    public Varaus(Asiakas asiakas, int varattavienPaikkojenLkm, Elokuva elokuva, int rivi, int sarake) {
        this.elokuva = elokuva;
    	this.asiakas = asiakas;
        this.varattavienPaikkojenLkm = varattavienPaikkojenLkm;
        this.rivi = rivi;
        this.sarake = sarake;
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
    public void asetaVarattavienPaikkojenLkm(int varattavienPaikkojenLkm) {
    	this.varattavienPaikkojenLkm = varattavienPaikkojenLkm;
    }
    public Elokuva annaElokuva() {
    	return elokuva;
    }
    public void asetaElokuva(Elokuva elokuva) {
    	this.elokuva = elokuva;
    }
    public Elokuva annaRivi() {
    	return rivi;
    }
    public void asetaRivi(int rivi) {
    	this.rivi = rivi;
    }
    public Elokuva annaSarake() {
    	return sarake;
    }
    public void asetaSarake(int sarake) {
    	this.sarake = sarake;
    }
}
