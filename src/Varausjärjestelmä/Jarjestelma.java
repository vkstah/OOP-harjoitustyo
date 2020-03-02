package Varausjärjestelmä;

import java.util.ArrayList;

public class Jarjestelma {
    private ArrayList<Sali> salit;
    private ArrayList<Varaus> varaukset;

    public Jarjestelma() {
        salit = new ArrayList<Sali>();
        varaukset = new ArrayList<Varaus>();
    }


    public void muokkaaVarausta(Asiakas asiakas){
        //toteutus
    }

    public void teeVaraus(Varaus varaus) {
        Elokuva e = varaus.annaElokuva();

        if (riittaakoIka(varaus)) { //onko käyttäjä tarpeeksi vanha?
            for (Sali s : salit) { //käydään läpi saleja
                if (e.equals(s.annaElokuva())) { //tarkastetaan onko salissa haluttu elokuva
                    if (s.annaVapaidenPaikkojenLkm() >= varaus.annaVarattavienPaikkojenLkm()) { //onko salissa tarpeeksi paikkoja
                        varaukset.add(varaus);
                        s.varaaPaikka(varaus.annaVarattavienPaikkojenLkm());
                        System.out.println("Varaus onnistui saliin " + s.annaNumero());
                        return;
                    } else {
                        System.out.println("Ei vapaita paikkoja salissa, etsitään toisesta salista");
                        //ei vapaita paikkoja salissa, etsitään elokuvaa muista saleista
                    }
                }else {
                    System.out.println("Elokuvaa ei missään salissa");
                }
            }
        } else {
            System.out.println("Et ole tarpeeksi vanha");
        }
        System.out.println("Varaus epäonnistui");

    }

    private boolean riittaakoIka(Varaus varaus){
        if(varaus.annaElokuva().annaIkaraja() <= varaus.annaAsiakas().annaIka()){
            return true;
        }
        return false;
    }


    public void naytaVaraukset() {
        for (Varaus v: varaukset) {
            System.out.println(v.annaAsiakas().annaNimi() + " on varannut " + v.annaVarattavienPaikkojenLkm() + " paikkaa, elokuvaan " + v.annaElokuva().annaNimi() + ".");
        }
    }

    public ArrayList<Sali> naytaSalit() {
        return salit;
    }

    public void lisaaSali(Sali sali) {
        boolean onkoSali = false;
        for (Sali s: salit) {
            if(s.annaNumero() == sali.annaNumero()){
                System.out.println("sali kyseisellä numerolla on jo olemassa");
                onkoSali = true;
            }
        }
        if(!onkoSali){
            salit.add(sali);
        }
    }
}
