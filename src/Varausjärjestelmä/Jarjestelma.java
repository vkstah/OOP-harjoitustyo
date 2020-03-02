package Varausjärjestelmä;

import java.util.ArrayList;

public class Jarjestelma {
    private ArrayList<Sali> salit;
    private ArrayList<Varaus> varaukset;

    public Jarjestelma() {
        salit = new ArrayList<Sali>();
        varaukset = new ArrayList<Varaus>();
    }

    public void teeVaraus(Varaus varaus) {
        Elokuva e = varaus.getElokuva();

        if (varaus.getElokuva().getIkaraja() <= varaus.getAsiakas().getIka()) {
            Sali s = etsiSali(e);
            if (s != null) {
                if (s.getPaikkojenLkm() >= varaus.getVarattavienPaikkojenLkm()) {
                    varaukset.add(varaus);
                    s.varaaPaikka(varaus.getVarattavienPaikkojenLkm()); //ei toimi vielä
                } else {
                    System.out.println("Ei vapaita paikkoja");
                }
            } else {
                System.out.println("Ei elokuvaa missään salissa");
            }
        } else {
            System.out.println("liian nuori ihminen");
        }

    }



    private Sali etsiSali(Elokuva elokuva) {
        for (int i = 0; i < salit.size(); i++) {
            if (salit.get(i).getElokuva().equals(elokuva)) {
                return salit.get(i); //palautetaan ensimmäinen sali, jossa on haluttu elokuva
            }
        }

        return null; //ei salia jossa kyseistä elokuvaa
    }

    public ArrayList<Varaus> naytaVaraukset() {
        return varaukset;
    }

    public ArrayList<Sali> naytaSalit() {
        return salit;
    }

    public void lisaaSali(Sali sali) {
        salit.add(sali);
    }
}
