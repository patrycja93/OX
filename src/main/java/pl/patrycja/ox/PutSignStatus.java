package pl.patrycja.ox;

public enum PutSignStatus {
    SUCCESS(""),
    FAILURE_RANGE_OVER("Number is over range. Try again.\n"),
    FAILURE_PLACE_OCCUPIED("This place is already occupied. Try again.\n");

    private String message;

    PutSignStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
