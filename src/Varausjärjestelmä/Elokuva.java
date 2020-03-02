package Varausjärjestelmä;

public class Elokuva {
    private String nimi;
    private int ikaraja;

    public Elokuva(String nimi, int ikaraja) {
        this.nimi = nimi;
        this.ikaraja = ikaraja;
    }

    public String getNimi() {
        return nimi;
    }

    public int getIkaraja() {
        return ikaraja;
    }


}
