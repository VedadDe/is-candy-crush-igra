package grafika;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import logika.Logika;

/** Glavni panel koji sadrzi dugmad za igru. */
public class PanelDugmadi extends JPanel {

	/** Deklarisanje varijabli */
	int n;
	static JButton dugme = new JButton();
	static Color boja1 = Color.green;
	static Color boja2 = Color.red;
	static Color boja3 = Color.blue;
	static Color boja4 = Color.yellow;
	static Color boja5 = Color.ORANGE;
	static Color selektovan = Color.WHITE;
	static int[][] mat = new int[6][6];
	static boolean update = false;

	/**
	 * Javni konstruktor klase okvir koji kao paramentar prima matricu prethodnog
	 * stanja, odnosno stanje koje je potrebno iscrtati
	 */
	public PanelDugmadi(int[][] mat1) {
		// TODO Auto-generated method stub

		mat = mat1;
		setLayout(new GridLayout(mat.length, mat.length));
		/**Popunjavanje sa bojama*/
		System.out.println("pozivam pravi");
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {

				dugme = new JButton();
				Dimension dim = new Dimension(50, 50);
				dugme.setSize(dim);

				if (mat[i][j] == 1) {
					dugme.setBackground(boja1);
				} else if (mat[i][j] == 2) {
					dugme.setBackground(boja2);

				} else if (mat[i][j] == 3) {
					dugme.setBackground(boja3);

				} else if (mat[i][j] == 4) {
					dugme.setBackground(boja4);

				} else {
					dugme.setBackground(boja5);

				}
				final int x;
				final int y;
				x = i;
				y = j;
				/**Postavljanje action lisenera za klikove*/
				dugme.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						// TODO Auto-generated method stub
						Logika.unos(x, y);

					}
				});

				add(dugme);

			}
		}

	}

}
