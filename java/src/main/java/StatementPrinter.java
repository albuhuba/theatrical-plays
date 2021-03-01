import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

    public String print(Invoice invoice){
        if (null == invoice){
            throw new IllegalArgumentException("Parameters null or empty");
        }
        var totalAmount = invoice.getTotalAmount();
        var volumeCredits = invoice.getVolumeCredits();
        return printInternal(invoice, totalAmount, volumeCredits);
    }

    private String printInternal(Invoice invoice, int totalAmount, int volumeCredits) {
        return invoice.formatInvoice();
    }

}
