package player;

import java.util.ArrayList;
import java.util.Stack;

public class SHWAI extends abstractAI
{

	private int myX;
	private int myY;
	private boolean isDestroyShip= true;
	private int shipStartX;
	private int shipStartY;
	private boolean canDown=true;
	private boolean canUp=true;
	private boolean canRight=true;
	private boolean canLeft=true;
	private int guessWhere=0;
	private boolean notKing=false;
	private boolean speical=false;
	private ArrayList<Integer> pickTwice=new ArrayList<>();
	private Stack<Integer> tempArray=new Stack<>();
	private int temp;
	@Override
	public int getPatrolBoatPositionX()
	{
		return 8;
		
	}

	@Override
	public int getPatrolBoatPositionY()
	{
		return 5;
		
	}

	@Override
	public int getPatrolBoatOrientation()
	{
		return CW_90DEG;
		
	}

	@Override
	public int getDestroyerPositionX()
	{
		return 9;
		
	}

	@Override
	public int getDestroyerPositionY()
	{
		return 7;
		
	}

	@Override
	public int getDestroyerOrientation()
	{
		return CW_180DEG;
		
	}

	@Override
	public int getCruiserPositionX()
	{
		return 5;
		
	}

	@Override
	public int getCruiserPositionY()
	{
		return 2;
		
	}

	@Override
	public int getCruiserOrientation()
	{
		return CW_0DEG;
		
	}

	@Override
	public int getBattleshipPositionX()
	{
		return 5;
		
	}

	@Override
	public int getBattleshipPositionY()
	{
		return 0;
		
	}

	@Override
	public int getBattleshipOrientation()
	{
		return CW_90DEG;
		
	}

	@Override
	public int getSubmarinePositionX()
	{
		return 2;
		
	}

	@Override
	public int getSubmarinePositionY()
	{
		return 6;
		
	}

	@Override
	public int getSubmarineOrientation()
	{
		return CW_270DEG;
		
	}

	@Override
	public int getAircraftCarrierPositionX()
	{
		return 2;
		
	}

	@Override
	public int getAircraftCarrierPositionY()
	{
		return 0;
		
	}

	@Override
	public int getAircraftCarrierOrientation()
	{
		return CW_180DEG;
		
	}

	@Override
	public int getKingPositionX()
	{
		return 1;
		
	}

	@Override
	public int getKingPositionY()
	{
		return 5;
		
	}


	public void guessWherePlus1() {
		guessWhere=(guessWhere+1)%4;
	}
	public void guessDown() {
		myY++;
	}
	public void guessUp() {
		myY--;
	}
	public void guessRight() {
		myX++;
	}
	public void guessLeft() {
		myX--;
	}
	public int guess() {
		canDown=true;
		canUp=true;
		canRight=true;
		canLeft=true;
		notKing=false;
		while(true) {
			switch(guessWhere) {
			case 0:
				if(myY==9) {
					canDown=false;
					guessWherePlus1();
				}
				else if(map[myY+1][myX]!=0) {
					canDown=false;
					guessWherePlus1();
					if(map[myY+1][myX]==1) {
						notKing=true;
					}
				}
				else {
					guessDown();
					guessWhere=0;
					return 0;
				}
				break;
			case 1:
				if(myY==0) {
					canUp=false;
					guessWherePlus1();
				}
				else if(map[myY-1][myX]!=0) {
					canUp=false;
					guessWherePlus1();
					if(map[myY-1][myX]==1) {
						notKing=true;
					}
				}
				else {
					guessUp();
					guessWhere=1;
					return 0;
				}
				break;
			case 2:
				if(myX==9) {
					canRight=false;
					guessWherePlus1();
				}
				else if(map[myY][myX+1]!=0) {
					canRight=false;
					guessWherePlus1();
					if(map[myY][myX+1]==1) {
						notKing=true;
					}
				}
				else {
					guessRight();
					guessWhere=2;
					return 0;
				}
			case 3:
				if(myX==0) {
					canLeft=false;
					guessWherePlus1();
				}
				else if(map[myY][myX-1]!=0) {
					canLeft=false;
					guessWherePlus1();
					if(map[myY][myX-1]==1) {
						notKing=true;
					}
				}
				else {
					guessLeft();
					guessWhere=3;
					return 0;
				}
			}
			if(!canDown&&!canUp&&!canRight&&!canLeft) {
				if(notKing) {
					temp=tempArray.pop();
					System.out.println("1: "+temp);
					shipStartX=temp/10;
					shipStartY=temp%10;
					myX=shipStartX;
					myY=shipStartY;
					return guess();
				}
				else {
					return 0;
				}
			}
		}
	}
	
	public void makeX(int x, int y) {
		if(y>0) {
			if(x>0) {
				if(map[y-1][x-1]==0)
					map[y-1][x-1]=-1;
			}
			if(map[y-1][x]==0)
				map[y-1][x]=-1;
			if(x<9) {
				if(map[y-1][x+1]==0)
					map[y-1][x+1]=-1;
			}
		}
		if(x>0) {
			if(map[y][x-1]==0)
				map[y][x-1]=-1;
		}
		if(x<9) {
			if(map[y][x+1]==0)
				map[y][x+1]=-1;
		}
		if(y<9) {
			if(x>0) {
				if(map[y+1][x-1]==0)
					map[y+1][x-1]=-1;
			}
			if(map[y+1][x]==0)
				map[y+1][x]=-1;
			if(x<9) {
				if(map[y+1][x+1]==0)
					map[y+1][x+1]=-1;
			}
		}
		
	}
	public void destroyShip() {
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(map[i][j]>1) {
					makeX(j,i);
				}
			}
		}
	}
	public boolean isPickTwiceAlready() {
		if(pickTwice.contains(myX*10+myY)) {
			return true;
		}
		return false;
	}
	public boolean isWrongPick() {
		if(map[myY][myX]==-1) {
			return true;
		}
		if(map[myY][myX]>1) {
			return true;
		}
		if(isPickTwiceAlready()) {
			return true;
		}
		return false;
	}
	public void randomPick() {
		while(isWrongPick()) {
			setXYRandom();
		}
	}
	public void listOnPickTwice() {
		if(map[myY][myX]==1) {
			pickTwice.add(myX*10+myY);
		}
	}
	public void setXYRandom() {
		myX=randomSelecter.nextInt(10);
		myY=randomSelecter.nextInt(10);
	}
	@Override
	public int getBoomX()
	{
		
		if(map[myY][myX]==1 &&isDestroyShip) { //find ship initial
			tempArray.push(myX*10+myY);
			shipStartX=myX;
			shipStartY=myY;
			isDestroyShip=false;
			guess();
		}
		else if(map[myY][myX]==1&& !isDestroyShip) { //find ship finding ship
			tempArray.push(myX*10+myY);
			guess();
		}
		else if(map[myY][myX]==-1&& !isDestroyShip) { //missed but finding ship
			myX=shipStartX;
			myY=shipStartY;
			guessWherePlus1();
			guess();
		}
		else if(map[myY][myX]>1&&!isDestroyShip) { //find ship and destroyed ship
			isDestroyShip=true;
			setXYRandom(); //myX, myY update
			randomPick();
			listOnPickTwice();
			guessWhere=0;
			destroyShip();
			tempArray.clear();
		}
		else if(map[myY][myX]==-1&&isDestroyShip) { //missed and not finding ship
			setXYRandom(); //myX, myY update
			randomPick();
			listOnPickTwice();
		}
		else{	//don't know what situation
			setXYRandom(); //myX, myY update
			randomPick();
			listOnPickTwice();
		}
		return myX;
	}

	@Override
	public int getBoomY()
	{
		// TODO Auto-generated method stub
		return myY;
	}

}
