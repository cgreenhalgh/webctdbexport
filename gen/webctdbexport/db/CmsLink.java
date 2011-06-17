package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * CmsLink generated by hbm2java
 */
@Entity
@Table(name="CMS_LINK"
)
public class CmsLink  implements java.io.Serializable {


     private BigDecimal id;
     private CmsLinkType cmsLinkType;
     private CmsContentEntry cmsContentEntryByLeftobjectId;
     private CmsContentEntry cmsContentEntryByRightobjectId;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private String name;
     private Double displayOrder;
     private CoOrganizerlink coOrganizerlink;
     private CmsLinkOrder cmsLinkOrder;
     private CoResourcelink coResourcelink;
     private CoActionmenulink coActionmenulink;
     private SyllitemLearningobjLink syllitemLearningobjLink;
     private CoTocLink coTocLink;

    public CmsLink() {
    }

	
    public CmsLink(BigDecimal id, CmsLinkType cmsLinkType, CmsContentEntry cmsContentEntryByLeftobjectId, CmsContentEntry cmsContentEntryByRightobjectId, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.id = id;
        this.cmsLinkType = cmsLinkType;
        this.cmsContentEntryByLeftobjectId = cmsContentEntryByLeftobjectId;
        this.cmsContentEntryByRightobjectId = cmsContentEntryByRightobjectId;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public CmsLink(BigDecimal id, CmsLinkType cmsLinkType, CmsContentEntry cmsContentEntryByLeftobjectId, CmsContentEntry cmsContentEntryByRightobjectId, BigDecimal createTs, BigDecimal lastmodifyTs, String name, Double displayOrder, CoOrganizerlink coOrganizerlink, CmsLinkOrder cmsLinkOrder, CoResourcelink coResourcelink, CoActionmenulink coActionmenulink, SyllitemLearningobjLink syllitemLearningobjLink, CoTocLink coTocLink) {
       this.id = id;
       this.cmsLinkType = cmsLinkType;
       this.cmsContentEntryByLeftobjectId = cmsContentEntryByLeftobjectId;
       this.cmsContentEntryByRightobjectId = cmsContentEntryByRightobjectId;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.name = name;
       this.displayOrder = displayOrder;
       this.coOrganizerlink = coOrganizerlink;
       this.cmsLinkOrder = cmsLinkOrder;
       this.coResourcelink = coResourcelink;
       this.coActionmenulink = coActionmenulink;
       this.syllitemLearningobjLink = syllitemLearningobjLink;
       this.coTocLink = coTocLink;
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
    @JoinColumn(name="LINK_TYPE_ID", nullable=false)
    public CmsLinkType getCmsLinkType() {
        return this.cmsLinkType;
    }
    
    public void setCmsLinkType(CmsLinkType cmsLinkType) {
        this.cmsLinkType = cmsLinkType;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="LEFTOBJECT_ID", nullable=false)
    public CmsContentEntry getCmsContentEntryByLeftobjectId() {
        return this.cmsContentEntryByLeftobjectId;
    }
    
    public void setCmsContentEntryByLeftobjectId(CmsContentEntry cmsContentEntryByLeftobjectId) {
        this.cmsContentEntryByLeftobjectId = cmsContentEntryByLeftobjectId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="RIGHTOBJECT_ID", nullable=false)
    public CmsContentEntry getCmsContentEntryByRightobjectId() {
        return this.cmsContentEntryByRightobjectId;
    }
    
    public void setCmsContentEntryByRightobjectId(CmsContentEntry cmsContentEntryByRightobjectId) {
        this.cmsContentEntryByRightobjectId = cmsContentEntryByRightobjectId;
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

    
    @Column(name="NAME", length=1000)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="DISPLAY_ORDER", precision=126, scale=0)
    public Double getDisplayOrder() {
        return this.displayOrder;
    }
    
    public void setDisplayOrder(Double displayOrder) {
        this.displayOrder = displayOrder;
    }

@OneToOne(fetch=FetchType.EAGER, mappedBy="cmsLink")
    public CoOrganizerlink getCoOrganizerlink() {
        return this.coOrganizerlink;
    }
    
    public void setCoOrganizerlink(CoOrganizerlink coOrganizerlink) {
        this.coOrganizerlink = coOrganizerlink;
    }

@OneToOne(fetch=FetchType.EAGER, mappedBy="cmsLink")
    public CmsLinkOrder getCmsLinkOrder() {
        return this.cmsLinkOrder;
    }
    
    public void setCmsLinkOrder(CmsLinkOrder cmsLinkOrder) {
        this.cmsLinkOrder = cmsLinkOrder;
    }

@OneToOne(fetch=FetchType.EAGER, mappedBy="cmsLink")
    public CoResourcelink getCoResourcelink() {
        return this.coResourcelink;
    }
    
    public void setCoResourcelink(CoResourcelink coResourcelink) {
        this.coResourcelink = coResourcelink;
    }

@OneToOne(fetch=FetchType.EAGER, mappedBy="cmsLink")
    public CoActionmenulink getCoActionmenulink() {
        return this.coActionmenulink;
    }
    
    public void setCoActionmenulink(CoActionmenulink coActionmenulink) {
        this.coActionmenulink = coActionmenulink;
    }

@OneToOne(fetch=FetchType.EAGER, mappedBy="cmsLink")
    public SyllitemLearningobjLink getSyllitemLearningobjLink() {
        return this.syllitemLearningobjLink;
    }
    
    public void setSyllitemLearningobjLink(SyllitemLearningobjLink syllitemLearningobjLink) {
        this.syllitemLearningobjLink = syllitemLearningobjLink;
    }

@OneToOne(fetch=FetchType.EAGER, mappedBy="cmsLink")
    public CoTocLink getCoTocLink() {
        return this.coTocLink;
    }
    
    public void setCoTocLink(CoTocLink coTocLink) {
        this.coTocLink = coTocLink;
    }




}


