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
 * SrCriteriaDetail generated by hbm2java
 */
@Entity
@Table(name="SR_CRITERIA_DETAIL"
)
public class SrCriteriaDetail  implements java.io.Serializable {


     private BigDecimal id;
     private LearningContext learningContext;
     private SrCriteria srCriteria;
     private Person person;
     private GenericGroup genericGroup;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;

    public SrCriteriaDetail() {
    }

	
    public SrCriteriaDetail(BigDecimal id, SrCriteria srCriteria, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.id = id;
        this.srCriteria = srCriteria;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public SrCriteriaDetail(BigDecimal id, LearningContext learningContext, SrCriteria srCriteria, Person person, GenericGroup genericGroup, BigDecimal createTs, BigDecimal lastmodifyTs) {
       this.id = id;
       this.learningContext = learningContext;
       this.srCriteria = srCriteria;
       this.person = person;
       this.genericGroup = genericGroup;
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
    @JoinColumn(name="LC_GROUP_ID")
    public LearningContext getLearningContext() {
        return this.learningContext;
    }
    
    public void setLearningContext(LearningContext learningContext) {
        this.learningContext = learningContext;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CRITERIA_ID", nullable=false)
    public SrCriteria getSrCriteria() {
        return this.srCriteria;
    }
    
    public void setSrCriteria(SrCriteria srCriteria) {
        this.srCriteria = srCriteria;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PERSON_ID")
    public Person getPerson() {
        return this.person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="GENERIC_GROUP_ID")
    public GenericGroup getGenericGroup() {
        return this.genericGroup;
    }
    
    public void setGenericGroup(GenericGroup genericGroup) {
        this.genericGroup = genericGroup;
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


