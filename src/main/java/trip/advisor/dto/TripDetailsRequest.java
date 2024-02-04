package trip.advisor.dto;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
//import trip.advisor.enums.ReliefType;
import trip.advisor.enums.SeasonType;

public class TripDetailsRequest {

	@Parameter(description = "Trip length in km", example = "99")
	@NotNull(message = "distance can not be null")
	@Min(value = 1)
	private int distance;

	@Parameter(description = "The time of year when the trip is planned")
	private SeasonType season;

	// TODO:
//	@Parameter(description = "Type of relief for planned trip")
//	private ReliefType relief;

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public SeasonType getSeason() {
		return season;
	}

	public void setSeason(SeasonType season) {
		this.season = season;
	}

//	public ReliefType getRelief() {
//		return relief;
//	}
//
//	public void setRelief(ReliefType relief) {
//		this.relief = relief;
//	}

	// TODO: some extra input parameters, for more precise backpack recommendation.
//	private Location location; //Possibility to check wheather by statistics
//	private ExperienceLevel experience;
//	private Budget budget;

}
