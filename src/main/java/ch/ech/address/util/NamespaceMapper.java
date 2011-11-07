package ch.ech.address.util;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NamespaceMapper extends NamespacePrefixMapper {

    private Map<String, String> registeredNamespaces;
    private String[] preDeclaredNamespaceUris;
    private String[] contextualNamespaceDecls;

    protected NamespaceMapper() {}

    /**
     * Register namespaces mapping
     * @param registeredNamespaces a map associating namespaces to prefixes
     */
    public NamespaceMapper(Map<String, String> registeredNamespaces) {
        configureNamespaces(registeredNamespaces);
    }

    @Override
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
        String ns = this.registeredNamespaces.get(namespaceUri);

        return ns == null ? "" : ns;
    }

    @Override
    public String[] getPreDeclaredNamespaceUris() {
        return preDeclaredNamespaceUris;
    }

    @Override
    public String[] getContextualNamespaceDecls() {
        return contextualNamespaceDecls;
    }

    protected void configureNamespaces(Map<String, String> registeredNamespaces) {
        List<String> uris = new ArrayList<String>();
        List<String> nsDecls = new ArrayList<String>();

        this.registeredNamespaces = new HashMap<String, String>();
        for (String ns : registeredNamespaces.keySet()) {
            this.registeredNamespaces.put(ns, registeredNamespaces.get(ns));

            uris.add(ns);

            nsDecls.add(ns);
            nsDecls.add(registeredNamespaces.get(ns));
        }

        this.preDeclaredNamespaceUris = uris.toArray(new String[uris.size()]);
        this.contextualNamespaceDecls = nsDecls.toArray(new String[nsDecls.size()]);
    }
}
