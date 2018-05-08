package main.game.entities;

import java.awt.Graphics;
import java.util.ListIterator;
import main.game.utils.Vector;

public class Entity {
	
	private int x, y, w, h;
	private int posDiffOne, posDiffTwo, xPosDiff, yPosDiff, projection;
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
		
		
		//Checks distance on the x axis
		
		posDiffOne = other.x - (this.x + this.w);
		posDiffTwo = (other.x + other.w) - this.x;
				
		xPosDiff = Math.abs(posDiffOne) < Math.abs(posDiffTwo) ? posDiffOne: posDiffTwo;
				
		//Checks distance on the y axis
				
		posDiffOne = other.y - (this.y - this.h);
		posDiffTwo = (other.y-other.h) - this.y;
					
		yPosDiff = Math.abs(posDiffOne) < Math.abs(posDiffTwo) ? posDiffOne : posDiffTwo;

		//Check intersection distances
		intersectsX = Math.abs(xPosDiff) < Integer.signum(xPosDiff)*(this.v.getX()-other.v.getX());
		intersectsY = Math.abs(yPosDiff) < Integer.signum(yPosDiff)*(this.v.getY()-other.v.getY());
				
		if(intersectsX && intersectsY){
			intersectsX = Math.abs(xPosDiff) < Math.abs(yPosDiff);
		}
		
		if(other.getMovable()){	
		
		if(intersectsX){
			//Collide on x axis
			int velocityRemainder = this.v.getX() - other.v.getX() - xPosDiff;
				if(xPosDiff < 0){
					//on my left side
					
					
					int absVX1 = Math.abs(this.v.getX());
					int absVX2 = Math.abs(other.v.getX());
					
					//int velocityRemainder = this.v.x - other.v.x - xPosDiff;
					
					int additionalVelocity;
					
					
					// sqrt((mv^2)/(m1+m2)) = v
					
					if(absVX1 > absVX2){
						
						//additionalVelocity = Integer.signum(velocityRemainder) * Math.sqrt((this.m*Math.pow(velocityRemainder,2))/(this.m+other.m));
							
					}else{
						
						//additionalVelocity = Integer.signum(velocityRemainder) * Math.sqrt((other.m*Math.pow(velocityRemainder,2))/(this.m+other.m));
						
					}
					
				}else{
					//on my right side
					
					
				}
		}else{
			//Collide on y axis
				if(yPosDiff < 0){
					//on my bottom
				}else{
					//on my top
				}
		}
	}
		
		else{
			//Non moveable entity
				
			if(intersectsX){

				if(xPosDiff < 0){ //on left side

					projection = this.x + this.w + Player.step; 

					if(projection > other.x){
						this.move(xPosDiff, 0);
					}

				}

				else{
					projection = this.x - Player.step;

					if(projection < other.x){
						this.move(-xPosDiff, 0);
					}
				}


			}

			else{

				if(yPosDiff < 0){ //below
					
					projection = this.y + this.h + Player.step;

					if(projection < other.y + other.h){
						this.move(0, yPosDiff);
					}

				}

				else{
					projection = this.y - Player.step;

					if(projection > other.y){
						this.move(0, -yPosDiff);
					}

				}


			}
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
