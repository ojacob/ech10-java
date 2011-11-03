package ch.ech.address.util;

import ch.ech.address.builder.MailAddressBuilder;
import org.custommonkey.xmlunit.exceptions.XpathException;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.StringWriter;

import static org.custommonkey.xmlunit.XMLAssert.assertXpathEvaluatesTo;

public class MailAddressMarshallerTest {
    @Test
    public void testMarshalling() throws IOException, SAXException, XpathException {
        String mrMrs = "1";
        String firstName = "Robert";
        String lastName = "Doe";
        String addressLine1 = "Chez Robert";
        String addressLine2 = "Chalet Edelweiss";
        String street = "Route du Jorat";
        String houseNumber = "14";
        String dwellingNumber = "Appartement 42";
        long postOfficeBoxNumber = 3l;
        String town = "Echallens";
        long swissZipCode = 1309l;
        String swissZipCodeAddOn = "26";
        int swissZipCodeId = 139;
        String country = "CH";

        MailAddressMarshaller m = new MailAddressMarshaller();
        StringWriter writer = new StringWriter();

        MailAddressBuilder address = MailAddressBuilder.newInstance();
        address.personMailAddressInfo().mrMrs(mrMrs).firstName(firstName).lastName(lastName);

        address.addressInformation()
                .addressLine1(addressLine1)
                .addressLine2(addressLine2)
                .street(street)
                .houseNumber(houseNumber)
                .dwellingNumber(dwellingNumber)
                .postOfficeBoxNumber(postOfficeBoxNumber)
                .town(town)
                .swissZipCode(swissZipCode)
                .swissZipCodeAddOn(swissZipCodeAddOn)
                .swissZipCodeId(swissZipCodeId)
                .country(country);

        try {
            m.marshal(address.build(), writer);
        } catch (JAXBException jaxbe) {
            Assert.fail("No exception should be thrown here. Got this one : " + jaxbe.getMessage());
        }

        String xml = writer.toString();

        assertXpathEvaluatesTo(mrMrs, generateXPathInPersonFor("mrMrs"), xml);
        assertXpathEvaluatesTo(firstName, generateXPathInPersonFor("firstName"), xml);
        assertXpathEvaluatesTo(lastName, generateXPathInPersonFor("lastName"), xml);

        assertXpathEvaluatesTo(addressLine1, generateXPathInAddressFor("addressLine1"), xml);
        assertXpathEvaluatesTo(addressLine2, generateXPathInAddressFor("addressLine2"), xml);
        assertXpathEvaluatesTo(street, generateXPathInAddressFor("street"), xml);
        assertXpathEvaluatesTo(houseNumber, generateXPathInAddressFor("houseNumber"), xml);
        assertXpathEvaluatesTo(dwellingNumber, generateXPathInAddressFor("dwellingNumber"), xml);
        assertXpathEvaluatesTo(String.valueOf(postOfficeBoxNumber), generateXPathInAddressFor("postOfficeBoxNumber"), xml);
        assertXpathEvaluatesTo(town, generateXPathInAddressFor("town"), xml);
        assertXpathEvaluatesTo(String.valueOf(swissZipCode), generateXPathInAddressFor("swissZipCode"), xml);
        assertXpathEvaluatesTo(swissZipCodeAddOn, generateXPathInAddressFor("swissZipCodeAddOn"), xml);
        assertXpathEvaluatesTo(String.valueOf(swissZipCodeId), generateXPathInAddressFor("swissZipCodeId"), xml);
        assertXpathEvaluatesTo(country, generateXPathInAddressFor("country"), xml);

    }

    private String generateXPathInAddressFor(String fieldName) {
        return generateXPathFor("mailAddress", "addressInformation", fieldName);
    }

    private String generateXPathInPersonFor(String fieldName) {
        return generateXPathFor("mailAddress", "person", fieldName);
    }

    private String generateXPathFor(String... elements) {
        StringBuilder xpath = new StringBuilder(64);

        for (String elt : elements) {
            xpath.append("/*[local-name()='").append(elt).append("']");
        }

        return xpath.toString();
    }
}
