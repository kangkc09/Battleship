package game;

import java.util.ArrayList;

import gameInterface.BattleShipPlayPage;
import gameInterface.BattleShipSetShip;
import player.KKCAI;
import player.NewKKCAI;
import player.PlayerInterface;
import player.SHWAI;

public class BSGameCore
{
	private static final int DEMENSION = 10;
	private static final int NUMBER_OF_SHIPS = 7;
	private static final int EXPLODE_SLEEP_TIME=100;
	private static final int TURN_SLEEP_TIME=100;
	private BattleShipPlayPage playPage;
	private BattleShipSetShip setShip;
	private PlayerInterface player1 = new NewKKCAI();
	private PlayerInterface player2 = new SHWAI();

	/*
	 * map status
	 * default: 0
	 * only boom: -1
	 * boom & attack: 1
	 */
	private int[][] map1 = new int[DEMENSION][DEMENSION];
	private int[][] map2 = new int[DEMENSION][DEMENSION];
	
	private ArrayList<Ship> survivedShips1= new ArrayList<Ship>();
	private ArrayList<Ship> survivedShips2= new ArrayList<Ship>();
	
	public BSGameCore()
	{
		/*
		 * PatrolBoat
		 */
		Ship patrolBoat1 = new PatrolBoat();
		patrolBoat1.placeOnMap(player1.getPatrolBoatPositionX(), player1.getPatrolBoatPositionY(), player1.getPatrolBoatOrientation());
		survivedShips1.add(patrolBoat1);
		Ship patrolBoat2 = new PatrolBoat();		
		patrolBoat2.placeOnMap(player2.getPatrolBoatPositionX(), player2.getPatrolBoatPositionY(), player2.getPatrolBoatOrientation());
		survivedShips2.add(patrolBoat2);
		
		/*
		 * destroyer
		 */
		Ship destroyer1 = new Destroyer();
		destroyer1.placeOnMap(player1.getDestroyerPositionX(), player1.getDestroyerPositionY(), player1.getDestroyerOrientation());
		survivedShips1.add(destroyer1);
		Ship destroyer2 = new Destroyer();		
		destroyer2.placeOnMap(player2.getDestroyerPositionX(), player2.getDestroyerPositionY(), player2.getDestroyerOrientation());
		survivedShips2.add(destroyer2);

		/*
		 * cruiser
		 */
		Ship cruiser1 = new Cruiser();
		cruiser1.placeOnMap(player1.getCruiserPositionX(), player1.getCruiserPositionY(), player1.getCruiserOrientation());
		survivedShips1.add(cruiser1);
		Ship cruiser2 = new Cruiser();		
		cruiser2.placeOnMap(player2.getCruiserPositionX(), player2.getCruiserPositionY(), player2.getCruiserOrientation());
		survivedShips2.add(cruiser2);

		/*
		 * battleship
		 */
		Ship battleship1 = new Battleship();
		battleship1.placeOnMap(player1.getBattleshipPositionX(), player1.getBattleshipPositionY(), player1.getBattleshipOrientation());
		survivedShips1.add(battleship1);
		Ship battleship2 = new Battleship();		
		battleship2.placeOnMap(player2.getBattleshipPositionX(), player2.getBattleshipPositionY(), player2.getBattleshipOrientation());
		survivedShips2.add(battleship2);

		/*
		 * submarine
		 */
		Ship submarine1 = new Submarine();
		submarine1.placeOnMap(player1.getSubmarinePositionX(), player1.getSubmarinePositionY(), player1.getSubmarineOrientation());
		survivedShips1.add(submarine1);
		Ship submarine2 = new Submarine();		
		submarine2.placeOnMap(player2.getSubmarinePositionX(), player2.getSubmarinePositionY(), player2.getSubmarineOrientation());
		survivedShips2.add(submarine2);

		/*
		 * aircraftCarrier
		 */
		Ship aircraftCarrier1 = new AircraftCarrier();
		aircraftCarrier1.placeOnMap(player1.getAircraftCarrierPositionX(), player1.getAircraftCarrierPositionY(), player1.getAircraftCarrierOrientation());
		survivedShips1.add(aircraftCarrier1);
		Ship aircraftCarrier2 = new AircraftCarrier();		
		aircraftCarrier2.placeOnMap(player2.getAircraftCarrierPositionX(), player2.getAircraftCarrierPositionY(), player2.getAircraftCarrierOrientation());
		survivedShips2.add(aircraftCarrier2);
		
		/*
		 * king
		 */
		Ship king1 = new King();
		king1.placeOnMap(player1.getKingPositionX(), player1.getKingPositionY(), 0);
		survivedShips1.add(king1);
		Ship king2 = new King();		
		king2.placeOnMap(player2.getKingPositionX(), player2.getKingPositionY(), 0);
		survivedShips2.add(king2);

		player1.setSurvivedShips(survivedShips1);
		player2.setSurvivedShips(survivedShips2);
	}
	class Turn extends Thread{
		boolean shipAttackSuccess1=true;
		boolean shipAttackSuccess2=true;
		Player1Win p1win=new Player1Win();
		Player2Win p2win=new Player2Win();
		class Player1Turn extends Thread{
			int player1X=player1.getBoomX();
			int player1Y=player1.getBoomY();
			@Override
			public void run() {
				playPage.setPlayer1Turn(true);
				playPage.setPlayer2Turn(false);
				for(int i=0;i<10;i++) {
					playPage.setIsPlayer2WhiteTrue(player1X,i);
					playPage.setIsPlayer2WhiteTrue(i,player1Y);
				}
				playPage.repaintPlayer2();
				try {
					Thread.sleep(EXPLODE_SLEEP_TIME);
				}catch(Exception e) {
					System.out.println(e);
				}
				if(isShipAttacked(player1X,player1Y,player1)) {
					
					playPage.clearIsPlayer2White();
					playPage.setIsPlayer2ExplodeTrue(player1X, player1Y);
					playPage.repaintPlayer2();
					try {
						Thread.sleep(EXPLODE_SLEEP_TIME);
					}catch(Exception e) {
						System.out.println(e);
					}
					playPage.clearIsPlayer2White();
					playPage.clearIsPlayer2Explode();
					playPage.setIsPlayer2BoomTrue(player1X, player1Y);
					playPage.repaintPlayer2();
					shipAttackSuccess1=true;
				}
				else {
					playPage.clearIsPlayer2White();
					playPage.setIsPlayer2MissTrue(player1X, player1Y);
					playPage.repaintPlayer2();
					try {
						Thread.sleep(EXPLODE_SLEEP_TIME);
					}catch(Exception e) {
						System.out.println(e);
					}
					playPage.clearIsPlayer2Miss();
					if(map2[player1Y][player1X]==1) {
						playPage.setIsPlayer2BoomTrue(player1X, player1Y);
					}
					else {
						playPage.setIsPlayer2XTrue(player1X, player1Y);
					}
					playPage.repaintPlayer2();
					shipAttackSuccess1=false;
				}
				switch(ShipDestroyed(player1)) {
				case "PatrolBoat":
					setShip.setIsShowPlayer2ShipEach(0, true);
					playPage.setSurvivedShips2(0, false);
					break;
				case "Destroyer":
					setShip.setIsShowPlayer2ShipEach(1, true);
					playPage.setSurvivedShips2(1, false);
					break;
				case "Cruiser":
					setShip.setIsShowPlayer2ShipEach(2, true);
					playPage.setSurvivedShips2(2, false);
					break;
				case "Battleship":
					setShip.setIsShowPlayer2ShipEach(3, true);
					playPage.setSurvivedShips2(3, false);
					break;
				case "Submarine":
					setShip.setIsShowPlayer2ShipEach(4, true);
					playPage.setSurvivedShips2(4, false);
					break;
				case "AircraftCarrier":
					setShip.setIsShowPlayer2ShipEach(5, true);
					playPage.setSurvivedShips2(5, false);
					break;
				case "King":
					setShip.setIsShowPlayer2ShipEach(6, true);
					playPage.setSurvivedShips2(6, false);
					break;
				default:
					break;
				}
				player1.setMap(map2);
			}
		}
		class Player2Turn extends Thread{
			int player2X=player2.getBoomX();
			int player2Y=player2.getBoomY();
			@Override
			public void run() {
				playPage.setPlayer2Turn(true);
				playPage.setPlayer1Turn(false);
				for(int i=0;i<10;i++) {
					playPage.setIsPlayer1WhiteTrue(player2X,i);
					playPage.setIsPlayer1WhiteTrue(i,player2Y);
				}
				playPage.repaintPlayer1();
				try {
					Thread.sleep(EXPLODE_SLEEP_TIME);
				}catch(Exception e) {
					System.out.println(e);
				}
				if(isShipAttacked(player2X,player2Y,player2)) {
					playPage.clearIsPlayer1White();
					playPage.setIsPlayer1ExplodeTrue(player2X, player2Y);
					playPage.repaintPlayer1();
					try {
						Thread.sleep(EXPLODE_SLEEP_TIME);
					}catch(Exception e) {
						System.out.println(e);
					}
					playPage.clearIsPlayer1White();
					playPage.clearIsPlayer1Explode();
					playPage.setIsPlayer1BoomTrue(player2X, player2Y);
					playPage.repaintPlayer1();
					shipAttackSuccess2=true;
				}
				else {
					playPage.clearIsPlayer1White();
					playPage.setIsPlayer1MissTrue(player2X, player2Y);
					playPage.repaintPlayer1();
					try {
						Thread.sleep(EXPLODE_SLEEP_TIME);
					}catch(Exception e) {
						System.out.println(e);
					}
					playPage.clearIsPlayer1Miss();
					if(map1[player2Y][player2X]==1) {
						playPage.setIsPlayer1BoomTrue(player2X, player2Y);
					}
					else {
						playPage.setIsPlayer1XTrue(player2X, player2Y);
					}
					playPage.repaintPlayer1();
					shipAttackSuccess2=false;
				}
				switch(ShipDestroyed(player2)) {
				case "PatrolBoat":
					setShip.setIsShowPlayer1ShipEach(0, true);
					playPage.setSurvivedShips1(0, false);
					break;
				case "Destroyer":
					setShip.setIsShowPlayer1ShipEach(1, true);
					playPage.setSurvivedShips1(1, false);
					break;
				case "Cruiser":
					setShip.setIsShowPlayer1ShipEach(2, true);
					playPage.setSurvivedShips1(2, false);
					break;
				case "Battleship":
					setShip.setIsShowPlayer1ShipEach(3, true);
					playPage.setSurvivedShips1(3, false);
					break;
				case "Submarine":
					setShip.setIsShowPlayer1ShipEach(4, true);
					playPage.setSurvivedShips1(4, false);
					break;
				case "AircraftCarrier":
					setShip.setIsShowPlayer1ShipEach(5, true);
					playPage.setSurvivedShips1(5, false);
					break;
				case "King":
					setShip.setIsShowPlayer1ShipEach(6, true);
					playPage.setSurvivedShips1(6, false);
					break;
				default:
					break;
				}
				player2.setMap(map1);
			}
		}
		class Player1Win extends Thread{
			@Override
			public void run() {
				playPage.player1Win();
			}
		}
		class Player2Win extends Thread{
			@Override
			public void run() {
				playPage.player2Win();
			}
		}
		@Override
		public void run() {
			while(true) {
				
				while(shipAttackSuccess1) {
					Player1Turn turn1=new Player1Turn();
					turn1.start();
					try {
						turn1.join();
						Thread.sleep(TURN_SLEEP_TIME);
					}catch(Exception e) {
						System.out.println(e);
					}
					if(isGameComplete(player1)) {
						System.out.println("player1 win");
						try {
							Thread.sleep(3000);
						}catch(Exception e) {
							System.out.println(e);
						}
						p1win.start();
						try {
							p1win.join();
						}catch(Exception e) {
							System.out.println(e);
						}
						System.exit(0);
					}
				}
				
				while(shipAttackSuccess2) {
					Player2Turn turn2=new Player2Turn();
					turn2.start();
					try {
						turn2.join();
						Thread.sleep(TURN_SLEEP_TIME);
					}catch(Exception e) {
						System.out.println(e);
					}
					if(isGameComplete(player2)) {
						System.out.println("player2 win");
						try {
							Thread.sleep(3000);
						}catch(Exception e) {
							System.out.println(e);
						}
						p2win.start();
						try {
							p2win.join();
						}catch(Exception e) {
							System.out.println(e);
						}
						System.exit(0);
					}
				}
				
				shipAttackSuccess1=true;
				shipAttackSuccess2=true;
			}
		}
	}
	public void printmatrix(int[][] matrix) {
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println();
	}
	public void play() {
		Turn turn=new Turn();
		turn.start();
	}
	public void setPlayPage(BattleShipPlayPage playPage) {
		this.playPage=playPage;
	}
	public void setSetShip(BattleShipSetShip setShip){
		this.setShip=setShip;
	}
	public boolean isShipAttacked(int BoomX, int BoomY, PlayerInterface currentPlayer)
	{
		if(currentPlayer == player1)
		{
			for(Ship i : survivedShips2)
			{
				for(int j=0;j<i.alivedXY.size();j++) {
					if(i.alivedXY.get(j).x==BoomX&&i.alivedXY.get(j).y==BoomY)
					{
						i.alivedXY.remove(j);
						map2[BoomY][BoomX] = 1;
						
						return true;
					}
				}
			}
			if(map2[BoomY][BoomX] == 0)
			{
				map2[BoomY][BoomX] = -1;				
			}
		}
		else
		{
			for(Ship i : survivedShips1)
			{
				for(int j=0;j<i.alivedXY.size();j++) {
					if(i.alivedXY.get(j).x==BoomX&&i.alivedXY.get(j).y==BoomY)
					{
						i.alivedXY.remove(j);
						map1[BoomY][BoomX] = 1;
						return true;
					}
				}
			}
			if(map1[BoomY][BoomX] == 0)
			{
				map1[BoomY][BoomX] = -1;				
			}
		}
		return false;
	}
	
	public String ShipDestroyed(PlayerInterface currentPlayer)
	{
		if(currentPlayer == player1)
		{
			for(Ship i: survivedShips2)
			{
				if(i.alivedXY.isEmpty())
				{
					System.out.println(i.getShipName());
					survivedShips2.remove(i);
					for(int j=0;j<i.originXY.size();j++) {
						map2[i.originXY.get(j).y][i.originXY.get(j).x]=ShipEnum.valueOf(i.getShipName()).ordinal()+2;
					}
					player1.setSurvivedShips(survivedShips2);
					return i.getShipName();
				}
			}
		}
		else
		{
			for(Ship i: survivedShips1)
			{
				if(i.alivedXY.isEmpty())
				{
					System.out.println(i.getShipName());
					survivedShips1.remove(i);
					for(int j=0;j<i.originXY.size();j++) {
						map1[i.originXY.get(j).y][i.originXY.get(j).x]=ShipEnum.valueOf(i.getShipName()).ordinal()+2;
					}
					player2.setSurvivedShips(survivedShips1);
					return i.getShipName();
				}
			}
		}
		return "";
	}
	
	public boolean isGameComplete(PlayerInterface currentPlayer)
	{
		if(currentPlayer == player1)
		{
			boolean findKing=false;
			for(int i=0;i<survivedShips2.size();i++) {
				if(survivedShips2.get(i).getShipName()=="King") {
					findKing=true;
				}
			}
			if(!findKing) {
				return true;
			}
			else if(survivedShips2.size()==1) {
				return true;
			}
		}
		else {
			boolean findKing=false;
			for(int i=0;i<survivedShips1.size();i++) {
				if(survivedShips1.get(i).getShipName()=="King") {
					findKing=true;
				}
			}
			if(!findKing) {
				return true;
			}
			else if(survivedShips1.size()==1) {
				return true;
			}
		}
		return false;
	}
	
	public int[][] getMap(int i)
	{
		if(i == 1)
		{
			return map1;
		}
		else
		{
			return map2;
		}
	}
	
	public PlayerInterface getPlayer1() {
		return player1;
	}
	public PlayerInterface getPlayer2() {
		return player2;
	}
}
