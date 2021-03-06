package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * ProxyToolDef generated by hbm2java
 */
@Entity
@Table(name="PROXY_TOOL_DEF"
)
public class ProxyToolDef  implements java.io.Serializable {


     private BigDecimal id;
     private String version;
     private String name;
     private String description;
     private String adaptor;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private BigDecimal deletedFlag;
     private Set<ProxyToolInstance> proxyToolInstances = new HashSet<ProxyToolInstance>(0);

    public ProxyToolDef() {
    }

	
    public ProxyToolDef(BigDecimal id, String name, String description, String adaptor, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.adaptor = adaptor;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public ProxyToolDef(BigDecimal id, String name, String description, String adaptor, BigDecimal createTs, BigDecimal lastmodifyTs, BigDecimal deletedFlag, Set<ProxyToolInstance> proxyToolInstances) {
       this.id = id;
       this.name = name;
       this.description = description;
       this.adaptor = adaptor;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.deletedFlag = deletedFlag;
       this.proxyToolInstances = proxyToolInstances;
    }
   
     @Id 

    
    @Column(name="ID", nullable=false, precision=20, scale=0)
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }

//    @Version
    @Column(name="VERSION", nullable=false, length=40)
    public String getVersion() {
        return this.version;
    }
    
    public void setVersion(String version) {
        this.version = version;
    }

    
    @Column(name="NAME", nullable=false, length=384)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="DESCRIPTION", nullable=false, length=4000)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="ADAPTOR", nullable=false, length=768)
    public String getAdaptor() {
        return this.adaptor;
    }
    
    public void setAdaptor(String adaptor) {
        this.adaptor = adaptor;
    }

    
    @Column(name="CREATE_TS", nullable=false, precision=20, scale=0)
    public BigDecimal getCreateTs() {
        return this.createTs;
    }
    
    public void setCreateTs(BigDecimal createTs) {
        this.createTs = createTs;
    }

    
    @Column(name="LASTMODIFY_TS", nullable=false, precision=20, scale=0)
    public BigDecimal getLastmodifyTs() {
        return this.lastmodifyTs;
    }
    
    public void setLastmodifyTs(BigDecimal lastmodifyTs) {
        this.lastmodifyTs = lastmodifyTs;
    }

    
    @Column(name="DELETED_FLAG", precision=20, scale=0)
    public BigDecimal getDeletedFlag() {
        return this.deletedFlag;
    }
    
    public void setDeletedFlag(BigDecimal deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="proxyToolDef")
    public Set<ProxyToolInstance> getProxyToolInstances() {
        return this.proxyToolInstances;
    }
    
    public void setProxyToolInstances(Set<ProxyToolInstance> proxyToolInstances) {
        this.proxyToolInstances = proxyToolInstances;
    }




}


