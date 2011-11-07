package ch.ech.address.util;


import ch.ech.address.MailAddress;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class MailAddressUnmarshallerTest {

    private MailAddressUnmarshaller unmarshaller;

    @Before
    public void createObjectUnderTest() {
        this.unmarshaller = new MailAddressUnmarshaller();
    }

    @Test
    public void testUnmarshallPersonAddress() throws JAXBException {
        MailAddress result = unmarshaller.unmarshal(getInputStreamForFilename("person1.xml"));

        assertNotNull(result);

        assertNotNull(result.getPerson());

        assertEquals("1", result.getPerson().getMrMrs());
        assertEquals("Responsable Développements", result.getPerson().getTitle());
        assertEquals("Robert", result.getPerson().getFirstName());
        assertEquals("Doe", result.getPerson().getLastName());

        assertEquals("Chez Robert", result.getAddressInformation().getAddressLine1());
        assertEquals("Chalet Edelweiss", result.getAddressInformation().getAddressLine2());
        assertEquals("Route de Jorat", result.getAddressInformation().getStreet());
        assertEquals("14", result.getAddressInformation().getHouseNumber());
        assertEquals("Appartement 42", result.getAddressInformation().getDwellingNumber());
        assertTrue(3 == result.getAddressInformation().getPostOfficeBoxNumber());
        assertEquals("Echallens", result.getAddressInformation().getTown());
        assertTrue(1309 == result.getAddressInformation().getSwissZipCode());
        assertEquals("26", result.getAddressInformation().getSwissZipCodeAddOn());
        assertTrue(139 == result.getAddressInformation().getSwissZipCodeId());

        assertNull(result.getOrganisation());
    }

    private InputStream getInputStreamForFilename(String filename) {
        return this.getClass().getClassLoader().getResourceAsStream(filename);
    }
}
