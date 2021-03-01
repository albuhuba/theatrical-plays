import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Invoice {

    private final String customer;
    private final Map<String, Play> plays = new HashMap<>();
    private final List<Performance> performances = new ArrayList<>();

    public Invoice(String customer) {
        this.customer = customer;
    }

    public void addPerformances(List<Performance> performances){
        this.performances.addAll(performances);
    }

    public void addPlays(Map<String,Play> plays){
        this.plays.putAll(plays);
    }

    public String formatCustomerStatement() {
        return String.format("Statement for %s\n", customer);
    }

    public String formatPlayResults() {
        return performances.stream().map(p->plays.get(p.playID()).formatAmount(p)).collect(Collectors.joining(""));
    }

    public int getTotalAmount() {
        return performances.stream().mapToInt(p -> plays.get(p.playID()).getAmount(p)).sum();
    }

    public int getVolumeCredits() {
        return performances.stream().mapToInt(p -> plays.get(p.playID()).getVolumeCredits(p)).sum();
    }

    public String formatTotalAmount(int totalAmount, NumberFormat formatter) {
        return String.format("Amount owed is %s\n", formatter.format(totalAmount / 100));
    }

    public String formatVolumeCredits(int volumeCredits) {
        return String.format("You earned %s credits\n", volumeCredits);
    }
}
