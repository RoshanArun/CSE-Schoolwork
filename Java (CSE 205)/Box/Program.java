package Box;

public class Program {

	/**
	 * @param args[]
	 */
	public static void main(String args[]) {

		Box2 test = new Box2(2, 2, 2, 2);

		System.out.println(test.calcVolume());
		test.calcVolume();

	}
}
