package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * MlEntry generated by hbm2java
 */
@Entity
@Table(name="ML_ENTRY"
)
public class MlEntry  implements java.io.Serializable {


     private BigDecimal id;
     private CmsContentEntry cmsContentEntry;
     private boolean linkType;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private String keywords;
     private boolean htmlContentFlag;
     private boolean titleStyle;
     private String attchmntName;
     private String creatorRole;
     private Set<MlChangeQueue> mlChangeQueues = new HashSet<MlChangeQueue>(0);

    public MlEntry() {
    }

	
    public MlEntry(CmsContentEntry cmsContentEntry, boolean linkType, BigDecimal createTs, BigDecimal lastmodifyTs, boolean htmlContentFlag, boolean titleStyle) {
        this.cmsContentEntry = cmsContentEntry;
        this.linkType = linkType;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
        this.htmlContentFlag = htmlContentFlag;
        this.titleStyle = titleStyle;
    }
    public MlEntry(CmsContentEntry cmsContentEntry, boolean linkType, BigDecimal createTs, BigDecimal lastmodifyTs, String keywords, boolean htmlContentFlag, boolean titleStyle, String attchmntName, String creatorRole, Set<MlChangeQueue> mlChangeQueues) {
       this.cmsContentEntry = cmsContentEntry;
       this.linkType = linkType;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.keywords = keywords;
       this.htmlContentFlag = htmlContentFlag;
       this.titleStyle = titleStyle;
       this.attchmntName = attchmntName;
       this.creatorRole = creatorRole;
       this.mlChangeQueues = mlChangeQueues;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="cmsContentEntry"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="ID", nullable=false, precision=20, scale=0)
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }

@OneToOne(fetch=FetchType.LAZY)
    public CmsContentEntry getCmsContentEntry() {
        return this.cmsContentEntry;
    }
    
    public void setCmsContentEntry(CmsContentEntry cmsContentEntry) {
        this.cmsContentEntry = cmsContentEntry;
    }

    
    @Column(name="LINK_TYPE", nullable=false, precision=1, scale=0)
    public boolean isLinkType() {
        return this.linkType;
    }
    
    public void setLinkType(boolean linkType) {
        this.linkType = linkType;
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

    
    @Column(name="KEYWORDS", length=3000)
    public String getKeywords() {
        return this.keywords;
    }
    
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    
    @Column(name="HTML_CONTENT_FLAG", nullable=false, precision=1, scale=0)
    public boolean isHtmlContentFlag() {
        return this.htmlContentFlag;
    }
    
    public void setHtmlContentFlag(boolean htmlContentFlag) {
        this.htmlContentFlag = htmlContentFlag;
    }

    
    @Column(name="TITLE_STYLE", nullable=false, precision=1, scale=0)
    public boolean isTitleStyle() {
        return this.titleStyle;
    }
    
    public void setTitleStyle(boolean titleStyle) {
        this.titleStyle = titleStyle;
    }

    
    @Column(name="ATTCHMNT_NAME", length=1000)
    public String getAttchmntName() {
        return this.attchmntName;
    }
    
    public void setAttchmntName(String attchmntName) {
        this.attchmntName = attchmntName;
    }

    
    @Column(name="CREATOR_ROLE", length=30)
    public String getCreatorRole() {
        return this.creatorRole;
    }
    
    public void setCreatorRole(String creatorRole) {
        this.creatorRole = creatorRole;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="mlEntry")
    public Set<MlChangeQueue> getMlChangeQueues() {
        return this.mlChangeQueues;
    }
    
    public void setMlChangeQueues(Set<MlChangeQueue> mlChangeQueues) {
        this.mlChangeQueues = mlChangeQueues;
    }




}


