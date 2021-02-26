public class TragedyPlay extends Play{

    public TragedyPlay(String name) {
        super(name);
    }

    private static final int baseAmount = 40000;

    public int getAmount(Performance performance) {
        if (performance.audience() > 30) {
            return  baseAmount + 1000 * (performance.audience() - 30);
        }
        return baseAmount;
    }
}