package grafika;

import javax.swing.JLabel;
/**Klasa pomo�u koje pamtimo broj bodova, tj poteza koji su ostali*/
public class Bodovi extends JLabel {
	/**
	 * Labela koja sluzi za ispis bodova i adekvatne poruke na osnovu bodova. Bodovi
	 * se proslije�uju kao parametar
	 */
	public Bodovi(int n) {
		if (n == 7) {
			this.setText(String.valueOf(n) + " Jo� jedan potez preostao");
		}
		if (n == 8) {
			this.setText(" Kraj igre");
		} else {

			this.setText(String.valueOf(n));
			this.setSize(420, 10);
		}
	}
}
