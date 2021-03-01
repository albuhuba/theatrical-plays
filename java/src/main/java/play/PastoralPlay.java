package play;

import model.Performance;

public class PastoralPlay extends AbstractPlay {
    public PastoralPlay(String name) {
        super(name);
    }

    @Override
    public int getAmount(Performance perf) {
        throw new Error("unknown type: ${play.type}");
    }
}
