package Testi;

import Varausjärjestelmä.*;

public class Testi {

    public static void main(String[] args){
        Jarjestelma j = new Jarjestelma();
        Elokuva e = new Elokuva("Rambo", 18);
        Sali s = new Sali2D(e, 10, 3);
        Sali se = new Sali2D(e, 12, 2);
        j.lisaaSali(s);
        j.lisaaSali(se);
        Asiakas a = new Asiakas("Asiakas", 19);
        Asiakas b = new Asiakas("Homo", 20);

        j.teeVaraus(new Varaus(a, 3, e));
        j.teeVaraus(new Varaus(a, 2, e));
        j.teeVaraus(new Varaus(a, 5, e));
        j.teeVaraus(new Varaus(b, 3, e));

        j.naytaVaraukset("Asiakas");
        j.naytaVaraukset("Homo");


    }
}
