package by.bsu.airline.main;

import by.bsu.airline.model.*;

import java.awt.List;
import java.util.Collections;
import java.util.Scanner;

public class AviaTest {

	public static void main(String[] args) {

		Plane mria = new Plane("AN Mria", 250 /* capacity */,
				300/* passenger */, 10000/* fuel */, 20000 /* range */);
		Plane airbus = new Plane("Airbus", 150 /* capacity */,
				200/* passenger */, 5000/* fuel */, 15000 /* range */);
		Plane boeing747 = new Plane("Boeing 747", 100 /* capacity */,
				120/* passenger */, 3000/* fuel */, 10000 /* range */);
		Plane boeing947 = new Plane("Boeing 947", 50 /* capacity */,
				60/* passenger */, 1000/* fuel */, 5000 /* range */);

		Airline mAirline = new Airline();
		mAirline.addPlane(mria);
		mAirline.addPlane(airbus);
		mAirline.addPlane(boeing747);
		mAirline.addPlane(boeing947);

		System.out.println("total Capacity of Airline: "
				+ mAirline.totalCapacity());

		System.out.println("total Passenger of Airline: "
				+ mAirline.totalPassenger());
		sortPlanesByRange(mAirline.getPlanes());
		selectPlanesByFuelConsumption(mAirline);
	}

	private static void sortPlanesByRange(java.util.List<Plane> planes) {

		Collections.sort(planes);
		for (Plane plane : planes) {
			System.out.println(plane.getName() + " range " + plane.getRange());
		}

	}

	public static void selectPlanesByFuelConsumption(Airline airline) {

		while (true) {

			System.out
					.println("Range of consumption of fuel for the passenger and cargo plane: ");

			Scanner scanIn = new Scanner(System.in);
			String s = scanIn.nextLine();

			if (" ".equals(s))
				break;

			try {
				int fuel = Integer.parseInt(s);
				for (Plane plane : airline.getPlanes()) {
					if (fuel < Plane.getFuelConsumtion()) {
						System.out.println("For you it is necessary- "
								+ plane.getName() + "With fuel consumption- "
								+ plane.getFuelConsumtion());
					}
				}
			} catch (Exception e) {
				System.out.println("Incorrect input, try once again");
			}
		}

		System.out.println("Program end");
	}
}