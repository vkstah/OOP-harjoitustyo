package Testi;

import Tietokanta.Tietokanta;
import Varausjärjestelmä.Asiakas;
import Varausjärjestelmä.Elokuva;
import Varausjärjestelmä.Jarjestelma;
import Varausjärjestelmä.Varaus;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Kayttoliittyma {
    private Scanner lukija;
    private Jarjestelma jarjestelma;

    public Kayttoliittyma(Scanner lukija, Jarjestelma jarjestelma) {
        this.lukija = lukija;
        this.jarjestelma = jarjestelma;
    }

    public void valikko() {
        int valinta;
        String syote;
        System.out.println("Tervetuloa elokuva lippujen varausjärjestelmään!");
        while(true) {
            System.out.println("Mitä haluat tehdä?");
            System.out.println("1. Näytä varaukseni");
            System.out.println("2. Tee varaus");
            System.out.println("3. Muuta varausta");
            System.out.println("4. Näytä ohjelmistossa olevat elokuvat");
            System.out.println("5. Poistu");

            try {
                valinta = Integer.parseInt(lukija.nextLine());
                switch (valinta) {
                    case 1:
                        System.out.println("Syötä nimesi:");
                        syote = lukija.nextLine();
                        jarjestelma.naytaVaraukset(syote.toLowerCase());
                        break;
                    case 2:
                        System.out.println("Syötä nimesi: ");
                        syote = lukija.nextLine();
                        System.out.println("Syötä ikäsi: ");
                        valinta = Integer.parseInt(lukija.nextLine());
                        Asiakas asiakas = new Asiakas(syote.toLowerCase(), valinta);
                        System.out.println("Syötä elokuvan nimi: ");
                        syote = lukija.nextLine();
                        System.out.println("Syötä varattavien paikkojen lukumäärä: ");
                        valinta = Integer.parseInt(lukija.nextLine());
                        Varaus varaus = new Varaus(asiakas, valinta, syote.toLowerCase());
                        jarjestelma.teeVaraus(varaus);
                        break;
                    case 3:

                        break;
                    case 4:
                        jarjestelma.tulostaElokuvat();
                        break;
                    case 5:
                        return;
                    default:
                        break;
                }
            }catch (Exception e){
                System.out.println("Virhe! Yritä uudelleen!");
            }


        }
    }
}