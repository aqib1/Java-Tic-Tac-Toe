package com.mainclass.Main;
import java.awt.Dimension;

import com.jframepackage.www.MainJFrameClass;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
public class MainClass {
	private static String GAME_TITLE="Tic Tac Toe";
public static void main (String [] args){
	SwingUtilities.invokeLater(new Runnable()
	{
		public void run()
		{
			JFrame frame = new MainJFrameClass(MainClass.GAME_TITLE);
			frame.setSize(new Dimension (500,500));
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
	});
}
}
