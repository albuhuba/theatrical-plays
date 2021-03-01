import model.Invoice;

// Service
// stateless
public class StatementPrinterService {

    public String print(Invoice invoice) {
        if (null == invoice) {
            throw new IllegalArgumentException("model.Invoice can't be null!");
        }
        return printInternal(invoice);
    }

    private String printInternal(Invoice invoice) {
        return invoice.formatInvoice();
    }

}
