package validation;

/*
 * Code written By 
 * @author
 * Satyendra Pandey
*/
public class Validation {

	public static boolean checkFirstName(String string) {

		if (string.isEmpty() || string.equals("") || string.equals(null)) {
			return false;
		}
		if (string.matches("-?\\d+(\\.\\d+)?")) {
			return false;
		}

		return true;
	}

	public static boolean validateInputString(String string) {

		if (string.isEmpty() || string.equals("")) {
			return false;

		}

		return true;
	}

}
