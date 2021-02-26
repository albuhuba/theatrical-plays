public class HistoryPlay extends Play{
    public HistoryPlay(String name) {
        super(name);
    }

    @Override
    public int getAmount(Performance perf) {
        throw new Error("unknown type: ${play.type}");
    }
}
