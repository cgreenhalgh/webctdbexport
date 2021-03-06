package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * CmsContentEntryT generated by hbm2java
 */
@Entity
@Table(name="CMS_CONTENT_ENTRY_T"
)
public class CmsContentEntryT  implements java.io.Serializable {


     private CmsContentEntryTId id;

    public CmsContentEntryT() {
    }

    public CmsContentEntryT(CmsContentEntryTId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="opId", column=@Column(name="OP_ID", nullable=false, precision=20, scale=0) ) } )
    public CmsContentEntryTId getId() {
        return this.id;
    }
    
    public void setId(CmsContentEntryTId id) {
        this.id = id;
    }




}


