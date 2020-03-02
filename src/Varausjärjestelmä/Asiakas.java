package Varausjärjestelmä;

import java.util.ArrayList;

public class Asiakas {
    private String nimi;
    private int ika;

    public Asiakas(String nimi, int ika) {
        this.nimi = nimi;
        this.ika = ika;
    }


    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getIka() {
        return ika;
    }

    public void setIka(int ika) {
        this.ika = ika;
    }
}
