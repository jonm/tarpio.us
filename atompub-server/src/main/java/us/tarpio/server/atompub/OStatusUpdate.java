package us.tarpio.server.atompub;

import java.util.Date;

public class OStatusUpdate {
    private String id;
    private Date updated;
    private Date published;
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * @return the updated
     */
    public Date getUpdated() {
        return updated;
    }
    /**
     * @param updated the updated to set
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
    /**
     * @return the published
     */
    public Date getPublished() {
        return published;
    }
    /**
     * @param published the published to set
     */
    public void setPublished(Date published) {
        this.published = published;
    }
    
    
}
