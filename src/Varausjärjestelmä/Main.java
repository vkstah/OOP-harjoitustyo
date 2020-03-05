package Varausjärjestelmä;

import Tietokanta.Tietokanta;
import Luokat.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner lukija = new Scanner(System.in);
        Tietokanta t = new Tietokanta();
        Jarjestelma j = new Jarjestelma(t);

        Elokuva rambo = new Elokuva("Rambo 1", 18);
        Elokuva rambo2 = new Elokuva("Rambo 2", 15);
        Elokuva jb = new Elokuva("James Bond", 12);

        Sali sali1 = new Sali2D(rambo, 100, 20);
        Sali sali2 = new Sali3D(rambo, 40, 30);
        Sali sali3 = new Sali2D(jb, 15, 21);


        j.lisaaSali(sali1);
        j.lisaaSali(sali2);
        j.lisaaSali(sali3);

        Kayttoliittyma k = new Kayttoliittyma(lukija, j);
        k.valikko();
    }
}
