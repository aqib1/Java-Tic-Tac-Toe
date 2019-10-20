package com.jframepackage.www;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GameWithComputerHard {
	private JButton button[];
	private boolean firstComputerIntelligence = true;
	private boolean computerRespondMessageForWait = true;
	public static int draw = 0;
	private ImageIcon icon[] = { new ImageIcon("src//good.png"),
			new ImageIcon("src//cross.png") };

	public GameWithComputerHard(JButton button1[]) {
		this.button = button1;
		performingAction();
		try {
			gameStart();
		} catch (Exception e) {
		}
	}

	public void performingAction() {
		for (int y = 0; y < 9; y++) {
			if (y != 4) {
				this.button[y].setEnabled(false);
			}
		}
		EventHandler handle = new EventHandler();
		for (int x = 0; x < 9; x++) {
			this.button[x].addActionListener(handle);
		}
	}

	public void openPlayButton() {
		if (this.firstComputerIntelligence) {
			for (int x = 0; x < 9; x++) {
				if (x == 4) {
					this.button[x].setEnabled(false);
					this.button[x].setIcon(this.icon[1]);
					this.button[x].setBackground(Color.RED);
				}
				if (x != 4) {
					this.button[x].setEnabled(true);
				}
			}
			this.firstComputerIntelligence = false;
		}
		this.computerRespondMessageForWait = false;
	}

	public void play(int x) {
		this.button[x].setIcon(icon[0]);
		this.button[x].setEnabled(false);
		this.button[x].setBackground(Color.YELLOW);

	}

	public void gameStart() throws InterruptedException {
		Thread.sleep(500);
		openPlayButton();
	}

	public void counterAttact(int x) {
		int intelligence = 0;
		if (x == 0) {
			intelligence = 3;
		}
		if (x == 3) {
			intelligence = 0;
		}
		if (x == 1) {
			intelligence = 2;
		}
		if (x == 2) {
			intelligence = 1;
		}
		if (x == 6) {
			intelligence = 7;
		}
		if (x == 7) {
			intelligence = 6;
		}
		if (x == 5) {
			intelligence = 8;
		}
		if (x == 8) {
			intelligence = 5;
		}
		if (this.button[x].getIcon() == icon[0]) {
			this.button[intelligence].setIcon(icon[1]);
			this.button[intelligence].setEnabled(false);
			this.button[intelligence].setBackground(Color.RED);
			return;
		}

	}

	public void checkResult() {
		Result result = new Result(this.icon, this.button);
		result.HardGameDraw();
		result.getResult();
		result.drawResultForHardGame();

	}

	private class EventHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			for (int x = 0; x < 9; x++) {
				if (event.getSource() == button[x]) {
					final int saver = x;
					Thread thread = new Thread() {
						public void run() {
							try {
								if (computerRespondMessageForWait) {

								}
								if (saver != 4) {
									play(saver);
									Thread.sleep(1000);
									counterAttact(saver);
									checkResult();
								}
							} catch (InterruptedException e) {
								e.getStackTrace();
							}
						}

					};
					thread.start();

				}
			}
		}
	}
}
