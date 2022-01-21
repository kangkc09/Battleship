package game;

public class PatrolBoat extends Ship
{

	@Override
	public void placeOnMap(int origin_x, int origin_y, int orientation)
	{
		/*
		 * x
		 * x
		 */
		if(orientation%2 == 0)
		{
			/*
			 * x
			 * x
			 */
			originXY.add(new xyLocation(origin_x, origin_y));
			originXY.add(new xyLocation(origin_x, origin_y+1));
			alivedXY.add(new xyLocation(origin_x, origin_y));
			alivedXY.add(new xyLocation(origin_x, origin_y+1));
		}
		else
		{
			/*
			 * xx
			 */
			originXY.add(new xyLocation(origin_x, origin_y));
			originXY.add(new xyLocation(origin_x+1, origin_y));
			alivedXY.add(new xyLocation(origin_x, origin_y));
			alivedXY.add(new xyLocation(origin_x+1, origin_y));			
		}	
	}

	@Override
	public String getShipName()
	{
		// TODO Auto-generated method stub
		return "PatrolBoat";
	}
}
