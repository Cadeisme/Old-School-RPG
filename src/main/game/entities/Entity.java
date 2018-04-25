package main.game.entities;

import java.awt.Graphics;
import java.util.ListIterator;
import main.game.utils.Vector;

public class Entity {
	
	private int x, y, w, h;
	private int posDiffOne, posDiffTwo, xPosDiff, yPosDiff;
	protected boolean movable;
	private boolean intersectsX, intersectsY;
	Vector v = new Vector();

	public Entity(int x, int y, int w, int h, boolean movable){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h= h;
		this.movable = movable;
	}
	
	public void collisionDetect(Entity other){
		
	if(other.getMovable()){	
		
		//Checks distance on the x axis
		
		posDiffOne = other.x - (this.x + this.w);
		posDiffTwo = (other.x + other.w) - this.x;
		
		xPosDiff = Math.abs(posDiffOne) < Math.abs(posDiffTwo) ? posDiffOne: posDiffTwo;
		
		//Checks distance on the y axis
		
		posDiffOne = other.y - (this.y - this.h);
		posDiffTwo = (other.y-other.h) - this.y;
			
		yPosDiff = Math.abs(posDiffOne) < Math.abs(posDiffTwo) ? posDiffOne : posDiffTwo;

		//intersectsX = 
		
		
		
	}
	
	else{
	
		
		
	}
		
		
		
	}
	
	
	
	public void setPos(int x, int y){
		setX(x);
		setY(y);
	}
	
	
	
	public void move(int xAmt, int yAmt){
		x+= xAmt;
		y+= yAmt;
	}
	
	
	
	public void destroy(ListIterator<Entity> itr){
		itr.remove();
	}
	
	
	
	
	public void tick(ListIterator<Entity> itr){
		
	}
	
	
	
	public void draw(Graphics g){
		g.drawRect(x, y, w, h);
	}
	
	public boolean getMovable(){
		return movable;
	}
	
	public void setMovable(boolean movable){
		this.movable = movable;
	}
	
	public int getX() {
		return x;
	}

	
	
	public void setX(int x) {
		this.x = x;
	}

	
	
	public int getY() {
		return y;
	}

	
	
	public void setY(int y) {
		this.y = y;
	}

	
	
	public int getW() {
		return w;
	}

	
	
	public void setW(int w) {
		this.w = w;
	}

	
	
	public int getH() {
		return h;
	}

	
	
	public void setH(int h) {
		this.h = h;
	}
	
}
