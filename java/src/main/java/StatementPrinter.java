import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

    public String print(Invoice invoice, Map<String, Play> plays) {
        var totalAmount = 0;
        var volumeCredits = 0;
        var result = String.format("Statement for %s\n", invoice.customer);

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

        for (var perf : invoice.performances) {
            var play = plays.get(perf.playID());
            var thisAmount = play.getAmount(perf);
            totalAmount += thisAmount;

            result += String.format("  %s: %s (%s seats)\n", play.name, formatter.format(thisAmount / 100), perf.audience());
            volumeCredits += play.getVolumeCredits(perf);

        }

        result += String.format("Amount owed is %s\n", formatter.format(totalAmount / 100));
        result += String.format("You earned %s credits\n", volumeCredits);
        return result;
    }


}
