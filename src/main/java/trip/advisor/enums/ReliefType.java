package trip.advisor.enums;

public enum ReliefType {

	FLAT("FLAT"),
    HILLY("HILLY"),
    MOUNTAINOUS("MOUNTAINOUS"),
    FORESTED("FORESTED"),
    DESERT("DESERT"),
    COASTAL("COASTAL"),
    URBAN("URBAN"),
    RURAL("RURAL"),
    WILDERNESS("WILDERNESS");

    String code;

    ReliefType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
