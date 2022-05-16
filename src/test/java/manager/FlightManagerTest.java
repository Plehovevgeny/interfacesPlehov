package manager;

import comparators.TicketComparatorPrice;
import comparators.TicketComparatorTimeFlight;
import org.junit.jupiter.api.Test;
import tickets.Ticket;
import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.*;

class FlightManagerTest {

    FlightManager manager = new FlightManager();
    Comparator<Ticket> comparatorByPrice = new TicketComparatorPrice();
    Comparator<Ticket> comparatorByTimeFlight = new TicketComparatorTimeFlight();

    Ticket ticket1 = new Ticket(1, 5000, "Kolcovo", "Sheremetevo", 156);
    Ticket ticket2 = new Ticket(2, 6000, "Kolcovo", "Sheremetevo", 155);
    Ticket ticket3 = new Ticket(3, 7000, "Kolcovo", "Sheremetevo", 154);
    Ticket ticket4 = new Ticket(4, 8000, "Kolcovo", "Sheremetevo1", 153);
    Ticket ticket5 = new Ticket(5, 9000, "Kolcovo", "Sheremetevo1", 152);
    Ticket ticket6 = new Ticket(6, 10000, "Kolcovo1", "Sheremetevo", 151);
    Ticket ticket7 = new Ticket(7, 11000, "Kolcovo1", "Sheremetevo", 150);

    @Test
    public void shouldFindAllEmptyTicketsComparatorByPrice() {

        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.findAll("Kolcovo", "Sheremetevo", comparatorByPrice);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllOneTicketComparatorByPrice() {

        manager.add(ticket1);

        Ticket[] expected = new Ticket[]{ticket1};
        Ticket[] actual = manager.findAll("Kolcovo", "Sheremetevo", comparatorByPrice);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllFiveTicketComparatorByPrice() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = new Ticket[]{ticket1, ticket2, ticket3};
        Ticket[] actual = manager.findAll("Kolcovo", "Sheremetevo", comparatorByPrice);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllFiveTicketComparatorByPrice1() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = new Ticket[]{ticket6, ticket7};
        Ticket[] actual = manager.findAll("Kolcovo1", "Sheremetevo", comparatorByPrice);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllEmptyTicketsComparatorByTimeFlight() {

        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.findAll("Kolcovo", "Sheremetevo", comparatorByTimeFlight);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllOneTicketsComparatorByTimeFlight() {

        manager.add(ticket1);

        Ticket[] expected = new Ticket[]{ticket1};
        Ticket[] actual = manager.findAll("Kolcovo", "Sheremetevo", comparatorByTimeFlight);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllSevenTicketsComparatorByTimeFlight() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = new Ticket[]{ticket7, ticket6};
        Ticket[] actual = manager.findAll("Kolcovo1", "Sheremetevo", comparatorByTimeFlight);

        assertArrayEquals(expected, actual);
    }
}
