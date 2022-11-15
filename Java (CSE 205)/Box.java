
public abstract class box {
	
	protected int length; 
	protected int width;
	protected int height;
		
	public box(int l, int w, int h) {
		length = l;
		width = w;
		height = h;
	}
	
	public int calcVolume() {
		return length * width * height;
	}
	public  abstract String thisis();

}
