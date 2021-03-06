package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * MediaentryIdsT generated by hbm2java
 */
@Entity
@Table(name="MEDIAENTRY_IDS_T"
)
public class MediaentryIdsT  implements java.io.Serializable {


     private MediaentryIdsTId id;

    public MediaentryIdsT() {
    }

    public MediaentryIdsT(MediaentryIdsTId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="processId", column=@Column(name="PROCESS_ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="entryId", column=@Column(name="ENTRY_ID", nullable=false, precision=20, scale=0) ) } )
    public MediaentryIdsTId getId() {
        return this.id;
    }
    
    public void setId(MediaentryIdsTId id) {
        this.id = id;
    }




}


