package main;

import javax.swing.JFrame;

import gameInterface.BattleShipMainPage;

public class BattleShipDemo extends JFrame
{
	public static final int SCREEN_WIDTH = 1920;
	public static final int SCREEN_HEIGHT = 1080;
	public BattleShipDemo() {
		setTitle("BattleShip");
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
		setResizable(false);
	}
	public static void main(String[] args) {
		new BattleShipMainPage(new BattleShipDemo());
	}
}
