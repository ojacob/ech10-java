package ch.ech.address.util;

import ch.ech.address.MailAddress;
import ch.ech.address.builder.MailAddressBuilder;
import org.custommonkey.xmlunit.SimpleNamespaceContext;
import org.custommonkey.xmlunit.XMLUnit;
import org.custommonkey.xmlunit.exceptions.XpathException;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static org.custommonkey.xmlunit.XMLAssert.assertXpathEvaluatesTo;

public class MailAddressMarshallerTest {
    @Test
    public void testMarshallingWithoutNamespace() throws IOException, SAXException, XpathException {
        MailAddress addr = createAddressObject();

        performAsserts(addr, new MailAddressMarshaller(), new LocalNameXPathQueryBuilder());
    }

    @Test
    public void testMarshallingWithNamespace() throws IOException, SAXException, XpathException {
        setGlobalNamespaceContext("ech10", "http://www.ech.ch/xmlns/eCH-0010/4");

        // Default namespace is ech10
        MailAddressMarshaller m = new MailAddressMarshaller(new DefaultNamespaceMapper());

        MailAddress addr = createAddressObject();

        performAsserts(addr, m, new NamespaceXPathQueryBuilder("ech10"));
    }

    private MailAddress createAddressObject() {
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

        return address.build();
    }

    private void performAsserts(MailAddress addr, MailAddressMarshaller m, XPathQueryBuilder xpathBuilder)
            throws SAXException, IOException, XpathException {
        StringWriter writer = new StringWriter();

        try {
            m.marshal(addr, writer);
        } catch (JAXBException jaxbe) {
            Assert.fail("No exception should be thrown here. Got this one : " + jaxbe.getMessage());
            return ;
        }

        String xml = writer.toString();

        assertXpathEvaluatesTo(addr.getPerson().getMrMrs(), xpathBuilder.build("mailAddress", "person", "mrMrs"), xml);
        assertXpathEvaluatesTo(addr.getPerson().getFirstName(), xpathBuilder.build("mailAddress", "person", "firstName"), xml);
        assertXpathEvaluatesTo(addr.getPerson().getLastName(), xpathBuilder.build("mailAddress", "person", "lastName"), xml);

        assertXpathEvaluatesTo(addr.getAddressInformation().getAddressLine1(), xpathBuilder.build("mailAddress", "addressInformation", "addressLine1"), xml);
        assertXpathEvaluatesTo(addr.getAddressInformation().getAddressLine2(), xpathBuilder.build("mailAddress", "addressInformation", "addressLine2"), xml);
        assertXpathEvaluatesTo(addr.getAddressInformation().getStreet(), xpathBuilder.build("mailAddress", "addressInformation", "street"), xml);
        assertXpathEvaluatesTo(addr.getAddressInformation().getHouseNumber(), xpathBuilder.build("mailAddress", "addressInformation", "houseNumber"), xml);
        assertXpathEvaluatesTo(addr.getAddressInformation().getDwellingNumber(), xpathBuilder.build("mailAddress", "addressInformation", "dwellingNumber"), xml);
        assertXpathEvaluatesTo(String.valueOf(addr.getAddressInformation().getPostOfficeBoxNumber()), xpathBuilder.build("mailAddress", "addressInformation", "postOfficeBoxNumber"), xml);
        assertXpathEvaluatesTo(addr.getAddressInformation().getTown(), xpathBuilder.build("mailAddress", "addressInformation", "town"), xml);
        assertXpathEvaluatesTo(String.valueOf(addr.getAddressInformation().getSwissZipCode()), xpathBuilder.build("mailAddress", "addressInformation", "swissZipCode"), xml);
        assertXpathEvaluatesTo(addr.getAddressInformation().getSwissZipCodeAddOn(), xpathBuilder.build("mailAddress", "addressInformation", "swissZipCodeAddOn"), xml);
        assertXpathEvaluatesTo(String.valueOf(addr.getAddressInformation().getSwissZipCodeId()), xpathBuilder.build("mailAddress", "addressInformation", "swissZipCodeId"), xml);
        assertXpathEvaluatesTo(addr.getAddressInformation().getCountry(), xpathBuilder.build("mailAddress", "addressInformation", "country"), xml);
    }

    private void setGlobalNamespaceContext(String prefix, String uri) {
        Map<String, String> prefixMap = new HashMap<String, String>();
        prefixMap.put(prefix, uri);
        XMLUnit.setXpathNamespaceContext(new SimpleNamespaceContext(prefixMap));
    }
}
