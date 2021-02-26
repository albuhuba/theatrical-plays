public class Performance {

    private final String playID;
    private final int audience;

    public Performance(String playID, int audience) {
        this.playID = playID;
        this.audience = audience;
    }

    public int audience() {
        return audience;
    }

    public String playID() {
        return playID;
    }
}
