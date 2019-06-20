import ihs.apcs.spacebattle.BasicEnvironment;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.util.List;

import ihs.apcs.spacebattle.*;
import ihs.apcs.spacebattle.commands.*;
import ihs.apcs.spacebattle.BasicSpaceship;
import ihs.apcs.spacebattle.RegistrationData;
import ihs.apcs.spacebattle.commands.ShipCommand;
import ihs.apcs.spacebattle.games.BaubleHuntGameInfo;
import ihs.apcs.spacebattle.BasicGameInfo;

public class RotatorShip extends BasicSpaceship {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// run method on TextClient with the IP Address and an instance of your Ship
		// class.10.52.105.88
		ihs.apcs.spacebattle.TextClient.main(new String[] { "10.52.105.88", "RotatorShip", "2020" });
	}

	private int currentState = 0;
	private static double speed = 0;
	Point energy = null;
	//1122.000000, 502.000000
	int rotated = 0;

	@Override

	public ShipCommand getNextCommand(BasicEnvironment env) {
		ObjectStatus ship = env.getShipStatus();
		Point position = ship.getPosition();
		int orientation = ship.getOrientation();
		BaubleHuntGameInfo info = (BaubleHuntGameInfo) env.getGameInfo();
		Point outpost = info.getObjectiveLocation();

		RadarResults results = new RadarResults();
		currentState++;

		switch (currentState) {
		case 1:
			if (energy != null) {
				System.out.println("energy isn't null, rotating toward");
				currentState = 4;
			}
			RadarCommand radar = new RadarCommand(4);
			System.out.println("scanned");
			return radar;

		case 2:
			results = env.getRadar();
			if (energy == null && results.getByType("Star") != null && results.getByType("Star").size() > 0) {
				System.out.println("found star");
				energy = results.getByType("Star").get(0).getPosition();
				System.out.println(energy);
				// energy = results.getByType("Star").get(0).getPosition();
			} else if (energy == null && results.getByType("Nebula") != null
					&& results.getByType("Nebula").size() > 0) {
				System.out.println("found nebula");
				energy = results.getByType("Nebula").get(0).getPosition();
				System.out.println(energy);
			}
			List<ObjectStatus> babules = results.getByType("Bauble");
			System.out.println(info.getNumBaublesCarried());
			if (info.getNumBaublesCarried() > 3) {
				System.out.println("collected babule, heading to outpost");
				if (outpost != null) {
					return new RotateCommand(position.getAngleTo(outpost) - orientation);
				}
			}
			double distance = 10000;
			int closestIndex = -1;
			for (int i = 0; i < babules.size(); i++) {
				if (babules.get(i).getPosition().getDistanceTo(position) < distance) {
					distance = babules.get(i).getPosition().getDistanceTo(position);
					closestIndex = i;
				}
			}
			if (closestIndex != -1) {
				return new RotateCommand(position.getAngleTo(babules.get(closestIndex).getPosition()) - orientation);
			}
		case 3:
			return new ThrustCommand('B', 5, 1);
		case 4:
			System.out.println("case 4");
			if (energy != null) {
				currentState = 4;
			} else {

				currentState = 0;
				return new BrakeCommand(0.001);
			}

		case 5:
			// head to star
			System.out.println("heading to star");
			if (ship.isInCelestialBody()) {
				return new BrakeCommand(0.001);
			}
			return new RotateCommand(position.getAngleTo(energy) - orientation);

		case 6:

			if (!ship.isInCelestialBody()) {
				currentState = 4;
				return new ThrustCommand('B', 1.5, 0.5);
			} else if (ship.getEnergy() < 50) {
				System.out.println("scoop lowered");
				return new LowerEnergyScoopCommand(true);
			} else if (ship.getHealth() < 75) {
				System.out.println("healing");
				return new RepairCommand(99);
			} else if (rotated < 3) {
				rotated++;
				System.out.println("firing");
				currentState = 5;
				return new FireTorpedoCommand('F');
			} else {
				RadarCommand radar1 = new RadarCommand(4);
				System.out.println("scanned");
				return radar1;
			}
		case 7:
			currentState = 5;
			results = env.getRadar();
			rotated = 0;
			System.out.println("rotated");
			if (results != null && results.getByType("Ship") != null && results.getByType("Ship").size() > 0) {
				
				return new RotateCommand(
						position.getAngleTo(results.getByType("Ship").get(0).getPosition()) - orientation);
			} else if (results != null && results.getByType("Dragon") != null
					&& results.getByType("Dragon").size() > 0) {
				return new RotateCommand(
						position.getAngleTo(results.getByType("Dragon").get(0).getPosition()) - orientation);
			} else if (results != null && results.getByType("Asteriod") != null
					&& results.getByType("Asteriod").size() > 0) {
				return new RotateCommand(
						position.getAngleTo(results.getByType("Asteriod").get(0).getPosition()) - orientation);
			} else {
				return new RotateCommand(5);
			}

		}
		currentState = 0;

		return new BrakeCommand(0.001);

	}

	private Point center;

	@Override

	public RegistrationData registerShip(int numImages, int worldWidth, int worldHeight) {
		// modify kship1 to your ship's name.
		center = new Point(worldWidth / 2, worldHeight / 2);
		System.out.println("center: " + center);
		return new RegistrationData("Evan 15.0", new Color(252, 133, 15), 3);

	}
}
