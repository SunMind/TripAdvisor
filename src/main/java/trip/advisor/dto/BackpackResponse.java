package trip.advisor.dto;

import java.util.List;

import trip.advisor.model.Item;

public class BackpackResponse {

	private List<ItemResponse> packingItems;

	private String additionalInfo;

	public BackpackResponse() {
		super();
	}

	public BackpackResponse(List<ItemResponse> packingItems, String additionalInfo) {
		super();
		this.packingItems = packingItems;
		this.additionalInfo = additionalInfo;
	}

	public List<ItemResponse> getPackingItems() {
		return packingItems;
	}

	public void setPackingItems(List<ItemResponse> packingItems) {
		this.packingItems = packingItems;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

}
