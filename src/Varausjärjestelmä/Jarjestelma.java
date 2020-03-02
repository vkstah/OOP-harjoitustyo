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
            for (Sali s : salit) {
                if (s != null) {
                    if (s.getPaikkojenLkm() >= varaus.getVarattavienPaikkojenLkm()) {
                        varaukset.add(varaus);
                        s.varaaPaikka(varaus.getVarattavienPaikkojenLkm());
                        System.out.println("Varaus onnistui");
                        break;
                    } else {
                        System.out.println("Ei vapaita paikkoja");
                    }
                } else {
                    System.out.println("Ei elokuvaa missään salissa");
                }
            }
        } else {
            System.out.println("liian nuori ihminen");
        }

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
