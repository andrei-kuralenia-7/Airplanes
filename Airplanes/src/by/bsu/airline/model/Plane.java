package by.bsu.airline.model;

public class Plane implements Comparable<Plane> {
	public String name;
	public int capacity;
	public int passenger;
	public int fuelConsumtion;
	public int range;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setPassenger(int passenger) {
		this.passenger = passenger;
	}

	public int getPassenger() {
		return passenger;
	}

	public void setFuelConsumtion(int fuelConsumtion) {
		this.fuelConsumtion = fuelConsumtion;
	}

	public int getFuelConsumtion() {
		return fuelConsumtion;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getRange() {
		return range;
	}

	/*
	 * public static class Builder { public String name=null; public final int
	 * fuelConsumtion; public int capacity; public int passenger; public int
	 * range;
	 * 
	 * 
	 * public Builder(String name, int fuelConsumtion) { this.name = name;
	 * this.fuelConsumtion = fuelConsumtion; }
	 * 
	 * public Builder capacity(int val) { capacity = val; return this; }
	 * 
	 * public Builder passenger(int val) { passenger = val; return this; }
	 * 
	 * public Builder range(int val) { range = val; return this; }
	 * 
	 * public Plane build() { return new Plane(this); } }
	 * 
	 * public Plane(Builder builder) { name = builder.name; fuelConsumtion =
	 * builder.fuelConsumtion; capacity = builder.capacity; passenger =
	 * builder.passenger; range = builder.range; }
	 */

	public Plane(String name, int capacity, int passenger, int fuelConsumtion,
			int range) {
		super();
		this.name = name;
		this.capacity = capacity;
		this.passenger = passenger;
		this.fuelConsumtion = fuelConsumtion;
		this.range = range;

	}

	public boolean equals(Plane plane) {
		if (!(plane instanceof Plane))
			return false;
		Plane tmp = (Plane) plane;
		return name.equals(tmp.name) && range == tmp.range;
	}

	public int compareTo(Plane p) {
		return Integer.signum(this.getRange() - p.getRange());
	}
}
