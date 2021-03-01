package play;

import model.Performance;

public class HistoryPlay extends AbstractPlay {
    public HistoryPlay(String name) {
        super(name);
    }

    @Override
    public int getAmount(Performance perf) {
        throw new Error("unknown type: ${play.type}");
    }
}
