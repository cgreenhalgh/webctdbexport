package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ProxyToolDefBak generated by hbm2java
 */
@Entity
@Table(name="PROXY_TOOL_DEF_BAK"
)
public class ProxyToolDefBak  implements java.io.Serializable {


     private ProxyToolDefBakId id;

    public ProxyToolDefBak() {
    }

    public ProxyToolDefBak(ProxyToolDefBakId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="name", column=@Column(name="NAME", nullable=false, length=384) ), 
        @AttributeOverride(name="version", column=@Column(name="VERSION", nullable=false, length=40) ), 
        @AttributeOverride(name="description", column=@Column(name="DESCRIPTION", nullable=false, length=4000) ), 
        @AttributeOverride(name="adaptor", column=@Column(name="ADAPTOR", nullable=false, length=768) ), 
        @AttributeOverride(name="createTs", column=@Column(name="CREATE_TS", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="lastmodifyTs", column=@Column(name="LASTMODIFY_TS", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="deletedFlag", column=@Column(name="DELETED_FLAG", nullable=false, precision=20, scale=0) ) } )
    public ProxyToolDefBakId getId() {
        return this.id;
    }
    
    public void setId(ProxyToolDefBakId id) {
        this.id = id;
    }




}


