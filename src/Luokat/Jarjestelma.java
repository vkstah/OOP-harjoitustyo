package Luokat;

import Tietokanta.Tietokanta;

import java.util.ArrayList;

public class Jarjestelma {
    private ArrayList<Sali> salit;
    private Tietokanta tietokanta;
    private ArrayList<Elokuva> ohjelmistossa;

    public Jarjestelma(Tietokanta tietokanta) {
        salit = new ArrayList<Sali>();
        ohjelmistossa = new ArrayList<Elokuva>();
        this.tietokanta = tietokanta;
    }

    public void naytaVaraukset(String asiakkaanNimi) {
        tietokanta.haeTietokannasta(asiakkaanNimi);
    }

    public void poistaVaraus(int varausTunnus, String asiakkaanNimi) {
        int saliNumero = tietokanta.haeSalinumero(varausTunnus);
        int varatutPaikat = tietokanta.haePaikat(varausTunnus);
        tietokanta.poistaTietokannasta(varausTunnus, asiakkaanNimi);

        if (saliNumero == 0) {
            System.out.println("Tiedoillasi ei löytynyt varausta.");
            return;
        }
        for (Sali s : salit) {
            if (s.annaNumero() == saliNumero) {
                vapautaPaikkoja(s, varatutPaikat);
                break;
            }
        }

        System.out.println("Varaus poistettiin onnistuneesti!");

    }

    private Elokuva annaElokuva(Varaus varaus) {
        Elokuva elokuva = null;
        for (Elokuva e : ohjelmistossa) {
            if (e.annaNimi().toLowerCase().equals(varaus.annaElokuva().toLowerCase())) {
                elokuva = e;
            }
        }

        return elokuva;
    }

    private ArrayList<Sali> salitJoissaElokuva(Elokuva elokuva) {
        ArrayList<Sali> palautusSalit = new ArrayList<Sali>();
        for (Sali s : salit) {
            if (elokuva.equals(s.annaElokuva())) {
                palautusSalit.add(s);
            }
        }

        return palautusSalit;
    }

    public void teeVaraus(Varaus varaus) {

        Elokuva elokuva = annaElokuva(varaus);

        if (elokuva == null) {
            System.out.println("Elokuvaa ei ohjelmistossa.");
            System.out.println();
            return;
        }

        if (riittaakoIka(varaus)) { //onko käyttäjä tarpeeksi vanha?
            if (salitJoissaElokuva(elokuva).isEmpty()) {
                System.out.println("Elokuvaa ei missään salissa.");
                System.out.println();
                return;
            }
            for (Sali s : salitJoissaElokuva(elokuva)) { //käydään läpi saleja
                if (s.annaVapaidenPaikkojenLkm() >= varaus.annaVarattavienPaikkojenLkm()) { //onko salissa tarpeeksi paikkoja
                    tietokanta.laitaTietokantaan(varaus.annaAsiakas().annaNimi(), varaus.annaVarattavienPaikkojenLkm(), s.annaNumero(), elokuva.annaNimi());
                    varaaPaikkoja(s, varaus.annaVarattavienPaikkojenLkm());
                    System.out.println("Varaus onnistui saliin " + s.annaNumero());
                    System.out.println("Voit näyttää varauksesi nimelläsi!");
                    System.out.println();
                    return;
                } else {
                    System.out.println("Ei vapaita paikkoja salissa, etsitään toisesta salista");
                    //ei vapaita paikkoja salissa, etsitään elokuvaa muista saleista
                }
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


    public void tulostaElokuvat() {
        for (Sali s : salit) {
            System.out.println("ELOKUVAN NIMI: " + s.annaElokuva().annaNimi() + "\n" +
                    "IKÄRAJA: " + s.annaElokuva().annaIkaraja());
            System.out.println();
        }
    }

    public void lisaaSali(Sali sali) {
        boolean onkoSali = false;
        if (tietokanta.annaSali(sali.annaNumero()) == sali.annaNumero()) {
            //System.out.println("Sali kyseisellä numerolla on jo olemassa!");
            onkoSali = true;
        }

        if (!onkoSali) {
            salit.add(sali);
            tietokanta.lisaaSali(sali.annaNumero(), sali.annaVapaidenPaikkojenLkm(), sali.annaElokuva().annaNimi());
            if (!ohjelmistossa.contains(sali.annaElokuva())) {
                ohjelmistossa.add(sali.annaElokuva());
            }
        }
    }

    private void varaaPaikkoja(Sali sali, int maara) {
        sali.varaaPaikka(maara);
        tietokanta.lisaaPaikkoja(sali.annaNumero(), -maara);
    }

    private void vapautaPaikkoja(Sali sali, int maara) {
        sali.vapautaPaikka(maara);
        tietokanta.lisaaPaikkoja(sali.annaNumero(), maara);
    }
}
