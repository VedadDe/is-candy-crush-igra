package konzolni;

import logika.Logika;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
/** Klasa koja omoguæuje igru u konzoli*/
public class Konzola {

	// import z_1_2parcijalni.DugmeBoja;
	/** Klasa okvir koja nasljeðuje JFrame */

	/** Deklarisanje varijabli koje se koriste u klasi odvir */
	int n;
//		static Color boja = new color[];

	static int[][] mat = new int[6][6];
	static boolean update = false;
//		private static Component add;

	/**
	 * Fja koja prima velièinu table za igru i generise random vrijednosti odnosno
	 * random boje koje cemo smjestiti u tablu za igru a potom i u matricu stanja
	 * kako bi mogli vršiti manipulaciju njima. UPDATE: U novoj verziji premjesteno
	 * u logiku.
	 */
	/**
	 * Javni konstruktor klase okvir koji kao paramentar prima matricu prethodnog
	 * stanja, odnosno stanje koje je potrebno iscrtati
	 */

	public Konzola(int[][] mat2) {
		// TODO Auto-generated constructor stub
		mat = mat2;

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				int boja;
				/** Dodavanje dugmadi */

				if (mat[i][j] == 1) {

					boja = 1;
				} else if (mat[i][j] == 2) {
					boja = 2;

				} else if (mat[i][j] == 3) {
					boja = 3;

				} else if (mat[i][j] == 4) {
					boja = 4;

				} else {
					boja = 5;

				}
				System.out.print(boja + " ");

			}
			System.out.printf("%n");
		}
		int x1;
		int y1;
		int x2;
		int y2;
		Scanner unos = new Scanner(System.in);
		System.out.println("Unesite koordinate polja za izmjenu: ");
		x1 = unos.nextInt();
		y1 = unos.nextInt();
		x2 = unos.nextInt();
		y2 = unos.nextInt();
		Logika.unos(x1, y1);
		Logika.unos(x2, y2);
	}

}
