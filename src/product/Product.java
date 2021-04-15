package product;

/*
 * Code written By 
 * @author
 * Poorvika Pandey
*/
public class Product {
	public String itemName;
	public String itemType;
	public int itemQuantity;
	public double itemPrice;

	public Product(String itemName, int itemQuantity, double itemPrice, String itemType) {
		this.itemQuantity = itemQuantity;
		this.itemType = itemType;
		this.itemPrice = itemPrice;
		this.itemName = itemName;
	}
}
