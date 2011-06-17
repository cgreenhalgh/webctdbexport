package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
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
 * RubricUsage generated by hbm2java
 */
@Entity
@Table(name="RUBRIC_USAGE"
)
public class RubricUsage  implements java.io.Serializable {


     private BigDecimal id;
     private Rubric rubric;
     private CmsContentEntry cmsContentEntry;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private Set<RubricLink> rubricLinks = new HashSet<RubricLink>(0);

    public RubricUsage() {
    }

	
    public RubricUsage(BigDecimal id, Rubric rubric, CmsContentEntry cmsContentEntry, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.id = id;
        this.rubric = rubric;
        this.cmsContentEntry = cmsContentEntry;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public RubricUsage(BigDecimal id, Rubric rubric, CmsContentEntry cmsContentEntry, BigDecimal createTs, BigDecimal lastmodifyTs, Set<RubricLink> rubricLinks) {
       this.id = id;
       this.rubric = rubric;
       this.cmsContentEntry = cmsContentEntry;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.rubricLinks = rubricLinks;
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
    @JoinColumn(name="RUBRIC_ID", nullable=false)
    public Rubric getRubric() {
        return this.rubric;
    }
    
    public void setRubric(Rubric rubric) {
        this.rubric = rubric;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="rubricUsage")
    public Set<RubricLink> getRubricLinks() {
        return this.rubricLinks;
    }
    
    public void setRubricLinks(Set<RubricLink> rubricLinks) {
        this.rubricLinks = rubricLinks;
    }




}


