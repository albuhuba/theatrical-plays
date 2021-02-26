public class ComedyPlay extends Play {

    private static final int baseAmount = 30000;

    public ComedyPlay(String name) {
        super(name);
    }

    @Override
    public int getAmount(Performance performance) {
        return performance.getComedyAmount(baseAmount);
    }

    @Override
    public int getVolumeCredits(Performance perf) {
        return internalGetBaseVolumeCredit(perf) + (int) Math.floor(perf.audience() / 5);
    }


}
