package mngrApp.model;

public enum Benefit {
    HEALTH_INSURANCE("Health Insurance"), LIFE_INSURANCE("Life Insurance"),
    DENTAL_INSURANCE("Dental Insurance"), VISION_INSURANCE("Vision Insurance"),
    RETIREMENT_BENEFITS("Retirement Benefits"), COMPANY_CAR("Company Car");

    private final String name;

    Benefit(String name) {
        this.name = name;
    }

    public String getValue() {
        return name;
    }

    public static Benefit getEnum(String value) {
        for (Benefit b : values()) {
            if (b.getValue().equalsIgnoreCase(value)) return b;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return this.name;
    }
}
