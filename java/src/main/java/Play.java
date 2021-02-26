public abstract class Play {

    public String name;

    public Play(String name) {
        this.name = name;
    }

    public abstract int getAmount(Performance perf);

    public int getVolumeCredits(Performance perf){
        return internalGetBaseVolumeCredit(perf);
    }

    protected int internalGetBaseVolumeCredit(Performance perf) {
        return Math.max(perf.audience() - 30, 0);
    }
}
