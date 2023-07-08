package pl.MGalecki10;

public enum Action {
    QUIT(0),
    ADD_TO_QUEUE(1),
    NEXT_REVIEW(2);

    private final int button;

    Action(int button) {
        this.button = button;
    }

    public int getButton() {
        return button;
    }
}
