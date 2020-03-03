package Varausjärjestelmä;

public class Sali2D extends Sali {
	paikat[][] = {
			{1,1,1,1,1},
			{1,1,1,1,1},
			{1,1,1,1,1},
			{1,1,1,1,1},
			{1,1,1,1,1}};
	
	public Sali2D(Elokuva elokuva, int paikkojenLkm, int salinNumero) {
        super(elokuva, paikkojenLkm, salinNumero);
    }
	
	
	
	public boolean onkoPaikkaVapaa(int rivi, int sarake) {
		if(paikat[rivi][sarake] == 1) {
			return true;
		}
		return false;
	}
	public Sali2d() {
		
	}

}
