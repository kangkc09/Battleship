package player;

public class SampleAI extends abstractAI
{
	/*
	 * notice
	 * 1. fill getShipPositionX, Y and orientation
	 * 2. you will get latest map from BSGameCore by setMap
	 * 2-1 map[y][x]=0 is never found yet
	 * 2-2 map[y][x]=1 is success but cannot destroy ship yet
	 * 2-3 map[y][x]=-1 is your attack is missed
	 * 2-4 map[y][x]= 2 is you destroyed PatrolBoat
	 * 2-5 map[y][x]= 3 is you destroyed Destroyed
	 * 2-6 map[y][x]= 4 is you destroyed Cruiser
	 * 2-7 map[y][x]= 5 is you destroyed Battleship
	 * 2-8 map[y][x]= 6 is you destroyed Submarine
	 * 2-9 map[y][x]= 7 is you destroyed AircraftCarrier
	 * 2-10 map[y][x]= 8 is you destroyed King
	 * 3. according to map, you fill getBoomX and getBoomY
	 * 4. your objective is destroy all ships except king or attack king twice
	 */
	
	
	
	@Override
	public int getPatrolBoatPositionX()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPatrolBoatPositionY()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPatrolBoatOrientation()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDestroyerPositionX()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDestroyerPositionY()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDestroyerOrientation()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCruiserPositionX()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCruiserPositionY()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCruiserOrientation()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBattleshipPositionX()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBattleshipPositionY()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBattleshipOrientation()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSubmarinePositionX()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSubmarinePositionY()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSubmarineOrientation()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAircraftCarrierPositionX()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAircraftCarrierPositionY()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAircraftCarrierOrientation()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getKingPositionX()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getKingPositionY()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBoomX()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBoomY()
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
