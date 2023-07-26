package HW;

public class Geek {
	String nam;
	int numberOfQuestions = 0;

	public Geek(String name) {
		nam = name;
		numberOfQuestions = 0;
	}

	public String getName() {
		numberOfQuestions = numberOfQuestions + 1;
		return nam;
	}

	public int getNumberOfQuestions() {
		numberOfQuestions = numberOfQuestions + 1;
		return numberOfQuestions;
	}

	public boolean divisibleBy3(int value) {
		if (value % 3 == 0) {
			numberOfQuestions = numberOfQuestions + 1;
			return true;

		} else {
			numberOfQuestions = numberOfQuestions + 1;
			return false;
		}
	}

	public float closerToPi(float value1, float value2) {
		float pi = 3.1415927f;
		float one = value1;
		float two = value2;
		numberOfQuestions = numberOfQuestions + 1;

		if (value1 > pi) {
			value1 = value1 - pi;
		} else {
			value1 = pi - value1;
		}

		if (value2 > pi) {
			value2 = value2 - pi;
		} else {
			value2 = pi - value2;
		}

		if (value1 < value2) {
			return one;
		} else {
			return two;
		}
	}

	public int countIn(String statement, char letter) {
		int number = 0;
		numberOfQuestions = numberOfQuestions + 1;

		for (int i = 0; i < statement.length(); i++) {
			if (statement.charAt(i) == letter) {
				number++;
			}
		}
		return number;
	}

	public boolean isBetween(int a, int b, int c) {
		numberOfQuestions = numberOfQuestions + 1;

		if (b > a && b < c) {
			return true;
		} else if (b < a && b < c) {
			return true;
		} else {
			return false;
		}
	}

	public int reverseNumber(int number) {
		numberOfQuestions = numberOfQuestions + 1;
		int remainder;
		int number2 = 0;

		while (number != 0) {
			remainder = number % 10;
			number2 = number2 * 10 + remainder;
			number = number / 10;
		}
		return number2;
	}

}
