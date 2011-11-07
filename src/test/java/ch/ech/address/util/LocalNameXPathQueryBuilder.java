package ch.ech.address.util;

/**
 * @author Olivier Jacob
 */
public class LocalNameXPathQueryBuilder implements XPathQueryBuilder {
    public String build(String... elements) {
        StringBuilder xpath = new StringBuilder(64);

        for (String elt : elements) {
            xpath.append("/*[local-name()='").append(elt).append("']");
        }

        return xpath.toString();
    }
}
