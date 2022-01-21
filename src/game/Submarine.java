package game;

public class Submarine extends Ship
{

	@Override
	public void placeOnMap(int origin_x, int origin_y, int orientation)
	{
		/*
		 * x
		 * xx
		 * x
		 */
		if(orientation == 0)
		{
			/*
			 * x
			 * xx
			 * x
			 */
			originXY.add(new xyLocation(origin_x, origin_y));
			originXY.add(new xyLocation(origin_x, origin_y+1));
			originXY.add(new xyLocation(origin_x+1, origin_y+1));
			originXY.add(new xyLocation(origin_x, origin_y+2));
			alivedXY.add(new xyLocation(origin_x, origin_y));
			alivedXY.add(new xyLocation(origin_x, origin_y+1));
			alivedXY.add(new xyLocation(origin_x+1, origin_y+1));
			alivedXY.add(new xyLocation(origin_x, origin_y+2));
		}
		else if(orientation == 1)
		{
			/*
			 * xxx
			 *  x
			 */
			originXY.add(new xyLocation(origin_x, origin_y));
			originXY.add(new xyLocation(origin_x+1, origin_y));
			originXY.add(new xyLocation(origin_x+1, origin_y+1));
			originXY.add(new xyLocation(origin_x+2, origin_y));		
			alivedXY.add(new xyLocation(origin_x, origin_y));
			alivedXY.add(new xyLocation(origin_x+1, origin_y));
			alivedXY.add(new xyLocation(origin_x+1, origin_y+1));
			alivedXY.add(new xyLocation(origin_x+2, origin_y));			
		}
		else if(orientation == 2)
		{
			/*
			 *  x
			 * xx
			 *  x
			 */
			originXY.add(new xyLocation(origin_x+1, origin_y));
			originXY.add(new xyLocation(origin_x, origin_y+1));
			originXY.add(new xyLocation(origin_x+1, origin_y+1));
			originXY.add(new xyLocation(origin_x+1, origin_y+2));
			alivedXY.add(new xyLocation(origin_x+1, origin_y));
			alivedXY.add(new xyLocation(origin_x, origin_y+1));
			alivedXY.add(new xyLocation(origin_x+1, origin_y+1));
			alivedXY.add(new xyLocation(origin_x+1, origin_y+2));
			
		}
		else
		{
			/*
			 *  x
			 * xxx
			 */
			originXY.add(new xyLocation(origin_x, origin_y+1));
			originXY.add(new xyLocation(origin_x+1, origin_y));
			originXY.add(new xyLocation(origin_x+1, origin_y+1));
			originXY.add(new xyLocation(origin_x+2, origin_y+1));
			alivedXY.add(new xyLocation(origin_x, origin_y+1));
			alivedXY.add(new xyLocation(origin_x+1, origin_y));
			alivedXY.add(new xyLocation(origin_x+1, origin_y+1));
			alivedXY.add(new xyLocation(origin_x+2, origin_y+1));			
			
		}
	}

	@Override
	public String getShipName()
	{
		// TODO Auto-generated method stub
		return "Submarine";
	}


}
