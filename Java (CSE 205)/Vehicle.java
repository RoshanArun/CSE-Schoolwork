
public abstract class Vehicle {
	protected int wheel;
	protected int door;
	
	public Vehicle(int w, int d) {
		wheel = w;
		door = d;
	}
	
	public abstract String test();
	
}
