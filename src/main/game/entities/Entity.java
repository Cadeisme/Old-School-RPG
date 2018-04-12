package main.game.entities;

import java.awt.Graphics;
import java.util.ListIterator;

import main.game.GameLogic;
import main.game.preferences.Preferences;

public class Entity {
	
	private int x, y, w, h;

	public Entity(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h= h;
	}
	
	public void setPos(int x, int y){
		setX(x);
		setY(y);
	}
	
	public void move(int xAmt, int yAmt){
		x+= xAmt;
		y+= yAmt;
	}
	
	public boolean collisionDetect(Entity other){
		
		switch(GameLogic.lastKey){
		
		case Preferences.down:
			if(this.y + h + Player.moveSpeed >= other.y && this.y + Player.moveSpeed < other.y && (this.x + w + Player.moveSpeed >= other.x && this.x + Player.moveSpeed < other.x || this.x + Player.moveSpeed <= other.x + w && this.x + w + Player.moveSpeed > other.x)){
				move(0, -Player.moveSpeed);
				return true;
			}
			break;
		
		case Preferences.up:
			if(this.y + Player.moveSpeed <= other.y + h && this.y + h + Player.moveSpeed > other.y + h && (this.x + w + Player.moveSpeed >= other.x && this.x + Player.moveSpeed < other.x || this.x + Player.moveSpeed <= other.x + w && this.x + w + Player.moveSpeed > other.x)){
				move(0, Player.moveSpeed);
				return true;
			}
			break;
			
		case Preferences.right:
			if(this.x + w + Player.moveSpeed >= other.x && this.x + Player.moveSpeed < other.x && (this.y + Player.moveSpeed <= other.y + h && this.y + h + Player.moveSpeed > other.y + h || this.y + h + Player.moveSpeed >= other.y && this.y + Player.moveSpeed < other.y)){
				move(-Player.moveSpeed, 0);
				return true;
			}
			break;
			
		case Preferences.left:
			if(this.x + Player.moveSpeed <= other.x + w && this.x + w + Player.moveSpeed > other.x && (this.y + Player.moveSpeed <= other.y + h && this.y + h + Player.moveSpeed > other.y + h || this.y + h + Player.moveSpeed >= other.y && this.y + Player.moveSpeed < other.y)){
				move(Player.moveSpeed, 0);
				return true;
			}
			break;
		
		default: return false;
		}
		return false;
	}
	
	public void destroy(ListIterator<Entity> itr){
		itr.remove();
	}
	
	
	public void tick(ListIterator<Entity> itr){
		
	}
		
	public void draw(Graphics g){
		g.drawRect(x, y, w, h);
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
