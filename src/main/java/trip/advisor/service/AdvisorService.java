package trip.advisor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import trip.advisor.dto.BackpackResponse;
import trip.advisor.dto.ItemRequest;
import trip.advisor.dto.ItemResponse;
import trip.advisor.dto.TripDetailsRequest;
import trip.advisor.enums.ItemCategoryType;
import trip.advisor.enums.SeasonType;
import trip.advisor.model.Item;
import trip.advisor.repository.ClassificatorRepository;
import trip.advisor.repository.ItemRepository;

@Service
public class AdvisorService {
	
	static final String DEFAULT_BACKPACK = "Hey, you got a default list of items necessary for any trip";
	
	static final String CUSTOM_BACKPACK = DEFAULT_BACKPACK + " plus custom items specific to chosen parameters";

	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ClassificatorRepository classificatorRepository;

	public List<Item> findAllItems(ItemCategoryType category, SeasonType season) {
		List<Item> items = new ArrayList<>();
		if (category == null && season == null)
			itemRepository.findAll().forEach(items::add);
		else if (category != null && season == null)
			itemRepository.findItemsBySeasonAndCategory(null, category.getCode()).forEach(items::add);
		else if (category == null && season != null) {
			itemRepository.findItemsBySeasonAndCategory(season.getCode(), null).forEach(items::add);
		} else {
			itemRepository.findItemsBySeasonAndCategory(season.getCode(), category.getCode()).forEach(items::add);
		}
		return items;
	}

	public BackpackResponse getRecommendedBackpack(TripDetailsRequest request) {
		List<ItemResponse> items = new ArrayList<>();
		BackpackResponse response;
		int distance = request.getDistance();

		if (request.getSeason() == null) {
			itemRepository.getDefaultItems().forEach(item -> insertToBackpack(distance, item, items));
			response = new BackpackResponse(items, DEFAULT_BACKPACK);
		} else {
			itemRepository.getItemsBySeason(request.getSeason().getCode())
					.forEach(item -> insertToBackpack(distance, item, items));
			response = new BackpackResponse(items, CUSTOM_BACKPACK);
		}
		return response;
	}
	
	public Item createItem(ItemRequest item) {
		Item newItem = itemRepository.save(new Item(item.getName(), item.getCategory().getCode(), item.getEnoughForKm(),
				item.getWeight(), item.getNotes()));
		newItem.addSeason(classificatorRepository.getClassificatorBySeason(item.getSeason().getCode()));
		itemRepository.save(newItem);
		return newItem;
	}

	private void insertToBackpack(int distance, Item item, List<ItemResponse> items) {
		long quantity = distance / item.getEnoughForKm() < 1 ? 1 : Math.round(distance / item.getEnoughForKm());
		ItemResponse itemResponse = new ItemResponse(item, quantity);
		items.add(itemResponse);
	}
}
