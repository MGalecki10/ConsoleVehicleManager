package pl.MGalecki10.model;

public enum Action {
    QUIT(0),
    ADD_TO_QUEUE(1),
    NEXT_REVIEW(2);

    private final int value;

    Action(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
