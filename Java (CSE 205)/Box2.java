
public class box2 extends box{
	private int two;
	public box2(int l, int w, int h, int t) {
		super(l, w, h);
		two = t;
	}
	
	public int calcVolume() {
		return length * width * height * two;
	}
	
	public String thisis() {
		return "string";
	}
}
