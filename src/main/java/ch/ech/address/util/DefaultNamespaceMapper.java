package ch.ech.address.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Olivier Jacob
 */
public class DefaultNamespaceMapper extends NamespaceMapper {
    public DefaultNamespaceMapper() {
        Map<String, String> registeredNamespaces = getRegisteredNamespaces();

        configureNamespaces(registeredNamespaces);
    }

    private Map<String, String> getRegisteredNamespaces() {
        Map<String, String> registeredNamespaces = new HashMap<String, String>();
        registeredNamespaces.put("http://www.ech.ch/xmlns/eCH-0010/4", "ech10");
        return registeredNamespaces;
    }
}
