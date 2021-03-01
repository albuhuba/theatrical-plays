package play;

import model.Performance;

public class TragedyPlay extends AbstractPlay {

    private static final int baseAmount = 40000;

    public TragedyPlay(String name) {
        super(name);
    }

    public int getAmount(Performance performance) {
        return performance.getTragedyAmount(baseAmount);
    }
}
