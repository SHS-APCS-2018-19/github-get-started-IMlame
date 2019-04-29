import info.gridworld.actor.Bug;

public class CircleBug extends Bug{
	int count = 0;
	public void act() {
		count++;
		if(count%3 == 0) {
			turn();
		} else {
			move();
		}
	}
}
