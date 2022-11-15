
public class Car extends Vehicle implements handles{
	private int honk;
	
	public Car(int w, int d, int h) {
		super(w, d);
		h = honk;
	}
	
	public String test() {
		return honk + " ";
	}
	
	public int wheels() {
		return wheel;
	}
	
	public void change() {
		
	}
	
	public void help() {
		
	}
}
