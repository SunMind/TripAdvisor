package trip.advisor.enums;

public enum ItemCategoryType {

	CLOTHING("CLOTHING"),
	FOOTWEAR("FOOTWEAR"),
	SLEEP_SYSTEM("SLEEP_SYSTEM"),
	SHELTER("SHELTER"),
	COOKING("COOKING"),
	HYDRATION("HYDRATION"),
	NAVIGATION("NAVIGATION"),
	HEALTH_AND_SAFETY("HEALTH_AND_SAFETY"),
	TOOLS("TOOLS"),
	PERSONAL_ITEMS("PERSONAL_ITEMS"),
	LIGHTING("LIGHTING"),
	ELECTRONICS("ELECTRONICS"),
	STORAGE("STORAGE"),
	BACKPACK("BACKPACK"),
	EQUIPMENT("EQUIPMENT"),
	OPTICS("OPTICS"),
	FOOD("FOOD");

    String code;

    ItemCategoryType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
