/**
 * 
 */
package com.ss.item;

/**
 * <p>
 * This class will contain the information of item recognized by item code
 * 
 * @author Saurav
 *
 */
public enum ItemInfo {

	TM("Tea - Masala", 10), TI("Tea -  Ice", 15), TL("Tea - Lemon", 15), 
	CC("Coffee - Cold", 15), CL("Coffee - Latte", 30), CM("Coffee - Mocha", 40), 
	CDC("Cold Drinks - Coke", 20), CDP("Cold Drinks - Pepsi", 20), CDS("Cold Drinks - Sprite", 15);

	private String item;
	private float price;

	private ItemInfo(String item, float price) {
		this.item = item;
		this.price = price;
	}

	public String item() {
		return item;
	}

	public float price() {
		return price;
	}
	

}
