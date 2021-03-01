package play;

import model.Performance;

public class TragedyPlay extends AbstractPlay {

    public TragedyPlay(String name) {
        super(name);
    }

    private static final int baseAmount = 40000;

    public int getAmount(Performance performance) {
        return performance.getTragedyAmount(baseAmount);
    }
}
