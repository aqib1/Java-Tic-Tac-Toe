package com.jframepackage.www;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenuItem;

public class Game {
	private JButton button1[];
	private JMenuItem menuItem[][];
public Game(final JButton button[], final JMenuItem menuItem[][])
{
	this.menuItem=menuItem;
	this.button1=button;
	EventHandler handel= new EventHandler();
	for(int x=0;x<3;x++)
	{
		for(int y=0;y<3;y++){
		this.menuItem[x][y].addActionListener(handel);
		}
	}

}
public class EventHandler implements ActionListener
{

	public void actionPerformed(ActionEvent event) {
	
		if(event.getSource()==menuItem[0][0])
		{
			new GameWithComputerEasy(button1);
		}
		//if(){}
		if(event.getSource()==menuItem[0][2])
		{
			new GameWithComputerHard(button1);
		}
	}
	}

}
