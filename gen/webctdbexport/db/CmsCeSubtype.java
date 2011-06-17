package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CmsCeSubtype generated by hbm2java
 */
@Entity
@Table(name="CMS_CE_SUBTYPE"
)
public class CmsCeSubtype  implements java.io.Serializable {


     private CmsCeSubtypeId id;
     private CmsCeType cmsCeType;
     private BigDecimal id_1;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private Set<CmsMimetype> cmsMimetypes = new HashSet<CmsMimetype>(0);
     private Set<CmsContentEntry> cmsContentEntries = new HashSet<CmsContentEntry>(0);

    public CmsCeSubtype() {
    }

	
    public CmsCeSubtype(CmsCeSubtypeId id, CmsCeType cmsCeType, BigDecimal id_1, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.id = id;
        this.cmsCeType = cmsCeType;
        this.id_1 = id_1;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public CmsCeSubtype(CmsCeSubtypeId id, CmsCeType cmsCeType, BigDecimal id_1, BigDecimal createTs, BigDecimal lastmodifyTs, Set<CmsMimetype> cmsMimetypes, Set<CmsContentEntry> cmsContentEntries) {
       this.id = id;
       this.cmsCeType = cmsCeType;
       this.id_1 = id_1;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.cmsMimetypes = cmsMimetypes;
       this.cmsContentEntries = cmsContentEntries;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="ceTypeName", column=@Column(name="CE_TYPE_NAME", nullable=false, length=100) ), 
        @AttributeOverride(name="name", column=@Column(name="NAME", nullable=false, length=100) ) } )
    public CmsCeSubtypeId getId() {
        return this.id;
    }
    
    public void setId(CmsCeSubtypeId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CE_TYPE_NAME", nullable=false, insertable=false, updatable=false)
    public CmsCeType getCmsCeType() {
        return this.cmsCeType;
    }
    
    public void setCmsCeType(CmsCeType cmsCeType) {
        this.cmsCeType = cmsCeType;
    }

    
    @Column(name="ID", unique=true, nullable=false, precision=20, scale=0)
    public BigDecimal getId_1() {
        return this.id_1;
    }
    
    public void setId_1(BigDecimal id_1) {
        this.id_1 = id_1;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="cmsCeSubtype")
    public Set<CmsMimetype> getCmsMimetypes() {
        return this.cmsMimetypes;
    }
    
    public void setCmsMimetypes(Set<CmsMimetype> cmsMimetypes) {
        this.cmsMimetypes = cmsMimetypes;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cmsCeSubtype")
    public Set<CmsContentEntry> getCmsContentEntries() {
        return this.cmsContentEntries;
    }
    
    public void setCmsContentEntries(Set<CmsContentEntry> cmsContentEntries) {
        this.cmsContentEntries = cmsContentEntries;
    }




}


