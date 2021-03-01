import model.Invoice;
import model.Performance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import play.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.approvaltests.Approvals.verify;

public class StatementPrinterTests {

    @Test
    void exampleStatement() {
        Invoice invoice = new InvoiceBuilder()
                .customer("BigCo")
                .performance("hamlet", 55)
                .performance("as-like", 35)
                .performance("othello", 40)
                .play("hamlet",  new TragedyPlay("Hamlet"))
                .play("as-like", new ComedyPlay("As You Like It"))
                .play("othello", new TragedyPlay("Othello"))
                .build();

        StatementPrinter statementPrinter = new StatementPrinter();
        var result = statementPrinter.print(invoice);

        verify(result);
    }

    @Test
    void statementWithNewPlayTypes() {
        Invoice invoice = new InvoiceBuilder()
                .customer("BigCo")
                .performance("henry-v", 53)
                .performance("as-like", 55)
                .play("henry-v",  new HistoryPlay("Henry V"))
                .play("as-like", new PastoralPlay("As You Like It"))
                .build();

        StatementPrinter statementPrinter = new StatementPrinter();
        Assertions.assertThrows(Error.class, () -> {
            statementPrinter.print(invoice);
        });
    }

    private static final class InvoiceBuilder{

        private String customer;

        private final List<Performance> performances;
        private final Map<String, AbstractPlay> plays;

        public InvoiceBuilder(){
            this.performances = new ArrayList<>();
            this.plays = new HashMap<>();
        }

        public InvoiceBuilder customer(String customer) {
            this.customer = customer;
            return this;
        }

        public InvoiceBuilder performance(String playId, int audience) {
            this.performances.add(new Performance(playId, audience));
            return this;
        }

        public InvoiceBuilder play(String name, AbstractPlay play){
            this.plays.put(name, play);
            return this;
        }

        public Invoice build() {
            Invoice invoice = new Invoice(customer);
            invoice.addPerformances(performances);
            invoice.addPlays(plays);
            return invoice;
        }
    }
}

