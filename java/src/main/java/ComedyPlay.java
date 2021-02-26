public class ComedyPlay extends Play{

    private static final int baseAmount = 30000;

    public ComedyPlay(String name) {
        super(name);
    }

    @Override
    public int getAmount(Performance performance) {
        return baseAmount + getComedyAmount(performance);
    }

    @Override
    public int getVolumeCredits(Performance perf) {
        return internalGetBaseVolumeCredit(perf) + (int) Math.floor(perf.audience() / 5);
    }

    private int getComedyAmount(Performance perf) {
        int thisAmount = 0;
        if (perf.audience() > 20) {
            thisAmount += 10000 + 500 * (perf.audience() - 20);
        }
        thisAmount += 300 * perf.audience();
        return thisAmount;
    }
}
