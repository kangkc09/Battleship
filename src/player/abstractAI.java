package player;

import java.util.ArrayList;
import java.util.Random;

import game.Ship;

public abstract class abstractAI implements PlayerInterface
{
	public static final int CW_0DEG=0;
	public static final int CW_90DEG=1;
	public static final int CW_180DEG=2;
	public static final int CW_270DEG=3;
	protected int[][] map=new int[10][10];
	protected ArrayList<Ship> survivedShips=new ArrayList<Ship>();
	protected final Random randomSelecter= new Random();
	
	@Override
	public void setMap(int[][] map)
	{
		this.map=map;
		
	}

	@Override
	public void setSurvivedShips(ArrayList<Ship> survivedShips)
	{
		this.survivedShips=survivedShips;
		
	}
}
