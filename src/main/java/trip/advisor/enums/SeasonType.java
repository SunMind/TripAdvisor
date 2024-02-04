package trip.advisor.enums;

public enum SeasonType {

    SUMMER("SUMMER"),
    
    AUTUMN("AUTUMN"),

    WINTER("WINTER"),
    
    SPRING("SPRING"),
    
    ALL_YEAR("ALL_YEAR");

	String code;

	SeasonType(String code) {
	   this.code = code;
	}

	public String getCode() {
	   return code;
	}
}
