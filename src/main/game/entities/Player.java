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

public class Player extends Creature{

	private BufferedImage sprite;
	
	public static int moveSpeed = 2;
	
	//Constructors
	public Player(int x, int y, int w, int h, int hp) {
		super(x, y, w, h, hp);
		
		
		try{
			sprite = ImageIO.read(new File("Assets/Temp.png")); //tries to set the player image
		}catch (IOException e){
			e.printStackTrace(); //if not returns the error
		}
	}
	
	
	
	@Override
	public void tick(ListIterator<Entity> itr){
		
		if(KeyManager.isKeyPressed(Preferences.down)){ //TODO change the method so that the character doesn't clip through platforms
			
			this.move(0, moveSpeed); //if i press s the character moves down
			
			this.collisionDetect(Renderer.tes);
			
			GameLogic.lastKey = Preferences.down;
		}
		
		if(KeyManager.isKeyPressed(Preferences.up)){
			
			this.move(0, -moveSpeed); //if i press s the character moves down
			
			this.collisionDetect(Renderer.tes);
			
			GameLogic.lastKey = Preferences.up;
		}
		
		if(KeyManager.isKeyPressed(Preferences.left)){
			
			this.move(-moveSpeed, 0); //if i press a the character moves left
			
			this.collisionDetect(Renderer.tes);
			
			GameLogic.lastKey = Preferences.left;
		}
		
		if(KeyManager.isKeyPressed(Preferences.right)){
			
			this.move(moveSpeed, 0); //if i press d the character moves right		
			
			this.collisionDetect(Renderer.tes);
			
			GameLogic.lastKey = Preferences.right;
		}

		
		
	}
	
	@Override
	public void draw(Graphics g){
		g.drawImage(sprite, this.getX(), this.getY(), this.getW(), this.getH(), null);
	}

}
