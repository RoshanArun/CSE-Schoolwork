
public class HW3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "";

		 
		//Use Scanner to ask the user for first name
		System.out.println("What is your first, middle and last names? ");
		name = scan.n

		
		int space1 = name.indexOf(" ");
		int space2 = name.indexOf("

		
		String initial = name.substring(0, 1);

		
		String firstName = name.substring(1, space1);

		  
		if(space2 > 1){
			String initial3 = name.substring(space2 + 1, space2 + 2);
			String lastName2 = name.substring(space2 + 2, length);

					
			System.out.println("Initials        : " + initial.toUpperCase() + "." + initial2.toUpperCase() + 
					." + initial3.toUpperCase() + ".");  
			System.out.println("Last Name First : " + initial3.toUpperCase() + lastName2.toLowerCase() + ",
					" + initial.toUpperCase() + firstName.toLowerCase( +  " " +  initial2.toUpperCase() + ".");
			System.out.println("First and Last  : " + initial.toUpperCase() + firstName.toLowerCase() + " " + initial3.toUpperCase() + lastName2.toLowerCase() );
  
		}else if(space1 > 1) {
			System.out.println("Initials        : " + initial.toUpperCase() + "." + initial2.toUpperCase() +
					 ".");
			System.out.println("Last Name First : " + initial2.toUpperCase() + lastName.toLowerCase() + ", 
					+ initial.toUpperCase() + firstName.toLowerCase();
			System.out.println("First and Last  : " + initial.toUpperCase() + firstName.toLowerCase() + " " + initial2.toUpperCase() + lastName.toLowerCase() );


		
	}
}