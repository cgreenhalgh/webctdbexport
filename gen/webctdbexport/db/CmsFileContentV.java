package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * CmsFileContentV generated by hbm2java
 */
@Entity
@Table(name="CMS_FILE_CONTENT_V"
)
public class CmsFileContentV  implements java.io.Serializable {


     private CmsFileContentVId id;

    public CmsFileContentV() {
    }

    public CmsFileContentV(CmsFileContentVId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="content", column=@Column(name="CONTENT", nullable=false) ), 
        @AttributeOverride(name="mimetypeId", column=@Column(name="MIMETYPE_ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="characterSet", column=@Column(name="CHARACTER_SET", nullable=false, length=30) ), 
        @AttributeOverride(name="location", column=@Column(name="LOCATION", nullable=false, length=6) ), 
        @AttributeOverride(name="remoteLobId", column=@Column(name="REMOTE_LOB_ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="xythosId", column=@Column(name="XYTHOS_ID", nullable=false, length=30) ), 
        @AttributeOverride(name="createTs", column=@Column(name="CREATE_TS", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="lastmodifyTs", column=@Column(name="LASTMODIFY_TS", nullable=false, precision=20, scale=0) ) } )
    public CmsFileContentVId getId() {
        return this.id;
    }
    
    public void setId(CmsFileContentVId id) {
        this.id = id;
    }




}


