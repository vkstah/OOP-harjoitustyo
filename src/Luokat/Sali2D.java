package Luokat;

public class Sali2D extends Sali {


    public Sali2D(Elokuva elokuva, int paikkojenLkm, int salinNumero) {
        super(elokuva, paikkojenLkm, salinNumero);
    }
    public  void varaaPaikka(int lkm){
        vapaidenPaikkojenLkm -= lkm;
    }
    public  void vapautaPaikka(int lkm){
        vapaidenPaikkojenLkm += lkm;
    }

}
