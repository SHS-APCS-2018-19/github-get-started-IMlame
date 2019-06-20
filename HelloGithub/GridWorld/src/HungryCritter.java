import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;

public class HungryCritter extends ChameleonCritter{
	public void processActors(ArrayList<Actor> actors) {
		int n = actors.size();
		if(n == 0) {
			return;
		}
		int r = (int)(Math.random()*n);
		
		Actor other = actors.get(r);
		
		if(getColor().equals(other.getColor())) {
			other.removeSelfFromGrid();
		}
		setColor(other.getColor());

		
	}
	
}
