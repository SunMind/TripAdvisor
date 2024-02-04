package trip.advisor.dto;

import trip.advisor.model.Item;

public class ItemResponse {

	private Item item;

	private long quantity;

	public ItemResponse(Item item, long quantity) {
		super();
		this.item = item;
		this.quantity = quantity;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

}
