package avd.jdm.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Property {
    private String address;
    private PropertyType propertyType;
    private int livingArea;
    private Integer priceAsked;

    private List<Bid> bids = new ArrayList<>();
    private List<Picture> pictures = new ArrayList<>();

    public String getAddress() {
        return address;
    }

    public int getLivingArea() {
        return livingArea;
    }

    public Integer getPriceAsked() {
        return priceAsked;
    }

    public Property(String address, PropertyType propertyType, int livingArea, Integer priceAsked) {
        this.address = address;
        this.propertyType = propertyType;
        this.livingArea = livingArea;
        this.priceAsked = priceAsked;
    }

    public Property(String address, PropertyType propertyType, int livingArea) {
        this(address, propertyType, livingArea, null);
    }


    public void doOffer(Customer customer, int priceOffered) {
        if (isAccepted(priceOffered)) {
            // here we can see the composition relationship (instead of aggregation) between Property and Bid
            bids.add(new Bid(customer, priceOffered));
        }
    }

    private boolean isAccepted(int priceOffered) {
        Optional<Bid> previousMaxOffer
                = bids.stream().max((b1, b2) -> b1.getPriceOffered() - b2.getPriceOffered());

        if (previousMaxOffer.isPresent()) {
            return previousMaxOffer.get().getPriceOffered() < priceOffered;
        } else {
            return false;
        }
    }

    public void addPicture(Picture picture) {
        // here we can see the aggregation (instead of composition) relationship between Property and Picture
        pictures.add(picture);
    }

    @Override
    public String toString() {
        return propertyType + " at " + address  +
                ", priceAsked=" + priceAsked;
    }
}
