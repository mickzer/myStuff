import java.util.*;

public class Primes {

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);
		boolean validInput = false;
		String intake = "";
		int prime = 0;
		// Get and validate user input
		do {
			System.out.println("Please enter prime to find:");
			intake = input.next();
			if (intake.matches("[0-9]*")) {
				prime = Integer.parseInt(intake);
				validInput = true;
			}
		} while (validInput == false);

		long start = System.currentTimeMillis();

		int count = 0;
		double calLength = 2 * prime * (Math.log(prime));
		int length = (int) Math.round(calLength);
		System.out.println("Using array of size: " + length);

		boolean[] myArray = new boolean[length];
		int num = 0;
		int limit = 0;

		// Set every value in the array to true
		for (int i = 2; i < myArray.length; i ++ ) {

			myArray[i] = true;

		}

		// Find all trues in array
		for (int i = 2; i < myArray.length; i ++ ) {

			if (myArray[i] == true) {

				count ++ ;
				if (count == prime) {

					long elapsed = System.currentTimeMillis() - start;
					System.out.println("The " + prime + "th prime number is "
							+ i + ".");
					System.out.println("The answer took " + elapsed
							+ " milliseconds to compute.");

				}

				for (int j = 2; j < myArray.length; j ++ ) {

					num = i * j;
					if (num >= (myArray.length)) {
						break;
					}

					myArray[num] = false;

				}
				
			}//end if true found

		}//end outer loop

	}//end main

}