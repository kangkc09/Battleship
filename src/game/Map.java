package game;

import java.util.Arrays;

import player.PlayerInterface;

public class Map
{
	private static final int MAP_ROW=10;
	private static final int MAP_COLUMN=10;
	private int[][] map=new int[MAP_ROW][MAP_COLUMN];
	public Map(PlayerInterface player) {
		for(int i=0;i<MAP_ROW;i++) {
			Arrays.fill(map, 0);
		}
		/*
		 * PatrolBoat
		 */
		if(player.getPatrolBoatOrientation()%2==0) {
			map[player.getPatrolBoatPositionY()][player.getPatrolBoatPositionX()]=1;
			map[player.getPatrolBoatPositionY()+1][player.getPatrolBoatPositionX()]=1;
		}
		else {
			map[player.getPatrolBoatPositionY()][player.getPatrolBoatPositionX()]=1;
			map[player.getPatrolBoatPositionY()][player.getPatrolBoatPositionX()+1]=1;
		}
		/*
		 * Destroyer
		 */
		if(player.getDestroyerOrientation()%2==0) {
		}
		else {
			
		}
		/*
		 * Cruiser
		 */
		
		/*
		 * Battleship
		 */
		
		/*
		 * Submarine
		 */
		
		/*
		 * AircraftCarrier
		 */
		
		/*
		 * King
		 */
	}
}
