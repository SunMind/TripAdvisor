package trip.advisor.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import trip.advisor.repository.*;
import trip.advisor.service.AdvisorService;
import trip.advisor.dto.BackpackResponse;
import trip.advisor.dto.ItemRequest;
import trip.advisor.dto.TripDetailsRequest;
import trip.advisor.enums.ItemCategoryType;
import trip.advisor.enums.SeasonType;
import trip.advisor.model.*;

@Tag(name = "Trip Advisor", description = "Trip advisor management APIs")
@RestController
@RequestMapping("/api")
public class AdvisorController {
	
	@Autowired
	ClassificatorRepository classificatorRepository;

	@Autowired
	AdvisorService advisorService;

	@Operation(summary = "Get recommended backpack", description = "Get recommended backpack for a trip by given parameters")
	@GetMapping("/backpack")
	public ResponseEntity<BackpackResponse> getRecommendedBackpack(@Valid @ParameterObject TripDetailsRequest request) {
		try {
			BackpackResponse response = advisorService.getRecommendedBackpack(request);
			return okResponse(response);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(summary = "Retrieve a list of items", description = "Get a list of all items or a list of items by category or season")
	@GetMapping("/items")
	public ResponseEntity<List<Item>> findAllItems(@RequestParam(required = false) ItemCategoryType category,
			@RequestParam(required = false) SeasonType season) {
		try {
			List<Item> items = advisorService.findAllItems(category, season);
			return okResponse(items);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//TODO: if new item added, than need to choose between two same items when recommending backpack (maybe compare weight or quality/price etc..)
	@Operation(summary = "Add new item", description = "Add new item for specific category and season")
	@PostMapping("/items")
	public ResponseEntity<Item> createItem(@Valid @ParameterObject ItemRequest item) {
		try {
			Item newItem = advisorService.createItem(item);
			return new ResponseEntity<>(newItem, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//TODO: if added needs to customize enumerators or take classificator values not from enum???.
//	@PostMapping("/classificators")
//	public ResponseEntity<Classificator> createClassificator(@Valid @ParameterObject Classificator classificator) {
//		try {
//			Classificator newClassificator = classificatorRepository.save(new Classificator(classificator.getDomain(),
//					classificator.getCode(), classificator.getMeaning(), classificator.getDescription()));
//			return new ResponseEntity<>(newClassificator, HttpStatus.CREATED);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	private <T> ResponseEntity<T> okResponse(T data) {
		HttpStatus status;
		if (data instanceof List) {
			status = ((List<?>) data).isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK;
		} else {
			status = data != null ? HttpStatus.OK : HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<T>(data, status);
	}
}
