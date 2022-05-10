package manager;

import org.junit.jupiter.api.Test;
import tickets.Ticket;
import static org.junit.jupiter.api.Assertions.*;

class FlightManagerTest {

    FlightManager manager = new FlightManager();
    Ticket ticket1 = new Ticket(1, 5000, "Kolcovo", "Sheremetevo", 150);
    Ticket ticket2 = new Ticket(2, 6000, "Kolcovo", "Sheremetevo", 151);
    Ticket ticket3 = new Ticket(3, 7000, "Kolcovo", "Sheremetevo1", 152);
    Ticket ticket4 = new Ticket(4, 8000, "Kolcovo", "Sheremetevo", 152);
    Ticket ticket5 = new Ticket(5, 9000, "Kolcovo", "Sheremetevo1", 152);
    Ticket ticket6 = new Ticket(5, 10000, "Kolcovo1", "Sheremetevo", 152);
    Ticket ticket7 = new Ticket(5, 11000, "Kolcovo1", "Sheremetevo", 152);

    @Test
    public void shouldFindAll() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = new Ticket[]{ticket1, ticket2, ticket4};
        Ticket[] actual = manager.findAll("Kolcovo", "Sheremetevo");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll1() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = new Ticket[]{ticket6, ticket7};
        Ticket[] actual = manager.findAll("Kolcovo1", "Sheremetevo");

        assertArrayEquals(expected, actual);
    }
}
