package manager;

import repository.TicketsRepository;
import tickets.Ticket;

import java.util.Arrays;
import java.util.Comparator;

public class FlightManager {

    TicketsRepository repository = new TicketsRepository();

    //constructors

    public FlightManager() {
    }

    public FlightManager(TicketsRepository repository) {
        this.repository = repository;
    }

    //getters and setters

    public TicketsRepository getRepository() {
        return repository;
    }

    public void setRepository(TicketsRepository repository) {
        this.repository = repository;
    }

    //methods

    public void add(Ticket ticket) {
        repository.add(ticket);
    }

    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        //сортировка по увеличению price или самому маленькому времени
        Arrays.sort(result, comparator);
        return result;
    }

    // метод определения соответствия ticket запросу findAll

    public boolean matches(Ticket ticket, String from, String to) {
        if (!ticket.getFrom().equals(from)) {
            return false;
        }
        if (!ticket.getTo().equals(to)) {
            return false;
        }
        return true;
    }

//    public void removeId(int id) {
//        repository.removeId(id);
//    }
}
