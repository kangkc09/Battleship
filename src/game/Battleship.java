package game;

public class Battleship extends Ship
{

	@Override
	public void placeOnMap(int origin_x, int origin_y, int orientation)
	{
		/*
		 * x
		 * x
		 * x
		 * x
		 * x
		 */
		if(orientation%2 == 0)
		{
			/*
			 * x
			 * x
			 * x
			 * x
			 * x
			 */
			originXY.add(new xyLocation(origin_x, origin_y));
			originXY.add(new xyLocation(origin_x, origin_y+1));
			originXY.add(new xyLocation(origin_x, origin_y+2));
			originXY.add(new xyLocation(origin_x, origin_y+3));
			originXY.add(new xyLocation(origin_x, origin_y+4));	
			alivedXY.add(new xyLocation(origin_x, origin_y));
			alivedXY.add(new xyLocation(origin_x, origin_y+1));
			alivedXY.add(new xyLocation(origin_x, origin_y+2));
			alivedXY.add(new xyLocation(origin_x, origin_y+3));
			alivedXY.add(new xyLocation(origin_x, origin_y+4));			
		}
		else
		{
			/*
			 * xxxxx
			 */
			originXY.add(new xyLocation(origin_x, origin_y));
			originXY.add(new xyLocation(origin_x+1, origin_y));
			originXY.add(new xyLocation(origin_x+2, origin_y));
			originXY.add(new xyLocation(origin_x+3, origin_y));
			originXY.add(new xyLocation(origin_x+4, origin_y));	
			alivedXY.add(new xyLocation(origin_x, origin_y));
			alivedXY.add(new xyLocation(origin_x+1, origin_y));
			alivedXY.add(new xyLocation(origin_x+2, origin_y));
			alivedXY.add(new xyLocation(origin_x+3, origin_y));
			alivedXY.add(new xyLocation(origin_x+4, origin_y));			
		}
		
	}

	@Override
	public String getShipName()
	{
		// TODO Auto-generated method stub
		return "Battleship";
	}


}
