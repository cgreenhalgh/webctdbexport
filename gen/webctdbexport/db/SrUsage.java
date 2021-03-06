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
 * SrUsage generated by hbm2java
 */
@Entity
@Table(name="SR_USAGE"
)
public class SrUsage  implements java.io.Serializable {


     private BigDecimal id;
     private CoTemplate coTemplate;
     private SrHead srHead;
     private CmsContentEntry cmsContentEntry;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;

    public SrUsage() {
    }

	
    public SrUsage(BigDecimal id, CoTemplate coTemplate, CmsContentEntry cmsContentEntry, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.id = id;
        this.coTemplate = coTemplate;
        this.cmsContentEntry = cmsContentEntry;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public SrUsage(BigDecimal id, CoTemplate coTemplate, SrHead srHead, CmsContentEntry cmsContentEntry, BigDecimal createTs, BigDecimal lastmodifyTs) {
       this.id = id;
       this.coTemplate = coTemplate;
       this.srHead = srHead;
       this.cmsContentEntry = cmsContentEntry;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
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
    @JoinColumn(name="DELIVERY_CONTEXT_ID", nullable=false)
    public CoTemplate getCoTemplate() {
        return this.coTemplate;
    }
    
    public void setCoTemplate(CoTemplate coTemplate) {
        this.coTemplate = coTemplate;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="HEAD_ID")
    public SrHead getSrHead() {
        return this.srHead;
    }
    
    public void setSrHead(SrHead srHead) {
        this.srHead = srHead;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CONTENT_ENTRY_ID", nullable=false)
    public CmsContentEntry getCmsContentEntry() {
        return this.cmsContentEntry;
    }
    
    public void setCmsContentEntry(CmsContentEntry cmsContentEntry) {
        this.cmsContentEntry = cmsContentEntry;
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




}


