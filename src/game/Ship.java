package game;

import java.util.ArrayList;

class xyLocation
{
	int x;
	int y;

	public xyLocation(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}

public abstract class Ship
{
	/*
	 * for core
	 */
	public ArrayList<xyLocation> alivedXY= new ArrayList<xyLocation>();
	public ArrayList<xyLocation> originXY= new ArrayList<xyLocation>();

	public boolean isShipAlived()
	{
		if (alivedXY.size() == 0)
		{
			return true;
		}
		return false;
	}
	public abstract String getShipName();

	public abstract void placeOnMap(int origin_x, int origin_y, int orientation);


}
