
public class Lab7 {
	private String name;

	public Lab7(String nam) {
		name = nam;
	}

	public String getName() {
		return name;
	}

	public String makeRow(int n, String s) {
		String one = "";

		for (int i = 0; i < n; i++) {
			one = one + s;
		}
		return one;
	}

	public void printPyramid(int n, String s) {
		if (n % 2 == 0) {
			System.out.println("Sorry you didn�t provide an odd number � nothing to print.");
		} else {

			for (int i = 1; i <= n; i = i + 2) {
				for (int j = i; j < n; j = j + 2) {
					System.out.print(" ");
				}

				for (int k = 0; k < i; k++) {
					System.out.print(s);
				}

				for (int l = i; l < n; l = l + 2) {
					System.out.print(" ");
				}
				System.out.println("");
			}

		}
	}
}
