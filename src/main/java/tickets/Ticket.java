package tickets;

import java.util.Arrays;


public class Ticket implements Comparable<Ticket> {

    @Override
    public int compareTo(Ticket o) {
        return this.getPrice() - o.getPrice();
    }

    private int id;
    private int price;
    private String from;
    private String to;
    private int timeFlight;


    //constructors

    public Ticket() {
    }

    public Ticket(int id, int price, String from, String to, int timeFlight) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.timeFlight = timeFlight;
    }

    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getTimeFlight() {
        return timeFlight;
    }

    public void setTimeFlight(int timeFlight) {
        this.timeFlight = timeFlight;
    }
}
