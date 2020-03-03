package Varausjärjestelmä;

public class Sali2D extends Sali {




	public Sali2D(Elokuva elokuva, int saliId) {
        super(elokuva, saliId);
        this.paikkojenLkm = 25;
		paikat = new int[][] {{1,1,1,1,1},
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
