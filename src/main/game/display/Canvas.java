package main.game.display;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import main.game.preferences.Preferences;

@SuppressWarnings("serial")
public class Canvas extends JPanel { //is a subclass of jPanel
	
	@Override
	public Dimension getPreferredSize(){ //creates a canvas of the preferred resolution
		return new Dimension(Preferences.SCREEN_WIDTH, Preferences.SCREEN_HEIGHT);
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g); //passes in g to the JPanel
		Renderer.Render(g); //Renders the game
	}
}