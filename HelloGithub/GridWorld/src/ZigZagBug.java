import info.gridworld.actor.Bug;

public class ZigZagBug extends Bug {
	int count = 0;

	public ZigZagBug() {
	}

	public void act() {
		if(canMove()) {
			if(count == 0) {
				move();
				count++;
			} else if(count == 1) {
				setDirection(270);
				count++;
			} else if(count ==2) {
				move();
				count++;
			} else if(count == 3) {
				setDirection(0);
				count = 0;
			}
		}
	}
}
