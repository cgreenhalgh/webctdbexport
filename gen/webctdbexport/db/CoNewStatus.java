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
 * CoNewStatus generated by hbm2java
 */
@Entity
@Table(name="CO_NEW_STATUS"
)
public class CoNewStatus  implements java.io.Serializable {


     private BigDecimal id;
     private CoTemplate coTemplate;
     private Person person;
     private CmsContentEntry cmsContentEntry;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;

    public CoNewStatus() {
    }

    public CoNewStatus(BigDecimal id, CoTemplate coTemplate, Person person, CmsContentEntry cmsContentEntry, BigDecimal createTs, BigDecimal lastmodifyTs) {
       this.id = id;
       this.coTemplate = coTemplate;
       this.person = person;
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
    @JoinColumn(name="TEMPLATE_ID", nullable=false)
    public CoTemplate getCoTemplate() {
        return this.coTemplate;
    }
    
    public void setCoTemplate(CoTemplate coTemplate) {
        this.coTemplate = coTemplate;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PERSON_ID", nullable=false)
    public Person getPerson() {
        return this.person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
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


