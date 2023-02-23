package Box;

public abstract class Box {

	protected int length;
	protected int width;
	protected int height;

	public Box(int l, int w, int h) {
		length = l;
		width = w;
		height = h;
	}

	/**
	 * @return int
	 */
	public int calcVolume() {
		return length * width * height;
	}

	public abstract String thisis();

}
