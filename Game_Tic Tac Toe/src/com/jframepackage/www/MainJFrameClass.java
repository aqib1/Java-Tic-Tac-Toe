package com.jframepackage.www;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainJFrameClass extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton button[] = new JButton[9];
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu[] = { new JMenu("New"), new JMenu("Format"),
			new JMenu("Exit") };
	private String title;
	private static final JMenuItem menuItem[][] = {
			{ new JMenuItem("Easy Play"), new JMenuItem("With Player"),
					new JMenuItem("Hard Play") },
			{ new JMenuItem("Tic For Player1"),
					new JMenuItem("Tic For Player2"), new JMenuItem("Use O") },
			{ new JMenuItem("Exit"), new JMenuItem("Help"),
					new JMenuItem("About") } };

	public MainJFrameClass(String title) {
		this.title = title;
		addMenuBar();
		addButton();
        new Game(this.button,menuItem);
	}

	public void addMenuBar() {
		for (int x = 0; x < 3; x++) {
			menuBar.add(menu[x]);
		}

		for (int y = 0; y < 3; y++) {
			for (int z = 0; z < 3; z++) {
				menu[y].add(menuItem[y][z]);
			}
		}
		super.setJMenuBar(menuBar);
	}

	public void addButton() {
		super.setTitle(title);
		super.setLayout(new GridLayout(3, 3));
		for (int x = 0; x < 9; x++) {
			button[x] = new JButton();
			super.add(button[x]);
		}
	}
}
