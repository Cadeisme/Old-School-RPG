package main.game.display;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import main.game.Game;
import main.game.input.KeyManager;

public class Display {

	public static JFrame window;
	
	
	public static void init(){ //creates the initialization function that we call in the main method
		
		window = new JFrame("RPG THING"); //creates a new window
		
		
		WindowListener exitListener = new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){  //Sets the isRunning boolean to false when the window is closed
				Game.isRunning = false;
			}
		};
		
		/*window.createBufferStrategy(3);
		
		BufferStrategy buffer = window.getBufferStrategy();*/
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Closes JFrame on close
		
		window.addWindowListener(exitListener); //creates the ability to change the isRunning boolean
		
		window.addKeyListener(new KeyManager()); //Implements keyManager into the window
		
		window.add(new Canvas()); //Creates the canvas to draw on
		
		window.pack(); //Packs the window components all together
		
		window.setVisible(true); //Sets the window to visible
	}
	
}
