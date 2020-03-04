package Luokat;

public abstract class Sali {
    private int salinNumero;
    private Elokuva elokuva;
    protected int vapaidenPaikkojenLkm;

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

    public abstract void varaaPaikka(int lkm);
    public abstract void vapautaPaikka(int lkm);

    public int annaNumero(){
        return salinNumero;
    }

}
