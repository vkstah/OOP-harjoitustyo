package Luokat;

public class Sali3D  extends Sali{

    public Sali3D(Elokuva elokuva, int paikkojenLkm, int salinNumero) {
        super(elokuva, paikkojenLkm, salinNumero);
    }

    public void varaaPaikka(int lkm){
        vapaidenPaikkojenLkm -= 2*lkm;
    }
    public void vapautaPaikka(int lkm){
        vapaidenPaikkojenLkm += 2*lkm;
    }
}
