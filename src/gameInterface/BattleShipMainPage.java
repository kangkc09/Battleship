package gameInterface;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import game.ImgSrc;

public class BattleShipMainPage
{
	public static final int SCREEN_WIDTH = 1920;
	public static final int SCREEN_HEIGHT = 1080;
	private static final int START_BUTTON_POSITION_X=742;
	private static final int START_BUTTON_POSITION_Y=742;
	private static final int START_BUTTON_SIZE_X=434;
	private static final int START_BUTTON_SIZE_Y=176;
	
	private ImgSrc imgsrc = new ImgSrc();
	public BattleShipMainPage(JFrame frm) {
		
		
		JPanel pnlStartPage = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				
				g.drawImage(imgsrc.srcStartPage(), 0, 0, null);
			}
		};
		pnlStartPage.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		frm.add(pnlStartPage);
		
		JButton btnStart = new JButton();
		btnStart.setBounds(START_BUTTON_POSITION_X, START_BUTTON_POSITION_Y, START_BUTTON_SIZE_X, START_BUTTON_SIZE_Y);
		btnStart.setBorderPainted(false);
		btnStart.setContentAreaFilled(false);
		frm.getContentPane().add(btnStart);

		btnStart.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new BattleShipSetShip(frm);
				pnlStartPage.setVisible(false);
			}
		});
	}
}
