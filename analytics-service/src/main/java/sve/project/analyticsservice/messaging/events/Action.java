package sve.project.analyticsservice.messaging.events;

public enum Action{
    CREATE("CREATE"),
    DELETE("DELETE");

    private final String action;

    Action(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
