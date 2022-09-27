package avd.jdm.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PropertyMarket {

    private List<Property> properties = new ArrayList<>();


    public void addProperties(Property... properties) {
        this.properties.addAll(Arrays.asList(properties));
    }

    public List<Property> search(int maxPrice) {
        return search(0, maxPrice);
    }
    public List<Property> search(int minPrice, int maxPrice) {
        List<Property> found = new ArrayList<>();
        for (Property property : properties) {
            if (property.getPriceAsked() == null) {
                // properties without a askingPrice are also returned
                found.add(property);
            }
            // A asking price is present and not null:
            int priceAsked = property.getPriceAsked();
            if (minPrice <= priceAsked && priceAsked <= maxPrice) {
                found.add(property);
            }
        }
        return found;
    }
}
