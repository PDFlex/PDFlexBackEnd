package consonants.flex.entity;

public abstract class Form {

    private boolean confirmed;
    private boolean filledOut;
    private boolean inProgress;


    protected Form(boolean confirmed, boolean filledOut, boolean inProgress) {
        this.confirmed = confirmed;
        this.filledOut = filledOut;
        this.inProgress = inProgress;
    }

    // Consider checkConfirmed(), checkFilledOut() and checkInProgress() to be
    // the getters of their corresponding attributes
}
