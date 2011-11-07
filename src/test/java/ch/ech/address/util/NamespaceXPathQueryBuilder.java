package ch.ech.address.util;

/**
 * @author Olivier Jacob
 */
public class NamespaceXPathQueryBuilder implements XPathQueryBuilder {
    private String namespace;

    public NamespaceXPathQueryBuilder(String namespace) {
        this.namespace = namespace;
    }

    public String build(String... elements) {
        StringBuilder xpath = new StringBuilder(64);

        for (String elt : elements) {
            xpath.append("/").append(this.namespace).append(":").append(elt);
        }

        return xpath.toString();
    }
}
