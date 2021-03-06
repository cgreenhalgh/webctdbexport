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
 * CoUrl generated by hbm2java
 */
@Entity
@Table(name="CO_URL"
)
public class CoUrl  implements java.io.Serializable {


     private BigDecimal id;
     private CmsContentEntry cmsContentEntry;
     private String link;
     private boolean openinnewwindowflag;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private String createdByRole;

    public CoUrl() {
    }

	
    public CoUrl(CmsContentEntry cmsContentEntry, String link, boolean openinnewwindowflag, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.cmsContentEntry = cmsContentEntry;
        this.link = link;
        this.openinnewwindowflag = openinnewwindowflag;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public CoUrl(CmsContentEntry cmsContentEntry, String link, boolean openinnewwindowflag, BigDecimal createTs, BigDecimal lastmodifyTs, String createdByRole) {
       this.cmsContentEntry = cmsContentEntry;
       this.link = link;
       this.openinnewwindowflag = openinnewwindowflag;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.createdByRole = createdByRole;
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

    
    @Column(name="LINK", nullable=false, length=4000)
    public String getLink() {
        return this.link;
    }
    
    public void setLink(String link) {
        this.link = link;
    }

    
    @Column(name="OPENINNEWWINDOWFLAG", nullable=false, precision=1, scale=0)
    public boolean isOpeninnewwindowflag() {
        return this.openinnewwindowflag;
    }
    
    public void setOpeninnewwindowflag(boolean openinnewwindowflag) {
        this.openinnewwindowflag = openinnewwindowflag;
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

    
    @Column(name="CREATED_BY_ROLE", length=30)
    public String getCreatedByRole() {
        return this.createdByRole;
    }
    
    public void setCreatedByRole(String createdByRole) {
        this.createdByRole = createdByRole;
    }




}


