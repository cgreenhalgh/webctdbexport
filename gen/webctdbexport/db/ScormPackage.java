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
 * ScormPackage generated by hbm2java
 */
@Entity
@Table(name="SCORM_PACKAGE"
)
public class ScormPackage  implements java.io.Serializable {


     private BigDecimal id;
     private CmsContentEntry cmsContentEntry;
     private boolean isopeninnewwindow;
     private boolean gradable;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private String control;
     private String url;
     private String numbering;
     private String author;
     private String keywords;
     private Set<ScormItem> scormItems = new HashSet<ScormItem>(0);

    public ScormPackage() {
    }

	
    public ScormPackage(CmsContentEntry cmsContentEntry, boolean isopeninnewwindow, boolean gradable, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.cmsContentEntry = cmsContentEntry;
        this.isopeninnewwindow = isopeninnewwindow;
        this.gradable = gradable;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public ScormPackage(CmsContentEntry cmsContentEntry, boolean isopeninnewwindow, boolean gradable, BigDecimal createTs, BigDecimal lastmodifyTs, String control, String url, String numbering, String author, String keywords, Set<ScormItem> scormItems) {
       this.cmsContentEntry = cmsContentEntry;
       this.isopeninnewwindow = isopeninnewwindow;
       this.gradable = gradable;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.control = control;
       this.url = url;
       this.numbering = numbering;
       this.author = author;
       this.keywords = keywords;
       this.scormItems = scormItems;
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

    
    @Column(name="ISOPENINNEWWINDOW", nullable=false, precision=1, scale=0)
    public boolean isIsopeninnewwindow() {
        return this.isopeninnewwindow;
    }
    
    public void setIsopeninnewwindow(boolean isopeninnewwindow) {
        this.isopeninnewwindow = isopeninnewwindow;
    }

    
    @Column(name="GRADABLE", nullable=false, precision=1, scale=0)
    public boolean isGradable() {
        return this.gradable;
    }
    
    public void setGradable(boolean gradable) {
        this.gradable = gradable;
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

    
    @Column(name="CONTROL", length=40)
    public String getControl() {
        return this.control;
    }
    
    public void setControl(String control) {
        this.control = control;
    }

    
    @Column(name="URL", length=1000)
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

    
    @Column(name="NUMBERING", length=2)
    public String getNumbering() {
        return this.numbering;
    }
    
    public void setNumbering(String numbering) {
        this.numbering = numbering;
    }

    
    @Column(name="AUTHOR", length=256)
    public String getAuthor() {
        return this.author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }

    
    @Column(name="KEYWORDS", length=3000)
    public String getKeywords() {
        return this.keywords;
    }
    
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="scormPackage")
    public Set<ScormItem> getScormItems() {
        return this.scormItems;
    }
    
    public void setScormItems(Set<ScormItem> scormItems) {
        this.scormItems = scormItems;
    }




}


