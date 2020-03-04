package Varausjärjestelmä;

import Tietokanta.Tietokanta;
import Luokat.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner lukija = new Scanner(System.in);
        Tietokanta t = new Tietokanta();
        Jarjestelma j = new Jarjestelma(t);

        Elokuva e = new Elokuva("Rambo 1", 18);
        Elokuva ea = new Elokuva("Rambo 2", 15);

        Sali s = new Sali2D(e, 10, 3);
        Sali se = new Sali3D(ea, 4, 5);

        j.lisaaSali(s);
        j.lisaaSali(se);

        Kayttoliittyma k = new Kayttoliittyma(lukija, j);
        k.valikko();
    }
}
