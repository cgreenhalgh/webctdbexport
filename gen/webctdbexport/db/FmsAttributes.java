package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * FmsAttributes generated by hbm2java
 */
@Entity
@Table(name="FMS_ATTRIBUTES"
)
public class FmsAttributes  implements java.io.Serializable {


     private BigDecimal id;
     private CmsContentEntry cmsContentEntry;
     private String author;
     private String title;
     private String keywords;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;

    public FmsAttributes() {
    }

	
    public FmsAttributes(CmsContentEntry cmsContentEntry, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.cmsContentEntry = cmsContentEntry;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public FmsAttributes(CmsContentEntry cmsContentEntry, String author, String title, String keywords, BigDecimal createTs, BigDecimal lastmodifyTs) {
       this.cmsContentEntry = cmsContentEntry;
       this.author = author;
       this.title = title;
       this.keywords = keywords;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
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

    
    @Column(name="AUTHOR", length=1000)
    public String getAuthor() {
        return this.author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }

    
    @Column(name="TITLE", length=1000)
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    
    @Column(name="KEYWORDS", length=3000)
    public String getKeywords() {
        return this.keywords;
    }
    
    public void setKeywords(String keywords) {
        this.keywords = keywords;
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


