import java.util.Iterator;
import java.util.List;

public class Invoice implements Iterable<Performance>{

    private final String customer;
    private final List<Performance> performances;

    public Invoice(String customer, List<Performance> performances) {
        this.customer = customer;
        this.performances = performances;
    }

    @Override
    public Iterator<Performance> iterator() {
        return performances.iterator();
    }

    public String formatCustomerStatement() {
        return String.format("Statement for %s\n", customer);
    }
}
