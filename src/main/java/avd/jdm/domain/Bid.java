package avd.jdm.domain;

import java.time.LocalDateTime;

public class Bid {
    private Customer customer;
    private int priceOffered;
    private LocalDateTime timeOfBid;

    public Bid(Customer customer, int priceOffered) {
        this.customer = customer;
        this.priceOffered = priceOffered;
        timeOfBid = LocalDateTime.now();
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getPriceOffered() {
        return priceOffered;
    }

    public LocalDateTime getTimeOfBid() {
        return timeOfBid;
    }
}
