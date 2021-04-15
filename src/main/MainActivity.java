package main;

/*
 * Code written By 
 * @author
 * Satyendra Pandey
*/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import constants.TaxConstant;
import product.Product;
import taxcalculate.CalculateTax;
import validation.Validation;

public class MainActivity {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("-----------------------------------------------");

		System.out.print("Input should be accepted with following command line options:\r\n"
				+ "-name 	<first item name>\r\n" + "-price 	<price of first item>\r\n"
				+ "-quantity   <quantity of first item>\r\n" + "-type  	<type of first item>\r\n" + "");
		System.out.println("-----------------------------------------------");

		ArrayList<Product> items = new ArrayList<Product>();

		while (true) {

			String itemName = TaxConstant.STRING_CONSTANT;
			double itemPrice = TaxConstant.DOUBLE_CONSTANT;
			int itemQuantity = TaxConstant.INTEGER_CONSTANT;
			String itemType = TaxConstant.STRING_CONSTANT;

			System.out.println("-----------------------------------------------");

			System.out.println("Enter your details\n\n");

			System.out.println("-----------------------------------------------");

			// validate input here
			try {
				itemName = scan.next();
			} catch (Exception ioException) {
				throw new RuntimeException("Unable to Scan or read value", ioException);
			}

			if (!Validation.checkFirstName(itemName)) {
				System.out.println("Invalid...please enter again");
				continue;
			}

			itemPrice = scan.nextInt();
			itemQuantity = scan.nextInt();
			itemType = scan.next();

			Product item = new Product(itemName, itemQuantity, itemPrice, itemType);
			items.add(item);

			System.out.println("-----------------------------------------------");

			System.out.println("Do you Want to Add More Item?");
			System.out.println("-----------------------------------------------");

			String options = scan.next();

			// validate string here
			if (options.equals("yes")) {
				continue;
			}

			Iterator itr = items.iterator();

			int[] array = new int[2];

			// traverse elements of ArrayList object
			while (itr.hasNext()) {
				Product st = (Product) itr.next();

				array = CalculateTax.calculateTax(st.itemType, st.itemPrice, st.itemQuantity);
				System.out.println("-----------------------------------------------");
				System.out.println("Product Name        :" + st.itemName);
				System.out.println("Product Price       :" + st.itemPrice);
				System.out.println("Product Tax         :" + array[0]);
				System.out.println("Product Total Price :" + array[1]);
				System.out.println("-----------------------------------------------");

			}

			return;
		}

	}

}