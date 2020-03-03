package Varausjärjestelmä;

import Tietokanta.Tietokanta;

import java.util.ArrayList;

public class Jarjestelma {
    private ArrayList<Sali> salit;
    private Tietokanta varaukset;
    private ArrayList<Elokuva> ohjelmistossa;

    public Jarjestelma(Tietokanta varaukset) {
        salit = new ArrayList<Sali>();
        ohjelmistossa = new ArrayList<Elokuva>();
        this.varaukset = varaukset;
    }

    public void naytaVaraukset(String asiakkaanNimi) {
        varaukset.haeTietokannasta(asiakkaanNimi);
    }

    public void poistaVaraus(int varausTunnus, String asiakkaanNimi){
        varaukset.poistaTietokannasta(varausTunnus, asiakkaanNimi);
        for (Sali s: salit) {
            if(s.annaNumero() == varaukset.haeSalinumero(varausTunnus)){
                vapautaPaikkoja(s, varaukset.haePaikat(varausTunnus));
                break;
            }
        }

        System.out.println("Varaus poistettiin onnistuneesti!");

    }


    public void teeVaraus(Varaus varaus) {
        Elokuva elokuva = null;
        for (Elokuva e : ohjelmistossa) {
            if (e.annaNimi().toLowerCase().equals(varaus.annaElokuva().toLowerCase())) {
                elokuva = e;
            }
        }

        if (elokuva == null) {
            System.out.println("Elokuvaa ei ohjelmistossa");
            return;
        }

        if (riittaakoIka(varaus)) { //onko käyttäjä tarpeeksi vanha?
            for (Sali s : salit) { //käydään läpi saleja
                if (elokuva.equals(s.annaElokuva())) { //tarkastetaan onko salissa haluttu elokuva
                    if (s.annaVapaidenPaikkojenLkm() >= varaus.annaVarattavienPaikkojenLkm()) { //onko salissa tarpeeksi paikkoja
                        varaukset.laitaTietokantaan(varaus.annaAsiakas().annaNimi(), varaus.annaVarattavienPaikkojenLkm(), s.annaNumero(), elokuva.annaNimi());
                        varaaPaikkoja(s, varaus.annaVarattavienPaikkojenLkm());
                        System.out.println("Varaus onnistui saliin " + s.annaNumero());
                        System.out.println("Voit näyttää varauksesi nimelläsi!");
                        System.out.println();
                        return;
                    } else {
                        System.out.println("Ei vapaita paikkoja salissa, etsitään toisesta salista");
                        //ei vapaita paikkoja salissa, etsitään elokuvaa muista saleista
                    }
                } /*else {
                    System.out.println("Ei vapaita paikkoja");
                }*/
            }
        } else {
            System.out.println("Et ole tarpeeksi vanha");
        }
        System.out.println("Varaus epäonnistui");

    }

    private boolean riittaakoIka(Varaus varaus) {
        Elokuva elokuva = null;
        for (Elokuva e : ohjelmistossa) {
            if (e.annaNimi().toLowerCase().equals(varaus.annaElokuva().toLowerCase())) {
                elokuva = e;
            }
        }
        if (elokuva == null) {
            return false;
        }
        if (elokuva.annaIkaraja() <= varaus.annaAsiakas().annaIka()) {
            return true;
        }
        return false;
    }


    public ArrayList<Sali> naytaSalit() {
        return salit;
    }

    public void tulostaElokuvat() {
        for (Sali s : salit) {
            System.out.println("ELOKUVAN NIMI: " + s.annaElokuva().annaNimi() + "\n" +
                    "IKÄRAJA: " + s.annaElokuva().annaIkaraja());
            System.out.println();
        }
    }

    public void lisaaSali(Sali sali) {
        boolean onkoSali = false;
        for (Sali s : salit) {
            if (s.annaNumero() == sali.annaNumero()) {
                System.out.println("sali kyseisellä numerolla on jo olemassa");
                onkoSali = true;
            }
        }
        if (!onkoSali) {
            salit.add(sali);
            if (!ohjelmistossa.contains(sali.annaElokuva())) {
                ohjelmistossa.add(sali.annaElokuva());
            }
        }
    }

    private void varaaPaikkoja(Sali sali, int maara){
        sali.varaaPaikka(maara);
    }
    private void vapautaPaikkoja(Sali sali, int maara){
        sali.vapautaPaikka(maara);
    }
}
