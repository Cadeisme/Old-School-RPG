package main.game;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import main.game.display.Renderer;
import main.game.entities.Entity;
import main.game.entities.Player;
import main.game.platforms.Platform;
import main.game.preferences.Preferences;

public class GameLogic extends Thread{
	
	public static List<Entity> entities = Collections.synchronizedList(new ArrayList<Entity>());
	
	public static int lastKey = 0;
	
	public void run(){
		
		long futureTime;
		
		entities.add(new Player(0, 0, 64, 64, 20));
		entities.add(new Platform(500, 500, 32, 32));
		
		while(Game.isRunning){
			
			tick();
			
			futureTime = System.currentTimeMillis() + Preferences.TARGET_UPS; //keeps the fps at 60
			
			while(System.currentTimeMillis() < futureTime){
				try{
					sleep(1);
				} catch(InterruptedException e){ 
					e.printStackTrace();
				}
			}
			
		}
	}

	private void tick() {
		
		for(ListIterator<Entity> itr = entities.listIterator(); itr.hasNext();){
			itr.next().tick(itr);
		}
		
	}
	
	
}
