package repository;

import tickets.Ticket;

public class TicketsRepository {

    //constructors

    public Ticket[] tickets = new Ticket[0];

    public TicketsRepository() {
    }

    public TicketsRepository(Ticket[] tickets) {
        this.tickets = tickets;
    }

    //getters and setters

    protected Ticket[] getTickets() {
        return tickets;
    }

    public void setTickets(Ticket[] tickets) {
        this.tickets = tickets;
    }

    //methods
    // добавление в репозиторий

    public void add(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    //вывод всех билетов

    public Ticket[] findAll() {
        return getTickets();
    }

}