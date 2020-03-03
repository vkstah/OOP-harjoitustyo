package Varausjärjestelmä;

public class Sali3D  extends Sali{

	public Sali3D(Elokuva elokuva, int saliId) {
		super(elokuva, saliId);
		this.paikkojenLkm = 49;
		paikat = new int[][]{{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1}};
	}
	

	
	public boolean onkoPaikkaVapaa(int rivi, int sarake) {
		if(paikat[rivi][sarake] == 1) {
			return true;
		}
		return false;
	}

}
