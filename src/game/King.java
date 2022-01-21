package game;

public class King extends Ship
{

	@Override
	public void placeOnMap(int origin_x, int origin_y, int orientation)
	{
		originXY.add(new xyLocation(origin_x, origin_y));
		alivedXY.add(new xyLocation(origin_x, origin_y));
		alivedXY.add(new xyLocation(origin_x, origin_y));
	}

	@Override
	public String getShipName()
	{
		// TODO Auto-generated method stub
		return "King";
	}

}
