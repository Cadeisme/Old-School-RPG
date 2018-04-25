package main.game.entities;

public class Creature extends Entity{

	private int hp;
	
	public Creature(int x, int y, int w, int h, int hp, boolean movable) {
		super(x, y, w, h, movable);
		
		this.hp = hp;
		
		this.movable = movable;
	}

}
