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
	static int step = 2;
	
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
			this.collisionDetect(GameLogic.entities.get(1));
			this.move(0, step);																																																	
		}
		
		if(KeyManager.isKeyPressed(Preferences.up)){
			this.collisionDetect(GameLogic.entities.get(1));
			this.move(0, -step);
		}
		
		if(KeyManager.isKeyPressed(Preferences.left)){
			this.collisionDetect(GameLogic.entities.get(1));
			this.move(-step, 0);
		}
		
		if(KeyManager.isKeyPressed(Preferences.right)){
			this.collisionDetect(GameLogic.entities.get(1));
			this.move(step, 0);
		}

		
		
	}
	
	@Override
	public void draw(Graphics g){
		g.drawImage(sprite, this.getX(), this.getY(), this.getW(), this.getH(), null);
	}

}
