package igraj;

import java.util.Scanner;
/**@author Vedad Deliæ*/
import konzolni.Konzola;
import logika.Logika;
/**Poèetak igrice/ pozivanje konzole ili grafike */
public class Main {
	/** Pozivanje igre, sluzi za poziv konstuktora kako bi pokrenuli igru */
	public static void main(String[] args) {

		boolean igraGrafike = true;
		Logika l = new Logika(igraGrafike);
	}

}
