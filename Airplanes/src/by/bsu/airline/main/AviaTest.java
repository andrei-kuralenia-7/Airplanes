package by.bsu.airline.main;

import java.util.Collections;
import java.util.Scanner;

import org.apache.log4j.Logger;

import by.bsu.airline.exceptions.NoFlightFoundException;
import by.bsu.airline.exceptions.WrongInputException;
import by.bsu.airline.model.Airline;
import by.bsu.airline.model.Plane;

public class AviaTest {

	private static Logger logger = Logger.getLogger(AviaTest.class);

	public static void main(String[] args) {

		Plane mria = new Plane("AN Mria", 250 /* capacity */,
				300/* passenger */, 10000/* fuel */, 20000 /* range */);
		Plane airbus = new Plane("Airbus", 150 /* capacity */,
				200/* passenger */, 5000/* fuel */, 15000 /* range */);
		Plane boeing747 = new Plane("Boeing 747", 100 /* capacity */,
				120/* passenger */, 3000/* fuel */, 30000 /* range */);
		Plane boeing947 = new Plane("Boeing 947", 50 /* capacity */,
				60/* passenger */, 1000/* fuel */, 50000 /* range */);

		Airline mAirline = new Airline();
		mAirline.addPlane(mria);
		mAirline.addPlane(airbus);
		mAirline.addPlane(boeing747);
		mAirline.addPlane(boeing947);

		logger.info("Total Airline Capacity: " + mAirline.totalCapacity());

		logger.info("Total Airline Passengers: " + mAirline.totalPassenger());

		sortPlanesByRange(mAirline.getPlanes());

		selectPlanesByFuelConsumption(mAirline);
	}

	private static void sortPlanesByRange(java.util.List<Plane> planes) {

		logger.info( "Planes sorted by Range:" );
				
		Collections.sort(planes);
		for (Plane plane : planes) {
			logger.info("  " + plane.getName() + "; Range: " + plane.getRange());
		}

	}

	public static void selectPlanesByFuelConsumption(Airline airline) {

		logger.info("Starting planes selection... ");
		
		while (true) {

			logger.info("");
			logger.info("Enter Fuel Consumption (press space and enter to exit): ");

			Scanner scanIn = new Scanner(System.in);
			String s = scanIn.nextLine();

			if (" ".equals(s))
				break;

			try {

				int fuel = 0;
				
				try {
					fuel = Integer.parseInt(s);	
				} catch (Exception e) {
					throw new WrongInputException(e);
				}
				
				boolean found = false;

				for (Plane plane : airline.getPlanes()) {
					if (fuel < plane.getFuelConsumtion()) {
						found = true;
						logger.info("Your match is " + plane.getName()
								+ "; fuel consumption: "
								+ plane.getFuelConsumtion());
					}
				}

				if (!found) {
					throw new NoFlightFoundException();
				}

			} catch (NoFlightFoundException e) {
				logger.info("No planes found matching your criteria. Try again.");
			} catch (WrongInputException e) {
				logger.error("Incorrect input, try again", e);
			}
		}

		logger.info("Plane selection finished.");
	}
}