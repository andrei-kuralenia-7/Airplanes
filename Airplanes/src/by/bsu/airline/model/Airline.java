package by.bsu.airline.model;

import java.util.ArrayList;
import java.util.List;

public class Airline {

	public Airline() {
	}

	private List<Plane> planes = new ArrayList<Plane>();

	public void addPlane(Plane plane) {
		planes.add(plane);
	}

	public List<Plane> getPlanes() {
		return planes;
	}

	public int totalCapacity() {
		int totalCapacity = 0;
		for (Plane plane : planes) {
			totalCapacity += plane.getCapacity();
		}
		return totalCapacity;
	}

	public int totalPassenger() {
		int totalPassenger = 0;
		for (Plane plane : planes) {
			totalPassenger += plane.getPassenger();
		}
		return totalPassenger;
	}
}
