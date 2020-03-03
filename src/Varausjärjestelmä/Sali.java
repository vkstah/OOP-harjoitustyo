package Varausjärjestelmä;

public abstract class Sali {
    protected int saliId;
    protected Elokuva elokuva;
    protected int paikkojenLkm;
    protected int[][] paikat;
    protected int vapaidenPaikkojenLkm;


    public abstract boolean onkoPaikkaVapaa(int rivi, int sarake);
    
    public Sali(Elokuva elokuva, int saliID){
        this.saliId = saliId;
        this.elokuva = elokuva;
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

    public int annaId(){
        return saliId;
    }


}
