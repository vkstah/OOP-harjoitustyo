package Luokat;

import Tietokanta.Tietokanta;

import java.util.ArrayList;

public class Jarjestelma {
    //private ArrayList<Sali> salit;
    private Tietokanta tietokanta;
    private ArrayList<Elokuva> ohjelmistossa;

    public Jarjestelma(Tietokanta tietokanta) {
        //salit = new ArrayList<Sali>();
        ohjelmistossa = new ArrayList<Elokuva>();
        this.tietokanta = tietokanta;
    }

    public void naytaVaraukset(String asiakkaanNimi) {
        tietokanta.haeVaraukset(asiakkaanNimi);
    }

    public void poistaVaraus(int varausTunnus, String asiakkaanNimi) {
        int saliNumero = tietokanta.haeSalinumero(varausTunnus);
        int varatutPaikat = tietokanta.haePaikat(varausTunnus);


        if(!tietokanta.onkoVarausta(varausTunnus, asiakkaanNimi)){
            System.out.println("Tiedoillasi ei löytynyt varausta.");
            System.out.println();
            return;
        }

        if (saliNumero == 0) {
            System.out.println("Tiedoillasi ei löytynyt varausta.");
            System.out.println();
            return;
        }
        tietokanta.poistaVaraus(varausTunnus, asiakkaanNimi);
        vapautaPaikkoja(saliNumero, varatutPaikat); //vapautaPaikkoja(saliNumero, varatutPaikat);


        System.out.println("Varaus poistettiin onnistuneesti!");
        System.out.println();

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

    public void laitaElokuvaSaliin(Sali sali, Elokuva elokuva){
        tietokanta.asetaElokuva(sali.annaNumero(), elokuva.annaNimi());
    }



    public void teeVaraus(Varaus varaus) {

        Elokuva elokuva = annaElokuva(varaus);

        if (elokuva == null) {
            System.out.println("Elokuvaa ei ohjelmistossa.");
            System.out.println();
            return;
        }

        if (riittaakoIka(varaus)) { //onko käyttäjä tarpeeksi vanha?
            if (tietokanta.annaSalitJoissaElokuva(elokuva.annaNimi()).isEmpty()) {
                System.out.println("Elokuvaa ei missään salissa.");
                System.out.println();
                return;
            }
            for (int i : tietokanta.annaSalitJoissaElokuva(elokuva.annaNimi())) { //käydään läpi saleja
                if (tietokanta.annaVapaatPaikat(i) >= varaus.annaVarattavienPaikkojenLkm()) { //onko salissa tarpeeksi paikkoja
                    tietokanta.teeVaraus(varaus.annaAsiakas().annaNimi(), varaus.annaVarattavienPaikkojenLkm(), i, elokuva.annaNimi());
                    varaaPaikkoja(i, varaus.annaVarattavienPaikkojenLkm());
                    System.out.println("Varaus onnistui saliin " + i);
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
        System.out.println();
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
        for (String s: tietokanta.annaKaikkiElokuvat()) {
            for (Elokuva e: ohjelmistossa) {
                if(e.annaNimi().equals(s)){
                    System.out.println("ELOKUVAN NIMI: " + s + "\n" +
                            "IKÄRAJA: " + e.annaIkaraja());
                    System.out.println();
                }
            }
        }
/*        for (Sali s : salit) {
            System.out.println("ELOKUVAN NIMI: " + s.annaElokuva().annaNimi() + "\n" +
                    "IKÄRAJA: " + s.annaElokuva().annaIkaraja());
            System.out.println();
        }*/
    }

    public void lisaaSali(Sali sali) {
        boolean onkoSali = false;
        boolean onkoElokuva = false;
        int saliNumero = tietokanta.annaSali(sali.annaNumero());
        if (saliNumero == sali.annaNumero()) {
            //System.out.println("Sali kyseisellä numerolla on jo olemassa!");
            onkoSali = true;
        }

        for (int i = 0; i < ohjelmistossa.size(); i++) {
            if(ohjelmistossa.get(i).annaNimi().equals(tietokanta.annaElokuva(saliNumero))){
                onkoElokuva = true;
            }
        }
        if (!onkoElokuva) {
            ohjelmistossa.add(sali.annaElokuva());
        }
        if (!onkoSali) {
            tietokanta.lisaaSali(sali.annaNumero(), sali.annaVapaidenPaikkojenLkm(), sali.annaElokuva().annaNimi());
        }
    }

    private void varaaPaikkoja(int sali, int maara) {

        tietokanta.lisaaPaikkoja(sali, -maara);
    }

    private void vapautaPaikkoja(int sali, int maara) {
        tietokanta.lisaaPaikkoja(sali, maara);
    }
}
