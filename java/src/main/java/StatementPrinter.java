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
        var totalAmount = 0;
        var volumeCredits = 0;
        var result = invoice.formatCustomerStatement();

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

        totalAmount = invoice.getTotalAmount(plays);
        volumeCredits = invoice.getVolumeCredits(plays);

        result += invoice.formatPlayResults(plays);

        result += String.format("Amount owed is %s\n", formatter.format(totalAmount / 100));
        result += String.format("You earned %s credits\n", volumeCredits);
        return result;
    }


}
