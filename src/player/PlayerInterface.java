package player;

import java.util.ArrayList;

import game.Ship;

public interface PlayerInterface
{
	/*
	 * for place ship...
	 * get placed datas
	 */
	public int getPatrolBoatPositionX();
	public int getPatrolBoatPositionY();
	public int getPatrolBoatOrientation();
	public int getDestroyerPositionX();
	public int getDestroyerPositionY();
	public int getDestroyerOrientation();
	public int getCruiserPositionX();
	public int getCruiserPositionY();
	public int getCruiserOrientation();
	public int getBattleshipPositionX();
	public int getBattleshipPositionY();
	public int getBattleshipOrientation();
	public int getSubmarinePositionX();
	public int getSubmarinePositionY();
	public int getSubmarineOrientation();
	public int getAircraftCarrierPositionX();
	public int getAircraftCarrierPositionY();
	public int getAircraftCarrierOrientation();
	public int getKingPositionX();
	public int getKingPositionY();
	
	/*
	 * for throw...
	 * get where throw
	 */
	public int getBoomX();
	public int getBoomY();
	
	public void setMap(int[][] map);
	public void setSurvivedShips(ArrayList<Ship> survivedShips);
}
