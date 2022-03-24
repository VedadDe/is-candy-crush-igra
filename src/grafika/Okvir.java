package grafika;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import logika.Logika;

/** Klasa okvir koja naslje�uje JFrame */


public class Okvir extends JFrame {

	/**
	 * Konstruktor kalse, dodaje Panel za igu i labelu za bodove. Tako�er ukoliko
	 * zatvorimo okvir sve se gasi. Postavljamo veli�inu prozora i ure�ujemo izgled
	 * okvira
	 */
	public Okvir(int[][] mat1, int n) {

		PanelDugmadi p = new PanelDugmadi(mat1);
		Bodovi b = new Bodovi(n);
		this.add(p);
		this.setTitle("Projekat Candy Crush Vedad Deli�");
		this.add(b, BorderLayout.AFTER_LAST_LINE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void prikazi() {
		setVisible(true);

	}

}
