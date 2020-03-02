package Testi;

import Varausjärjestelmä.*;

public class Testi {

    public static void main(String[] args){
        Jarjestelma j = new Jarjestelma();
        Elokuva e = new Elokuva("Rambo", 18);
        Sali s = new Sali2D(e, 10);
        Asiakas a = new Asiakas("Asiakas", 19);

    }
}
