import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Invoice implements Iterable<Performance>{

    private final String customer;
    private final List<Performance> performances = new ArrayList<>();

    public Invoice(String customer) {
        this.customer = customer;
    }

    @Override
    public Iterator<Performance> iterator() {
        return performances.iterator();
    }

    public String formatCustomerStatement() {
        return String.format("Statement for %s\n", customer);
    }

    public void addPerformances(List<Performance> performances){
        this.performances.addAll(performances);
    }
}
