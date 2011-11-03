package ch.ech.address.util;


import ch.ech.address.MailAddress;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;

public class MailAddressUnmarshaller {
    public MailAddress unmarshal(File file) throws JAXBException {
        return (MailAddress) getUnmarshaller().unmarshal(file);
    }

    @SuppressWarnings("unchecked")
    public MailAddress unmarshal(InputStream inputStream) throws JAXBException {
        return ((JAXBElement<MailAddress>) getUnmarshaller().unmarshal(inputStream)).getValue();
    }

    @SuppressWarnings("unchecked")
    public MailAddress unmarshal(Reader reader) throws JAXBException {
        return ((JAXBElement<MailAddress>) getUnmarshaller().unmarshal(reader)).getValue();
    }

    @SuppressWarnings("unchecked")
    public MailAddress unmarshal(URL url) throws JAXBException {
        return ((JAXBElement<MailAddress>) getUnmarshaller().unmarshal(url)).getValue();
    }

    @SuppressWarnings("unchecked")
    public MailAddress unmarshal(InputSource inputSource) throws JAXBException {
        return ((JAXBElement<MailAddress>) getUnmarshaller().unmarshal(inputSource)).getValue();
    }

    @SuppressWarnings("unchecked")
    public MailAddress unmarshal(Node node) throws JAXBException {
        return ((JAXBElement<MailAddress>) getUnmarshaller().unmarshal(node)).getValue();
    }

    @SuppressWarnings("unchecked")
    public MailAddress unmarshal(Source source) throws JAXBException {
        return ((JAXBElement<MailAddress>) getUnmarshaller().unmarshal(source)).getValue();
    }

    @SuppressWarnings("unchecked")
    public MailAddress unmarshal(XMLStreamReader xmlStreamReader) throws JAXBException {
        return ((JAXBElement<MailAddress>) getUnmarshaller().unmarshal(xmlStreamReader)).getValue();
    }

    @SuppressWarnings("unchecked")
    public MailAddress unmarshal(XMLEventReader xmlEventReader) throws JAXBException {
        return ((JAXBElement<MailAddress>) getUnmarshaller().unmarshal(xmlEventReader)).getValue();
    }

    private Unmarshaller getUnmarshaller() throws JAXBException {
        return getJAXBContext().createUnmarshaller();
    }

    private JAXBContext getJAXBContext() throws JAXBException {
        return JAXBContext.newInstance(MailAddress.class.getPackage().getName());
    }
}
