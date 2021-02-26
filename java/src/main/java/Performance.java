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

    public int getComedyAmount(int baseAmount) {
        if (audience() > 20) {
            return baseAmount + 300 * audience() + 10000 + 500 * (audience() - 20);
        }
        return baseAmount + 300 * audience();
    }

    public int getTragedyAmount(int baseAmount) {
        if (audience() > 30) {
            return baseAmount + 1000 * (audience() - 30);
        }
        return baseAmount;
    }
}
