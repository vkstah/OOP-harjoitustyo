package Varausjärjestelmä;

public abstract class Sali {
    protected Elokuva elokuva;
    protected int vapaidenPaikkojenLkm;

    public Sali(Elokuva elokuva, int vapaidenPaikkojenLkm){
        this.elokuva = elokuva;
        this.vapaidenPaikkojenLkm = vapaidenPaikkojenLkm;
    }

    public Elokuva getElokuva() {
        return elokuva;
    }

    public void setElokuva(Elokuva elokuva) {
        this.elokuva = elokuva;
    }

    public int getPaikkojenLkm() {
        return vapaidenPaikkojenLkm;
    }

    public void varaaPaikka(int lkm){
        vapaidenPaikkojenLkm -= lkm;
    }

}
