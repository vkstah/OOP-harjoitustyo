package Varausjärjestelmä;

public abstract class Sali {
    protected int salinNumero;
    protected Elokuva elokuva;
    protected int paikkojenLkm;
    protected int salinNumero;
    protected int paikat[][];
    protected int vapaidenPaikkojenLkm;
    public abstract boolean onkoPaikkaVapaa();
    
    public Sali(Elokuva elokuva, int vapaidenPaikkojenLkm, int salinNumero){
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

    public int annaNumero(){
        return salinNumero;
    }


}
