import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public String formatPlayResults(Map<String,Play> plays) {
        return performances.stream().map(p->plays.get(p.playID()).formatAmount(p)).collect(Collectors.joining(""));
    }

    public int getTotalAmount(Map<String,Play> plays) {
        return performances.stream().mapToInt(p -> plays.get(p.playID()).getAmount(p)).sum();
    }
}
