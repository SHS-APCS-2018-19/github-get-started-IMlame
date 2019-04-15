import java.awt.Color;

import info.gridworld.actor.Flower;

public class DyingFlower extends Flower{
	private int lifeTime = 0;
	
	public DyingFlower(int lifeTime) {
		this.lifeTime = lifeTime;
	}
	
	public void act() {
		if(lifeTime > -1) {
			lifeTime--;
		} else {
			removeSelfFromGrid();
		}
	}
}
