package main.game.entities;

public class Creature extends Entity{

	private int hp;
	
	public Creature(int x, int y, int w, int h, int hp) {
		super(x, y, w, h);
		
		this.hp = hp;
	}

}
