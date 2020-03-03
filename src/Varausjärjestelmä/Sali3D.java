package Varausjärjestelmä;

public class Sali3D  extends Sali{
	paikkojenLkm = 49;
	public Sali3D(Elokuva elokuva, int paikkojenLkm, int saliId) {
		super(elokuva, saliId);
		this.paikkojenLkm = paikkojenLkm;
	}
	
	paikat = {
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1}};
	
	public boolean onkoPaikkaVapaa(int rivi, int sarake) {
		if(paikat[rivi][sarake] == 1) {
			return true;
		}
		return false;
	}

}
