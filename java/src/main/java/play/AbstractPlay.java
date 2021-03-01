package play;

import model.Performance;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class AbstractPlay {

    private final String name;

    public AbstractPlay(String name) {
        this.name = name;
    }

    public abstract int getAmount(Performance perf);

    public int getVolumeCredits(Performance perf) {
        return internalGetBaseVolumeCredit(perf);
    }

    protected int internalGetBaseVolumeCredit(Performance perf) {
        return Math.max(perf.audience() - 30, 0);
    }

    public String formatAmount(Performance perf) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        return String.format("  %s: %s (%s seats)\n", name, formatter.format(getAmount(perf) / 100), perf.audience());
    }
}
