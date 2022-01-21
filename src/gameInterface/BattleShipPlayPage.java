package gameInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.ImgSrc;

public class BattleShipPlayPage
{	
	private static final int PLAYER1_TURN_POSITION_X=100;
	private static final int PLAYER1_TURN_POSITION_Y=850;
	private static final int PLAYER2_TURN_POSITION_X=1000;
	private static final int PLAYER2_TURN_POSITION_Y=850;
	private static final int PLAYER_TURN_SIZE_X=150;
	private static final int PLAYER_TURN_SIZE_Y=176;
	private static final int PLAYER1_LEFT_SHIP_POSITION_X=300;
	private static final int PLAYER1_LEFT_SHIP_POSITION_Y=850;
	private static final int PLAYER2_LEFT_SHIP_POSITION_X=1200;
	private static final int PLAYER2_LEFT_SHIP_POSITION_Y=850;
	private static final int PLAYER_LEFT_SHIP_SIZE_X=600;
	private static final int PLAYER_LEFT_SHIP_SIZE_Y=150;
	private static final int RECT_SIZE=30;
	private static final int SHIP_SPACE=30;
	private static final int MATRIX_SIZE=75;
	private ImgSrc imgsrc=new ImgSrc();
	private boolean player1Turn=false;
	private boolean player2Turn=false;
	private JPanel pnlPlayer1Turn;
	private JPanel pnlPlayer2Turn;
	private JPanel[][] player1Matrix=new JPanel[10][10];
	private boolean[][] isPlayer1White=new boolean[10][10];
	private boolean[][] isPlayer1Miss=new boolean[10][10];
	private boolean[][] isPlayer1X=new boolean[10][10];
	private boolean[][] isPlayer1Explode=new boolean[10][10];
	private boolean[][] isPlayer1Boom=new boolean[10][10];
	private JPanel[][] player2Matrix=new JPanel[10][10];
	private boolean[][] isPlayer2White=new boolean[10][10];
	private boolean[][] isPlayer2Miss=new boolean[10][10];
	private boolean[][] isPlayer2X=new boolean[10][10];
	private boolean[][] isPlayer2Explode=new boolean[10][10];
	private boolean[][] isPlayer2Boom=new boolean[10][10];
	private boolean[] survivedShips1=new boolean[7];
	private boolean[] survivedShips2=new boolean[7];
	private BattleShipSetShip setShip;
	private JFrame frm;
	public BattleShipPlayPage(JFrame frm, BattleShipSetShip setShip) {
		this.frm=frm;
		this.setShip=setShip;
		Arrays.fill(survivedShips1, true);
		Arrays.fill(survivedShips2, true);
		clearIsPlayer1White();
		clearIsPlayer1Miss();
		clearIsPlayer1X();
		clearIsPlayer1Explode();
		clearIsPlayer1Boom();

		clearIsPlayer2White();
		clearIsPlayer2Miss();
		clearIsPlayer2X();
		clearIsPlayer2Explode();
		clearIsPlayer2Boom();
		
		pnlPlayer2Turn= new JPanel() {
			public void paintComponent(Graphics g) {
				if(player2Turn)
					g.drawImage(imgsrc.srcUpArrow(), 0,0,null);
			}
		};
		pnlPlayer2Turn.setBounds(PLAYER1_TURN_POSITION_X,PLAYER1_TURN_POSITION_Y,PLAYER_TURN_SIZE_X,PLAYER_TURN_SIZE_Y);
		frm.add(pnlPlayer2Turn,1);
		
		pnlPlayer1Turn= new JPanel() {
			public void paintComponent(Graphics g) {
				if(player1Turn)
					g.drawImage(imgsrc.srcUpArrow(), 0,0,null);
			}
		};
		pnlPlayer1Turn.setBounds(PLAYER2_TURN_POSITION_X,PLAYER2_TURN_POSITION_Y,PLAYER_TURN_SIZE_X,PLAYER_TURN_SIZE_Y);
		frm.add(pnlPlayer1Turn,1);
		JPanel pnlPlayer1LeftShip = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				g.setColor(Color.orange);
				/*
				 * PatrolBoat
				 */
				if(survivedShips1[0])
					g.fillRect(0,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*2,RECT_SIZE,RECT_SIZE*2);
				/*
				 * Destroyer
				 */
				if(survivedShips1[1])
				g.fillRect(RECT_SIZE*2+SHIP_SPACE,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*3,RECT_SIZE,RECT_SIZE*3);
				/*
				 * Cruiser
				 */
				if(survivedShips1[2])
				g.fillRect((RECT_SIZE*2+SHIP_SPACE)*2,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*4,RECT_SIZE,RECT_SIZE*4);
				/*
				 * Battleship
				 */
				if(survivedShips1[3])
				g.fillRect((RECT_SIZE*2+SHIP_SPACE)*3,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*5,RECT_SIZE,RECT_SIZE*5);
				/*
				 * Submarine
				 */
				if(survivedShips1[4]) {
					g.fillRect((RECT_SIZE*2+SHIP_SPACE)*4,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*3,RECT_SIZE,RECT_SIZE*3);
					g.fillRect((RECT_SIZE*2+SHIP_SPACE)*4+RECT_SIZE,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*2,RECT_SIZE,RECT_SIZE);
				}
				/*
				 * AircraftCarrier
				 */
				if(survivedShips1[5]) {
					g.fillRect((RECT_SIZE*2+SHIP_SPACE)*5+RECT_SIZE,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*4,RECT_SIZE,RECT_SIZE*3);
					g.fillRect((RECT_SIZE*2+SHIP_SPACE)*5+RECT_SIZE*2,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*3,RECT_SIZE,RECT_SIZE*3);
				}
				
				g.setColor(Color.black);
				/*
				 * PatrolBoat
				 */
				g.drawRect(0,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*2,RECT_SIZE,RECT_SIZE);
				g.drawRect(0,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE,RECT_SIZE,RECT_SIZE);
				/*
				 * Destroyer
				 */
				g.drawRect(RECT_SIZE*2+SHIP_SPACE,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE,RECT_SIZE,RECT_SIZE);
				g.drawRect(RECT_SIZE*2+SHIP_SPACE,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*2,RECT_SIZE,RECT_SIZE);
				g.drawRect(RECT_SIZE*2+SHIP_SPACE,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*3,RECT_SIZE,RECT_SIZE);
				/*
				 * Cruiser
				 */
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*2,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*2,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*2,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*2,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*3,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*2,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*4,RECT_SIZE,RECT_SIZE);
				/*
				 * Battleship
				 */
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*3,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*3,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*2,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*3,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*3,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*3,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*4,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*3,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*5,RECT_SIZE,RECT_SIZE);
				/*
				 * Submarine
				 */
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*4,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*4,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*2,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*4,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*3,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*4+RECT_SIZE,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*2,RECT_SIZE,RECT_SIZE);
				/*
				 * AircraftCarrier
				 */
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*5+RECT_SIZE,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*2,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*5+RECT_SIZE,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*3,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*5+RECT_SIZE,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*4,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*5+RECT_SIZE*2,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*5+RECT_SIZE*2,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*2,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*5+RECT_SIZE*2,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*3,RECT_SIZE,RECT_SIZE);
			}
		};
		pnlPlayer1LeftShip.setBounds(PLAYER1_LEFT_SHIP_POSITION_X,PLAYER1_LEFT_SHIP_POSITION_Y,PLAYER_LEFT_SHIP_SIZE_X,PLAYER_LEFT_SHIP_SIZE_Y+1);
		frm.add(pnlPlayer1LeftShip,1);
		
		JPanel pnlPlayer2LeftShip = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				g.setColor(Color.orange);
				/*
				 * PatrolBoat
				 */
				if(survivedShips2[0])
				g.fillRect(0,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*2,RECT_SIZE,RECT_SIZE*2);
				/*
				 * Destroyer
				 */
				if(survivedShips2[1])
				g.fillRect(RECT_SIZE*2+SHIP_SPACE,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*3,RECT_SIZE,RECT_SIZE*3);
				/*
				 * Cruiser
				 */
				if(survivedShips2[2])
				g.fillRect((RECT_SIZE*2+SHIP_SPACE)*2,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*4,RECT_SIZE,RECT_SIZE*4);
				/*
				 * Battleship
				 */
				if(survivedShips2[3])
				g.fillRect((RECT_SIZE*2+SHIP_SPACE)*3,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*5,RECT_SIZE,RECT_SIZE*5);
				/*
				 * Submarine
				 */
				if(survivedShips2[4]) {
					g.fillRect((RECT_SIZE*2+SHIP_SPACE)*4,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*3,RECT_SIZE,RECT_SIZE*3);
					g.fillRect((RECT_SIZE*2+SHIP_SPACE)*4+RECT_SIZE,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*2,RECT_SIZE,RECT_SIZE);
				}
				/*
				 * AircraftCarrier
				 */
				if(survivedShips2[5]) {
					g.fillRect((RECT_SIZE*2+SHIP_SPACE)*5+RECT_SIZE,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*4,RECT_SIZE,RECT_SIZE*3);
					g.fillRect((RECT_SIZE*2+SHIP_SPACE)*5+RECT_SIZE*2,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*3,RECT_SIZE,RECT_SIZE*3);
				}
				
				g.setColor(Color.black);
				/*
				 * PatrolBoat
				 */
				g.drawRect(0,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*2,RECT_SIZE,RECT_SIZE);
				g.drawRect(0,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE,RECT_SIZE,RECT_SIZE);
				/*
				 * Destroyer
				 */
				g.drawRect(RECT_SIZE*2+SHIP_SPACE,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE,RECT_SIZE,RECT_SIZE);
				g.drawRect(RECT_SIZE*2+SHIP_SPACE,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*2,RECT_SIZE,RECT_SIZE);
				g.drawRect(RECT_SIZE*2+SHIP_SPACE,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*3,RECT_SIZE,RECT_SIZE);
				/*
				 * Cruiser
				 */
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*2,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*2,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*2,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*2,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*3,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*2,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*4,RECT_SIZE,RECT_SIZE);
				/*
				 * Battleship
				 */
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*3,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*3,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*2,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*3,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*3,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*3,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*4,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*3,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*5,RECT_SIZE,RECT_SIZE);
				/*
				 * Submarine
				 */
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*4,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*4,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*2,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*4,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*3,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*4+RECT_SIZE,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*2,RECT_SIZE,RECT_SIZE);
				/*
				 * AircraftCarrier
				 */
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*5+RECT_SIZE,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*2,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*5+RECT_SIZE,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*3,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*5+RECT_SIZE,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*4,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*5+RECT_SIZE*2,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*5+RECT_SIZE*2,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*2,RECT_SIZE,RECT_SIZE);
				g.drawRect((RECT_SIZE*2+SHIP_SPACE)*5+RECT_SIZE*2,PLAYER_LEFT_SHIP_SIZE_Y-RECT_SIZE*3,RECT_SIZE,RECT_SIZE);
			}
		};
		pnlPlayer2LeftShip.setBounds(PLAYER2_LEFT_SHIP_POSITION_X,PLAYER2_LEFT_SHIP_POSITION_Y,PLAYER_LEFT_SHIP_SIZE_X,PLAYER_LEFT_SHIP_SIZE_Y+1);
		frm.add(pnlPlayer2LeftShip,1);
		class Player1JPanel extends JPanel{
			int i,j;
			Player1JPanel(int i, int j){
				this.i=i;
				this.j=j;
			}
			public void paintComponent(Graphics g) {
				if(isPlayer1White[i][j]) {
					Color newWhite=new Color(255,255,255,100);
					g.setColor(newWhite);
					g.fillRect(0, 0, 75, 75);
				}
				else if(isPlayer1X[i][j]) {
					g.drawImage(imgsrc.srcX(), 0, 0, null);
				}
				else if(isPlayer1Miss[i][j]) {
					g.drawImage(imgsrc.srcMiss(), 0, 0, null);
				}
				else if(isPlayer1Explode[i][j]) {
					g.drawImage(imgsrc.srcExplode(), 0, 0, null);
				}
				else if(isPlayer1Boom[i][j]) {
					g.drawImage(imgsrc.srcBoom(), 0, 0, null);
				}
				
			}
		}
		class Player2JPanel extends JPanel{
			int i,j;
			Player2JPanel(int i, int j){
				this.i=i;
				this.j=j;
			}
			public void paintComponent(Graphics g) {
				if(isPlayer2White[i][j]) {
					Color newWhite=new Color(255,255,255,100);
					g.setColor(newWhite);
					g.fillRect(0, 0, 75, 75);
				}
				else if(isPlayer2X[i][j]) {
					g.drawImage(imgsrc.srcX(), 0, 0, null);
				}
				else if(isPlayer2Miss[i][j]) {
					g.drawImage(imgsrc.srcMiss(), 0, 0, null);
				}
				else if(isPlayer2Explode[i][j]) {
					g.drawImage(imgsrc.srcExplode(), 0, 0, null);
				}
				else if(isPlayer2Boom[i][j]) {
					g.drawImage(imgsrc.srcBoom(), 0, 0, null);
				}
			}
		}
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				player1Matrix[i][j] =new Player1JPanel(i,j);
				player2Matrix[i][j] =new Player2JPanel(i,j);
				player1Matrix[i][j].setBounds(Player1MatrixX(j),PlayerMatrixY(i),MATRIX_SIZE,MATRIX_SIZE);
				player2Matrix[i][j].setBounds(Player2MatrixX(j),PlayerMatrixY(i),MATRIX_SIZE,MATRIX_SIZE);
				frm.add(player1Matrix[i][j],19);
				frm.add(player2Matrix[i][j],19);
			}
		}
	}
	public void player1Win() {
		JPanel screen1 =new JPanel() {
			@Override
			public void paintComponent(Graphics g){
				Color background=new Color(255,255,255,100);
				g.drawImage(imgsrc.srcPlayer1Win(), 0, 0, background, null);
			}
		};
		screen1.setSize(1920,1080);
		frm.add(screen1,0);
		frm.repaint();
		try {
			Thread.sleep(3000);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void player2Win() {
		JPanel screen2 =new JPanel() {
			@Override
			public void paintComponent(Graphics g){
				Color background=new Color(255,255,255,100);
				g.drawImage(imgsrc.srcPlayer2Win(), 0, 0, background, null);
			}
		};
		screen2.setSize(1920,1080);
		frm.add(screen2,0);
		frm.repaint();
		try {
			Thread.sleep(3000);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void setSurvivedShips1(int index, boolean isSurvived) {
		survivedShips1[index]=isSurvived;
	}
	public void setSurvivedShips2(int index, boolean isSurvived) {
		survivedShips2[index]=isSurvived;
	}
	public void setPlayer1Turn(boolean isTurn) {
		player1Turn=isTurn;
		pnlPlayer1Turn.repaint();
	}
	public void setPlayer2Turn(boolean isTurn) {
		player2Turn=isTurn;
		pnlPlayer2Turn.repaint();
	}
	public void repaintPlayer1() {
		frm.repaint(100, 20, 800, 800);
		setShip.getPlayer1Map().repaint();
	}
	public void repaintPlayer2() {
		frm.repaint(1000, 20, 800, 800);
		setShip.getPlayer2Map().repaint();
	}
	public void clearIsPlayer1White() {
		for(int i=0;i<10;i++) {
			Arrays.fill(isPlayer1White[i], false);
		}
	}
	public void clearIsPlayer1Miss() {
		for(int i=0;i<10;i++) {
			Arrays.fill(isPlayer1Miss[i], false);
		}
	}
	public void clearIsPlayer1X() {
		for(int i=0;i<10;i++) {
			Arrays.fill(isPlayer1X[i], false);
		}
	}
	public void clearIsPlayer1Boom() {
		for(int i=0;i<10;i++) {
			Arrays.fill(isPlayer1Boom[i], false);
		}
	}
	public void clearIsPlayer1Explode() {
		for(int i=0;i<10;i++) {
			Arrays.fill(isPlayer1Explode[i], false);
		}
	}
	public void setIsPlayer1WhiteTrue(int x, int y) {
		isPlayer1White[y][x]=true;
	}
	public void setIsPlayer1MissTrue(int x, int y) {
		isPlayer1Miss[y][x]=true;
	}
	public void setIsPlayer1XTrue(int x, int y) {
		isPlayer1X[y][x]=true;
	}
	public void setIsPlayer1BoomTrue(int x, int y) {
		isPlayer1Boom[y][x]=true;
	}
	public void setIsPlayer1ExplodeTrue(int x, int y) {
		isPlayer1Explode[y][x]=true;
	}
	
	public void clearIsPlayer2White() {
		for(int i=0;i<10;i++) {
			Arrays.fill(isPlayer2White[i], false);
		}
	}
	public void clearIsPlayer2Miss() {
		for(int i=0;i<10;i++) {
			Arrays.fill(isPlayer2Miss[i], false);
		}
	}
	public void clearIsPlayer2X() {
		for(int i=0;i<10;i++) {
			Arrays.fill(isPlayer2X[i], false);
		}
	}
	public void clearIsPlayer2Boom() {
		for(int i=0;i<10;i++) {
			Arrays.fill(isPlayer2Boom[i], false);
		}
	}
	public void clearIsPlayer2Explode() {
		for(int i=0;i<10;i++) {
			Arrays.fill(isPlayer2Explode[i], false);
		}
	}
	public void setIsPlayer2WhiteTrue(int x, int y) {
		isPlayer2White[y][x]=true;
	}
	public void setIsPlayer2MissTrue(int x, int y) {
		isPlayer2Miss[y][x]=true;
	}
	public void setIsPlayer2XTrue(int x, int y) {
		isPlayer2X[y][x]=true;
	}
	public void setIsPlayer2BoomTrue(int x, int y) {
		isPlayer2Boom[y][x]=true;
	}
	public void setIsPlayer2ExplodeTrue(int x, int y) {
		isPlayer2Explode[y][x]=true;
	}
	public int Player1MatrixX(int x) {
		return 135+75*x;
	}
	public int PlayerMatrixY(int y) {
		return 55+75*y;
	}
	public int Player2MatrixX(int x) {
		return 1035+75*x;
	}
}
