package Varausjärjestelmä;

public abstract class Sali {
    protected Elokuva elokuva;
    protected int paikkojenLkm;

    public Sali(Elokuva elokuva, int paikkojenLkm){
        this.elokuva = elokuva;
        this.paikkojenLkm = paikkojenLkm;
    }

}
