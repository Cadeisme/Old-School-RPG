package main.game.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ListIterator;

import javax.imageio.ImageIO;

import main.game.GameLogic;
import main.game.display.Renderer;
import main.game.input.KeyManager;
import main.game.preferences.Preferences;
import main.game.utils.Vector;

public class Player extends Creature{

	private BufferedImage sprite;
	
	int posDifOne, posDifTwo;
	
	//Constructors
	public Player(int x, int y, int w, int h, int hp) {
		super(x, y, w, h, hp, false);
		
		
		try{
			sprite = ImageIO.read(new File("Assets/test.png")); //tries to set the player image
		}catch (IOException e){
			e.printStackTrace(); //if not returns the error
		}
	}
	
	
	
	@Override
	public void tick(ListIterator<Entity> itr){

		if(KeyManager.isKeyPressed(Preferences.down)){ //TODO change the method so that the character doesn't clip through platforms
			this.v.setVector(0, 1);
			
			this.move(v);
		}
		
		if(KeyManager.isKeyPressed(Preferences.up)){
			
		}
		
		if(KeyManager.isKeyPressed(Preferences.left)){
			
		}
		
		if(KeyManager.isKeyPressed(Preferences.right)){
			
			
		}

		
		
	}
	
	@Override
	public void draw(Graphics g){
		g.drawImage(sprite, this.getX(), this.getY(), this.getW(), this.getH(), null);
	}

}
