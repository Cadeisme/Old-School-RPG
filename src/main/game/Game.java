package main.game;

import main.game.display.Display;
import main.game.display.Renderer;

public class Game {
	
	public static boolean isRunning = true; //sets the running variable to true
	
	public static void main(String args[]){
		Display.init(); //first initializes the display
		
		new Renderer().start(); //starts to render
		
		new GameLogic().start(); //starts to update
	}
	
}
