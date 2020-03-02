package Testi;

import Varausjärjestelmä.*;

public class Testi {

    public static void main(String[] args){
        Jarjestelma j = new Jarjestelma();
        Elokuva e = new Elokuva("Rambo", 18);
        Sali s = new Sali2D(e, 10, "2asdaf");
        Sali se = new Sali2D(e, 3, "dasf234a");
        j.lisaaSali(s);
        j.lisaaSali(se);
        Asiakas a = new Asiakas("Asiakas", 19);

        j.teeVaraus(new Varaus(a, 3, e));
        j.teeVaraus(new Varaus(a, 3, e));
        j.teeVaraus(new Varaus(a, 3, e));
        j.teeVaraus(new Varaus(a, 3, e));

    }
}
