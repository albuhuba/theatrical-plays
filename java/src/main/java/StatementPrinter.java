import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

    private class Tragedy {

        private static final int baseAmount = 40000;
        private final Performance performance;

        public Tragedy(Performance performance) {
            this.performance = performance;
        }

        private int getAmount() {
            if (performance.audience > 30) {
                return baseAmount + 1000 * (performance.audience - 30);
            }
            return baseAmount;
        }
    }

    private class Comedy {

        private static final int baseAmount = 3000;
        private final Performance performance;

        public Comedy(Performance performance) {
            this.performance = performance;
        }

        public int getAmount() {
            return baseAmount + getComedyAmount(performance);
        }

        private int getComedyAmount(Performance perf) {
            int thisAmount = 0;
            if (perf.audience > 20) {
                thisAmount += 10000 + 500 * (perf.audience - 20);
            }
            thisAmount += 300 * perf.audience;
            return thisAmount;
        }
    }

    public String print(Invoice invoice, Map<String, Play> plays) {
        var totalAmount = 0;
        var volumeCredits = 0;
        var result = String.format("Statement for %s\n", invoice.customer);

        NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

        for (var perf : invoice.performances) {
            var play = plays.get(perf.playID);
            var thisAmount = 0;

            switch (play.type) {
                case "tragedy":
                    thisAmount = new Tragedy(perf).getAmount();
                    break;
                case "comedy":
                    thisAmount = new Comedy(perf).getAmount();
                    break;
                default:
                    throw new Error("unknown type: ${play.type}");
            }

            totalAmount += thisAmount;

            result += String.format("  %s: %s (%s seats)\n", play.name, frmt.format(thisAmount / 100), perf.audience);

            volumeCredits += getVolumeCredits(perf, play);

        }
        result += String.format("Amount owed is %s\n", frmt.format(totalAmount / 100));
        result += String.format("You earned %s credits\n", volumeCredits);
        return result;
    }

    private int getVolumeCredits(Performance perf, Play play) {
        return addExtraVolumeCredits(perf, play);
    }

    private int addExtraVolumeCredits(Performance perf, Play play) {
        if ("comedy".equals(play.type)) {
            return getBaseVolumeCredit(perf) + (int) Math.floor(perf.audience / 5);
        }
        return getBaseVolumeCredit(perf);
    }

    private int getBaseVolumeCredit(Performance perf) {
        return Math.max(perf.audience - 30, 0);
    }


}
