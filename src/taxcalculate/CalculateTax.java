package taxcalculate;

/*
 * Code written By 
 * @author
 * Satyendra Pandey
*/

import java.util.ArrayList;

import constants.TaxConstant;

public class CalculateTax {

	public static int[] calculateTax(String productType, double price, int quantity) {
		double finalPrice;
		double totalPrice;
		double taxPrice = 0;
		if (productType.toLowerCase().equals(TaxConstant.TYPE_RAW)) {
			taxPrice = (double) ((price * 12.5) / 100);
		} else if (productType.toLowerCase().equals(TaxConstant.TYPE_MANUFACUTURED)) {
			taxPrice = (double) ((price * 12.5) / 100);
			taxPrice += (price + taxPrice) * 2 / 100;
		} else if (productType.toLowerCase().equals(TaxConstant.TYPE_IMPORTED)) {
			taxPrice = (double) ((price * 10) / 100);
			finalPrice = taxPrice + price;
			if (finalPrice <= 100) {
				taxPrice += 5;
			} else if (finalPrice <= 200) {
				taxPrice += 10;
			} else if (finalPrice > 200) {
				taxPrice += (double) ((finalPrice * 5) / 100);
			}
		}

		// Get Total Price
		totalPrice = (taxPrice + price) * quantity;

		int[] array = new int[2];
		array[0] = (int) taxPrice;
		array[1] = (int) totalPrice;
		return array;

//		return totalPrice;
	}

}
