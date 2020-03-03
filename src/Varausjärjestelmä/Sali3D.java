package Varausjärjestelmä;

public class Sali3D  extends Sali{
	paikat[][] = {
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
