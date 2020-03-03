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
        int summa = 0;
        if(paikat.length == 5) {
            for (int i = 0; i<5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (paikat[i][j] == 1) {
                        summa++;
                    }
                }
            }
        }else{
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (paikat[i][j] == 1) {
                        summa++;
                    }
                }
            }
        }
        vapaidenPaikkojenLkm = summa;
        return vapaidenPaikkojenLkm;
    }

    public void varaaPaikka(int lkm){
        vapaidenPaikkojenLkm -= lkm;
    }

    public int annaId(){
        return saliId;
    }


}
