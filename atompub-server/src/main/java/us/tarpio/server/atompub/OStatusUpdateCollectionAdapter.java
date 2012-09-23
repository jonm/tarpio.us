package us.tarpio.server.atompub;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Content;
import org.apache.abdera.model.Person;
import org.apache.abdera.model.Text;
import org.apache.abdera.protocol.server.RequestContext;
import org.apache.abdera.protocol.server.context.ResponseContextException;
import org.apache.abdera.protocol.server.impl.AbstractEntityCollectionAdapter;

public class OStatusUpdateCollectionAdapter extends AbstractEntityCollectionAdapter<OStatusUpdate> {

    private Map<String, OStatusUpdate> updates = new HashMap<String, OStatusUpdate>();
    
    public String getTitle(RequestContext request) {
        return "OStatus Updates";
    }

    @Override
    public void deleteEntry(String resourceName, RequestContext request)
            throws ResponseContextException {
        updates.remove(resourceName);
    }

    @Override
    public Object getContent(OStatusUpdate arg0, RequestContext arg1)
            throws ResponseContextException {
        return null;
    }

    @Override
    public Iterable<OStatusUpdate> getEntries(RequestContext request)
            throws ResponseContextException {
        return updates.values();
    }

    @Override
    public OStatusUpdate getEntry(String resourceName, RequestContext request)
            throws ResponseContextException {
        return updates.get(resourceName);
    }

    @Override
    public String getId(OStatusUpdate update) throws ResponseContextException {
        return update.getId();
    }

    @Override
    public String getName(OStatusUpdate update) throws ResponseContextException {
        return update.getId();
    }

    @Override
    public String getTitle(OStatusUpdate update) throws ResponseContextException {
        return "OStatus Update";
    }

    @Override
    public Date getUpdated(OStatusUpdate update) throws ResponseContextException {
        return update.getUpdated();
    }

    @Override
    public OStatusUpdate postEntry(String title, IRI id, String summary,
            Date updated, List<Person> authors, Content content, RequestContext request)
            throws ResponseContextException {
        OStatusUpdate update = new OStatusUpdate();
        update.setId(IRI.normalize(id).toString());
        update.setUpdated(updated);
        update.setPublished(new Date());
        updates.put(update.getId(), update);
        return update;
    }

    @Override
    public void putEntry(OStatusUpdate update, String title, Date updated,
            List<Person> authors, String summary, Content content, RequestContext request)
            throws ResponseContextException {
        update.setUpdated(updated);
    }

    @Override
    public String getAuthor(RequestContext request)
            throws ResponseContextException {
        return "Jon Moore";
    }

    @Override
    public String getId(RequestContext request) {
        return "tag:jjmoore.net,2012:feed:ostatus:jonm";
    }

    @Override
    public List<Person> getAuthors(OStatusUpdate entry, RequestContext request)
        throws ResponseContextException {
        Person author = request.getAbdera().getFactory().newAuthor();
        author.setName("Jon Moore");
        return Arrays.asList(author);
    }
    
    @Override
    public Text getSummary(OStatusUpdate entry, RequestContext request) {
        Text text = request.getAbdera().getFactory().newSummary();
        text.setText("An OStatus update");
        return text;
    }
}
