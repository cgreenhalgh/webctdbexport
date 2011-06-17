package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VistaifWlstoreBak generated by hbm2java
 */
@Entity
@Table(name="VISTAIF_WLSTORE_BAK"
)
public class VistaifWlstoreBak  implements java.io.Serializable {


     private VistaifWlstoreBakId id;

    public VistaifWlstoreBak() {
    }

    public VistaifWlstoreBak(VistaifWlstoreBakId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="ID", nullable=false, precision=22, scale=0) ), 
        @AttributeOverride(name="type", column=@Column(name="TYPE", nullable=false, precision=22, scale=0) ), 
        @AttributeOverride(name="handle", column=@Column(name="HANDLE", nullable=false, precision=22, scale=0) ), 
        @AttributeOverride(name="record", column=@Column(name="RECORD", nullable=false) ) } )
    public VistaifWlstoreBakId getId() {
        return this.id;
    }
    
    public void setId(VistaifWlstoreBakId id) {
        this.id = id;
    }




}


