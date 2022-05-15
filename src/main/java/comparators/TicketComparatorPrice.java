package comparators;

import tickets.Ticket;
import java.util.Comparator;

public class TicketComparatorPrice implements Comparator<Ticket> {

    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getPrice() - o2.getPrice();
    }
}