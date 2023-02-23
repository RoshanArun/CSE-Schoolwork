package Box;

public class Box2 extends Box {
	private int two;

	public Box2(int l, int w, int h, int t) {
		super(l, w, h);
		two = t;
	}

	/**
	 * @return int
	 */
	public int calcVolume() {
		return length * width * height * two;
	}

	public String thisis() {
		return "string";
	}
}
