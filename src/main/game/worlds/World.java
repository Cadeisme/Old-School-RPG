package main.game.worlds;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import main.game.platforms.Platform;
import main.game.preferences.Preferences;

public class World {
	
	BufferedImage[] worlds = new BufferedImage[5];
	
	ArrayList<Platform> edges = new ArrayList<Platform>();
	
	public World(){
		try {
			worlds[0] = ImageIO.read(new File("Assets/CollisionTest.png"));
		} catch (IOException e) {
			System.out.println("The world image doesn't exist or failed to load. \n Try checking if the path is correct");
			e.printStackTrace();
		}
	}
	
	public void Edge(BufferedImage map){
		for(int y = 0; y < Preferences.SCREEN_HEIGHT; y++){ //Goes through each pixel of the map
			for(int x = 0; x < Preferences.SCREEN_WIDTH; x++){
				if(map.getRGB(x, y) != 0xFFFFFF){ //if the pixel isn't white make a platform}
					edges.add(new Platform(x, y, Preferences.platW, Preferences.platH));
					x += Preferences.platW; y+= Preferences.platH;
					System.out.println(edges.toString());
				}
			}
		}
			
	}
	
	public void draw(Graphics g, int level){
		g.drawImage(worlds[level], 0, 0, Preferences.SCREEN_WIDTH, Preferences.SCREEN_HEIGHT, null);
	}
}
