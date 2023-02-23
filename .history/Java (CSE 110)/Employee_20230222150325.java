
//-------------------------------------------------------------------------
// AUTHOR: Roshan Arun
// FILENAME: Employee.java
// SPECIFICATION: This implements the methods for the HW6.java file
// FOR: CSE 110- HW #6
// TIME SPENT:  45 min
//-------------------------------------------------------------------------
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Employee {
	NumberFormat cf1 = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
	private String Name;
	private double Salary;
	private int Experience;
	private static int employeeNum = 0;

	public Employee() {
		Name = "None";
		Salary = 0.0;
		Experience = 0;
	}

	public Employee(String nam, Double Sal, int Exp) {
		Name = nam;
		Salary = Sal;
		Experience = Exp;
		employeeNum++;
	}

	public Employee(String str) {
		Scanner in = new Scanner(str).useDelimiter(",");
		Name = in.next();
		in.skip("[^0-9]*");
		Salary = in.nextDouble();
		in.skip("[^0-9]*");
		Experience = in.nextInt();
		employeeNum++;
		in.close();
	}

	/**
	 * @return String
	 */
	public String getName() {
		return Name;
	}

	public double getSalary() {
		return Salary;
	}

	public int getYears() {
		return Experience;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setYears(int numYears) {
		Experience = numYears;
	}

	public void raiseSalary(double byPercent) {
		Salary = Salary * (byPercent * .01) + Salary;
	}

	public Employee moreExperience(Employee e) {
		if (this.getYears() > e.getYears()) {
			return this;
		} else {
			return e;
		}
	}

	public static int countEmployees() {
		return employeeNum;
	}

	public String toString() {
		return "\nName: " + Name + "\nSalary: " + cf1.format(Salary) + "\nYears of Experience: " + Experience;
	}

}
