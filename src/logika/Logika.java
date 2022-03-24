package logika;

import java.util.concurrent.ThreadLocalRandom;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.tools.sjavac.comp.dependencies.PublicApiCollector;

import grafika.Bodovi;
import grafika.Okvir;
import konzolni.Konzola;

//import novi_zad.Okvir;
/**
 * Klasa logika vrši provjere podudaranja, generise nove vrijednosti ako je
 * doslo do ponistavanja i uklanja ponistene vrij ednosti
 */
public class Logika {
	public static int bodovi = 0;

	// static int[][] pocMat = new int[6][6];
	/**
	 * Poèetna inicijalizacija igre. U ranijoj verziji ovo je raðeno unutar okvira
	 */
	public Logika(boolean gr) {
		// TODO Auto-generated constructor stub
		System.out.println("usao u logiku");
		tabla = gr;

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				int randomNum = ThreadLocalRandom.current().nextInt(1, 5 + 1);
				mat[i][j] = randomNum;
			}
		}
		if (gr) {
			Okvir no = new Okvir(mat, bodovi);
			no.prikazi();
		} else {
			Konzola k1 = new Konzola(mat);
		}
	}

	/** Deklarisanje varijabli unutar klase logika */
	static int brojacUnesenih = 0;
	static int prviX;
	static int prviY;
	static int drugiX;
	static int drugiY;
	static boolean tabla;
	// boolean legalnoStanje=false;
	static int[][] mat = new int[6][6];
	static int[][] pomMat = new int[6][6];

	/** Unos kliknutih dugmadi za provjeru validnosti poteza */
	public static void unos(int x, int y) {
		// TODO Auto-generated method stub

		if (brojacUnesenih == 0) {
			prviX = x;
			prviY = y;
			System.out.println("prvi: " + x + y);

		}
		/** Spasavanje koordinata unesenih polja */
		if (brojacUnesenih == 1) {
			drugiX = x;
			drugiY = y;
			System.out.println("drugi: " + x + y);

		}
		brojacUnesenih++;
		/**
		 * Nakon dva unesena provjeravamo validnost i podudaranja. Ako dobijemo
		 * negativan odgovor trazimo ponovni unos
		 */
		if (brojacUnesenih == 2) {
			brojacUnesenih = 0;
			provjeri_podudaranja(prviX, prviY, drugiX, drugiY);
			System.out.println("RESETOVAO BROJAC");
		}
	}

	/** Provjeravammo podudaranja i zamjenu uradi po potrebi*/
	private static void provjeri_podudaranja(int prviX2, int prviY2, int drugiX2, int drugiY2) {
		// TODO Auto-generated method stub
		System.out.println("prvi X: " + prviX2 + " prvi y: " + prviY2 + " boja: " + mat[prviX2][prviY2] + " drugi x: "
				+ drugiX2 + " drugi y: " + drugiY2 + " boja: " + mat[prviX2][prviY2]);
		/**
		 * Provjeravamo da li su dva polja susjedna na osnovu koorrdinata (njihova
		 * razlika mora biti jedan )
		 **/
		if (Math.abs(prviX2 - prviY2) + Math.abs(drugiX2 - drugiY2) == 1
				|| Math.abs(prviX2 - drugiX2) + Math.abs(prviY2 - drugiY2) == 1) {
			pomMat = mat;
			/** Uzimamo koordinate unesenih polja */
			int prvi = mat[prviX2][prviY2];
			int drugi = mat[drugiX2][drugiY2];
			pomMat[prviX2][prviY2] = drugi;
			pomMat[drugiX2][drugiY2] = prvi;
			System.out.println("p " + prvi);

			System.out.println("d " + drugi);
			boolean podudaranje = false;
			/**
			 * Provjeravamo postoji li podudaranje tako što gledamo da li su tri ili vise
			 * susjednih vertikalno ili horizontalno isti
			 */
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {

					if (i == 5 && pomMat[i][j] == pomMat[i - 1][j] && pomMat[i][j] == pomMat[i - 2][j]) {
						System.out.println(
								"Imam podudaranje: " + pomMat[i][j] + " " + pomMat[i - 2][j] + " " + pomMat[i - 1][j]);
						/** Ukoliko jesu dodijeljujemo im nove vrijednosti */
						int tren = pomMat[i][j];
						pomMat[i][j] = ThreadLocalRandom.current().nextInt(1, 5 + 1);
						pomMat[i - 1][j] = ThreadLocalRandom.current().nextInt(1, 5 + 1);
						pomMat[i - 2][j] = ThreadLocalRandom.current().nextInt(1, 5 + 1);
						if (pomMat[i-3][j] == tren && (i-3)>=0)
							pomMat[i-3][j] = ThreadLocalRandom.current().nextInt(1, 5 + 1);
						if (pomMat[i-4][j] == tren && (j-4)>=0)
							pomMat[i-4][j] = ThreadLocalRandom.current().nextInt(1, 5 + 1);
						mat = pomMat;
						ispisimatricu(mat);
						;
						podudaranje = true;
						break;
					}

					else if (j == 5 && pomMat[i][j] == pomMat[i][j - 1] && pomMat[i][j] == pomMat[i][j - 2]) {
						System.out.println(
								"Imam podudaranje: " + pomMat[i][j] + " " + pomMat[i][j - 2] + " " + pomMat[i][j - 1]);
						int tren = pomMat[i][j];
						pomMat[i][j] = ThreadLocalRandom.current().nextInt(1, 5 + 1);
						pomMat[i][j - 1] = ThreadLocalRandom.current().nextInt(1, 5 + 1);
						pomMat[i][j - 2] = ThreadLocalRandom.current().nextInt(1, 5 + 1);
						if (pomMat[i][j-3] == tren && (j-3)>=0)
							pomMat[i][j-3] = ThreadLocalRandom.current().nextInt(1, 5 + 1);
						if (pomMat[i][j-4] == tren && (j-4)>=0)
							pomMat[i][j-4] = ThreadLocalRandom.current().nextInt(1, 5 + 1);
						mat = pomMat;
						ispisimatricu(mat);
						;
						podudaranje = true;
						break;
					}

					else if (i < 5 && i > 0 && pomMat[i][j] == pomMat[i + 1][j] && pomMat[i][j] == pomMat[i - 1][j]) {
						System.out.println(
								"Imam podudaranje: " + pomMat[i][j] + " " + pomMat[i + 1][j] + " " + pomMat[i - 1][j]);
						/** Ukoliko jesu dodijeljujemo im nove vrijednosti */
						int tren = pomMat[i][j];
						pomMat[i][j] = ThreadLocalRandom.current().nextInt(1, 5 + 1);
						pomMat[i + 1][j] = ThreadLocalRandom.current().nextInt(1, 5 + 1);
						pomMat[i - 1][j] = ThreadLocalRandom.current().nextInt(1, 5 + 1);
				    	if((i-2)>=0) {
						if ( pomMat[i-2][j] == tren)
							pomMat[i-2][j] = ThreadLocalRandom.current().nextInt(1, 5 + 1);}
				    	if((i+2)<=5) {

				    	if (pomMat[i+2][j] == tren)
							pomMat[i+2][j] = ThreadLocalRandom.current().nextInt(1, 5 + 1);
				    	}
						
						mat = pomMat;
						ispisimatricu(mat);
						;
						podudaranje = true;
						break;
					} else if (j < 5 && j > 0 && pomMat[i][j] == pomMat[i][j + 1]
							&& pomMat[i][j] == pomMat[i][j - 1]) {
						System.out.println(
								"Imam podudaranje: " + pomMat[i][j] + " " + pomMat[i][j + 1] + " " + pomMat[i][j - 1]);
						int tren = pomMat[i][j];
						pomMat[i][j] = ThreadLocalRandom.current().nextInt(1, 5 + 1);
						pomMat[i][j + 1] = ThreadLocalRandom.current().nextInt(1, 5 + 1);
						pomMat[i][j - 1] = ThreadLocalRandom.current().nextInt(1, 5 + 1);
				    	if((j-2)>=0) {

						if (pomMat[i][j-2] == tren )
							pomMat[i][j-2] = ThreadLocalRandom.current().nextInt(1, 5 + 1);}
				    	if((j+2)<=5) {
						if (pomMat[i][j+2] == tren)
							pomMat[i][j+2] = ThreadLocalRandom.current().nextInt(1, 5 + 1);
				    	}
						mat = pomMat;
						ispisimatricu(mat);
						podudaranje = true;
						break;
					}

				}
			}
			/**
			 * Ukoliko je bilo podudaranje crtamoo novonastali okvir i ponistavamo
			 * podudaranje za ubuduce
			 */
			if (podudaranje) {
				// Konzola k1 = new Konzola(mat);
				// System.out.println("pozov");
				bodovi++;
				if (bodovi == 9) {
					System.exit(0);
				}

				if (tabla) {
					Okvir o1 = new Okvir(mat, bodovi);
					o1.prikazi();
				}
				if (!tabla) {
					Konzola k1 = new Konzola(mat);
					System.out.println("TAblaaaaa111");

				}
				podudaranje = false;
			}

			else {
				pomMat[prviX2][prviY2] = prvi;
				pomMat[drugiX2][drugiY2] = drugi;

				if (!tabla) {
					Konzola k1 = new Konzola(mat);
					System.out.println("TAblaaaaa");
				}

			}
		}
		/**Ukoliko nisu susjedni u konzolu dajemo ispis o nevaljanom potezu*/
		else {
			System.out.println("Nisu dva susjedna: " + (Math.abs(prviX2 - prviY2) + Math.abs(drugiX2 - drugiY2)));

			if (!tabla) {
				Konzola k1 = new Konzola(mat);
				System.out.println("TAblaaaaa222");

			}

		}
	}

	/** ispisivanje matrice */
	public static void ispisimatricu(int[][] mat) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(mat[i][j]);
			}
		}
		System.out.println();
	}

	/**
	 * Na pocetku se koristi samo i sluzi za unos rand vr iz klase okvir u matricu
	 * stanja
	 */
	public static void popuniMatricu(int i, int j, int k) {
		// TODO Auto-generated method stub
		mat[i][j] = k;
	}

}
