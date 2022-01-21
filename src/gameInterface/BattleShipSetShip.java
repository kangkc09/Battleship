package gameInterface;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import game.BSGameCore;
import game.ImgSrc;
import game.ShipEnum;
import player.PlayerInterface;

public class BattleShipSetShip
{
	public static final int SCREEN_WIDTH = 1920;
	public static final int SCREEN_HEIGHT = 1080;
	private static final int PLAYER1_MAP_POSITION_X = 100;
	private static final int PLAYER1_MAP_POSITION_Y = 20;
	private static final int PLAYER_MAP_SIZE_X = 800;
	private static final int PLAYER_MAP_SIZE_Y = 800;
	private static final int PLAYER2_MAP_POSITION_X = 1000;
	private static final int PLAYER2_MAP_POSITION_Y = 20;
	private static final int SHOWHIDE_BUTTON_POSITION_X = 100;
	private static final int SHOWHIDE_BUTTON_POSITION_Y = 850;
	private static final int START_BUTTON_POSITION_X = 1550;
	private static final int START_BUTTON_POSITION_Y = 850;
	private static final int BUTTON_SIZE_X = 256;
	private static final int BUTTON_SIZE_Y = 123;
	private static final int PLAYER1 = 1;
	private static final int PLAYER2 = 2;
	private static final int SHIP_SIZE = 75;
	private static final int NUMBER_OF_TYPE=7;
	private static final int INVALID_FLAG = -1;
	private ImgSrc imgsrc = new ImgSrc();
	private JFrame frm;
	private boolean isShowShip=false;
	private boolean[] isShowPlayer1ShipEach =new boolean[NUMBER_OF_TYPE];
	private boolean[] isShowPlayer2ShipEach =new boolean[NUMBER_OF_TYPE];
	private JPanel pnlPlayer1Map;
	private JPanel pnlPlayer2Map;

	public BattleShipSetShip(JFrame frm)
	{
		this.frm = frm;
		Arrays.fill(isShowPlayer1ShipEach, false);
		Arrays.fill(isShowPlayer2ShipEach, false);
		BSGameCore game=new BSGameCore();
		setPlayer1Map(game.getPlayer1());
		setPlayer2Map(game.getPlayer2());

		
		pnlPlayer1Map = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				
				g.drawImage(imgsrc.srcMap(), 0, 0, null);
			}
		};
		pnlPlayer1Map.setBounds(PLAYER1_MAP_POSITION_X, PLAYER1_MAP_POSITION_Y, PLAYER_MAP_SIZE_X, PLAYER_MAP_SIZE_Y);
		frm.add(pnlPlayer1Map);

		pnlPlayer2Map = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				
				g.drawImage(imgsrc.srcMap(), 0, 0, null);
			}
		};
		pnlPlayer2Map.setBounds(PLAYER2_MAP_POSITION_X, PLAYER2_MAP_POSITION_Y, PLAYER_MAP_SIZE_X, PLAYER_MAP_SIZE_Y);
		frm.add(pnlPlayer2Map);

		JPanel pnlShowHideButton = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				
				if (isShowShip)
					g.drawImage(imgsrc.srcHideButton(), 0, 0, null);
				else
					g.drawImage(imgsrc.srcShowButton(), 0, 0, null);
			}
		};
		pnlShowHideButton.setBounds(SHOWHIDE_BUTTON_POSITION_X, SHOWHIDE_BUTTON_POSITION_Y, BUTTON_SIZE_X,
				BUTTON_SIZE_Y);
		frm.add(pnlShowHideButton);
		
		JPanel pnlStartButton = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				g.drawImage(imgsrc.srcStartButton(), 0, 0, null);
			}
		};
		pnlStartButton.setBounds(START_BUTTON_POSITION_X, START_BUTTON_POSITION_Y, BUTTON_SIZE_X,
				BUTTON_SIZE_Y);
		frm.add(pnlStartButton);

		JPanel pnlStartPage = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				
				g.drawImage(imgsrc.srcBackground(), 0, 0, null);
			}
		};
		pnlStartPage.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		frm.add(pnlStartPage,-1);

		JButton btnShowHide = new JButton();
		btnShowHide.setBounds(SHOWHIDE_BUTTON_POSITION_X, SHOWHIDE_BUTTON_POSITION_Y, BUTTON_SIZE_X,
				BUTTON_SIZE_Y);
		btnShowHide.setBorderPainted(false);
		btnShowHide.setContentAreaFilled(false);
		frm.getContentPane().add(btnShowHide);

		
		JButton btnStart = new JButton();
		btnStart.setBounds(START_BUTTON_POSITION_X, START_BUTTON_POSITION_Y, BUTTON_SIZE_X,
				BUTTON_SIZE_Y);
		btnStart.setBorderPainted(false);
		btnStart.setContentAreaFilled(false);
		frm.getContentPane().add(btnStart);
		
		
		btnShowHide.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (isShowShip)
				{
					isShowShip = false;
					Arrays.fill(isShowPlayer1ShipEach, false);
					Arrays.fill(isShowPlayer2ShipEach, false);
					frm.repaint();
				} else
				{
					isShowShip = true;
					Arrays.fill(isShowPlayer1ShipEach, true);
					Arrays.fill(isShowPlayer2ShipEach, true);
					frm.repaint();
				}
				pnlShowHideButton.repaint();
			}
		});
		
		btnStart.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				isShowShip=false;
				Arrays.fill(isShowPlayer1ShipEach, false);
				Arrays.fill(isShowPlayer2ShipEach, false);
				pnlShowHideButton.setVisible(false);
				btnShowHide.setEnabled(false);
				pnlStartButton.setVisible(false);
				btnStart.setEnabled(false);
				frm.repaint();
				BattleShipPlayPage playPage=new BattleShipPlayPage(frm,returnthis());
				game.setSetShip(returnthis());
				game.setPlayPage(playPage);
				game.play();
			}
		});
	}
	public BattleShipSetShip returnthis() {
		return this;
	}
	public void setPlayer1Map(PlayerInterface player1)
	{

		JPanel pnlPlayer1PatrolBoat = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				if(isShowPlayer1ShipEach[ShipEnum.PatrolBoat.ordinal()])
					g.drawImage(imgsrc.srcPatrolBoat(player1.getPatrolBoatOrientation()), 0, 0, null);
			}
		};
		pnlPlayer1PatrolBoat.setBounds(mapX(PLAYER1, player1.getPatrolBoatPositionX()),
				mapY(player1.getPatrolBoatPositionY()),
				rotateByOrientationX(ShipEnum.PatrolBoat, player1.getPatrolBoatOrientation()) * SHIP_SIZE,
				rotateByOrientationY(ShipEnum.PatrolBoat, player1.getPatrolBoatOrientation()) * SHIP_SIZE);
		frm.add(pnlPlayer1PatrolBoat,0);

		JPanel pnlPlayer1Destroyer = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				if(isShowPlayer1ShipEach[ShipEnum.Destroyer.ordinal()])
					g.drawImage(imgsrc.srcDestroyer(player1.getDestroyerOrientation()), 0, 0, null);
			}
		};
		pnlPlayer1Destroyer.setBounds(mapX(PLAYER1, player1.getDestroyerPositionX()),
				mapY(player1.getDestroyerPositionY()),
				rotateByOrientationX(ShipEnum.Destroyer, player1.getDestroyerOrientation()) * SHIP_SIZE,
				rotateByOrientationY(ShipEnum.Destroyer, player1.getDestroyerOrientation()) * SHIP_SIZE);
		frm.add(pnlPlayer1Destroyer,0);

		JPanel pnlPlayer1Cruiser = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				
				if(isShowPlayer1ShipEach[ShipEnum.Cruiser.ordinal()])
					g.drawImage(imgsrc.srcCruiser(player1.getCruiserOrientation()), 0, 0, null);
			}
		};
		pnlPlayer1Cruiser.setBounds(mapX(PLAYER1, player1.getCruiserPositionX()), mapY(player1.getCruiserPositionY()),
				rotateByOrientationX(ShipEnum.Cruiser, player1.getCruiserOrientation()) * SHIP_SIZE,
				rotateByOrientationY(ShipEnum.Cruiser, player1.getCruiserOrientation()) * SHIP_SIZE);
		frm.add(pnlPlayer1Cruiser,0);

		JPanel pnlPlayer1Battleship = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				
				if(isShowPlayer1ShipEach[ShipEnum.Battleship.ordinal()])
					g.drawImage(imgsrc.srcBattleship(player1.getBattleshipOrientation()), 0, 0, null);
			}
		};
		pnlPlayer1Battleship.setBounds(mapX(PLAYER1, player1.getBattleshipPositionX()),
				mapY(player1.getBattleshipPositionY()),
				rotateByOrientationX(ShipEnum.Battleship, player1.getBattleshipOrientation()) * SHIP_SIZE,
				rotateByOrientationY(ShipEnum.Battleship, player1.getBattleshipOrientation()) * SHIP_SIZE);
		frm.add(pnlPlayer1Battleship,0);

		JPanel pnlPlayer1Submarine = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				
				if(isShowPlayer1ShipEach[ShipEnum.Submarine.ordinal()])
					g.drawImage(imgsrc.srcSubmarine(player1.getSubmarineOrientation()), 0, 0, null);
			}
		};
		pnlPlayer1Submarine.setBounds(mapX(PLAYER1, player1.getSubmarinePositionX()),
				mapY(player1.getSubmarinePositionY()),
				rotateByOrientationX(ShipEnum.Submarine, player1.getSubmarineOrientation()) * SHIP_SIZE,
				rotateByOrientationY(ShipEnum.Submarine, player1.getSubmarineOrientation()) * SHIP_SIZE);
		frm.add(pnlPlayer1Submarine,0);
		
		JPanel pnlPlayer1AircraftCarrier = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				if(isShowPlayer1ShipEach[ShipEnum.AircraftCarrier.ordinal()])
					g.drawImage(imgsrc.srcAircraftCarrier(player1.getAircraftCarrierOrientation()), 0, 0, null);
			}
		};
		pnlPlayer1AircraftCarrier.setBounds(mapX(PLAYER1, player1.getAircraftCarrierPositionX()),
				mapY(player1.getAircraftCarrierPositionY()),
				rotateByOrientationX(ShipEnum.AircraftCarrier, player1.getAircraftCarrierOrientation()) * SHIP_SIZE,
				rotateByOrientationY(ShipEnum.AircraftCarrier, player1.getAircraftCarrierOrientation()) * SHIP_SIZE);
		frm.add(pnlPlayer1AircraftCarrier,0);

		JPanel pnlPlayer1King = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				if(isShowPlayer1ShipEach[ShipEnum.King.ordinal()])
					g.drawImage(imgsrc.srcKing(), 0, 0, null);
			}
		};
		pnlPlayer1King.setBounds(mapX(PLAYER1, player1.getKingPositionX()),
				mapY(player1.getKingPositionY()), ShipEnum.King.shipSizeX() * SHIP_SIZE,
				ShipEnum.King.shipSizeY() * SHIP_SIZE);
		frm.add(pnlPlayer1King,0);

	}

	public void setPlayer2Map(PlayerInterface player2)
	{

		JPanel pnlPlayer2PatrolBoat = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				
				if(isShowPlayer2ShipEach[ShipEnum.PatrolBoat.ordinal()])
					g.drawImage(imgsrc.srcPatrolBoat(player2.getPatrolBoatOrientation()), 0, 0, null);
			}
		};
		pnlPlayer2PatrolBoat.setBounds(mapX(PLAYER2, player2.getPatrolBoatPositionX()),
				mapY(player2.getPatrolBoatPositionY()),
				rotateByOrientationX(ShipEnum.PatrolBoat, player2.getPatrolBoatOrientation()) * SHIP_SIZE,
				rotateByOrientationY(ShipEnum.PatrolBoat, player2.getPatrolBoatOrientation()) * SHIP_SIZE);
		frm.add(pnlPlayer2PatrolBoat,0);

		JPanel pnlPlayer2Destroyer = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				
				if(isShowPlayer2ShipEach[ShipEnum.Destroyer.ordinal()])
					g.drawImage(imgsrc.srcDestroyer(player2.getDestroyerOrientation()), 0, 0, null);
			}
		};
		pnlPlayer2Destroyer.setBounds(mapX(PLAYER2, player2.getDestroyerPositionX()),
				mapY(player2.getDestroyerPositionY()),
				rotateByOrientationX(ShipEnum.Destroyer, player2.getDestroyerOrientation()) * SHIP_SIZE,
				rotateByOrientationY(ShipEnum.Destroyer, player2.getDestroyerOrientation()) * SHIP_SIZE);
		frm.add(pnlPlayer2Destroyer,0);

		JPanel pnlPlayer2Cruiser = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				
				if(isShowPlayer2ShipEach[ShipEnum.Cruiser.ordinal()])
					g.drawImage(imgsrc.srcCruiser(player2.getCruiserOrientation()), 0, 0, null);
			}
		};
		pnlPlayer2Cruiser.setBounds(mapX(PLAYER2, player2.getCruiserPositionX()), mapY(player2.getCruiserPositionY()),
				rotateByOrientationX(ShipEnum.Cruiser, player2.getCruiserOrientation()) * SHIP_SIZE,
				rotateByOrientationY(ShipEnum.Cruiser, player2.getCruiserOrientation()) * SHIP_SIZE);
		frm.add(pnlPlayer2Cruiser,0);

		JPanel pnlPlayer2Battleship = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				
				if(isShowPlayer2ShipEach[ShipEnum.Battleship.ordinal()])
					g.drawImage(imgsrc.srcBattleship(player2.getBattleshipOrientation()), 0, 0, null);
			}
		};
		pnlPlayer2Battleship.setBounds(mapX(PLAYER2, player2.getBattleshipPositionX()),
				mapY(player2.getBattleshipPositionY()),
				rotateByOrientationX(ShipEnum.Battleship, player2.getBattleshipOrientation()) * SHIP_SIZE,
				rotateByOrientationY(ShipEnum.Battleship, player2.getBattleshipOrientation()) * SHIP_SIZE);
		frm.add(pnlPlayer2Battleship,0);

		JPanel pnlPlayer2Submarine = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				
				if(isShowPlayer2ShipEach[ShipEnum.Submarine.ordinal()])
					g.drawImage(imgsrc.srcSubmarine(player2.getSubmarineOrientation()), 0, 0, null);
			}
		};
		pnlPlayer2Submarine.setBounds(mapX(PLAYER2, player2.getSubmarinePositionX()),
				mapY(player2.getSubmarinePositionY()),
				rotateByOrientationX(ShipEnum.Submarine, player2.getSubmarineOrientation()) * SHIP_SIZE,
				rotateByOrientationY(ShipEnum.Submarine, player2.getSubmarineOrientation()) * SHIP_SIZE);
		frm.add(pnlPlayer2Submarine,0);

		JPanel pnlPlayer2AircraftCarrier = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				
				if(isShowPlayer2ShipEach[ShipEnum.AircraftCarrier.ordinal()])
					g.drawImage(imgsrc.srcAircraftCarrier(player2.getAircraftCarrierOrientation()), 0, 0, null);
			}
		};
		pnlPlayer2AircraftCarrier.setBounds(mapX(PLAYER2, player2.getAircraftCarrierPositionX()),
				mapY(player2.getAircraftCarrierPositionY()),
				rotateByOrientationX(ShipEnum.AircraftCarrier, player2.getAircraftCarrierOrientation()) * SHIP_SIZE,
				rotateByOrientationY(ShipEnum.AircraftCarrier, player2.getAircraftCarrierOrientation()) * SHIP_SIZE);
		frm.add(pnlPlayer2AircraftCarrier,0);

		JPanel pnlPlayer2King = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				
				if(isShowPlayer2ShipEach[ShipEnum.King.ordinal()])
					g.drawImage(imgsrc.srcKing(), 0, 0, null);
			}
		};
		pnlPlayer2King.setBounds(mapX(PLAYER2, player2.getKingPositionX()), mapY(player2.getKingPositionY()),
				ShipEnum.King.shipSizeX() * SHIP_SIZE, ShipEnum.King.shipSizeY() * SHIP_SIZE);
		frm.add(pnlPlayer2King,0);

	}
	public JPanel getPlayer1Map() {
		return pnlPlayer1Map;
	}
	public JPanel getPlayer2Map() {
		return pnlPlayer2Map;
	}
	public void setIsShowPlayer1ShipEach(int index, boolean isShow) {
		isShowPlayer1ShipEach[index]=isShow;
	}
	public void setIsShowPlayer2ShipEach(int index, boolean isShow) {
		isShowPlayer2ShipEach[index]=isShow;
	}
	public boolean[] getIsShowPlayer1ShipEach() {
		return isShowPlayer1ShipEach;
	}
	public boolean[] getIsShowPlayer2ShipEach() {
		return isShowPlayer2ShipEach;
	}
	private static final int mapX(int player, int x)
	{
		if (player == PLAYER1)
		{
			return 135 + (75 * x);
		} else if (player == PLAYER2)
		{
			return 1035 + (75 * x);
		}
		return INVALID_FLAG;
	}

	private static final int mapY(int y)
	{
		return 55 + (75 * y);
	}

	private static final int rotateByOrientationX(ShipEnum shipenum, int orientation)
	{
		if (orientation % 2 == 0)
			return shipenum.shipSizeX();
		else
			return shipenum.shipSizeY();
	}

	private static final int rotateByOrientationY(ShipEnum shipenum, int orientation)
	{
		if (orientation % 2 == 0)
			return shipenum.shipSizeY();
		else
			return shipenum.shipSizeX();
	}
}
