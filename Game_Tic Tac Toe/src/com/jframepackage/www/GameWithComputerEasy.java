package com.jframepackage.www;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GameWithComputerEasy {
	private JButton button[];
	private boolean check = true;
	private int colorPicker;
	private boolean path1Recogniser = false;
	private boolean path2Recogniser = false;
	private ImageIcon icon[] = { new ImageIcon("src//good.png"),
			new ImageIcon("src//cross.png") };
	private int intelligence = 0;
	public static int draw = 0;

	public GameWithComputerEasy(JButton button[]) {
		this.button = button;
		EventHandler handel = new EventHandler();

		for (int x = 1; x < 9; x++) {
			this.button[x].setEnabled(false);
		}
		for (int y = 0; y < 9; y++) {
			this.button[y].addActionListener(handel);
		}
	}

	private class EventHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (check) {
				for (int x = 1; x < 9; x++) {
					button[x].setEnabled(true);
				}
			}
			check = false;
			for (int x = 8; x >= 0; x--) {

				if (event.getSource() == button[x]) {
					intelligence = x;
					button[x].setIcon(icon[0]);
					button[x].setEnabled(false);
					button[x].setBackground(Color.BLUE);
					Thread thread = new Thread() {
						public void run() {
							try {
								Thread.sleep(1000);
								computerPlayPrevent();
								computerAttact();
								button[colorPicker].setBackground(Color.RED);
							} catch (InterruptedException e) {
								e.getStackTrace();
							}
						}
					};
					thread.start();
					break;
				}
			}

		}
	}

	private void computerAttact() {
		checkResult();
		if (intelligence == 0) {
			button[2].setIcon(icon[1]);
			button[2].setEnabled(false);
			this.colorPicker = 2;

		}
		if (path1Recogniser) {
			if (intelligence == 1) {
				button[7].setIcon(icon[1]);
				button[7].setEnabled(false);
				this.colorPicker = 7;

			}
			if (intelligence == 7) {
				button[1].setIcon(icon[1]);
				button[1].setEnabled(false);
				this.colorPicker = 1;

			}
			if (intelligence == 4) {
				if (button[5].getIcon() == icon[1]
						|| button[5].getIcon() == icon[0]) {
					button[4].setIcon(icon[4]);
					button[4].setEnabled(false);
					this.colorPicker = 4;
					return;
				}
				button[5].setIcon(icon[1]);
				button[5].setEnabled(false);
				this.colorPicker = 5;
			}
			if (intelligence == 5) {
				if (button[1].getIcon() == icon[1]
						|| button[1].getIcon() == icon[0]) {
					button[8].setIcon(icon[1]);
					button[8].setEnabled(false);
					this.colorPicker = 8;
					return;
				}
				button[1].setIcon(icon[1]);
				button[1].setEnabled(false);
				this.colorPicker = 1;
			}
			if (intelligence == 8) {
				if (button[5].getIcon() == icon[1]
						|| button[5].getIcon() == icon[0]) {
					button[4].setIcon(icon[1]);
					button[4].setEnabled(false);
					this.colorPicker = 4;
					return;
				}
				button[5].setIcon(icon[1]);
				button[5].setEnabled(false);
				this.colorPicker = 5;
			}

		}
		if (path2Recogniser) {
			if (intelligence == 3) {
				button[7].setIcon(icon[1]);
				button[7].setEnabled(false);
				this.colorPicker = 7;
			}
			if (intelligence == 7) {
				button[3].setIcon(icon[1]);
				button[3].setEnabled(false);
				this.colorPicker = 3;
			}
			if (intelligence == 5) {
				if (button[1].getIcon() == icon[1]
						|| button[1].getIcon() == icon[0]) {
					button[8].setIcon(icon[1]);
					button[8].setEnabled(false);
					this.colorPicker = 8;
					return;
				}
				button[1].setIcon(icon[1]);
				button[1].setEnabled(false);
				this.colorPicker = 1;
			}

		}
		if (path1Recogniser == false && path2Recogniser == false) {
			if (intelligence == 1) {
				button[7].setIcon(icon[1]);
				button[7].setEnabled(false);
				this.colorPicker = 7;
			}
			if (intelligence == 7) {
				button[1].setIcon(icon[1]);
				button[1].setEnabled(false);
				this.colorPicker = 1;
			}
			if (intelligence == 5) {
				if (button[1].getIcon() == icon[1]
						|| button[1].getIcon() == icon[0]) {
					button[8].setIcon(icon[1]);
					button[8].setEnabled(false);
					this.colorPicker = 8;
					return;
				}
				if (button[8].getIcon() == icon[1]
						|| button[8].getIcon() == icon[0]) {
					button[3].setIcon(icon[1]);
					button[3].setEnabled(false);
					this.colorPicker = 3;
					return;
				}
				button[1].setIcon(icon[1]);
				button[1].setEnabled(false);
				this.colorPicker = 1;
			}
		}
	}

	private void computerPlayPrevent() {
		checkResult();

		if (button[0].getIcon() == icon[0] && button[3].getIcon() == icon[0]) {
			button[6].setIcon(icon[1]);
			button[6].setEnabled(false);
			this.colorPicker = 6;
			path1Recogniser = true;
			path2Recogniser = false;
			return;
		}
		if (button[0].getIcon() == icon[0] && button[6].getIcon() == icon[0]) {
			button[3].setIcon(icon[1]);
			button[3].setEnabled(false);
			this.colorPicker = 3;
			path1Recogniser = true;
			path2Recogniser = false;
			return;
		}

		if (button[0].getIcon() == icon[0] && button[4].getIcon() == icon[0]) {
			button[8].setIcon(icon[1]);
			button[8].setEnabled(false);
			this.colorPicker = 8;
			path2Recogniser = true;
			path1Recogniser = false;
			return;

		}
		if (button[0].getIcon() == icon[0] && button[8].getIcon() == icon[0]) {
			button[4].setIcon(icon[1]);
			button[4].setEnabled(false);
			this.colorPicker = 4;
			path2Recogniser = true;
			path1Recogniser = false;
			return;
		}

	}

	public void checkResult() {
		Result result = new Result(this.icon, this.button);
		result.EasyGameDraw();
		result.getResult();
		result.drawResultForEasyGame();

	}
}
