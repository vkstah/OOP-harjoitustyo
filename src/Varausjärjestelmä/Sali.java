package Varausjärjestelmä;

public abstract class Sali {
    protected String salinNumero;
    protected Elokuva elokuva;
    protected int vapaidenPaikkojenLkm;

    public Sali(Elokuva elokuva, int vapaidenPaikkojenLkm, String salinNumero){
        this.salinNumero = salinNumero;
        this.elokuva = elokuva;
        this.vapaidenPaikkojenLkm = vapaidenPaikkojenLkm;
    }

    public Elokuva annaElokuva() {
        return elokuva;
    }

    public void asetaElokuva(Elokuva elokuva) {
        this.elokuva = elokuva;
    }

    public int annaVapaidenPaikkojenLkm() {
        return vapaidenPaikkojenLkm;
    }

    public void varaaPaikka(int lkm){
        vapaidenPaikkojenLkm -= lkm;
    }

    public String annaSalinNumero(){
        return salinNumero;
    }

}
