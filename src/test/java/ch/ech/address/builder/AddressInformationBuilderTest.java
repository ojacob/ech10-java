package ch.ech.address.builder;

import ch.ech.address.AddressInformation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddressInformationBuilderTest {
    @Test
    public void testBuild() {
        String addressLine1 = "Chez Robert";
        String addressLine2 = "Chalet les Myriades";
        String street = "Grande Rue";
        String houseNumber = "12";
        long swissZipCode = 1356l;
        String town = "Corcelles-le-Jorat";
        String country = "CH";

        AddressInformationBuilder builder = new AddressInformationBuilder();
        builder.addressLine1(addressLine1)
                .addressLine2(addressLine2)
                .street(street)
                .houseNumber(houseNumber)
                .swissZipCode(swissZipCode)
                .town(town)
                .country(country);

        AddressInformation info = builder.build();

        assertEquals(addressLine1, info.getAddressLine1());
        assertEquals(addressLine2, info.getAddressLine2());
        assertEquals(street, info.getStreet());
        assertEquals(houseNumber, info.getHouseNumber());
        assertTrue(swissZipCode == info.getSwissZipCode());
        assertEquals(town, info.getTown());
        assertEquals(country, info.getCountry());
    }
}
