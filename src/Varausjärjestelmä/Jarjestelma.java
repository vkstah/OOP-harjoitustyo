package Varausjärjestelmä;

import java.util.ArrayList;

public class Jarjestelma {
    private ArrayList<Sali> salit;
    private ArrayList<Varaus> varaukset;

    public Jarjestelma() {
        salit = new ArrayList<Sali>();
        varaukset = new ArrayList<Varaus>();
    }

    public void teeVaraus(Varaus varaus){
        if(varaus.getElokuva().getIkaraja() >= varaus.getAsiakas().getIka()){
            varaukset.add(varaus);
        }else{
            System.out.println("liian nuori ihminen");
        }

    }

    public ArrayList<Varaus> naytaVaraukset(){
        return varaukset;
    }

    public ArrayList<Sali> naytaSalit(){
        return salit;
    }

    public void lisaaSali(Sali sali){
        salit.add(sali);
    }
}
