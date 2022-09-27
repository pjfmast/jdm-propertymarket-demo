package avd.jdm;

import avd.jdm.domain.Property;
import avd.jdm.domain.PropertyMarket;
import avd.jdm.domain.PropertyType;

import java.util.List;

public class Main {
    public static void main(String[] args) {
// gebruik tweede constructor, waarbij de priceAsked onbekend is:
        Property mijnHuis = new Property("breda, hogeschoollaan", PropertyType.HOUSE, 120000);

        Property p1 = new Property("Ginneken", PropertyType.HOUSE, 160,  650000);
        Property p2 = new Property("Tilburg", PropertyType.APARTMENT, 90, 360000);
        Property p3 = new Property("Made", PropertyType.GARAGE, 50, 25000);
        Property p4 = new Property("Breda", PropertyType.APARTMENT, 160, 410000);


        PropertyMarket mijnMarktplaats = new PropertyMarket();
        mijnMarktplaats.addProperties(p1, p2, p3, p4);

        System.out.println(mijnHuis);

        List<Property> found = mijnMarktplaats.search(30000, 999999);
        for (Property property : found) {
            System.out.println(property);
        }

    }
}