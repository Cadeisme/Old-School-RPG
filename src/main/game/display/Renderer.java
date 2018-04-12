package main.game.display;

import java.awt.Graphics;
import java.util.Iterator;

import main.game.GameLogic;
import main.game.entities.Entity;
import main.game.platforms.Platform;
import main.game.preferences.Preferences;
import main.game.worlds.World;

public class Renderer extends Thread{
	
	static World test = new World();
	
	public static Platform tes = new Platform(500, 500, 32, 32);
	
	public void update(){
		Display.window.repaint();
	}
	
	public void run(){
		
		long futureTime; //sets future time for ups
	
		while(main.game.Game.isRunning){
		
			update(); //updates the canvas
		
			futureTime = System.currentTimeMillis() + Preferences.TARGET_FPS; //sets future time so that fps will work
		
			while(System.currentTimeMillis() < futureTime){ //if it updates too fast it will wait
				try{
					sleep(1);
				} catch(InterruptedException e){ //prints out any errors
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void Render(Graphics g){
		test.draw(g, 0);
		
		tes.draw(g);
		
		for(Iterator<Entity> itr = GameLogic.entities.iterator(); itr.hasNext();){
			itr.next().draw(g);
		}
	}
}
