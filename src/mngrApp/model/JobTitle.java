package mngrApp.model;

public enum JobTitle {
    CEO, VICE_PRESIDENT, GENERAL_PRESIDENT, DIRECTOR, MANAGER,
    SUPERVISOR, ASSISTANT_MANAGER, ASSOCIATE, INTERN;

    JobTitle() {
    }

    @Override
    public String toString() {
        return name();
    }
}
