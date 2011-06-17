package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CmsFileContent generated by hbm2java
 */
@Entity
@Table(name="CMS_FILE_CONTENT"
)
public class CmsFileContent  implements java.io.Serializable {


     private BigDecimal id;
     private CmsCeCharset cmsCeCharset;
     private CmsMimetype cmsMimetype;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private Blob content;
     private BigDecimal remoteLobId;
     private String xythosId;
     private Set<Thumbnail> thumbnails = new HashSet<Thumbnail>(0);
     private Set<SimpleFile> simpleFiles = new HashSet<SimpleFile>(0);
     private Set<CmsContentEntry> cmsContentEntries = new HashSet<CmsContentEntry>(0);

    public CmsFileContent() {
    }

	
    public CmsFileContent(BigDecimal id, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.id = id;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public CmsFileContent(BigDecimal id, CmsCeCharset cmsCeCharset, CmsMimetype cmsMimetype, BigDecimal createTs, BigDecimal lastmodifyTs, Blob content, BigDecimal remoteLobId, String xythosId, Set<Thumbnail> thumbnails, Set<SimpleFile> simpleFiles, Set<CmsContentEntry> cmsContentEntries) {
       this.id = id;
       this.cmsCeCharset = cmsCeCharset;
       this.cmsMimetype = cmsMimetype;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.content = content;
       this.remoteLobId = remoteLobId;
       this.xythosId = xythosId;
       this.thumbnails = thumbnails;
       this.simpleFiles = simpleFiles;
       this.cmsContentEntries = cmsContentEntries;
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
    @JoinColumn(name="CHARACTER_SET")
    public CmsCeCharset getCmsCeCharset() {
        return this.cmsCeCharset;
    }
    
    public void setCmsCeCharset(CmsCeCharset cmsCeCharset) {
        this.cmsCeCharset = cmsCeCharset;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MIMETYPE_ID")
    public CmsMimetype getCmsMimetype() {
        return this.cmsMimetype;
    }
    
    public void setCmsMimetype(CmsMimetype cmsMimetype) {
        this.cmsMimetype = cmsMimetype;
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

    
    @Column(name="CONTENT")
    public Blob getContent() {
        return this.content;
    }
    
    public void setContent(Blob content) {
        this.content = content;
    }

    
    @Column(name="REMOTE_LOB_ID", precision=20, scale=0)
    public BigDecimal getRemoteLobId() {
        return this.remoteLobId;
    }
    
    public void setRemoteLobId(BigDecimal remoteLobId) {
        this.remoteLobId = remoteLobId;
    }

    
    @Column(name="XYTHOS_ID", length=30)
    public String getXythosId() {
        return this.xythosId;
    }
    
    public void setXythosId(String xythosId) {
        this.xythosId = xythosId;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cmsFileContent")
    public Set<Thumbnail> getThumbnails() {
        return this.thumbnails;
    }
    
    public void setThumbnails(Set<Thumbnail> thumbnails) {
        this.thumbnails = thumbnails;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cmsFileContent")
    public Set<SimpleFile> getSimpleFiles() {
        return this.simpleFiles;
    }
    
    public void setSimpleFiles(Set<SimpleFile> simpleFiles) {
        this.simpleFiles = simpleFiles;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cmsFileContent")
    public Set<CmsContentEntry> getCmsContentEntries() {
        return this.cmsContentEntries;
    }
    
    public void setCmsContentEntries(Set<CmsContentEntry> cmsContentEntries) {
        this.cmsContentEntries = cmsContentEntries;
    }




}


