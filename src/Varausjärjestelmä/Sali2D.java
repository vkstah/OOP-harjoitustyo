package Varausjärjestelmä;

public class Sali2D extends Sali {
	
	public Sali2D(Elokuva elokuva, int paikkojenLkm, int salinNumero) {
        super(elokuva, paikkojenLkm, salinNumero);
    }
	paikat[][] = {
			{1,1,1,1,1},
			{1,1,1,1,1},
			{1,1,1,1,1},
			{1,1,1,1,1},
			{1,1,1,1,1}};
	}
	public boolean onkoPaikkaVapaa(int rivi, int sarake) {
		if(paikat[rivi][sarake] == 1) {
			return true;
		}
		return false;
	}
	
}
