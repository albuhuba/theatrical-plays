import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

    public String print(Invoice invoice, Map<String, Play> plays){
        if (null == invoice || null == plays || plays.isEmpty()){
            throw new IllegalArgumentException("Parameters null or empty");
        }
        return printInternal(invoice, plays);
    }

    private String printInternal(Invoice invoice, Map<String, Play> plays) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

        var totalAmount = invoice.getTotalAmount(plays);
        var volumeCredits = invoice.getVolumeCredits(plays);

        var result = invoice.formatCustomerStatement();
        result += invoice.formatPlayResults(plays);
        result += String.format("Amount owed is %s\n", formatter.format(totalAmount / 100));
        result += String.format("You earned %s credits\n", volumeCredits);

        return result;
    }


}
