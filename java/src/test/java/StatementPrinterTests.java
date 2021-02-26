import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.approvaltests.Approvals.verify;

public class StatementPrinterTests {

    @Test
    void exampleStatement() {
        Map<String, Play> plays = Map.of(
                "hamlet",  new TragedyPlay("Hamlet"),
                "as-like", new ComedyPlay("As You Like It"),
                "othello", new TragedyPlay("Othello"));
        Invoice invoice = new InvoiceBuilder()
                .customer("BigCo")
                .performance("hamlet", 55)
                .performance("as-like", 35)
                .performance("othello", 40)
                .build();

        StatementPrinter statementPrinter = new StatementPrinter();
        var result = statementPrinter.print(invoice, plays);

        verify(result);
    }

    @Test
    void statementWithNewPlayTypes() {
        Map<String, Play> plays = Map.of(
                "henry-v",  new HistoryPlay("Henry V"),
                "as-like", new PastoralPlay("As You Like It"));

        Invoice invoice = new InvoiceBuilder()
                .customer("BigCo")
                .performance("henry-v", 53)
                .performance("as-like", 55)
                .build();

        StatementPrinter statementPrinter = new StatementPrinter();
        Assertions.assertThrows(Error.class, () -> {
            statementPrinter.print(invoice, plays);
        });
    }

    private static class InvoiceBuilder{

        private String customer;

        private List<Performance> performances = new ArrayList<>();

        public InvoiceBuilder customer(String customer) {
            this.customer = customer;
            return this;
        }

        public InvoiceBuilder performance(String playId, int audience) {
            this.performances.add(new Performance(playId, audience));
            return this;
        }

        public Invoice build() {
            Invoice invoice = new Invoice(customer);
            invoice.addPerformances(performances);
            return invoice;
        }
    }
}

