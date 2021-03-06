package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CmsUniqueName generated by hbm2java
 */
@Entity
@Table(name="CMS_UNIQUE_NAME"
)
public class CmsUniqueName  implements java.io.Serializable {


     private BigDecimal id;
     private CmsContentEntry cmsContentEntry;
     private String name;
     private String uniquenessGroup;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private BigDecimal deletedIndicator;

    public CmsUniqueName() {
    }

	
    public CmsUniqueName(BigDecimal id, CmsContentEntry cmsContentEntry, String name, String uniquenessGroup, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.id = id;
        this.cmsContentEntry = cmsContentEntry;
        this.name = name;
        this.uniquenessGroup = uniquenessGroup;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public CmsUniqueName(BigDecimal id, CmsContentEntry cmsContentEntry, String name, String uniquenessGroup, BigDecimal createTs, BigDecimal lastmodifyTs, BigDecimal deletedIndicator) {
       this.id = id;
       this.cmsContentEntry = cmsContentEntry;
       this.name = name;
       this.uniquenessGroup = uniquenessGroup;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.deletedIndicator = deletedIndicator;
    }
   
     @Id 

    
    @Column(name="ID", nullable=false, precision=20, scale=0)
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PARENT_ID", nullable=false)
    public CmsContentEntry getCmsContentEntry() {
        return this.cmsContentEntry;
    }
    
    public void setCmsContentEntry(CmsContentEntry cmsContentEntry) {
        this.cmsContentEntry = cmsContentEntry;
    }

    
    @Column(name="NAME", nullable=false, length=1000)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="UNIQUENESS_GROUP", nullable=false, length=100)
    public String getUniquenessGroup() {
        return this.uniquenessGroup;
    }
    
    public void setUniquenessGroup(String uniquenessGroup) {
        this.uniquenessGroup = uniquenessGroup;
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

    
    @Column(name="DELETED_INDICATOR", precision=20, scale=0)
    public BigDecimal getDeletedIndicator() {
        return this.deletedIndicator;
    }
    
    public void setDeletedIndicator(BigDecimal deletedIndicator) {
        this.deletedIndicator = deletedIndicator;
    }




}


