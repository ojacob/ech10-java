package ch.ech.address.builder;

import ch.ech.address.PersonMailAddressInfo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonMailAddressInfoBuilderTest {
    @Test
    public void testBuild() {
        String mrMrs = "1";
        String firstName = "Olivier";
        String lastName = "Jacob";

        PersonMailAddressInfoBuider builder = new PersonMailAddressInfoBuider();
        builder.mrMrs(mrMrs).firstName(firstName).lastName(lastName);

        PersonMailAddressInfo info = builder.build();

        assertEquals(mrMrs, info.getMrMrs());
        assertEquals(firstName, info.getFirstName());
        assertEquals(lastName, info.getLastName());
    }
}
