package main.game.preferences;

import java.awt.event.KeyEvent;

public class Preferences {
	
	//Sets resolution
	public static final int SCREEN_WIDTH = 1320;
	public static final int SCREEN_HEIGHT = 720;
		
	//Sets FPS and UPS preferential values
	public static final long TARGET_FPS = 1000/60;
	public static final long TARGET_UPS = 1000/60;
		
	//Sets key bindings
	public static final int up = KeyEvent.VK_W;
	public static final int down = KeyEvent.VK_S;
	public static final int left = KeyEvent.VK_A;
	public static final int right = KeyEvent.VK_D;
	
	//Test Code
	//Only works if the resolution is 32 pixels maybe
	public static int platW = (1/32) * SCREEN_WIDTH;
	public static int platH = (1/32) * SCREEN_HEIGHT;

}
