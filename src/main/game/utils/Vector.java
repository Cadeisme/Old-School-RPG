package main.game.utils;

public class Vector {

	
	private int y, x;
	
	public Vector(){
		x = 0;
		y = 0;
	}
	
	public void setVector(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
}
