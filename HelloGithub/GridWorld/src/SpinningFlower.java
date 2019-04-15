import java.awt.Color;

import info.gridworld.actor.Flower;

public class SpinningFlower extends Flower{
	int x = 0;
	
	public SpinningFlower(Color col) {
		super(col);
	}
	public void act() {
		super.act();
		x += 180;
		super.setDirection(x);
	}
	
}
