package Varausjärjestelmä;

public class Elokuva {
    private String nimi;
    private String ikaraja;

    public Elokuva(String nimi, String ikaraja) {
        this.nimi = nimi;
        this.ikaraja = ikaraja;
    }

    public String getNimi() {
        return nimi;
    }

    public String getIkaraja() {
        return ikaraja;
    }


}
