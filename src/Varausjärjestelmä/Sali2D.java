package Varausjärjestelmä;

public class Sali2D extends Sali {
	paikkojenLkm = 25;
	public Sali2D(Elokuva elokuva, int paikkojenLkm, int salinNumero) {
        super(elokuva, salinNumero);
        this.paikkojenLkm = paikkojenLkm;
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
