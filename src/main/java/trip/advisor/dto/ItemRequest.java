package trip.advisor.dto;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import trip.advisor.enums.ItemCategoryType;
import trip.advisor.enums.SeasonType;

public class ItemRequest {

	@Parameter(description = "Name of an item", example = "Boots")
	@NotNull
	private String name;

	@Parameter(description = "Category of an item", example = "FOOTWEAR")
	@NotNull
	private ItemCategoryType category;

	@Parameter(description = "Single unit need for this many km", example = "120")
	@NotNull
	@Min(value = 1)
	private int enoughForKm;

	@Parameter(description = "So many kg an item weights", example = "1.2")
	@NotNull
	@Min(value = (long) 0.1)
	private Double weight;

	@Parameter(description = "Instruction or any other important information about an item", example = "Use it wisely")
	private String notes;

	@NotNull
	@Parameter(description = "Season for which this items fits the best", example = "SUMMER")
	private SeasonType season;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ItemCategoryType getCategory() {
		return category;
	}

	public void setCategory(ItemCategoryType category) {
		this.category = category;
	}

	public int getEnoughForKm() {
		return enoughForKm;
	}

	public void setEnoughForKm(int enoughForKm) {
		this.enoughForKm = enoughForKm;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public SeasonType getSeason() {
		return season;
	}

	public void setSeason(SeasonType season) {
		this.season = season;
	}

}
