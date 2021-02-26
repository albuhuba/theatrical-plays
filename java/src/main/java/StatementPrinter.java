import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

    public String print(Invoice invoice, Map<String, Play> plays) {
        var totalAmount = 0;
        var volumeCredits = 0;
        var result = invoice.formatCustomerStatement();

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

        for (var perf : invoice) {
            var play = plays.get(perf.playID());
            totalAmount += play.getAmount(perf);
            volumeCredits += play.getVolumeCredits(perf);

            result += play.formatAmount(perf);

        }

        result += String.format("Amount owed is %s\n", formatter.format(totalAmount / 100));
        result += String.format("You earned %s credits\n", volumeCredits);
        return result;
    }


}
