package ch.ech.address.util;

import ch.ech.address.MailAddress;
import ch.ech.address.ObjectFactory;
import com.sun.xml.bind.marshaller.NamespacePrefixMapper;
import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;
import java.io.File;
import java.io.OutputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class MailAddressMarshaller {
    private Map<String, String> registeredNamespaces;
    private NamespacePrefixMapper namespacePrefixMapper;
    private boolean withNamespaceMapper;

    public MailAddressMarshaller() {}

    public MailAddressMarshaller(NamespacePrefixMapper namespacePrefixMapper) {
        this.namespacePrefixMapper = namespacePrefixMapper;
        this.withNamespaceMapper = Boolean.TRUE;
    }

    public void registerNamespace(String prefix, String uri) {
        if (registeredNamespaces == null) {
            registeredNamespaces = new HashMap<String, String>();
        }

        registeredNamespaces.put(uri, prefix);
        this.withNamespaceMapper = Boolean.TRUE;
    }

    public void marshal(MailAddress mailAddress, XMLEventWriter writer) throws JAXBException {
        getMarshaller().marshal(createJAXBElement(mailAddress), writer);
    }

    public void marshal(MailAddress mailAddress, XMLStreamWriter writer) throws JAXBException {
        getMarshaller().marshal(createJAXBElement(mailAddress), writer);
    }

    public void marshal(MailAddress mailAddress, Node node) throws JAXBException {
        getMarshaller().marshal(createJAXBElement(mailAddress), node);
    }

    public void marshal(MailAddress mailAddress, ContentHandler handler) throws JAXBException {
        getMarshaller().marshal(createJAXBElement(mailAddress), handler);
    }

    public void marshal(MailAddress mailAddress, Writer writer) throws JAXBException {
        getMarshaller().marshal(createJAXBElement(mailAddress), writer);
    }

    public void marshal(MailAddress mailAddress, File output) throws JAXBException {
        getMarshaller().marshal(createJAXBElement(mailAddress), output);
    }

    public void marshal(MailAddress mailAddress, OutputStream os) throws JAXBException {
        getMarshaller().marshal(createJAXBElement(mailAddress), os);
    }

    public void marshal(MailAddress mailAddress, Result result) throws JAXBException {
        getMarshaller().marshal(createJAXBElement(mailAddress), result);
    }

    private Marshaller getMarshaller() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(MailAddress.class);

        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        if (withNamespaceMapper) {
            m.setProperty("com.sun.xml.bind.namespacePrefixMapper", getNamespaceMapper());
        }

        return m;
    }

    private ObjectFactory getObjectFactory() {
        return new ObjectFactory();
    }

    private JAXBElement<MailAddress> createJAXBElement(MailAddress mailAddress) {
        return getObjectFactory().createMailAddress(mailAddress);
    }

    private NamespacePrefixMapper getNamespaceMapper() {
        return this.namespacePrefixMapper != null ? this.namespacePrefixMapper : new NamespaceMapper(registeredNamespaces);
    }
}
