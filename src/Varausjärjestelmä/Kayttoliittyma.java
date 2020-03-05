package Varausjärjestelmä;

import Luokat.Asiakas;
import Luokat.Jarjestelma;
import Luokat.Varaus;

import java.util.Scanner;

class Kayttoliittyma {
    private Scanner lukija;
    private Jarjestelma jarjestelma;

    public Kayttoliittyma(Scanner lukija, Jarjestelma jarjestelma) {
        this.lukija = lukija;
        this.jarjestelma = jarjestelma;
    }
    private void paaValikko(){
        System.out.println("Mitä haluat tehdä?");
        System.out.println("1. Näytä varaukseni");
        System.out.println("2. Tee varaus");
        System.out.println("3. Poista varaus");
        System.out.println("4. Näytä ohjelmistossa olevat elokuvat");
        System.out.println("5. Poistu");
    }


    public void valikko() {
        int valinta;
        String syote;
        System.out.println("Tervetuloa elokuva lippujen varausjärjestelmään!");
        while (true) {
            paaValikko();

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
                        System.out.println("Syötä nimesi: ");
                        String nimi = lukija.nextLine();
                        System.out.println("Syötä varaustunnuksesi: ");
                        int varausTunnus = Integer.parseInt(lukija.nextLine());
                        jarjestelma.poistaVaraus(varausTunnus, nimi.toLowerCase());
                        break;
                    case 4:
                        jarjestelma.tulostaElokuvat();
                        break;
                    case 5:
                        return;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Virhe! Yritä uudelleen!");
                System.out.println();
            }


        }
    }
}
