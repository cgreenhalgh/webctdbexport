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
 * CpmLcAclRel generated by hbm2java
 */
@Entity
@Table(name="CPM_LC_ACL_REL"
)
public class CpmLcAclRel  implements java.io.Serializable {


     private BigDecimal id;
     private AccessControlList accessControlList;
     private CpmRule cpmRule;
     private LearningContext learningContext;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;

    public CpmLcAclRel() {
    }

	
    public CpmLcAclRel(BigDecimal id, AccessControlList accessControlList, CpmRule cpmRule, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.id = id;
        this.accessControlList = accessControlList;
        this.cpmRule = cpmRule;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public CpmLcAclRel(BigDecimal id, AccessControlList accessControlList, CpmRule cpmRule, LearningContext learningContext, BigDecimal createTs, BigDecimal lastmodifyTs) {
       this.id = id;
       this.accessControlList = accessControlList;
       this.cpmRule = cpmRule;
       this.learningContext = learningContext;
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
    @JoinColumn(name="ACL_ID", nullable=false)
    public AccessControlList getAccessControlList() {
        return this.accessControlList;
    }
    
    public void setAccessControlList(AccessControlList accessControlList) {
        this.accessControlList = accessControlList;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="RULE_ID", nullable=false)
    public CpmRule getCpmRule() {
        return this.cpmRule;
    }
    
    public void setCpmRule(CpmRule cpmRule) {
        this.cpmRule = cpmRule;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="LEARNING_CONTEXT_ID")
    public LearningContext getLearningContext() {
        return this.learningContext;
    }
    
    public void setLearningContext(LearningContext learningContext) {
        this.learningContext = learningContext;
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


