package main.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener { //Is able to read what keys the user is pressing
		
		private static boolean[] keys; //Creates a boolean table called keys
		
		public KeyManager(){
			keys = new boolean[256]; //Initializes the keys table
		}

		public void keyPressed(KeyEvent e) {
			keys[e.getKeyCode()] = true; //if the key is pressed, set the value in the keys table to true
		}

		public void keyReleased(KeyEvent e) {
			keys[e.getKeyCode()] = false;  //if the key is released set the keys value back to false
		}

		@Override
		public void keyTyped(KeyEvent e) {} //we don't use this
		
		
		public static boolean isKeyPressed(int key){
			return keys[key]; //returns the key
		}
	}