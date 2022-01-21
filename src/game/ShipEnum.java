package game;

public enum ShipEnum
{
	PatrolBoat{
		public int shipSizeX(){
			return 1;
		}
		public int shipSizeY(){
			return 2;
		}
	},
	Destroyer{
		public int shipSizeX(){
			return 1;
		}
		public int shipSizeY(){
			return 3;
		}
	},
	Cruiser{
		public int shipSizeX(){
			return 1;
		}
		public int shipSizeY(){
			return 4;
		}
	},
	Battleship{
		public int shipSizeX(){
			return 1;
		}
		public int shipSizeY(){
			return 5;
		}
	},
	Submarine{
		public int shipSizeX(){
			return 2;
		}
		public int shipSizeY(){
			return 3;
		}
	},
	AircraftCarrier{
		public int shipSizeX(){
			return 2;
		}
		public int shipSizeY(){
			return 4;
		}
	},
	King{
		public int shipSizeX(){
			return 1;
		}
		public int shipSizeY(){
			return 1;
		}
	};
	abstract public int shipSizeX();
	abstract public int shipSizeY();
}
