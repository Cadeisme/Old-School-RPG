package main.game.platforms;

import java.awt.Color;
import java.awt.Graphics;

import main.game.entities.Entity;

public class Platform extends Entity{

	public Platform(int x, int y, int w, int h) {
		super(x, y, w, h, false);
	}
	
	public void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(getX(), getY(), getW(), getH());
	}

}
