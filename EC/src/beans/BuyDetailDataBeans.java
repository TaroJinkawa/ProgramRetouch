package beans;

import java.io.Serializable;

public class BuyDetailDataBeans  implements Serializable {
	private int id;
	private int buyId;
	private int itemId;

	private String itemName;
	private int itemPrice;


	public int getId() {
		return id;
	}
	public void setId(int buyDetailId) {
		this.id = buyDetailId;
	}
	public int getBuyId() {
		return buyId;
	}
	public void setBuyId(int buyId) {
		this.buyId = buyId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
}
