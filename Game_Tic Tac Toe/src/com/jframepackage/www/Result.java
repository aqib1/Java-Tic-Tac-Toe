package com.jframepackage.www;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Result {
	private JButton button[];
	private ImageIcon icon[] = { new ImageIcon("src//good.png"),
			new ImageIcon("src//cross.png") };
	private String status[] = { "You Win!", "Game Draw", "Computer Win!" };

	public Result(ImageIcon icon[], JButton button[]) {
		this.button = button;
		this.icon = icon;
	}

	public void HardGameDraw() {
		++GameWithComputerHard.draw;
	}

	public void EasyGameDraw() {
		++GameWithComputerEasy.draw;
	}

	public void getResult() {
		if (button[0].getIcon() == icon[0] && button[1].getIcon() == icon[0]
				&& button[2].getIcon() == icon[0]
				|| button[3].getIcon() == icon[0]
				&& button[4].getIcon() == icon[0]
				&& button[5].getIcon() == icon[0]
				|| button[6].getIcon() == icon[0]
				&& button[7].getIcon() == icon[0]
				&& button[8].getIcon() == icon[0]
				|| button[0].getIcon() == icon[0]
				&& button[4].getIcon() == icon[0]
				&& button[8].getIcon() == icon[0]
				|| button[2].getIcon() == icon[0]
				&& button[4].getIcon() == icon[0]
				&& button[6].getIcon() == icon[0]
				|| button[0].getIcon() == icon[0]
				&& button[3].getIcon() == icon[0]
				&& button[6].getIcon() == icon[0]
				|| button[1].getIcon() == icon[0]
				&& button[4].getIcon() == icon[0]
				&& button[7].getIcon() == icon[0]
				|| button[2].getIcon() == icon[0]
				&& button[5].getIcon() == icon[0]
				&& button[8].getIcon() == icon[0]) {
			JOptionPane.showMessageDialog(null, status[0], "ALERTS",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		if (button[0].getIcon() == icon[1] && button[1].getIcon() == icon[1]
				&& button[2].getIcon() == icon[1]
				|| button[3].getIcon() == icon[1]
				&& button[4].getIcon() == icon[1]
				&& button[5].getIcon() == icon[1]
				|| button[6].getIcon() == icon[1]
				&& button[7].getIcon() == icon[1]
				&& button[8].getIcon() == icon[1]
				|| button[0].getIcon() == icon[1]
				&& button[4].getIcon() == icon[1]
				&& button[8].getIcon() == icon[1]
				|| button[2].getIcon() == icon[1]
				&& button[4].getIcon() == icon[1]
				&& button[6].getIcon() == icon[1]
				|| button[0].getIcon() == icon[1]
				&& button[3].getIcon() == icon[1]
				&& button[6].getIcon() == icon[1]
				|| button[1].getIcon() == icon[1]
				&& button[4].getIcon() == icon[1]
				&& button[7].getIcon() == icon[1]
				|| button[2].getIcon() == icon[1]
				&& button[5].getIcon() == icon[1]
				&& button[8].getIcon() == icon[1]) {
			JOptionPane.showMessageDialog(null, status[2], "ALERTS",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}

	}

	public void drawResultForHardGame() {
		if (GameWithComputerHard.draw == 4) {
			JOptionPane.showMessageDialog(null, status[1], "ALERTS",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}

	public void drawResultForEasyGame() {
		if (GameWithComputerEasy.draw >= 10) {
			JOptionPane.showMessageDialog(null, status[1], "ALERTS",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}
}
