package us.tarpio.server.atompub;

import org.apache.abdera.protocol.server.Provider;
import org.apache.abdera.protocol.server.impl.DefaultProvider;
import org.apache.abdera.protocol.server.impl.SimpleWorkspaceInfo;
import org.apache.abdera.protocol.server.servlet.AbderaServlet;

public class OStatusUpdateProviderServlet extends AbderaServlet {

    private static final long serialVersionUID = 1L;

    protected Provider createProvider() {
        OStatusUpdateCollectionAdapter ca = new OStatusUpdateCollectionAdapter();
        ca.setHref("ostatus");
        
        SimpleWorkspaceInfo wi = new SimpleWorkspaceInfo();
        wi.setTitle("OStatus Workspace");
        wi.addCollection(ca);
        
        DefaultProvider provider = new DefaultProvider("/");
        provider.addWorkspace(wi);
        
        provider.init(getAbdera(), null);
        return provider;
    }

}
